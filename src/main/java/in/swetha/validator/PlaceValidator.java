package in.swetha.validator;
import in.swetha.exception.IsValidPlaceException;



public class PlaceValidator {

	private PlaceValidator()
	{
		//default constructor
	}
	public static boolean touristPlaceValidator(String place, String errorMessage) 
			throws IsValidPlaceException
	{
		if(place==null||place.trim().length()<=2)
		{
			throw new IsValidPlaceException(errorMessage);
		}
		return true;
	}

}
