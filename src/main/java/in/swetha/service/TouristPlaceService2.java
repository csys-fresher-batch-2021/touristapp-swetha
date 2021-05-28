package in.swetha.service;

import java.util.ArrayList;
import java.util.List;
import in.swetha.model.Tourist;
import com.google.gson.Gson;

public class TouristPlaceService2 {
		 public static List<Tourist> getAllTouristPlaces()
		 {
			 List<Tourist> placeDetail = new ArrayList<Tourist>(); 
			 Tourist place=new Tourist("Manali",50000.0,"manali.jpg");
			 Tourist place1=new Tourist("Ooty",35000.0,"ooty.jpg");			 
			 placeDetail.add(place);
			 placeDetail.add(place1);
			  return placeDetail;
			  }
		 
		 public static boolean addTouristPlace(String touristPlace,Double packageAmount) throws Exception {
			 
			 throw new Exception("Invalid Place Name");
			  
		 }
		 public static void main(String[] args) {
				List<Tourist> place=getAllTouristPlaces();
				 Gson gson = new Gson(); 
				String json = gson.toJson(place);
				System.out.println(" GSON JAR \n" + json);
			}
}
	
	
	
	
	
	
	
