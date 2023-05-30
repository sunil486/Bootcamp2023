package com.sunil486.firstspringapp.dependency.injection.principal.ci;

public class App {
	public static void main(String[] args) {

		// Mobile airtel = new Mobile(new Airtel());
		Mobile airtel = new Mobile(new Jio());
		airtel.accessSim();
	}
}
