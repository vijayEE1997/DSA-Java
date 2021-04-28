package com.lti.flightmanagement;

public class Airport {
	
	public static void main(String[] args) {
		Flight ecoFlight = new Flight("1",'E');
		Flight busFlight = new Flight("2",'B');
		
		Passenger john = new Passenger("John",true);
		Passenger mike = new Passenger("Mike",false);
		
		busFlight.addPassesnger(john);
		busFlight.removePassesnger(john);
		busFlight.addPassesnger(mike);
		ecoFlight.addPassesnger(mike);
		
		System.out.println("Business Flight");
		for(Passenger p: busFlight.getPassengersList())
			System.out.println(p.getName());
		
		System.out.println("Economic Flight");
		for(Passenger p: ecoFlight.getPassengersList())
			System.out.println(p.getName());
	}
	
	

}
