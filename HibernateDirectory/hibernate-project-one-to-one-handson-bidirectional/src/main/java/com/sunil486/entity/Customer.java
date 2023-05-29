package com.sunil486.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer { // one

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;

	private String customer_name;

	private String customer_mobile;

	@OneToMany(mappedBy = "customer", cascade = { CascadeType.PERSIST })
	private List<Order> orders;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_mobile() {
		return customer_mobile;
	}

	public void setCustomer_mobile(String customer_mobile) {
		this.customer_mobile = customer_mobile;
	}

	public List<Order> getOrder() {
		return orders;
	}

	public void setOrder(List<Order> order) {
		this.orders = order;
	}

	// This is basically for saving association value
	public void addOrder(Order order) {
		if (orders == null) {
			orders = new ArrayList<Order>(); // lazy initialisation
		}
		// This is ver important line if we are not adding below line then update will
		// not occur i.e relationship will not established and null value will be added
		// for customer
		order.setCustomer(this);// this means current object i.e customer
		orders.add(order);
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_mobile="
				+ customer_mobile + ", orders=" + orders + "]";
	}
}
