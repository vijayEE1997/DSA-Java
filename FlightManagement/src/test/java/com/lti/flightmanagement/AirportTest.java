package com.lti.flightmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AirportTest {
	
	@Test
	public void testAirport() {
		Flight ecoFlight = new Flight("1",'E');
		Flight busFlight = new Flight("2",'B');
		
		Passenger john = new Passenger("John",true);
		Passenger mike = new Passenger("Mike",false);
		
		assertEquals(true,ecoFlight.addPassesnger(john));
		assertEquals(false,ecoFlight.removePassesnger(john));
		assertEquals(true,busFlight.addPassesnger(john));
		assertEquals(false,busFlight.removePassesnger(john));
		
		assertEquals(true,ecoFlight.addPassesnger(mike));
		assertEquals(true,ecoFlight.removePassesnger(mike));
		assertEquals(false,busFlight.addPassesnger(mike));
		assertEquals(false,busFlight.removePassesnger(mike));
	}
}
