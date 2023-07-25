package com.sunil486.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProductDAOInvocationHandler implements InvocationHandler{

	private ProductDAOImpl productDAOImpl;
	
	public ProductDAOInvocationHandler(ProductDAOImpl productDAOImpl) {
		
		this.productDAOImpl = productDAOImpl;
	}
	
	                 
	//@Override                         //getProductById       //1
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		//do something here
		new DBConnectionUtils().connectToDB();
		
		Object returnType = method.invoke(productDAOImpl, args);
		
		//do something here
		new DBConnectionUtils().close();
		
		return returnType;
	}

}
