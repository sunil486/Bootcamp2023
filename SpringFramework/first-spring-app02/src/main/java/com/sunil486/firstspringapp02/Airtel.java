package com.sunil486.firstspringapp02;

import org.springframework.stereotype.Component;

@Component("airtel")
//@Primary
public class Airtel implements Sim {

	public void calling() {
		System.out.println("Airtel Calling");

	}

	public void data() {
		System.out.println("Airtel Data");

	}

}
