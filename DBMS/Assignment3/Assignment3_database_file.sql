Use lis;

/*  select which book have been issued for more than one month */
/*  Question 1 */

Select m.Member_Nm, m.Member_Id, t.Title_Nm, bi.Accession_No, bi.Issue_Dt, bi.Due_Date, DATEDIFF(Due_Date,Issue_Dt ) AS diff 
FROM Members As m, Titles AS t, Books AS b, Book_Issue AS bi
WHERE (bi.Member_Id = m.Member_Id && bi.Accession_No = b.Accession_No && b.Title_Id = t.Title_Id && (DATEDIFF(bi.Due_Date,bi.Issue_Dt) > 60)) ORDER BY m.Member_Nm, t.Title_Nm;

/* Select to find those rows having maximum length of member name */
SELECT Member_Nm,LENGTH(Member_Nm) FROM Members WHERE length(Member_Nm) = ( SELECT MAX(LENGTH(Member_Nm)) FROM Members);


/* Select to find total number of books issues so far */
SELECT COUNT(issue_dt) FROM book_issue GROUP BY issue_dt;

/* Select number of books purchased subject wise with subject id and subject name */
/* Question 2 */

SELECT s.Subject_Nm, s.Subject_Id, COUNT(t.Title_Id) AS "Number of books purchased" FROM Subjects s, Titles t 
where t.subject_id = s.subject_Id GROUP BY subject_id;

/* Select book details from book_issue where it can be returned after two months */

SELECT m.Member_Name, m.Member_Id, t.Title_Name, t.Title_Id, b.Accession_No, b.Issue_Date, b.Due_Date, DATEDIFF(Due_Date,Issue_Date ) AS Diff  FROM Members m, Book_Issue b, Title t, Books bk
WHERE (m.Member_Id = b.Member_Id && t.Title_Id = bk.Title_Id && bk.Accession_No = b.Accession_No) &&( DATEDIFF(b.Due_Date,b.Issue_Date )) > 60 ;

/* Select books details of books which have price greater than minimum cost */

SELECT Accession_No, Title_Id, Purchase_Dt, Price, Status FROM Books WHERE ( Price > (SELECT MIN(Price) FROM Books));

/* Question 3 */
/*Select total number of students, faculty, and total number of other in a row */
SELECT SUM(IF(category = "F", 1, 0)) AS "Faculty Count", 
	   SUM(IF(category = "M", 1, 0)) AS "Student Count",
	   SUM(IF(category = "O", 1, 0)) AS "Other's Count" FROM members;

/* Select details of title of books issued atleast two times */

SELECT t.Title_Nm AS tn, count(bi.Accession_No) AS Number
FROM Book_Issue AS bi, Titles AS t, Books AS b 
WHERE (b.Accession_No = bi.Accession_No AND t.Title_Id = b.Title_Id ) GROUP BY t.Title_Nm HAVING count(bi.Accession_No) >= 2;

/* Select details of book issued to members with category other than "F" */

SELECT bi.Accession_No, m.Member_Id, m.Member_Nm, bi.Issue_Dt, bi.Due_Date
FROM Members AS m, Book_Issue AS bi 
WHERE ( bi.Member_Id = m.Member_Id && m.Category <> "F");

/* Select details of authors whose atleast one book has been purchased */

SELECT a.Author_Id, a.Author_Nm 
FROM Authors AS a, Title_Author AS ta, Titles AS t, Books AS b
WHERE (a.Author_Id = ta.Author_Id && ta.Title_Id = t.Title_Id && t.Title_Id = b.Title_Id && ((SELECT COUNT(ta.Title_Id) FROM Books) > 0));
