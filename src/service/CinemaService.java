package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Cinema;

public class CinemaService {
	public static CinemaService instance;

	public static CinemaService getInstance() {
		if (instance == null) {
			instance = new CinemaService();
		}
		return instance;
	}

	private CinemaService() {
		cinemas = new ArrayList<Cinema>();
		idVsCinema = new HashMap<String, Cinema>();
	}
	public Cinema getCinema(String cinemaId) {
		return idVsCinema.get(cinemaId);
	}
	List<Cinema> cinemas;
	Map<String, Cinema> idVsCinema;
}
