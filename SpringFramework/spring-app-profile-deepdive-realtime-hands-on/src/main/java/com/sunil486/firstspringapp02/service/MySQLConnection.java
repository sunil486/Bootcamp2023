package com.sunil486.firstspringapp02.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class MySQLConnection implements IConnection {

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {

		// load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// get the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewProduct", "root",
				"rootadmin");

		return connection;
	}

}
