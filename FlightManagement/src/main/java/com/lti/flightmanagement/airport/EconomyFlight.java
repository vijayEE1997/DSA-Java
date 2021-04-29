package com.lti.flightmanagement;

public class EconomyFlight extends Flight{

	public EconomyFlight(String id) {
		super(id);
	}

	@Override
	public boolean addPassesnger(Passenger passenger) {
		return passengersList.add(passenger);
	}

	@Override
	public boolean removePassesnger(Passenger passenger) {
		if(!passenger.isVip())
			return passengersList.remove(passenger);
		return false;
	}

}
