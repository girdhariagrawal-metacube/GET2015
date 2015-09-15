/*create database*/
CREATE DATABASE lis;

/*select database*/
USE lis;

/*create members table*/
CREATE TABLE `members` (
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `member_nm` char(20) DEFAULT NULL,
  `addressline1` varchar(30) DEFAULT NULL,
  `addressline2` varchar(30) DEFAULT NULL,
  `category` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ;

/*create authors table*/
CREATE TABLE `authors` (
  `author_id` int(11) NOT NULL AUTO_INCREMENT,
  `author_nm` char(30) DEFAULT NULL,
  PRIMARY KEY (`author_id`)
) ;

/*create publishers table*/
CREATE TABLE `publishers` (
  `publisher_id` int(11) NOT NULL AUTO_INCREMENT,
  `publisher_nm` char(30) DEFAULT NULL,
  PRIMARY KEY (`publisher_id`)
) ;

/*create subjects table*/
CREATE TABLE `subjects` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_nm` char(30) DEFAULT NULL,
  PRIMARY KEY (`subject_id`)
) ;

/*create titles table*/
CREATE TABLE `titles` (
  `title_id` int(11) NOT NULL AUTO_INCREMENT,
  `title_nm` char(30) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `publisher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`title_id`),
  KEY `subject_id` (`subject_id`),
  KEY `publisher_id` (`publisher_id`),
  CONSTRAINT `titles_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`) ON DELETE CASCADE,
  CONSTRAINT `titles_ibfk_2` FOREIGN KEY (`publisher_id`) REFERENCES `publishers` (`publisher_id`) ON DELETE CASCADE
) ;

/*create books table*/
CREATE TABLE `books` (
  `accession_no` int(11) NOT NULL AUTO_INCREMENT,
  `title_id` int(11) DEFAULT NULL,
  `purchase_dt` date DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`accession_no`),
  KEY `title_id` (`title_id`),
  CONSTRAINT `books_ibfk_1` FOREIGN KEY (`title_id`) REFERENCES `titles` (`title_id`) ON DELETE CASCADE
) ;

/*create title_author table*/
CREATE TABLE `title_author` (
  `title_id` int(11) NOT NULL DEFAULT '0',
  `author_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`title_id`,`author_id`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `title_author_ibfk_1` FOREIGN KEY (`title_id`) REFERENCES `titles` (`title_id`) ON DELETE CASCADE,
  CONSTRAINT `title_author_ibfk_2` FOREIGN KEY (`author_id`) REFERENCES `authors` (`author_id`) ON DELETE CASCADE
) ;


/*create book_issue table*/
CREATE TABLE `book_issue` (
  `issue_dt` int(11) NOT NULL AUTO_INCREMENT,
  `accession_no` int(11) NOT NULL DEFAULT '0',
  `member_id` int(11) NOT NULL DEFAULT '0',
  `due_dt` date DEFAULT NULL,
  PRIMARY KEY (`issue_dt`,`accession_no`,`member_id`),
  KEY `accession_no` (`accession_no`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `book_issue_ibfk_1` FOREIGN KEY (`accession_no`) REFERENCES `books` (`accession_no`) ON DELETE CASCADE,
  CONSTRAINT `book_issue_ibfk_2` FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`) ON DELETE CASCADE
) ;

/*create book_return table*/
CREATE TABLE `book_return` (
  `return_dt` date NOT NULL DEFAULT '0000-00-00',
  `accession_no` int(11) NOT NULL DEFAULT '0',
  `member_id` int(11) NOT NULL DEFAULT '0',
  `issue_dt` date DEFAULT NULL,
  PRIMARY KEY (`return_dt`,`accession_no`,`member_id`),
  KEY `accession_no` (`accession_no`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `book_return_ibfk_1` FOREIGN KEY (`accession_no`) REFERENCES `books` (`accession_no`) ON DELETE CASCADE,
  CONSTRAINT `book_return_ibfk_2` FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`) ON DELETE CASCADE
) ;


/*To show tables*/
SHOW TABLES;

/*To alter time stamp of table to current*/
ALTER TABLE book_issue MODIFY issue_dt TIMESTAMP DEFAULT NOW();


/*To timestamp of due_dt to 15 + Now*/
DELIMITER ;;
CREATE TRIGGER book_due_date AFTER INSERT ON book_issue FOR EACH ROW
BEGIN	
	UPDATE book_issue SET due_dt = DATE_ADD(NOW(), INTERVAL 15 DAY) WHERE issue_dt = NOW();
END;;
DELIMITER ;

/*TO Drop Table*/
DROP TRIGGER book_due_date;
DROP TABLE book_return;
DROP TABLE book_issue;
DROP TABLE members;


/*create member table again*/
CREATE TABLE `members` (
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `member_nm` char(20) DEFAULT NULL,
  `addressline1` varchar(30) DEFAULT NULL,
  `addressline2` varchar(30) DEFAULT NULL,
  `category` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ;

CREATE TABLE `book_issue` (
  `issue_dt` DATE NOT NULL,
  `accession_no` int(11) NOT NULL DEFAULT '0',
  `member_id` int(11) NOT NULL DEFAULT '0',
  `due_dt` date DEFAULT NULL,
  PRIMARY KEY (`issue_dt`,`accession_no`,`member_id`),
  KEY `accession_no` (`accession_no`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `book_issue_ibfk_1` FOREIGN KEY (`accession_no`) REFERENCES `books` (`accession_no`) ON DELETE CASCADE,
  CONSTRAINT `book_issue_ibfk_2` FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`) ON DELETE CASCADE
) ;

CREATE TABLE `book_return` (
  `return_dt` date NOT NULL DEFAULT '0000-00-00',
  `accession_no` int(11) NOT NULL DEFAULT '0',
  `member_id` int(11) NOT NULL DEFAULT '0' ,
  `issue_dt` date DEFAULT NULL,
  PRIMARY KEY (`return_dt`,`accession_no`,`member_id`),
  KEY `accession_no` (`accession_no`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `book_return_ibfk_1` FOREIGN KEY (`accession_no`) REFERENCES `books` (`accession_no`) ON DELETE CASCADE,
  CONSTRAINT `book_return_ibfk_2` FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`) ON DELETE CASCADE
) ;

/*To alter time stamp of table to current*/
ALTER TABLE book_issue MODIFY issue_dt TIMESTAMP DEFAULT NOW();
DELIMITER ;;
CREATE TRIGGER book_due_date BEFORE INSERT ON Book_Issue FOR EACH ROW
BEGIN
    SET NEW.due_dt = DATE_ADD(NOW(), INTERVAL 15 DAY);
END;;
DELIMITER ;
/*insert data in tables*/

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


/*table members*/
INSERT INTO members(member_nm,addressline1,addressline2,category) values("Babalu","Jalabarh","Jalabarh","M");
INSERT INTO members(member_nm,addressline1,addressline2,category) values("Anurag Anand","Chai Ki Mandi","Patna","M");
INSERT INTO members(member_nm,addressline1,addressline2,category) values("Sumitra","Madhav Nagar","Chittorgarh","F");
INSERT INTO members(member_nm,addressline1,addressline2,category) values("Dheeraj","Kishan Gadh","Ajmer","M");
INSERT INTO members(member_nm,addressline1,addressline2,category) values("Girdhari","HOli Gate","Mathura","M");

/*table titles*/
INSERT INTO titles(title_nm, subject_id, publisher_id) values("Head First DATABASE",1,6);
INSERT INTO titles(title_nm, subject_id, publisher_id) values("Let Us C",2,5);
INSERT INTO titles(title_nm, subject_id, publisher_id) values("Few Things Left Unsaid",3,4);
INSERT INTO titles(title_nm, subject_id, publisher_id) values("AI- A Practicle Approach",4,2);
INSERT INTO titles(title_nm, subject_id, publisher_id) values("JAVA - Documentation",5,3);
INSERT INTO titles(title_nm, subject_id, publisher_id) values("Mathematics - Easy Way",6,1);

/*table title_author*/
INSERT INTO title_author(title_id, author_id) values(1,1);
INSERT INTO title_author(title_id, author_id) values(2,5);
INSERT INTO title_author(title_id, author_id) values(3,1);
INSERT INTO title_author(title_id, author_id) values(4,6);
INSERT INTO title_author(title_id, author_id) values(5,3);
INSERT INTO title_author(title_id, author_id) values(6,2);

/*table books*/
INSERT INTO books(title_id,purchase_dt, price, status) values(1,'2015-04-30',501, 'Available');
INSERT INTO books(title_id,purchase_dt, price, status) values(2,'2015-04-30',11, 'Available');
INSERT INTO books(title_id,purchase_dt, price, status) values(3,'2015-04-30',101, 'Available');
INSERT INTO books(title_id,purchase_dt, price, status) values(4,'2015-04-30',21, 'Available');
INSERT INTO books(title_id,purchase_dt, price, status) values(5,'2015-04-30',51, 'Available');
INSERT INTO books(title_id,purchase_dt, price, status) values(6,'2015-04-30',221, 'Available');

/*table book_issue*/
INSERT INTO book_issue(accession_no, member_id) values(1,5);
INSERT INTO book_issue(accession_no, member_id) values(2,4);
INSERT INTO book_issue(accession_no, member_id) values(3,3);
INSERT INTO book_issue(accession_no, member_id) values(4,2);
INSERT INTO book_issue(accession_no, member_id) values(5,1);

/* table book return */
INSERT INTO Book_Return(return_dt, accession_No, member_Id, issue_dt) VALUES('2015-09-06', 1, 2, '2015-08-23');
INSERT INTO Book_Return(return_dt, accession_No, member_Id, issue_dt) VALUES('2015-09-07', 2, 1, '2015-08-24');
INSERT INTO Book_Return(return_dt, accession_No, member_Id, issue_dt) VALUES('2015-09-04', 3, 3, '2015-08-21');
INSERT INTO Book_Return(return_dt, accession_No, member_Id, issue_dt) VALUES('2015-08-25', 8, 4, '2015-08-10');
INSERT INTO Book_Return(return_dt, accession_No, member_Id, issue_dt) VALUES('2015-08-31', 5, 6, '2015-08-16');

/* update addressline1*/
UPDATE members SET addressline1 = "EPIP, Sitapura" WHERE category ="F";

/*update addressline2*/
UPDATE members SET addressline2 = "Jaipur";	

-- Deleting Publishers
SELECT * FROM Members;
DELETE FROM titles WHERE publisher_Id = 1; 
SELECT * from titles;
DELETE FROM publishers;


/* Entering data using substitution variable */
SET @name = 'Shyam Books';
SET @Id = 1;
INSERT INTO Publishers(publisher_Id, publisher_nm)
VALUES(@Id, @name);


SET @name = ' Cbc House';
INSERT INTO Publishers(publisher_nm)
VALUES(@name);


SET @name = 'A M Publishers';
INSERT INTO Publishers(publisher_nm)
VALUES(@name);

SET @name = 'Academia Research';
INSERT INTO Publishers(publisher_nm)
VALUES(@name);

SET @name = 'Genius Publication';
INSERT INTO Publishers(publisher_nm)
VALUES(@name);

SET @name = 'Cloud Publications';
INSERT INTO Publishers(publisher_nm)
VALUES(@name);

SET @name = 'College Book House';
INSERT INTO Publishers(publisher_nm)
VALUES(@name);


SELECT * FROM Publishers;
