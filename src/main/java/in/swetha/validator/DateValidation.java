package in.swetha.validator;

import java.time.LocalDate;

import in.swetha.exception.ValidDateException;

public class DateValidation {
	public static boolean dateValidationStart(LocalDate validateDate) throws ValidDateException
	{

	LocalDate date = LocalDate.now();
	boolean isValidStartDate = true;
	if(validateDate.isBefore(date))
	{
		throw new ValidDateException("Entered starting journey date is before current date");
	}return isValidStartDate;

}


public static boolean dateValidationEnd(LocalDate startDate, LocalDate validateDate) throws ValidDateException {
	boolean isValidateEndDate = true;
	if (validateDate.isBefore(startDate)) {
		throw new ValidDateException("Entered end journey date is before the start date");

	}
	return isValidateEndDate;

}
}
