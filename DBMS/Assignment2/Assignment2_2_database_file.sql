--Assignment 2
--Select to display information of all books issued show(issue date, accssion no, member id and return date)
	SELECT bi.issue_dt "Book Issued On", bi.accession_no "Accession Number", bi.member_id "Book Issued To", return_dt "Returned On",m.member_nm "Member Name"
		FROM book_issue AS bi JOIN book_return AS br ON bi.accession_no = br.accession_no JOIN members AS m ON m.member_id = bi.member_id ORDER BY bi.issue_dt,bi.member ASC;
