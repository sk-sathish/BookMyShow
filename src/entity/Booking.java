package entity;

import java.util.List;

import constants.BookingStatus;
import helper.UUIDGenerator;

public class Booking {
	static UUIDGenerator uuidGenerator = new UUIDGenerator("booking");
	MovieShow forShow;
	List<ShowSeat> seats;
	BookingStatus status;
	private String id;
	public Booking() {
		id = uuidGenerator.generateUUID();
	}
	public MovieShow getForShow() {
		return forShow;
	}
	public void setForShow(MovieShow forShow) {
		this.forShow = forShow;
	}
	public List<ShowSeat> getSeats() {
		return seats;
	}
	public void setSeats(List<ShowSeat> seats) {
		this.seats = seats;
	}
	public BookingStatus getStatus() {
		return status;
	}
	public void setStatus(BookingStatus status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
}
