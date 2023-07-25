package com.sunil486.firstspringapp02;

import java.lang.reflect.Proxy;

import com.sunil486.jdkproxy.Product;
import com.sunil486.jdkproxy.ProductDAO;
import com.sunil486.jdkproxy.ProductDAOImpl;
import com.sunil486.jdkproxy.ProductDAOInvocationHandler;

public class App {
	public static void main(String[] args) {

		// Calling methods directly
//		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
//		Product product = productDAOImpl.getProductById(1);
//		productDAOImpl.save(product);

		// Calling methods using proxy class
		// ProductDAOImplProxy productDAOImplProxy = new ProductDAOImplProxy(new
		// ProductDAOImpl());
		// productDAOImplProxy.getProductById(1);

		// Calling methods using JDK dynamic proxy created by JVM

		ProductDAO productDAO = (ProductDAO) Proxy.newProxyInstance(ProductDAO.class.getClassLoader(),
				new Class[] { ProductDAO.class }, new ProductDAOInvocationHandler(new ProductDAOImpl()));

		Product product = productDAO.getProductById(1);
		System.out.println("Return type value : " + product);

		productDAO.save(product);

		System.out.println("*********");

	}
}
