package com.sunil486.firstspringapp.dependency.injection.principal.si;

public class App {
	public static void main(String[] args) {

		Mobile airtel = new Mobile();// Object creation

		// DI & Object creation(Airtel)
		// airtel.setSim(new Airtel());

		// DI & Object creation(Jio)
		airtel.setSim(new Jio());

		airtel.accessSim();
	}
}
