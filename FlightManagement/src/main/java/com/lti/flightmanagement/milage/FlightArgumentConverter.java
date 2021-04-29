package com.lti.flightmanagement.milage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import com.lti.flightmanagement.airport.BusinessFlight;
import com.lti.flightmanagement.airport.EconomyFlight;
import com.lti.flightmanagement.airport.Flight;
import com.lti.flightmanagement.airport.Passenger;
import com.lti.flightmanagement.airport.PremiumFlight;

public class FlightArgumentConverter extends SimpleArgumentConverter {
	@Override
	protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
		assertEquals(String.class,source.getClass(),"Can onlyu convert from String");
		assertEquals(Flight.class,targetType,"Can only convert to flight");
		
		String[] stringFlight = source.toString().split(";");
		Flight flight = null;
		
		switch(stringFlight[1].toLowerCase().trim().charAt(0)) {
		case 'b' :	flight = new BusinessFlight(stringFlight[0]);
			break;
		case 'e' :	flight = new EconomyFlight(stringFlight[0]);
			break;
		case 'p' :	flight = new PremiumFlight(stringFlight[0]);
			break;
		}
		
		flight.addPassesnger(new Passenger(stringFlight[2].trim(),Boolean.valueOf(stringFlight[3].trim())));
		flight.setDistance(Integer.parseInt(stringFlight[4].trim()));
		
		return flight;
	}

}
