package com.lti.flightmanagement;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class AirportTest {
	
	private Passenger mike;
	private Passenger john;
	
	@BeforeEach
	public void init() {
		mike = new Passenger("Mike",false);
		john = new Passenger("John",true);		
	}
	
	@Nested
	@DisplayName("Given there is a Business Flight")
	class BusinessFlightTest{
		
		private Flight busFlight;
		
		@BeforeEach
		public void init() {
			busFlight = new BusinessFlight("2");
		}
		
		@Test
		@DisplayName("Usual Passenger")
		public void usualPassenger() {

			assertAll(
					()->assertEquals(false,busFlight.addPassesnger(mike)),
					()->assertEquals(0,busFlight.getPassengersList().size()),
					()->assertEquals(false,busFlight.removePassesnger(mike)),
					()->assertEquals(0,busFlight.getPassengersList().size())
					);
		}
		
		@Test
		@DisplayName("VIP Passenger")
		public void vipPassenger() {

			assertAll(
					()->assertEquals(true,busFlight.addPassesnger(john)),
					()->assertEquals(1,busFlight.getPassengersList().size()),
					()->assertEquals(false,busFlight.removePassesnger(john)),
					()->assertEquals(1,busFlight.getPassengersList().size())
					);
		}
		
	}
	
	@Nested
	@DisplayName("Given there is a Economy Flight")
	class EconomyFlightTest{
		
		private Flight ecoFlight;
		
		@BeforeEach
		public void init() {
			ecoFlight = new EconomyFlight("1");
		}
		
		@Test
		@DisplayName("Usual Passenger")
		public void usualPassenger() {

			assertAll(
					()->assertEquals("1",ecoFlight.getId()),
					()->assertEquals(true,ecoFlight.addPassesnger(mike)),
					()->assertEquals(1,ecoFlight.getPassengersList().size()),
					()->assertEquals("Mike",ecoFlight.getPassengersList().get(0).getName()),
					
					()->assertEquals(true,ecoFlight.removePassesnger(mike)),
					()->assertEquals(0,ecoFlight.getPassengersList().size())
					);
		}
		
		@Test
		@DisplayName("VIP Passenger")
		public void vipPassenger() {

			assertAll(
					()->assertEquals("1",ecoFlight.getId()),
					()->assertEquals(true,ecoFlight.addPassesnger(john)),
					()->assertEquals(1,ecoFlight.getPassengersList().size()),
					()->assertEquals("John",ecoFlight.getPassengersList().get(0).getName()),
					
					()->assertEquals(false,ecoFlight.removePassesnger(john)),
					()->assertEquals(1,ecoFlight.getPassengersList().size())
					);
		}
	}
	@Nested
	@DisplayName("Given there is a Premium Flight")
	class PremiumFlightTest{
		
		private Flight premFlight;
		
		@BeforeEach
		public void init() {
			premFlight = new PremiumFlight("1");
		}
		
		@Test
		@DisplayName("Usual Passenger")
		public void usualPassenger() {

			assertAll(
					()->assertEquals(false,premFlight.addPassesnger(mike)),
					()->assertEquals(0,premFlight.getPassengersList().size()),					
					()->assertEquals(false,premFlight.removePassesnger(mike)),
					()->assertEquals(0,premFlight.getPassengersList().size())
					);
		}
		
		@Test
		@DisplayName("VIP Passenger")
		public void vipPassenger() {

			assertAll(
					()->assertEquals(true,premFlight.addPassesnger(john)),
					()->assertEquals(1,premFlight.getPassengersList().size()),
					()->assertEquals(true,premFlight.removePassesnger(john)),
					()->assertEquals(0,premFlight.getPassengersList().size())
					);
		}
	}
}
