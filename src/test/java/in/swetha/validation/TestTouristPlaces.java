package in.swetha.validation;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import in.swetha.exception.IsValidPlaceException;
import in.swetha.model.Tourist;
import in.swetha.service.TouristPlaceService;

public class TestTouristPlaces {

	@Test
	public void test() {

		List<Tourist> Places = TouristPlaceService.getTouristPlaces();
		assertEquals(5, Places.size());

	}

	@Test
	public void test1() throws IsValidPlaceException {

		boolean valid = TouristPlaceService.addTouristPlace("oo", 35000.0);

		assertFalse(valid);

	}

	@Test
	public void test2() throws IsValidPlaceException {

		boolean valid = TouristPlaceService.addTouristPlace("", 90.0);

		assertFalse(valid);
	}

}
