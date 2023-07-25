package com.sunil486.jdkproxy;

public class ProductDAOImpl implements ProductDAO {

	// @Override
	public Product getProductById(int id) {

		System.out.println("fetching product for id : " + id);

		return new Product();
	}

	// @Override
	public void save(Product product) {

		System.out.println("saving product to db...");

	}

}
