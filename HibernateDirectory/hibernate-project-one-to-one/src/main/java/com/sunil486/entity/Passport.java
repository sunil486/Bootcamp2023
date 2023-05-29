package com.sunil486.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Passport")
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "passport_id")
	private int id;

	@Column(name = "passport_number")
	private String passportNumber;

	@OneToOne(mappedBy = "passport")
	// @OneToOne(mappedBy = "passport", cascade=CascadeType.ALL) But it is not
	// recommended, Parent should have this controll not child
	private Student student;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", passportNumber=" + passportNumber + "]";
	}
}
