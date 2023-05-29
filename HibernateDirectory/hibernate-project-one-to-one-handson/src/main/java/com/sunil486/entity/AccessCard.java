package com.sunil486.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AccessCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "access_id")
	private int accessCardId;

	@Column(name = "access_card_number")
	private String accessCardNumber;

//	/**
//	 * 
//	 * @OneToOne
//	 * 
//	 * OR 
//	 * 
//	 * @OneToOne
//	 * @JoinColumn(name = "employee_emp_id", unique = true)
//	 * 
//	 * Both means same
//	 */
//	@OneToOne
//	private Employee employee;

	// Correct way because this is child/non-owner
	@OneToOne(mappedBy = "card", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private Employee employee;

	public int getAccessCardId() {
		return accessCardId;
	}

	public void setAccessCardId(int accessCardId) {
		this.accessCardId = accessCardId;
	}

	public String getAccessCardNumber() {
		return accessCardNumber;
	}

	public void setAccessCardNumber(String accessCardNumber) {
		this.accessCardNumber = accessCardNumber;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "AccessCard [accessCardId=" + accessCardId + ", accessCardNumber=" + accessCardNumber + ", employee="
				+ employee + "]";
	}
}
