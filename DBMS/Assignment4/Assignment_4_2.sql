/* Create View to select members nm and all the issue details */
CREATE VIEW MemberBookView AS SELECT m.member_nm, b.issue_dt, b.accession_no FROM members AS m JOIN book_issue AS b ON b.member_id = m.member_id;

/* Create view which contain member nm, member id and full description of category like F for Faculty */
CREATE VIEW MemberList AS SELECT member_id AS "Member ID", member_nm AS "Member nm", CASE category WHEN "F" THEN "Faculty" WHEN "S" THEN "Student" WHEN "O" THEN "Others" END AS "Member Category"FROM members;

/* Create view which contain subject nm, title, member nm, category, issue dt, due dt, return dt if not return then null */
		
	CREATE VIEW full_Description AS
		SELECT s.subject_nm, t.title_nm, m.member_nm, m.category, bi.issue_dt, bi.due_dt, IF(br.return_dt < now(),NULL,br.return_dt) AS "book return" 
			FROM members m, books b, subjects s, book_return br, book_issue bi, titles t WHERE m.member_id=bi.member_id 
			AND bi.accession_no = b.accession_no AND b.title_id=t.title_id AND t.subject_id = s.subject_id AND m.member_id=br.member_id;
