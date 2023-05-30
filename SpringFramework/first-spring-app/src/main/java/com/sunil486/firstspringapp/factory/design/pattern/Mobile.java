package com.sunil486.firstspringapp.factory.design.pattern;

public class Mobile {

	Sim sim;// default value is null

	public void accessSim(String accessSim) {

		this.sim = SimFactory.create(accessSim);
		sim.calling();
		sim.data();
	}

}
