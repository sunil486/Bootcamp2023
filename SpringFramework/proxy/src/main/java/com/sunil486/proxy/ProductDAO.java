package com.sunil486.proxy;

public interface ProductDAO {
	
	public Product getProductById(int id);
	public void save(Product product);

}
