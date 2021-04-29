package com.lti.flightmanagement.milage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.lti.flightmanagement.airport.Flight;
import com.lti.flightmanagement.airport.Passenger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MilageTest {

	private Milage milage;
	
	@BeforeAll
	void beforeAll() {
		milage = new Milage();
	}
	
	@ParameterizedTest
	@Disabled
	@ValueSource(strings = {"1;e;Mike;false;349","2;b;John;true;278","3;e;Mike;false;39","4;p;John;true;817"})
	void checkGivenPoints(@ConvertWith(FlightArgumentConverter.class) Flight flight) {
		for(Passenger p:flight.getPassengersList()) {
			milage.addMilage(p, flight.getDistance());
		}
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/flights_information.csv")
	void checkGivenPointsWithCSV(@ConvertWith(FlightArgumentConverter.class) Flight flight) {
		for(Passenger p:flight.getPassengersList()) {
			milage.addMilage(p, flight.getDistance());
		}
	}
	
	@AfterAll
	void afterAll() {
		milage.calculateGivenPoints();
		assertEquals(19,milage.getPassengersPointsMap().get(new Passenger("Mike",false)));
		assertEquals(109,milage.getPassengersPointsMap().get(new Passenger("John",true)));
	}
}
