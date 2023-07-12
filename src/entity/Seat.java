package entity;

import constants.SeatStatus;
import constants.SeatType;

public class Seat {
	String seatNumber;
	SeatType type;
	SeatStatus status;
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public SeatType getType() {
		return type;
	}
	public void setType(SeatType type) {
		this.type = type;
	}
	public SeatStatus getStatus() {
		return status;
	}
	public void setStatus(SeatStatus status) {
		this.status = status;
	}
	
}
