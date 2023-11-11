package aei_database;

import java.sql.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseConnector {
	/**
	 * String variables for the connector. Whoever is running the connector would replace the password and user
	 * The URL implies we call the database aei_database
	 */
	String url = "jdbc:mysql://localhost:3306/aei_database";
	String user = "";
	String password = "";
	
	public String userName, pass;
	
	//test variables for userID and idSchedule
	int userID = 1;
	int idSched = 1;
	
	Connection conn = null;
	/**
	 * Connects Eclipse to the database called aei_database on the local machine
	 * @param u The user name of one of the designers
	 * @param p The password of one of the designers
	 */
	public void Connector(String u, String p) {
		user = u;
		password = p;
		try {
			conn = DriverManager.getConnection(url, user, password);
			if(conn!=null) {
				System.out.println("Connected Successfully");
			}
		}catch(Exception e) {
			System.out.println("Connection Error");
		}
	}
	
	/**
	 * Method that inserts new users information into the database.
	 * Assumes their is a table called users in the database
	 * @param uN new users user name
	 * @param ps new users password
	 */
	public void createUser(String uN, String ps) {
		String insertSQL = "INSERT into users(userName, password, userID)" + "values (" + uN + ", " + ps + ", " + userID++;
		try {
			Statement st = conn.createStatement();
			st.executeQuery(insertSQL);
		}catch(Exception e) {
			System.out.println("Connection not found");
		}
	}
	/**
	 * Prints out the user names of the users and the ID associated with that user name
	 */
	public void printUsersID() {
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from users");
			while(rs.next()) {
				String userN = rs.getString("userName");
				int uID = rs.getInt("userID");
				System.out.println(userN + " ID: " + uID);
			}
		}catch(Exception e) {
			System.out.println("Connection not found");
		}
	}
	/**
	 * A method to serialize a schedule object to prepare for storage in the database.
	 * Note: class will produce errors until Schedule class is implemented and the class implements the serialize interface
	 * @param sch The schedule object to be serialized
	 * @param schName The name of the schedule(a day between sunday and saturday)
	 */
	public void serialize(Schedule sch, String schName) {
		try(ObjectOutputStream oos = new ObjectOutputStream(Files.newBufferedReader(Paths.get(schName)))){
			oos.writeObject(sch);
		}
	}
	
	/**
	 * A method that stores a schedule object into the schedule table in the database
	 * Note: Will continue to produce errors until schedule class is implemented
	 * @param userID The id of the user the schedule is connected to
	 * @param schedID The id of the schedule 
	 * @param fileName the file with the serialized object
	 */
	
	public void storeSchedule(int userID, int schedID, File fileName) {
		String insertSQL = "INSERT into schedule(idschedules, userID, schedule)" + "values (" + schedID++ + ", " + userID + ", " + fileName;
		try {
			Statement st = conn.createStatement();
			st.executeQuery(insertSQL);
		}catch(Exception e) {
			System.out.println("Connection not found");
		}
	}
	

	
}
	
