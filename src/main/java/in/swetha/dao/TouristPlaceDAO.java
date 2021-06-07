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
	private static List<Tourist> placeDetail = null;

	private static final List<Tourist> placeSearch = new ArrayList<>();

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
				String touristplace = rs.getString("tourist_place");
				Double touirstamount = rs.getDouble("tourist_amount");
				String touristimage = rs.getString("tourist_image");
				Tourist tour = new Tourist(touristplace, touirstamount, touristimage);
				placeDetail.add(tour);

			}
		} catch (SQLException e) {
			e.getMessage();
		} finally {

			ConnectionUtil.close(connection, pst);
		}
		return placeDetail;
	}

	public List<Tourist> deleteTouristPlace(String touristplace) throws DBException, SQLException {

		Connection connection = null;
		PreparedStatement pst = null;

		try {

			connection = ConnectionUtil.getConnection();
			String sql = "update touristplace_detail set active_status=0 where tourist_place=?";

			pst = connection.prepareStatement(sql);
			String place = touristplace;
			pst.setString(1, place);
			pst.executeUpdate();

			placeDetail.clear();
			allTouristPlace();
		} catch (SQLException e) {
			e.getMessage();
		}

		ConnectionUtil.close(connection, pst);
		return placeDetail;

	}

	public List<Tourist> searchBudgetPlace(double touristAmount) throws SQLException, DBException {
		Connection connection = null;
		PreparedStatement pst = null;

		try {

			connection = ConnectionUtil.getConnection();
			String sql = "select * from touristplace_detail where tourist_amount <= ? ";
			pst = connection.prepareStatement(sql);
			pst.setDouble(1, touristAmount);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String touristplace = rs.getString("tourist_place");
				Double touirstamount = rs.getDouble("tourist_amount");
				String touristimage = rs.getString("tourist_image");
				Tourist tourist = new Tourist(touristplace, touirstamount, touristimage);
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
