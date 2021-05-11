package in.swetha.validation;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import in.swetha.model.Tourist;
import in.swetha.service.ListOfTouristPlaces;

public class TestTouristPlaces {

	@Test
	public void test() {

		List<Tourist> Places = ListOfTouristPlaces.getTouristPlaces();
		assertEquals(5, Places.size());

	}

	@Test
	public void test1() {

		List<Tourist> Places = ListOfTouristPlaces.getTouristPlaces();
		assertEquals(4, Places.size());

	}
}
