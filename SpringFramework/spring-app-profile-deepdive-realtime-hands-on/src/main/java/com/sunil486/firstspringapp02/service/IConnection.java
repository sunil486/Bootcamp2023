package com.sunil486.firstspringapp02.service;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnection {

	Connection getConnection() throws ClassNotFoundException, SQLException;
}
