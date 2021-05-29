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
	private static final List<Tourist> searchList=new ArrayList<>();
	private static final List<Tourist> allTouristPlace = new ArrayList<>();
	static {
		
		Tourist place1 = new Tourist("Manali", 70000,"manali.jpg");
		allTouristPlace.add(place1);
		Tourist place2 = new Tourist("Goa", 75000,"goa.jfif");
		allTouristPlace.add(place2);
		Tourist place3 = new Tourist("KodaiKanal", 45000,"kodaikanal.jpg");
		allTouristPlace.add(place3);
		Tourist place4 = new Tourist("Simla", 90000,"simla.jpg");
		allTouristPlace.add(place4);
		Tourist place = new Tourist("Ooty", 35000,"ooty.jpg");
		allTouristPlace.add(place);

	}

	/**
	 * Get Places
	 * 
	 * @return
	 */

	public static List<Tourist> getTouristPlaces() {

		return allTouristPlace;

	}

	public static boolean addTouristPlace(String touristArea, double rate) throws IsValidPlaceException {
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

	public static void deleteTouristPlace(String touristPlace)  {
		int searchProduct =0;
		for (Tourist places : allTouristPlace) {
			if (places.getTouristPlace().equalsIgnoreCase(touristPlace))

			{
				searchProduct = allTouristPlace.indexOf(places);
				break;
			}
		}allTouristPlace.remove(searchProduct);
		
	}
		public static List<Tourist> searchPlace(double packageAmount)
		{
				
			for (Tourist places : allTouristPlace)
				if (places.getAmount()<=packageAmount)
				{
					searchList.add(places);
				}
		
		
			return searchList;
			
		}
		public static List<Tourist> displaySearchList()
		{
			return searchList;
		}
}
		
		
		


