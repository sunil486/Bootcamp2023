package com.sunil486.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "students")
//@NamedQuery(name = "myapp.allstudents", query = "FROM Student s")
//@NamedQuery(name = "myapp.allstudents.age", query = "FROM Student s where age = :AGE")

@NamedQueries(value = { @NamedQuery(name = "myapp.allstudents", query = "FROM Student s"),
		@NamedQuery(name = "myapp.allstudents.age", query = "FROM Student s where age = :AGE"),
		// @NamedQuery(name = "myapp.allstudents.namelike", query = "FROM Student s
		// where name like '%a'"),
		// @NamedQuery(name = "myapp.allstudents.namelike", query = "FROM Student s
		// where name like 'a%'")
		// @NamedQuery(name = "myapp.allstudents.namelike", query = "FROM Student s
		// where name like '%a%'")
		@NamedQuery(name = "myapp.allstudents.namelike", query = "FROM Student s where name like :subString") })
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "student_name")
	private String name;

	@Column(name = "student_mobile")
	private Long mobile;

	private int age;

	private String country;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobile=" + mobile + ", age=" + age + ", country=" + country
				+ "]";
	}
}
