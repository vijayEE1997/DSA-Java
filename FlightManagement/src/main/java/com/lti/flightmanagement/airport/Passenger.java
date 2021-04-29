package com.lti.flightmanagement.airport;

import java.util.Objects;

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
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null || getClass() != o.getClass())
			return false;
		Passenger p = (Passenger) o;
		return Objects.equals(name, p.name);
	}
	
	
	
}
