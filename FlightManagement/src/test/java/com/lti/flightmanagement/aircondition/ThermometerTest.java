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
class ThermometerTest {

	@InjectMocks
	Thermometer thermometer;
	
	@Mock
	Sensor sensor;
	
	@Test
	public void testWorkingSensor() {
		thermometer.setTemperature(25);
		when(sensor.isBlocked()).thenReturn(false);
		assertEquals(sensor,thermometer.getSensor());
		assertEquals(25,thermometer.getTemperature(),0.001);
		verify(sensor,times(1)).isBlocked();
		
	}
	
	@Test
	public void testBlockedSensor() {
		thermometer.setTemperature(25);
		when(sensor.isBlocked()).thenReturn(true);
		assertEquals(sensor,thermometer.getSensor());
		assertThrows(RuntimeException.class,()->thermometer.getTemperature());
		verify(sensor,times(1)).isBlocked();
	}
}
