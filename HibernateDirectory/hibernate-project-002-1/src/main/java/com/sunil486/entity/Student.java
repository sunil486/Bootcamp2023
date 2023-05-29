package com.sunil486.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student { //entity  --> pk

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // Basic value type

	@Column(name = "student_name") // default datatype VARCHAR , nullable true and length 255
	// @Column(name = "student_name", length = 70) // VARCHAR , nullable true and
	// length 70
	// @Column(name = "student_name", length = 70, nullable = false) // not null
	private String name; // Basic value type

	@Column(name = "student_mobile")
	private Long mobile; // Basic value type

	// private Demo demo; // Composite value type

	@Embedded //This annotation is optional
	private Address address; // Composite value type

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
