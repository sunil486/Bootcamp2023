package com.sunil486.proxy;

import com.sunil486.proxy.ProductDAOImpl;
import com.sunil486.proxy.ProductDAOImplProxy;

public class App {
	public static void main(String[] args) {

		// Calling methods directly
//		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
//		Product product = productDAOImpl.getProductById(1);
//		productDAOImpl.save(product);

		// Calling methods using proxy class
		ProductDAOImplProxy productDAOImplProxy = new ProductDAOImplProxy(new ProductDAOImpl());
		productDAOImplProxy.getProductById(1);
	}
}
