package com.lti.flightmanagement;

public class Passenger {

	private String name;
	private boolean vip;
	
	public Passenger(String name, boolean vip) {
		super();
		this.name = name;
		this.vip = vip;
	}
	public String getName() {
		return name;
	}
	public boolean isVip() {
		return vip;
	}
	
}
