package in.swetha.validator;

import in.swetha.exception.InvalidPassWordException;

import in.swetha.exception.IsValidNameException;

public class UserValidator {
	/**
	 * 
	 * @param name
	 * @returnChecking UserName With Some Condition
	 * @throws IsValidNameException
	 */
	public static boolean isValidUserName(String name) throws IsValidNameException {

		boolean valid = false;
		if (name == null || name.trim().equals("") || name.trim().length() < 3) {
			throw new IsValidNameException("Invalid name");
		} else {
			valid = true;
		}
		return valid;
	}

	/**
	 * 
	 * @param password
	 * @return valid password
	 * @throws InvalidPassWordException
	 */

	public static boolean isValidPassword(String password) throws InvalidPassWordException {
		boolean valid = false;
		if (password.length() < 7 || password.length() > 15 && password == null || password.trim().equals("")) {
			throw new InvalidPassWordException("Invalid Mobile Number");
		} else {
			valid = true;

		}
		return valid;
	}

	/**
	 * Checking Whether Mobile Number is Valid
	 * 
	 * @param mobileNo
	 * @return
	 */
	public static boolean isValidMobileNumber(long mobileNo) {
		boolean validMobileNo = false;
		String mobileNumberString = String.valueOf(mobileNo);
		if (mobileNumberString != null && mobileNumberString.trim().length() == 10 && mobileNumberString.startsWith("9")
				|| mobileNumberString.startsWith("8")) {
			validMobileNo = true;

		}
		return validMobileNo;
	}

}
