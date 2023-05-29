package com.sunil486.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders") // Order is a keyword in db
public class Order { // many

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	private String item_name;
	private double costs;

	// FK customer_id
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })// default fetch type is EAGER
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public double getCosts() {
		return costs;
	}

	public void setCosts(double costs) {
		this.costs = costs;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", item_name=" + item_name + ", costs=" + costs + "]";
	}
}
