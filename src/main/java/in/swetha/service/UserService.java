package in.swetha.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import in.swetha.exception.InValidDetailException;
import in.swetha.model.User;
import in.swetha.validator.UserServiceValidator;

public class UserService {
	private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private UserService(){
	}
	
	private static List<User> userDetailsList = new ArrayList<>();

	public static List<User> adduser(User user) {

		userDetailsList.add(user);
		return userDetailsList;
	}

	/**
	 * 
	 * @param user
	 * @return
	 * @throws InValidDetailException
	 */
	public static boolean validLogin(User user) throws InValidDetailException {

		boolean validLogIn = false;
		try {
			for (User userList : userDetailsList)
				if (userList.getUserName().equalsIgnoreCase(user.getUserName())
						&& userList.getUserPassWord().equalsIgnoreCase(user.getUserPassWord())) {
					validLogIn = true;
				}

		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new InValidDetailException("Unable To Login");
		}
		return validLogIn;

	}

	/**
	 * 
	 * @param user
	 * @return
	 * @throws InValidDetailException
	 */
	public static boolean validRegister(User user) throws InValidDetailException {
		boolean validRegister = false;
		try {
			if (UserServiceValidator.isValidRegistration(user))

			{

				validRegister = true;
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new InValidDetailException("Register Invalid Credential");
		}

		return validRegister;
	}

}
