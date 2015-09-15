/*Select to find nm of those members which belongs to category Babalu belongs */
SELECT member_nm FROM members WHERE category = (SELECT category FROM members WHERE member_nm = "Babalu");

/* Select books which are not returned till dt */
SELECT m.member_nm, re.issue_dt, re.due_dt FROM members AS m JOIN (
	SELECT issue_dt, due_dt,member_id  FROM book_issue WHERE accession_no NOT IN(
		SELECT accession_no FROM book_return)
	)AS re ON re.member_id = m.member_id; 
	
/* Select to display information on the books that have been returned after their due dts */
SELECT bi.member_id AS "Member Id",m.member_nm AS "Member nm",t.title_nm AS "Title nm",b.title_id AS "Title Id",DATE(bi.issue_dt) AS "Issue dt",bi.due_dt AS "Due dt" 
    FROM  book_issue bi , members m ,books b ,titles t 
        WHERE EXISTS ( SELECT  bi.accession_no FROM  book_return br WHERE br.accession_no = bi.accession_no AND DATEDIFF(br.return_dt, bi.due_dt) > 0)
    AND bi.member_id=m.member_id AND bi.accession_no= b.accession_no AND b.title_id= t.title_id;
    

/* Select to find those books whose price is equal to the most expensive book purchased so far */
SELECT accession_no, title_id, purchase_dt, price, status FROM books AS b WHERE  b.price = (SELECT MAX(price) FROM books);

/* Select command to find second maximum price of book */
SELECT price FROM (SELECT price FROM books ORDER BY price DESC LIMIT 2) AS re ORDER BY price ASC LIMIT 1;
									/* OR */
SELECT price FROM books ORDER BY price DESC LIMIT 1,1;


