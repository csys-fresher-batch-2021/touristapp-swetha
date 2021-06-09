package in.swetha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import in.swetha.exception.DBException;
import in.swetha.model.User;
import in.swetha.util.ConnectionUtil;

public class UserServiceDAO {
	private static final Map<String, String> userDetails = new HashMap<>();
/**
 * 
 * @param userDetail
 * @return Valid Information Means let you Register
 * @throws SQLException
 * @throws DBException
 */
	public boolean userRegister(User userDetail) throws SQLException, DBException {
		boolean isValid = true;
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into user_detail(user_name,user_password,user_mobilenumber) values (?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, userDetail.getUserName());
			pst.setString(2, userDetail.getUserPassWord());
			pst.setLong(3, userDetail.getUserMobileNumber());
			pst.executeUpdate();
		} 
		catch (Exception e) {
			isValid = false;
			e.getMessage();
		} finally {
			ConnectionUtil.close(connection, pst);
		}
		return isValid;
	}
/**
 * 
 * @param userName
 * @param userPassWord
 * @return To login Getting username password
 * @throws DBException
 * @throws SQLException
 */
	public Map<String, String> userLogin(String userName, String userPassWord) 
			throws DBException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from user_detail where user_name=? and user_password=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, userName);
			pst.setString(2, userPassWord);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String name = rs.getString("user_name");
				String password = rs.getString("user_password");
				userDetails.put(name, password);
			}
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			ConnectionUtil.close(connection, pst);
		}
		return userDetails;
	}
	public Map<String, String> getAllUserDetails() {
		return userDetails;
	}

}
