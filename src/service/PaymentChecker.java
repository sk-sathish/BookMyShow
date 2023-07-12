package service;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import constants.BookingStatus;
import constants.SeatStatus;
import entity.Booking;
import entity.ShowSeat;

public class PaymentChecker {
	public static PaymentChecker instance;

	public static PaymentChecker getInstance() {
		if (instance == null) {
			instance = new PaymentChecker();
		}
		return instance;
	}

	private PaymentChecker() {

	}
	public void checkPaymentLater(Booking booking) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				if(booking.getStatus() != BookingStatus.BOOKED) {
					List<ShowSeat> seats = booking.getSeats();
					for(ShowSeat seat: seats) {
						seat.setStatus(SeatStatus.AVAILABLE);
					}
				}
				
			}
		};
		timer.schedule(task, 6000);
	}
	
}
