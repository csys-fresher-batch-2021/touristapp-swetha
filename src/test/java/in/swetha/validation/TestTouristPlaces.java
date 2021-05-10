package in.swetha.validation;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import in.swetha.service.ListOfTouristPlaces;

public class TestTouristPlaces {

	@Test
	public  void test() {
		
		Map<String,Integer> Places=ListOfTouristPlaces.getTouristPlaces();
		assertEquals(5,Places.size());

	}
	@Test
	public  void test1() {
		
		Map<String,Integer> Places=ListOfTouristPlaces.getTouristPlaces();
		assertEquals(4,Places.size());

	}
	@Test
	public void test2()
	{
		ListOfTouristPlaces.displayAllTouristPlaces();
	}
}