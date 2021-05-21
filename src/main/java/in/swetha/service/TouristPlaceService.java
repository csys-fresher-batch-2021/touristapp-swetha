package in.swetha.service;

import java.util.ArrayList;
import java.util.List;

import in.swetha.exception.IsValidPlaceException;
import in.swetha.model.Tourist;

public class TouristPlaceService {

	private TouristPlaceService() {
		// Default Constructor

	}

	/**
	 * Adding Places
	 */

	private static final List<Tourist> allTouristPlace = new ArrayList<>();
	static {
		Tourist place = new Tourist("Ooty", 35000.0);
		allTouristPlace.add(place);
		Tourist place1 = new Tourist("Manali", 70000.0);
		allTouristPlace.add(place1);
		Tourist place2 = new Tourist("Goa", 75000.0);
		allTouristPlace.add(place2);
		Tourist place3 = new Tourist("KodaiKanal", 50000.0);
		allTouristPlace.add(place3);
		Tourist place4 = new Tourist("Simla", 90000.0);
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

	public static boolean addTouristPlace(String touristArea, Double rate) throws IsValidPlaceException {
		boolean isAdded = false;
		for (Tourist places : allTouristPlace)
			if (places.getTouristPlace().equalsIgnoreCase(touristArea)) {
				isAdded = true;

				throw new IsValidPlaceException("Place Is Already Exits");
			}
		if (!isAdded) {

			allTouristPlace.add(new Tourist(touristArea, rate));

		}
		return isAdded;

	}

	public static void deleteTouristPlace(String touristPlace) {
		int searchProduct = 0;
		for (Tourist places : allTouristPlace) {
			if (places.getTouristPlace().equalsIgnoreCase(touristPlace))

			{
				searchProduct = allTouristPlace.indexOf(places);
				break;
			}
		}allTouristPlace.remove(searchProduct);
		

	}
}
