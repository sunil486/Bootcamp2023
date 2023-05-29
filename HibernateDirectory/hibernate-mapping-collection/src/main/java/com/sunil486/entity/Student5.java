package com.sunil486.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.AttributeOverride;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Students")
public class Student5 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "student_name")
	private String name;

	@Column(name = "student_mobile")
	private Long mobile;

	private int age;

	private String country;

	@ElementCollection
	@MapKeyColumn(name = "nameType")
	@CollectionTable(name = "Students_NickName", joinColumns = @JoinColumn(name = "student_id"))
	@Column(name = "nick_name")
	private Map<String, String> nickNames = new HashMap<String, String>();

	// This is complex type i.e this is an embeddable type but collection type
	@ElementCollection
	@CollectionTable(name = "Address", joinColumns = @JoinColumn(name = "stud_id"))
	@AttributeOverride(name = "country", column = @Column(name = "student_country"))
	private List<Address> address = new ArrayList<>();

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

	public Map<String, String> getNickNames() {
		return nickNames;
	}

	public void setNickNames(Map<String, String> nickNames) {
		this.nickNames = nickNames;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobile=" + mobile + ", age=" + age + ", country=" + country
				+ ", nickNames=" + nickNames + "]";
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
}
