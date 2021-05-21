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
	public void test1() {

		try {
			TouristPlaceService.addTouristPlace("oo", 35000.0);
		} catch (IsValidPlaceException e) {

			e.printStackTrace();
		}
	}

	@Test
	public void test2() {

		try {
		TouristPlaceService.addTouristPlace("", 90.0);
		} catch (IsValidPlaceException e) {

			e.printStackTrace();
		}

	}

}
