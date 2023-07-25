package com.sunil486.firstspringapp02;

import org.springframework.stereotype.Component;

@Component
public class Person {

	private String name = "SKG";
	private String address = "PUNE";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + "]";
	}
}
