package com.lti.flightmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Flight {

	private String id;
	private List<Passenger> passengersList = new ArrayList<Passenger>();
	private char flightType;
	
	public Flight(String id, char flightType) {
		this.id = id;
		this.flightType = flightType;
	}

	public String getId() {
		return id;
	}

	public List<Passenger> getPassengersList() {
		return Collections.unmodifiableList(passengersList);
	}
	
	public boolean addPassesnger(Passenger passenger) {
		switch(flightType) {
		case 'E':
			return passengersList.add(passenger);
		case 'B':
			if(passenger.isVip())
				return passengersList.add(passenger);
			return false;
		default :
			throw new RuntimeException("Unknown Type: "+ flightType);
			
		}
	}

	public boolean removePassesnger(Passenger passenger) {
		switch(flightType) {
		case 'E':
			if(!passenger.isVip())
				return passengersList.remove(passenger);
			return false;
		case 'B':
			return false;
		default :
			throw new RuntimeException("Unknown Type: "+ flightType);
			
		}
	}		
}
