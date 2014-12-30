package com.adp.dao;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionDAO {
	Connection connection = null;
	DataSource dataSource;

	public Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		dataSource = (DataSource) envContext.lookup("jdbc/adpdb");
		connection = dataSource.getConnection();
		return connection;
	}

}