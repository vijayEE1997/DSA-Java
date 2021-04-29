package com.lti.flightmanagement.milage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.lti.flightmanagement.airport.Passenger;

public class Milage {
	
	public static final int VIP_FACTOR=10;
	public static final int USUAL_FACTOR=20;
	
	private Map<Passenger,Integer> passengersMilageMap = new HashMap<>();
	private Map<Passenger,Integer> passengersPointsMap = new HashMap<>();
	
	public Map<Passenger, Integer> getPassengersPointsMap() {
		return Collections.unmodifiableMap(this.passengersPointsMap);
	}

	public void  addMilage(Passenger p,int miles) {
		if(passengersMilageMap.containsKey(p))
			passengersMilageMap.put(p,passengersMilageMap.get(p)+miles);
		else
			passengersMilageMap.put(p,miles);
	}

	public void calculateGivenPoints() {
		for(Passenger p: passengersMilageMap.keySet()) {
			if(p.isVip())
				passengersPointsMap.put(p,passengersMilageMap.get(p)/VIP_FACTOR);
			else
				passengersPointsMap.put(p,passengersMilageMap.get(p)/USUAL_FACTOR);
		}
	}
}
