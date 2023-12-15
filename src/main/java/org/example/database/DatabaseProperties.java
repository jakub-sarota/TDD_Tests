package org.example.database;

public class DatabaseProperties {
	private static String jdbcUrl = "jdbc:postgresql://localhost:8082/postgres";
	private static String username = "postgres";
	private static String password = "123";

	public static String getJdbcUrl() {
		return jdbcUrl;
	}

	public static String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}
}
