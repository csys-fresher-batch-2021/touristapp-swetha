package in.swetha.service;

import java.sql.SQLException;
import java.util.List;
import in.swetha.dao.TouristPlaceDAO;
import in.swetha.exception.DBException;
import in.swetha.model.Tourist;

public class TouristPlaceService {

	private TouristPlaceService() {
		// Default Constructor

	}

	private static TouristPlaceDAO placeDao = new TouristPlaceDAO();

	public static boolean addTouristPlace(String touristPlace, Double touristAmount, String imageURL)
			throws SQLException, DBException {
		Tourist place = new Tourist(touristPlace, touristAmount, imageURL);
		boolean valid = placeDao.save(place);
		return valid;
	}

	public static List<Tourist> displayTouristPlace() throws ClassNotFoundException, DBException, SQLException {
		return placeDao.allTouristPlace();
	}

	public static List<Tourist> deletePlace(String touristPlace) throws DBException, SQLException {
		return (placeDao.deleteTouristPlace(touristPlace));
	}

	public static boolean searchBudgetTouristPlace(Double touristAmount) {
		boolean isSearch = true;
		try {
			placeDao.searchBudgetPlace(touristAmount);
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