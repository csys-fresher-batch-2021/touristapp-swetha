package in.swetha.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.lang.RuntimeException;
import in.swetha.model.Tourist;

public class ListOfTouristPlaces {
	private static final Logger Loggers = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private ListOfTouristPlaces() {
		// Default Constructor

	}

	/**
	 * Adding Places
	 */
	private static final List<Tourist> allTouristPlace = new ArrayList<>();
	static {
		Tourist place = new Tourist("Ooty", 35000);
		allTouristPlace.add(place);
		Tourist place1 = new Tourist("Manali", 70000);
		allTouristPlace.add(place1);
		Tourist place2 = new Tourist("Goa", 75000);
		allTouristPlace.add(place2);
		Tourist place3 = new Tourist("KodaiKanal", 50000);
		allTouristPlace.add(place3);
		Tourist place4 = new Tourist("Simla", 90000);
		allTouristPlace.add(place4);

	}

	/**
	 * Get Places
	 * 
	 * @return
	 */
	public static List<Tourist> getTouristPlaces() {

		return allTouristPlace;

	}

	public static boolean addTouristPlace(String touristArea, Integer rate) throws RuntimeException {
		boolean isAdded = false;
		for (Tourist places : allTouristPlace)
			if (places.getTouristPlace().equalsIgnoreCase(touristArea)) {
				throw new RuntimeException("Place Is Already Exits");
			}

		if (!isAdded) {
			allTouristPlace.add(new Tourist(touristArea, rate));
			isAdded = true;
		}
		return isAdded;

	}

}