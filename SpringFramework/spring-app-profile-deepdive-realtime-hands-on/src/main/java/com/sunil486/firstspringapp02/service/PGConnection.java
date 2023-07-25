package com.sunil486.firstspringapp02.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class PGConnection implements IConnection {

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {

		// load the driver
		Class.forName("org.postgresql.Driver");

		// get the connection
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proddb", "postgres",
				"abhi");

		return connection;
	}

}
