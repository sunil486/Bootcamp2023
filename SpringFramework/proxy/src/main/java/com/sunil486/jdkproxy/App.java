package com.sunil486.jdkproxy;

import java.lang.reflect.Proxy;

public class App {

	public static void main(String[] args) {

		ProductDAO productDAO = (ProductDAO) Proxy.newProxyInstance(ProductDAO.class.getClassLoader(),
				new Class[] { ProductDAO.class }, new ProductDAOInvocationHandler(new ProductDAOImpl()));

		Product product = productDAO.getProductById(1);

		productDAO.save(product);

		System.out.println("*********");

	}
}
