package in.swetha.validation;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import in.swetha.model.Tourist;
import in.swetha.service.TouristPlaceService;

public class TestTouristPlaces {

	@Test
	public void test() {

		List<Tourist> Places = TouristPlaceService.getTouristPlaces();
		assertEquals(5, Places.size());

	}

	
}
