package com.sunil486.firstspringapp02;

//@Component
public class Mobile {

	Sim sim;

	public Mobile(Sim sim) {
		System.out.println("Constructor injection");
		this.sim = sim;
	}

	// @Autowired
	// @Qualifier("jio")
	public void setSim(Sim sim) {
		System.out.println("Setter injection");
		this.sim = sim;
	}

	public void accessSim() {
		sim.calling();
		sim.data();

	}

}
