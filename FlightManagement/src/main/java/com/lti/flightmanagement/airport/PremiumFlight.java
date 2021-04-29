package com.lti.flightmanagement.airport;

public class PremiumFlight extends Flight{

	public PremiumFlight(String id) {
		super(id);
	}

	@Override
	public boolean addPassesnger(Passenger passenger) {
		if(passenger.isVip())
			return passengersList.add(passenger);
		return false;
	}

	@Override
	public boolean removePassesnger(Passenger passenger) {
		if(passenger.isVip())
			return passengersList.remove(passenger);
		return false;
	}

}
