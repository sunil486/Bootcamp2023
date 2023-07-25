package com.sunil486.proxy;

public class ProductDAOImplProxy implements ProductDAO {

	private ProductDAOImpl delegate;

	public ProductDAOImplProxy(ProductDAOImpl productDAOImpl) {

		this.delegate = productDAOImpl;

	}

	public Product getProductById(int id) {

		new DBConnectionUtils().connectToDB();

		Product product = delegate.getProductById(id);

		new DBConnectionUtils().close();

		return product;
	}

	public void save(Product product) {

		new DBConnectionUtils().connectToDB();

		delegate.save(product);

		new DBConnectionUtils().close();

	}

}
