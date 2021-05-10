package in.swetha.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListOfTouristPlaces {
	private static Map<String, Integer> allTouristPlace = new HashMap<String, Integer>();
	static {
	allTouristPlace.put("Ooty", 35000);
	allTouristPlace.put("Goa", 70000);
	allTouristPlace.put("Manali", 75000);
	allTouristPlace.put("Simla", 90000);
	allTouristPlace.put("Kodaikanal", 50000);


	}
	
	public static Map<String, Integer> getTouristPlaces()
	{
	
		return allTouristPlace;
		
		
	}
	
	  public static void displayAllTouristPlaces() {
	  System.out.println(">>>Avaliable Tourist Places<<<");
	  for (String key :allTouristPlace.keySet())
	  { 
		  int value = allTouristPlace.get(key);
		  
	  System.out.println(key + "...TouristPackage Amount Will Be Rs." + value); 
	  }
	  }
	 
}



