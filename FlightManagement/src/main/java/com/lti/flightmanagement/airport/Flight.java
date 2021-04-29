package com.lti.flightmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Flight {

	private String id;
	Set<Passenger> passengersList = new HashSet<Passenger>();
	
	public Flight(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public Set<Passenger> getPassengersList() {
		return Collections.unmodifiableSet(passengersList);
	}
	
	public abstract boolean addPassesnger(Passenger passenger); 
	public abstract boolean removePassesnger(Passenger passenger);

	
}
