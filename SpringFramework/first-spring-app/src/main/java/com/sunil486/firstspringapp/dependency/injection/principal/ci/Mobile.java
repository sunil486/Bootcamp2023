package com.sunil486.firstspringapp.dependency.injection.principal.ci;

public class Mobile {

	Sim sim;// default value is null

	public Mobile(Sim sim) {
		this.sim = sim;
	}

	public void accessSim() {
		sim.calling();
		sim.data();
	}

}
