package assignment1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Model {

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	/* Starting of createConnection method */
	// Method to create connection between our program and db server
	private static void createConnection() {
		con = ConnectionUtil.getConnection();
	}

	/* End of createConnection method */

	/* Starting of function searchBookByAuthor */
	public static List<BookTitles> searchBookByAuthor(Author author) {

		List<BookTitles> listTitle = new ArrayList<BookTitles>();
		System.out.println("Showing Author and authored Books");

		String query = "SELECT t.title_id, t.title_name FROM titles AS t JOIN ( SELECT a.author_id, a.author_name, ta.title_id FROM authors AS a JOIN title_author AS ta ON a.author_id = ta.author_id) AS re ON re.title_id = t.title_id WHERE re.author_name = ?";

		try {
			createConnection();
			ps = con.prepareStatement(query);
			/* set variable in prepared statement */
			ps.setString(1, author.getAuthorName());
			rs = ps.executeQuery();

			while (rs.next()) {
				BookTitles bookTitleObject = new BookTitles();
				bookTitleObject.setTitleId(rs.getInt(1)); 
				bookTitleObject.setTitleName(rs.getString(2));
				listTitle.add(bookTitleObject);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnections();
		}
		return listTitle;
	}
	/* Ending of function searchBookByAuthor */

	/* Starting of deleteBooksNotIssuedLastYear function */
	public static int deleteBooksNotIssuedLastYear() { 
		int rowCount = 0;
		System.out.println("Deleteing Books That are not issued since Last Year");

		String query = "DELETE FROM BOOKS WHERE DATEDIFF("
				+"NOW(), purchase_date) > 365 AND accession_no NOT IN ("
				+"SELECT DISTINCT(accession_no) FROM book_issue WHERE DATEDIFF("
				+"NOW(), issue_date ) < 365) ; ";
		try {
			createConnection();
			ps = con.prepareStatement(query);
			rowCount = ps.executeUpdate();
		} catch(SQLException exception) {
			exception.printStackTrace();
		} finally {
			closeConnections();
		}
		return rowCount;
	}
	/* Ending of deleteBooksNotIssuedLastYear function */

	/* Starting of issueBookIfAvaiable function */
	public static boolean issueBookIfAvaiable(Book bookObject, Member memberObject) {
		
		String query = "INSERT INTO book_issue("
				+ "accession_no,member_id)  VALUES(?,?) WHERE ("
				+ "SELECT status FROM books WHERE accession_no = ? ) = 'Available'";
		try {
			
			createConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, bookObject.getAccessionNumber());
			ps.setInt(2, memberObject.getMemberId());
			ps.setInt(3,bookObject.getAccessionNumber());
			rs = ps.executeQuery()	;
			if(rs.next()) {
				
				System.out.println("Book was available And issued");
				return true;
			} else {
				
				System.out.println("Book is not avaiable Try after few days");
			}
		} catch(SQLException exception) {
			
			System.out.println("There is an error!!");
		} finally {
			closeConnections();
		}
		return false;

	}
	/* Ending of issueBookIfAvaiable function */

	/* Starting of closeConnections function */
	private static void closeConnections() {
		/* close connection */
		try {
			if (con != null) {
				con.close();
			}
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/* Ending of closeConnections function */

}
/* Ending of Model class */
