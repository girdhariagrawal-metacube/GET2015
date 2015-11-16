package com.metacube.webservices.dbhelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.MetaHRMSystemException;
import com.metacube.webservices.db.ConnectionFactory;

@Path("/AddEmployee")
public class AddEmployee {

	@Path("{c}")
	@GET
	@Produces("application/xml")
	public String addEmployee(@PathParam("c") String name) throws MetaHRMSystemException {
		System.out.println("name is" + name);
		String INSERT_QUERY_EMPLOYEE = "insert into employee (name) values(?)";
		int noOfRows = 0;
		Connection connection = null;
		connection = ConnectionFactory.getConnection();
		try {
			System.out.println(connection);
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY_EMPLOYEE);
			preparedStatement.setString(1, name);
			noOfRows = preparedStatement.executeUpdate();
			System.out.println("Output is " + noOfRows);
			System.out.println("name is" + name);
		} catch (SQLException e) {
		throw new MetaHRMSystemException(e.getMessage());
		}
		finally
		{
			ConnectionFactory.closeConnection(connection);
		}
		String result = "Output:Successfully created ";
		return "<output>" + result + "</output>";
	}

}
