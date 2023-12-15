package org.example.renovation.repository;

import org.example.database.DatabaseProperties;
import org.example.renovation.model.Renovation;
import org.example.util.ShapeCalculator;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RenovationRepository {
	private static String jdbcUrl = DatabaseProperties.getJdbcUrl();
	private static String username = DatabaseProperties.getUsername();
	private static String password = DatabaseProperties.getPassword();

	public static List<Integer> showDataByID() {
		List<Integer> idList = new ArrayList<>();

		try {
			Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
			Statement statement = connection.createStatement();
			String sqlQuery = "SELECT id FROM renovation";
			ResultSet resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next()) {
				int renovationId = resultSet.getInt("id");
				idList.add(renovationId);
			}

			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return idList;
	}

	public static Renovation showDataById(Long id) {
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
			String sqlQuery = "SELECT * FROM renovation WHERE id = ?";

			try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
				preparedStatement.setLong(1, id);

				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					if (resultSet.next()) {
						String name = resultSet.getString("name");
						String dimensions = resultSet.getString("dimensions");
						boolean active = resultSet.getBoolean("active");
						String creationDate = resultSet.getString("creation_date");
						String lastEditDate = resultSet.getString("last_edit_date");
						String volume = resultSet.getString("volume");
						String field = resultSet.getString("field");

						return new Renovation.Builder()
								.setId(id)
								.setName(name)
								.setDimensions(dimensions)
								.setActive(active)
								.setCreationDate(creationDate)
								.setLastEditDate(lastEditDate)
								.setLastEditDate(lastEditDate)
								.setVolume(volume)
								.setField(field)
								.build();
					} else {
						System.out.println("Nie znaleziono renowacji od ID: " + id);
						return null;
					}
				}
			} finally {
				connection.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static Renovation addRenovation(Renovation renovation) {
		try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
			String sqlQuery = "INSERT INTO renovation (name, dimensions, active, volume, field, last_edit_date) VALUES (?, ?, ?, ?, ?, ?)";
			try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
				preparedStatement.setString(1, renovation.getName());
				preparedStatement.setString(2, renovation.getDimensions());
				preparedStatement.setBoolean(3, renovation.isActive());
				preparedStatement.setDouble(4, calculateVolume(renovation.getDimensions()));
				preparedStatement.setDouble(5, calculateField(renovation.getDimensions()));
				preparedStatement.setDate(6, Date.valueOf(LocalDate.now()));

				int rowsAffected = preparedStatement.executeUpdate();
				if (rowsAffected > 0) {
					try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
						if (generatedKeys.next()) {
							renovation.setId(generatedKeys.getLong(1));
						} else {
							throw new SQLException("Nie udało się pobrać wygenerowanych kluczy.");
						}
					}

					renovation.setCreationDate(LocalDate.now().toString());

					return renovation;
				} else {
					throw new SQLException("Nie udało się dodać obiektu.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private static double calculateVolume(String volume) {
		return ShapeCalculator.shapeCalculator(volume, true);
	}

	private static double calculateField(String volume) {
		return ShapeCalculator.shapeCalculator(volume, false);
	}
}
