package in.swetha.validation;

import static org.junit.Assert.*;

import org.junit.Test;

import in.swetha.exception.InvalidPassWordException;
import in.swetha.exception.IsValidNameException;
import in.swetha.validator.UserValidator;

public class RegisterTest {

	@Test
	public void testusername() {

		boolean valid = false;
		try {
			valid = UserValidator.isValidUserName("swetha");
		} catch (IsValidNameException e) {
			assertTrue(valid);
			e.printStackTrace();
		}

	}

	@Test
	public void testpassword() {
		boolean valid = false;
		try {
			valid = UserValidator.isValidPassword("swetha");
		} catch (InvalidPassWordException e) {
			assertFalse(valid);
			e.printStackTrace();
		}

	}

}
