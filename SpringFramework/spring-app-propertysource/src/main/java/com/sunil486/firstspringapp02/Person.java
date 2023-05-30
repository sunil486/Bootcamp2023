package com.sunil486.firstspringapp02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {

	@Value("${name}")
	private String name;

	@Value("${role}")
	private String role;

	@Value("${org}")
	private String org;

	@Value("${exp}")
	private String exp;
	
	@Value("${USER}")
	private String user;

	public void printPersonInfo() {
		System.out
				.println("Person name is : " + name + " and role is : " + role + " and org is " + org + " exp " + exp + " and user is : " +user);
	}

}
