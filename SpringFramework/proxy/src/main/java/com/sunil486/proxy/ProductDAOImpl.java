package com.sunil486.proxy;

public class ProductDAOImpl implements ProductDAO {

	public Product getProductById(int id) {

		//new DBConnectionUtils().connectToDB();
		System.out.println("fetching product for id : " + id);

		//new DBConnectionUtils().close();
		return new Product();
	}

	public void save(Product product) {

		//new DBConnectionUtils().connectToDB();
		System.out.println("saving product to db...");
		//new DBConnectionUtils().close();
	}

}
