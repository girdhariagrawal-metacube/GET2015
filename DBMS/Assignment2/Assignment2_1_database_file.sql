--Assignment1
--TO display all columns
SELECT * FROM members;

--To Select member_nm, member_id and category
SELECT member_id,member_nm,category FROM members;

--Select from members table where member is Faculty 
SELECT member_id,member_nm,category FROM members WHERE category = "F";

--To select various categories of members
SELECT DISTINCT(category)  FROM members;

--To Select member name and category in descending order of member name
SELECT member_nm, category FROM members ORDER BY member_nm DESC;

--select to display all title,their subject and publishers
SELECT titles.title_nm, subjects.subject_nm, publishers.publisher_nm FROM titles JOIN subjects ON subjects.subject_id = titles.subject_id JOIN publishers ON titles.publisher_id = publishers.publisher_id;

--select to display number of members present in each category
SELECT category,count(category) "Number of members" FROM members GROUP BY category;

--select to display those member which belongs to same category "Babalu" belongs
SELECT m1.member_nm FROM members AS m1 JOIN members AS m2 ON m1.category = m2.category WHERE m2.member_nm ="Babalu";

--Select to display information of all books issued show(issue date, accssion no, member id and return date)
SELECT bi.issue_dt "Book Issued On", bi.accession_no "Accession Number", bi.member_id "Book Issued To", return_dt "Returned On" 
	FROM book_issue AS bi JOIN book_return AS br ON bi.accession_no = br.accession_no;
	
