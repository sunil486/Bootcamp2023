package com.sunil486.firstspringapp.dependency.injection.principal.si;

public class SimFactory {

	public static Sim create(String accessSim) {

		switch (accessSim) {

		case "airtel":
			return new Airtel();

		case "jio":
			return new Jio();

		default:
			throw new IllegalArgumentException("Sim is Invalid");
		}
	}
}
