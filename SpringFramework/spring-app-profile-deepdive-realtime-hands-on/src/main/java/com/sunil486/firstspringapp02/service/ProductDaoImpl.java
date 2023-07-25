package com.sunil486.firstspringapp02.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.sunil486.firstspringapp02.model.Product;

@Repository
@Profile("database")
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private IConnection connection;

	@Override
	public List<Product> getAllProducts() throws ClassNotFoundException, SQLException {
		List<Product> productList = new ArrayList<Product>();

		// load the driver
		// Class.forName("com.mysql.cj.jdbc.Driver");

		// get the connection
		// Connection connection =
		// DriverManager.getConnection("jdbc:mysql://localhost:3306/NewProduct", "root",
		// "rootadmin");

		// execute an query
		PreparedStatement prepareStatement = connection.getConnection().prepareStatement("select * from product");

		ResultSet resultSet = prepareStatement.executeQuery();

		// returning the products
		while (resultSet.next()) {
			Product product = new Product();

			int productId = resultSet.getInt(1);
			String productName = resultSet.getString(2);

			product.setId(productId);
			product.setName(productName);

			productList.add(product);
		}

		return productList;
	}

}
