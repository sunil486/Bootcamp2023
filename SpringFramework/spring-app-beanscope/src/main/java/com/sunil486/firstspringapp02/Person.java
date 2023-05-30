package com.sunil486.firstspringapp02;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@Lazy
public class Person {

	private String name;

	private String role;

	public Person() {
		System.out.println("Person Constructor Called");
	}

	void printPersonInfo() {
		System.out.println("Person name is : " + name + " and role is : " + role);
	}

}
