package assignment1;

import java.util.List;

public class UserInterface {

	public static void main(String[] args) {
	
		JDBCHelper jdbcHelperObject = new JDBCHelper();
		String authorName = "Kathy Sierra";
		List<BookTitles> listOfTitles = jdbcHelperObject.titleByAuthor(authorName.trim());
		
		System.out.println("List of Titles of author is: "+authorName+"");
		
		for(BookTitles bookTitles: listOfTitles) {
			System.out.println("\t"+bookTitles.getTitleId()+"\t"+bookTitles.getTitleName());
		}
		
		int accessionNumber = 1;
		int memberId = 5;
		String output ="Yes";
		boolean hasIssued = jdbcHelperObject.hasBookIssued(accessionNumber, memberId);
		
		if(!hasIssued)
			output = "No";
		
		System.out.println("\nBook "+accessionNumber+" Issued to "+memberId + " "+output);
	
		int noOfBooks = jdbcHelperObject.deleteBookNotIssuedLastYear();
		
		System.out.println("No of Books Deleted : "+noOfBooks);
	}
}
