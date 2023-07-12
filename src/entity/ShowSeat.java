package entity;

public class ShowSeat extends Seat{
	String BookingId;
	public ShowSeat(Seat seat) {
		super.setSeatNumber(seat.getSeatNumber());
	}
	public String getBookingId() {
		return BookingId;
	}

	public void setBookingId(String bookingId) {
		BookingId = bookingId;
	}
	
	
}
