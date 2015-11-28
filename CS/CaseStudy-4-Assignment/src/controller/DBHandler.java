/**
 * @author Girdhari
 * Database handler 
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import model.Vehicle;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/* Starting of DBHandler class */
public class DBHandler {
	
	private static int vehicleId = 1;
	private static int carId = 1;
	
	/* Starting of isUserExist method */
	public boolean isUserExist(User user) {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result;
		String query = "SELECT * FROM user WHERE username= ? AND password= ?";
		boolean returnValue = false;
		
		try {
		
			statement = connection.prepareStatement(query);
			statement.setString(1, user.getName());
			statement.setString(2, user.getPassword());
			result = statement.executeQuery(); 
						
			if(result.next()) returnValue = true;
			else returnValue = false;
		} catch (SQLException e) {
			System.out.println("There is an error in query"+e);
		}
		return returnValue;
	}
	/* Ending of isUserExist method */

	/* Starting of addUser method */
	public boolean addUser(User user) {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement statement = null ;
		String query = "INSERT INTO user VALUES(?,?,?,?)";
		
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, user.getName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getNumber());
			statement.executeUpdate();
			return true;
		} catch(MySQLIntegrityConstraintViolationException e) {
			System.out.println("User Already Exist!!");
			return false;
		} catch(SQLException e) {
			System.out.println("Some SQL related error occured!!"+e);
			return false;
		}
	}
	/* Ending of addUser method */

	/* Starting of createVehicle method */
	public boolean createVehicle(Vehicle vehicle) {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement statement = null;
		boolean returnValue = false;
		String query1 = "INSERT INTO vehicle VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		String query2 = "INSERT INTO car VALUES(?,?,?,?,?)";
		try {
			statement = connection.prepareStatement(query1);
			statement.setInt(1, vehicleId++);
			statement.setInt(2,vehicle.getMake());
			statement.setString(3,(String) vehicle.getModel());
			statement.setInt(4,vehicle.getEngineInCC());
			statement.setString(5,vehicle.getFuelCapacity()+"");
			statement.setString(6,vehicle.getMilage()+"");
			statement.setString(7,vehicle.getPrice()+"");
			statement.setString(8,vehicle.getRoadTax()+"");
			statement.setString(9,"admin");
			
			statement.setDate(10, (new Date(vehicle.getCreatedTime().getTime())));
			statement.setString(11, vehicle.getVehicleType()+"");
			returnValue = statement.execute();
			
			statement = connection.prepareStatement(query2);
			statement.setInt(1,carId++);
			statement.setInt(2, 1);
			statement.setInt(3, 1);
			statement.setInt(4, 1);
			statement.setInt(5, vehicleId);
			returnValue = statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return returnValue;
	}
	/* Ending of createVehicle method */
	
	/* Starting of searchVehicle method */
	public ResultSet searchVehicle(String details) {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM vehicle AS v INNER JOIN car AS c ON v.Vehicle_Id = c.Vehicle_Id";
		try {
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	/* Ending of searchVehicle method */
	
}
