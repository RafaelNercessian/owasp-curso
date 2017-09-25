package br.com.alura.owasp.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/owasp",
					"root", "");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
