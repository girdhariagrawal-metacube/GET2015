

/*insert data in tables*/

/*table members*/
INSERT INTO members(member_nm,addressline1,addressline2,category) values("Babalu","Jalabarh","Jalabarh","M");
INSERT INTO members(member_nm,addressline1,addressline2,category) values("Anurag Anand","Chai Ki Mandi","Patna","M");
INSERT INTO members(member_nm,addressline1,addressline2,category) values("Sumitra","Madhav Nagar","Chittorgarh","F");
INSERT INTO members(member_nm,addressline1,addressline2,category) values("Dheeraj","Kishan Gadh","Ajmer","M");
INSERT INTO members(member_nm,addressline1,addressline2,category) values("Girdhari","HOli Gate","Mathura","M");

/*table authors*/
INSERT INTO authors(author_nm) values("Sandeep Sopankar");
INSERT INTO authors(author_nm) values("Chetan Bhagat");
INSERT INTO authors(author_nm) values("Kathy Sierra");
INSERT INTO authors(author_nm) values("James Gosling");
INSERT INTO authors(author_nm) values("Yashwant Kanetkar");
INSERT INTO authors(author_nm) values("Dennies Ritchie");

/*table publisher*/
INSERT INTO publishers(publisher_nm) values("Pearson Hall");
INSERT INTO publishers(publisher_nm) values("Tata McGraw Hill");
INSERT INTO publishers(publisher_nm) values("Oracle Publications");
INSERT INTO publishers(publisher_nm) values("Pegvin");
INSERT INTO publishers(publisher_nm) values("BPB Publications");
INSERT INTO publishers(publisher_nm) values("Wiley Publications");

/*table subjects*/
INSERT INTO subjects(subject_nm) values("DATABASE MANAGEMENT SYSTEM");
INSERT INTO subjects(subject_nm) values("C Programming");
INSERT INTO subjects(subject_nm) values("Nobles");
INSERT INTO subjects(subject_nm) values("Artificial Intelligence");
INSERT INTO subjects(subject_nm) values("JAVA");
INSERT INTO subjects(subject_nm) values("Mathematics");

/*table titles*/
INSERT INTO titles(title_nm, subject_id, publisher_id) values("Head First DATABASE",1,6);
INSERT INTO titles(title_nm, subject_id, publisher_id) values("Let Us C",2,5);
INSERT INTO titles(title_nm, subject_id, publisher_id) values("Few Things Left Unsaid",3,4);
INSERT INTO titles(title_nm, subject_id, publisher_id) values("AI- A Practicle Approach",4,2);
INSERT INTO titles(title_nm, subject_id, publisher_id) values("JAVA - Documentation",5,3);
INSERT INTO titles(title_nm, subject_id, publisher_id) values("Mathematics - Easy Way",6,1);

/*table books*/
INSERT INTO books(title_id,purchase_dt, price, status) values(1,'2015-04-30',501, 'Available');
INSERT INTO books(title_id,purchase_dt, price, status) values(2,'2015-04-30',11, 'Available');
INSERT INTO books(title_id,purchase_dt, price, status) values(3,'2015-04-30',101, 'Available');
INSERT INTO books(title_id,purchase_dt, price, status) values(4,'2015-04-30',21, 'Available');
INSERT INTO books(title_id,purchase_dt, price, status) values(5,'2015-04-30',51, 'Available');
INSERT INTO books(title_id,purchase_dt, price, status) values(6,'2015-04-30',221, 'Available');

/*table title_author*/
INSERT INTO title_author(title_id, author_id) values(1,1);
INSERT INTO title_author(title_id, author_id) values(2,5);
INSERT INTO title_author(title_id, author_id) values(3,1);
INSERT INTO title_author(title_id, author_id) values(4,6);
INSERT INTO title_author(title_id, author_id) values(5,3);
INSERT INTO title_author(title_id, author_id) values(6,2);

/*table book_issue*/
INSERT INTO book_issue(accession_no, member_id) values(1,5);
INSERT INTO book_issue(accession_no, member_id) values(2,4);
INSERT INTO book_issue(accession_no, member_id) values(3,3);
INSERT INTO book_issue(accession_no, member_id) values(4,2);
INSERT INTO book_issue(accession_no, member_id) values(5,1);


/*table book_issue*/
--INSERT INTO 

/* Show publishers data*/
SELECT * FROM publishers;


/* Delete publishers data*/
DELETE FROM publishers;

