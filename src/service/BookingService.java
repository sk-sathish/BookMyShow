package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import abstraction.IPaymentStrategy;
import constants.BookingStatus;
import constants.PaymentStatus;
import constants.PaymentType;
import constants.SeatStatus;
import entity.Booking;
import entity.Cinema;
import entity.MovieShow;
import entity.Payment;
import entity.ShowSeat;
import helper.PaymentFactory;

public class BookingService {
	List<Booking> bookings;
	Map<String, Booking> idVsBooking;
	public Booking bookTickets(String userName, String cinemaId, String showId, List<String> seatNumbers, PaymentType paymentType) {
		CinemaService cinemaService = CinemaService.getInstance();
		Cinema cinema = cinemaService.getCinema(cinemaId);
		MovieShow show = cinema.getShow(showId);
		Booking booking = new Booking();
		synchronized(show) {
			List<ShowSeat> seats = new ArrayList<ShowSeat>();
			boolean isAllSeatsAvailable = true;
			for(String seatNumber: seatNumbers) {
				ShowSeat showSeat = show.getSeat(seatNumber);
				if(showSeat.getStatus() != SeatStatus.AVAILABLE) {
					isAllSeatsAvailable = false;
					break;
				}
				else {
					seats.add(showSeat);
				}
			}
			if(!isAllSeatsAvailable) {
				booking.setStatus(BookingStatus.UN_AVAILABLE);
				return booking;
			}
			for(ShowSeat seat: seats) {
				seat.setStatus(SeatStatus.ON_HOLD);
			}
			booking.setSeats(seats);
			//releasing the lock, so others dont have wait till we make the payment
			PaymentChecker checker = PaymentChecker.getInstance();
			checker.checkPaymentLater(booking);
		}
		IPaymentStrategy paymentStrategy = PaymentFactory.getPaymentStrategy(paymentType);
		//if the payment is not successful with in the mentioned time, the time given for above checker, 
//		the payment will not be processed, we can give one or two minutes more for checker, 
//		like 5 minutes for payment and 7 minutes for checker
		Payment payment = paymentStrategy.processPayment();
		if(payment.getStatus()!= PaymentStatus.SUCCESSFUL) {
			booking.setStatus(BookingStatus.PAYMENT_FAILED);
			return booking;
		}
		List<ShowSeat> seats = booking.getSeats();
		//no need of lock here, as we made the given seats as "on hold"
		for(ShowSeat seat: seats) {
			seat.setStatus(SeatStatus.BOOKED);
		}
		idVsBooking.put(booking.getId(), booking);
		return booking;
		
	}
	public void cancelTickets(String userName, String bookingId) {
		Booking booking = idVsBooking.get(bookingId);
		booking.setStatus(BookingStatus.CANCELLED);
		for(ShowSeat seat: booking.getSeats()) {
			seat.setStatus(SeatStatus.AVAILABLE);
		}
	}
}
