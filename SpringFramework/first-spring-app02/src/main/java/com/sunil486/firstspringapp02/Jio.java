package com.sunil486.firstspringapp02;

import org.springframework.stereotype.Component;

@Component("jio")
//@Primary
public class Jio implements Sim {

	public void calling() {
		System.out.println("Jio Calling");

	}

	public void data() {
		System.out.println("Jio Data");

	}

}
