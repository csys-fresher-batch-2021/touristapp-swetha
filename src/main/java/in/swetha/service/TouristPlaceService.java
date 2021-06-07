package in.swetha.service;

import java.sql.SQLException;
import java.util.List;
import in.swetha.dao.TouristPlaceDAO;
import in.swetha.exception.DBException;
import in.swetha.model.Tourist;

public class TouristPlaceService {

	public TouristPlaceService() {
		// Default Constructor

	}

	private static TouristPlaceDAO placeDao = new TouristPlaceDAO();

	public static boolean addTouristPlace(String touristplace, double touristamount, String imageURL)
			throws ClassNotFoundException, SQLException, DBException {
		Tourist place = new Tourist(touristplace, touristamount, imageURL);
		boolean valid = placeDao.save(place);
		if (valid) {

		}

		return valid;
	}

	public static List<Tourist> displayTouristPlace() throws ClassNotFoundException, DBException, SQLException {

		List<Tourist> place = placeDao.allTouristPlace();

		return place;
	}

	public static List<Tourist> deletePlace(String touristPlace) throws DBException, SQLException {

		return (placeDao.deleteTouristPlace(touristPlace));

	}

	public static boolean searchBudgetTouristPlace(double touristamount) {
		boolean isSearch = true;

		try {
			placeDao.searchBudgetPlace(touristamount);
		} catch (DBException | SQLException e) {
			e.getMessage();
			isSearch = false;
		}
		return isSearch;
	}

	public List<Tourist> displaySearchTouristPlace() {
		return (placeDao.getSearchTouristPlace());
	}

}