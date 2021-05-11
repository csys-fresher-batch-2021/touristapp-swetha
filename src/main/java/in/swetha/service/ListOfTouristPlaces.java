package in.swetha.service;

import java.util.ArrayList;
import java.util.List;

import in.swetha.model.Tourist;

public class ListOfTouristPlaces {
	private ListOfTouristPlaces(){
		//Default Constructor
	
	}
	/**
	 * Adding Places
	 */
	private static final List<Tourist> allTouristPlace = new ArrayList<Tourist>();
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
 * @return
 */
	public static List<Tourist> getTouristPlaces() {

		return allTouristPlace;

	}
	
}