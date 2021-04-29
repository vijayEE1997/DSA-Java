package com.lti.flightmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AirportTest {
	
	@Test
	public void testAirport() {
		Flight ecoFlight = new EconomyFlight("1");
		Flight busFlight = new BusinessFlight("2");
		
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
	
	@Test
	public void businessFlightVipPassenger() {
		Flight busFlight = new BusinessFlight("2");
		Passenger john = new Passenger("John",true);

		assertEquals(true,busFlight.addPassesnger(john));
		assertEquals(1,busFlight.getPassengersList().size());
		assertEquals(false,busFlight.removePassesnger(john));
		assertEquals(1,busFlight.getPassengersList().size());
	}
	
	@Test
	public void businessFlightUsualPassenger() {
		Flight busFlight = new BusinessFlight("2");
		Passenger mike = new Passenger("Mike",false);

		assertEquals(false,busFlight.addPassesnger(mike));
		assertEquals(0,busFlight.getPassengersList().size());
		assertEquals(false,busFlight.removePassesnger(mike));
		assertEquals(0,busFlight.getPassengersList().size());
	}
}
