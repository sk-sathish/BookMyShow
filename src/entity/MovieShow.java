package entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieShow{
	Movie movie;
	String showTime;
	CinemaHall playsAt;
	List<ShowSeat> seats;
	Map<String, ShowSeat> idVsSeat;
	public MovieShow(Movie movie, String showTime, CinemaHall hall) {
		this.movie = movie;
		this.showTime = showTime;
		this.playsAt = hall;
		idVsSeat = new HashMap<String, ShowSeat>();
		List<Seat> hallSeats = hall.getSeats();
		for(Seat seat: hallSeats) {
			ShowSeat showSeat = new ShowSeat(seat);
			seats.add(showSeat);
			idVsSeat.put(showSeat.getSeatNumber(), showSeat);
		}
	}
	public ShowSeat getSeat(String seatNumber) {
		return idVsSeat.get(seatNumber);
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public CinemaHall getPlaysAt() {
		return playsAt;
	}
	public void setPlaysAt(CinemaHall playsAt) {
		this.playsAt = playsAt;
	}
	
}
