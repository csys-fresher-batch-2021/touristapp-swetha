package in.swetha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.swetha.exception.DBException;
import in.swetha.model.Tourist;
import in.swetha.util.ConnectionUtil;

public class TouristPlaceDAO {
	private static  List<Tourist> placeSearch;
	private static List<Tourist> placeDetail;
	public boolean save(Tourist tour) throws SQLException, DBException {
		boolean isValid = false;
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into touristplace_detail(tourist_place,tourist_amount,tourist_image)values(?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, tour.getTouristPlace());
			pst.setDouble(2, tour.getAmount());
			pst.setString(3, tour.getImageURL());
			pst.executeUpdate();
		} catch (SQLException e) {
			isValid = true;
			e.getMessage();
		} finally {
			ConnectionUtil.close(connection, pst);
		}
		return isValid;
	}

	public List<Tourist> allTouristPlace() throws DBException, SQLException {
		placeDetail = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from touristplace_detail where active_status=1";
			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String place = rs.getString("tourist_place");
				Double amount = rs.getDouble("tourist_amount");
				String image = rs.getString("tourist_image");
				Tourist tour = new Tourist(place, amount, image);
				placeDetail.add(tour);
			}
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			ConnectionUtil.close(connection, pst);
		}
		return placeDetail;
	}

	public List<Tourist> deleteTouristPlace(String touristPlace) throws DBException, SQLException {
		
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "update touristplace_detail set active_status=0 where tourist_place=?";
			pst = connection.prepareStatement(sql);
			String place = touristPlace;
			pst.setString(1, place);
			pst.executeUpdate();
			placeDetail.clear();
			allTouristPlace();
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			ConnectionUtil.close(connection, pst);
		}
		return placeDetail;
	}

	public List<Tourist> searchBudgetPlace(Double touristAmount) throws SQLException, DBException {
		placeSearch = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from touristplace_detail where tourist_amount <= ? ";
			pst = connection.prepareStatement(sql);
			pst.setDouble(1, touristAmount);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String place = rs.getString("tourist_place");
				Double amount = rs.getDouble("tourist_amount");
				String image = rs.getString("tourist_image");
				Tourist tourist = new Tourist(place, amount, image);
				placeSearch.add(tourist);
			}
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			ConnectionUtil.close(connection, pst);
		}
		return placeSearch;
	}

	public List<Tourist> getSearchTouristPlace() {
		
		return placeSearch;
	}
}
