package com.adp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
	ConnectionDAO connectionObject;
	Connection connection;
	Statement statement;
	ResultSet resultSet;

	public LoginDAO(ConnectionDAO connectionObject) throws Exception {
		this.connectionObject = connectionObject;
			connection = connectionObject.getConnection();
			System.out.print(connection + "at constructor");
	}

	public String validateUser(String username, String pwd) throws SQLException {
		statement = connection.createStatement();
		resultSet = statement
				.executeQuery("select is_admin from user where user_name = '"
						+ username + "' and binary password = '" + pwd + "'");
		if (resultSet.next()) {
			if (resultSet.getBoolean(1))
				return "admin";
			else
				return "user";
		} else
			return "invalidUser";

	}
}