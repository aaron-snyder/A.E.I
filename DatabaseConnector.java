import java.sql.*;

import javax.sql.rowset.serial.SerialException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseConnector {
	/**
	 * String variables for the connector. Whoever is running the connector would replace the password and user
	 * The URL implies we call the database aei_database
	 */
	String url = "jdbc:mysql://localhost:3306/aei_database";
	String user = "root";
	String password = "CS380Project";
	int newID;
	
	public String userName, pass;
	
	//test variables for userID and idSchedule
	int userID = 1;
	int idSched = 1;
	Schedule[] userSchedule = new Schedule[7];
	
	Connection conn = null;
	/**
	 * Connects Eclipse to the database called aei_database on the local machine
	 * @param u The user name of one of the designers
	 * @param p The password of one of the designers
	 */
	public DatabaseConnector() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			if(conn!=null) {
			}
		} catch(Exception e) {
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

		for (int i = 0; i <= 6; i++) {
			userSchedule[i] = new Schedule();
		}

		String getIdSQL = "SELECT MAX(userID) as highestUser FROM users";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(getIdSQL);
			
			while (rs.next()) {
				newID = rs.getInt("highestUser");
				newID++;
			}
		}catch(Exception e) {
			System.out.println("Could not get max");
			System.out.println(e);
		}


		String insertSQL = "INSERT INTO users(userName, password, userID) VALUES ('" + uN + "', '" + ps + "', '" + newID + "');";
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(insertSQL);
		}catch(Exception e) {
			System.out.println("Could not create user");
			System.out.println(e);
		}

		try {
			conn = DriverManager.getConnection(url, user, password);
			Blob blob = conn.createBlob();
			blob.setBytes(1, serialize(userSchedule));

			String blobSQL = "INSERT INTO schedules(scheduleID, schedule_array, userID)VALUES(?,?,?);";
         
			PreparedStatement preparedStatement = conn.prepareStatement(blobSQL);
			preparedStatement.setInt(1, newID);
			preparedStatement.setBlob(2, blob);
			preparedStatement.setInt(3, newID);
         
         preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Blob connection error");
			System.out.println(e);
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
	public static byte[] serialize(Schedule[] sch) {

		try {
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream objectOut = new ObjectOutputStream(byteOut);

            objectOut.writeObject(sch);
            return byteOut.toByteArray();

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
	}
	

	/**
	 * A method that stores a schedule object into the schedule table in the database
	 * Note: Will continue to produce errors until schedule class is implemented
	 * @param userID The id of the user the schedule is connected to
	 * @param schedID The id of the schedule 
	 * @param fileName the file with the serialized object
	 */
	public void storeSchedule(int userID, Schedule[] schedule) {

		try {
			conn = DriverManager.getConnection(url, user, password);
			Blob blob = conn.createBlob();
			blob.setBytes(1, serialize(schedule));

			String blobSQL = "UPDATE schedules SET schedule_array = ? WHERE scheduleID = ?;";
         
			PreparedStatement preparedStatement = conn.prepareStatement(blobSQL);
			preparedStatement.setBlob(1, blob);
			preparedStatement.setInt(2, userID);
         
         preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Blob connection error");
			System.out.println(e);
		}
	}


	/**
	 * Deserialize method goes here
	 */
	public Schedule[] deserialize(int userID) {
		Schedule[] deserializedSchedule = new Schedule[7];
		
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select schedule_array from schedules where userID = " + userID + ";"); 
			while(rs.next()) {
				Blob blob = rs.getBlob("schedule_array");
				int blobLength = (int)blob.length();
				byte[] blobBytes = blob.getBytes(1, blobLength);
				blob.free();
				
				ByteArrayInputStream bis = new ByteArrayInputStream(blobBytes);
				ObjectInput in = null;
				
				in = new ObjectInputStream(bis);
				
				deserializedSchedule = (Schedule[]) in.readObject();
			}
		} catch (Exception e) {
			System.out.println("Deserializing error");
			System.out.println(e);
		}

		 return deserializedSchedule;
	}


	/**
	 * Placeholder for checkUsername method
	 */
	public boolean checkUsername(String username){
		
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select userName from users");
			while(rs.next()){
				String userN = rs.getString("userName");
				if(userN.equals(username)){
					//print statement for user already exists
					System.out.println("username exists");
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println("check username error");
			e.printStackTrace();
		}
		
		System.out.println("username do not exist");
		return true;
	}


	/**
	 * Placeholder for checkLogin method
	 */
	public boolean checkLogin(String username, String password) {
		
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select userName,password from users");
			while(rs.next()){
				String userN = rs.getString("userName");
				String pass = rs.getString("password");
				if(userN.equals(username) && pass.equals(password)){
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("check login error");
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * Placeholder getCurrentUserID method, returns user ID associated with passed username and password
	 */
	public int getUserID(String username, String password) {
		
		try{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from users");
			while(rs.next()){
				String userN = rs.getString("userName");
				String pass = rs.getString("password");
				int curUserID = rs.getInt("userID");
				if(userN.equals(username) && pass.equals(password)){
					return curUserID;
				}
			}
		} catch (Exception e) {
			System.out.println("get user id error");
			e.printStackTrace();
		}
		return -1;
	}
}

	
