package com.lti.flightmanagement.airport;

public class BusinessFlight extends Flight {

	public BusinessFlight(String id) {
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
		return false;
	}

}
