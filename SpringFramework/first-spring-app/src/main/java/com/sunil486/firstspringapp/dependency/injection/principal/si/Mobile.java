package com.sunil486.firstspringapp.dependency.injection.principal.si;

public class Mobile {

	Sim sim;// default value is null


	public void setSim(Sim sim) {
		this.sim = sim;
	}



	public void accessSim() {
		sim.calling();
		sim.data();
	}

}
