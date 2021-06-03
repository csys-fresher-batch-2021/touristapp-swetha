package in.swetha.service;

import java.sql.SQLException;
import java.util.Map;
import in.swetha.DAO.UserServiceDAO;
import in.swetha.exception.DBException;
import in.swetha.model.User;

public class UserService {
	private UserService() {
	}

	private static UserServiceDAO userDetail = new UserServiceDAO();

	public static boolean adduserDetail(User user) throws SQLException, DBException {
		boolean valid = false;
		if (userDetail.userRegister(user)) {
			valid = true;
		}
		return valid;
	}

	public static boolean validUserLogin(String userName, String userPassword) throws DBException, SQLException {
		boolean isValid = false;
		Map<String, String> userCheck = userDetail.userLogin(userName, userPassword);

		if (userCheck.containsKey(userName) && userPassword.equals(userCheck.get(userName))) {

			isValid = true;
		}

		return isValid;
	}
}
