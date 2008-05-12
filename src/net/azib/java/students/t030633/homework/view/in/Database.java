package net.azib.java.students.t030633.homework.view.in;

import net.azib.java.students.t030633.homework.DecathlonCalculator;
import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.AthleteBuilder;
import net.azib.java.students.t030633.homework.model.Event;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Reads athletes from a database.
 * 
 * @author t030633
 */
public class Database implements Input {

	private Connection getConnection(File properties) throws IOException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(properties));
			return DriverManager.getConnection(reader.readLine(), reader.readLine(), reader.readLine());
		}
		catch (FileNotFoundException e) {
			throw new IOException("Unable to find properties file.");
		}
		catch (SQLException e) {
			throw new IOException("Unable to connect to database.");
		}
		catch (IOException e) {
			throw new IOException("Unable to read database properties.");
		}
	}

	private ResultSet getAthletes(Connection conn, String key) throws IOException {
		try {
			// Athlete parameters
			String sql = "SELECT athletes.name, athletes.dob, athletes.country_code, "
					// Results
					+ "results.race_100m, results.long_jump, results.shot_put, "
					+ "results.high_jump, results.race_400m, results.hurdles_110m, "
					+ "results.discus_throw, results.pole_vault, results.javelin_throw, "
					+ "results.race_1500m "
					// Selection
					+ "FROM athletes INNER JOIN results ON results.athlete_id = athletes.id "
					+ "INNER JOIN competitions ON results.competition_id = competitions.id "
					+ "WHERE competitions.id = ? OR competitions.name = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(key));
			stmt.setString(2, key);
			return stmt.executeQuery();
		}
		catch (SQLException e) {
			throw new IOException("Database access error.");
		}
	}

	private List<Athlete> parseAthletes(AthleteBuilder builder, ResultSet results) throws SQLException {
		List<Athlete> list = new LinkedList<Athlete>();
		while (results.next()) {
			builder.reset();
			builder.name(results.getString("name"));
			builder.date(results.getDate("dob"));
			builder.country(results.getString("country_code"));
			int i = 4; // columns 4+ are results
			for (Event e : Event.values()) {
				builder.addResult(e, ((double) results.getFloat(i++)));
			}
			list.add(builder.build());
		}
		return list;
	}

	public List<Athlete> read(AthleteBuilder builder) throws IOException {
		String key = DecathlonCalculator.inputProperty;
		if (key == null)
			throw new IOException("Competition name or number not specified.");

		try {
			Connection conn = getConnection(new File(DecathlonCalculator.class.getResource("db.properties").toURI()));
			return parseAthletes(builder, getAthletes(conn, key));
		}
		catch (URISyntaxException e) {
			throw new IOException("Unable to find properties file.");
		}
		catch (SQLException e) {
			throw new IOException("Error reading athlete from database.");
		}
	}
}