package aei_database;

import java.sql.*;

public class DatabaseConnector {
	/**
	 * String variables for the connector. Whoever is running the connector would replace the password and user
	 * The URL implies we call the database aei_database
	 */
	String url = "jdbc:mysql://localhost:3306/aei_database";
	String user = "";
	String password = "";
	
	public String userName, pass;
	
	int userID = 1;
	
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
	
	
	

	
}
	
