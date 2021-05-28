package in.swetha.validator;

import in.swetha.exception.InvalidPassWordException;

import in.swetha.exception.IsValidNameException;
import in.swetha.model.User;

public class UserServiceValidator {

	private UserServiceValidator() {
		// Default constructor
	}

	public static boolean isValidRegistration(User user) throws IsValidNameException, InvalidPassWordException {
		String username = user.getUserName();
		String password = user.getUserPassWord();
		long mobileNo = user.getUserMobileNumber();
		boolean valid = false;
		if (UserValidator.isValidUserName(username) && UserValidator.isValidPassword(password)
				&& UserValidator.isValidMobileNumber(mobileNo)) {
			valid = true;
		}
		return valid;
	}

	}
