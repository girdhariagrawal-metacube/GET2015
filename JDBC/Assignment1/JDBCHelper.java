/**
 * This is a helper class which will be used for querying and wrapping of data
 */
package assignment1;

import java.util.List;

public class JDBCHelper {

	public boolean hasBookIssued(int accessionNumber, int memberId) {
		
		Book bookObject = new Book();
		bookObject.setAccessionNumber(accessionNumber);
		
		Member memberObject = new Member();
		memberObject.setMemberId(memberId);
		return Model.issueBookIfAvaiable(bookObject, memberObject);
		
	}
	
	public int deleteBookNotIssuedLastYear() {
		
		return Model.deleteBooksNotIssuedLastYear();
	}

	public List<BookTitles> titleByAuthor(String authorName) {
		
		Author authorObject = new Author();
		authorObject.setAuthorName(authorName);
		
		return Model.searchBookByAuthor(authorObject);
	}

}
