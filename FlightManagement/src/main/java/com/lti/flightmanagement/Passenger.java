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
	public void setName(String name) {
		this.name = name;
	}
	public boolean isVip() {
		return vip;
	}
	public void setVip(boolean vip) {
		this.vip = vip;
	}
	
	
}
