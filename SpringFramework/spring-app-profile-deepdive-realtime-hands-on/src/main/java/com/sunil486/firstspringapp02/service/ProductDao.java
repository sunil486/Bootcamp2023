package com.sunil486.firstspringapp02.service;

import java.sql.SQLException;
import java.util.List;

import com.sunil486.firstspringapp02.model.Product;

public interface ProductDao {

	List<Product> getAllProducts() throws ClassNotFoundException, SQLException;

}
