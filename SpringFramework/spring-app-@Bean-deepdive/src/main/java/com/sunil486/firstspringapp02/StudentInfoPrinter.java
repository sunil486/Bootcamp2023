package com.sunil486.firstspringapp02;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentInfoPrinter {

	@Autowired
	private Person person;

	@Autowired
	private Student student;

	// Approach 1
	// private ModelMapper modelMapper;

	// Approach 2
	// @Autowired
	// private ModelMapper modelMapper;

	// Approach 3
	//Use @Bean in AppConfig class
	@Autowired
	private ModelMapper modelMapper;

	public void printStudentInfo() {
		// Approach 1
		// modelMapper = new ModelMapper();

		modelMapper.map(person, student);
		System.out.println(student);
	}

}
