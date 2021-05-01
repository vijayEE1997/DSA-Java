package com.lti.flightmanagement.aircondition;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.lti.flightmanagement.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AirConditioningSystemTest {

	@InjectMocks
	AirConditioningSystem airConditioningSystem;
		
	@Mock
	Thermometer thermometer;
		
	@Test
	public void testAirconditioningSystemStarted() {
		when(thermometer.getTemperature()).thenReturn(25.0);
		airConditioningSystem.setTemperatureThreshold(24.0);
		airConditioningSystem.checkAirConditioningSystem();
		assertTrue(airConditioningSystem.isOpen());
		verify(thermometer,times(1)).getTemperature();
		
	}
	
	@Test
	public void testAirconditioningSystemStopped() {
		when(thermometer.getTemperature()).thenReturn(23.0);
		airConditioningSystem.setTemperatureThreshold(24.0);
		airConditioningSystem.checkAirConditioningSystem();
		assertFalse(airConditioningSystem.isOpen());
		verify(thermometer,times(1)).getTemperature();
	}
}
