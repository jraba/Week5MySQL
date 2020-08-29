package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Berry;

public class BerriesDao {

	public static void createBerry(String name) throws SQLException {
		String sql = "INSERT INTO berries (name) VALUES (?)";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			dbConnection.getInstance();
			connection = dbConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.executeUpdate();
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}

		}
	}

	public static List<Berry> listBerries() throws SQLException {
		String sql = "SELECT * FROM berries";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Berry> berries = new ArrayList<>();

		try {
			dbConnection.getInstance();
			connection = dbConnection.getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Long berry_id = resultSet.getLong("berry_id"); 
				String name = resultSet.getString("name");
				Berry berry = new Berry(berry_id, name);
				berries.add(berry);

			}
			return berries;

		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	public static void modifyBerry(long berry_id, String name) throws SQLException {
		String sql = "UPDATE berries SET name = ? WHERE berry_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			dbConnection.getInstance();
			connection = dbConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setLong(2, berry_id);

			statement.executeUpdate();

		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	public static void deleteBerry(long berry_id) throws SQLException {
		String sql = "DELETE FROM berries WHERE berry_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			dbConnection.getInstance();
			connection = dbConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, berry_id);

			statement.executeUpdate();

		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

	}
}
