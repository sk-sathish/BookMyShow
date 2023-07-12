package entity;

import java.util.List;
import java.util.Map;

public class Cinema {
	Map<String, MovieShow> idVsShow;
	List<CinemaHall> halls;
	List<MovieShow> shows;
	public MovieShow getShow(String showId) {
		return idVsShow.get(showId);
	}
}
