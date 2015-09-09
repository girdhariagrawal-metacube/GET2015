/*create database*/
CREATE DATABASE lis1;

/*select database*/
USE lis1;

/*create members table*/
CREATE TABLE `members` (
  `member_id` int(11)  AUTO_INCREMENT,
  `member_nm` char(20),
  `addressline1` varchar(30),
  `addressline2` varchar(30),
  `category` char(1),
  PRIMARY KEY (`member_id`)
) ;

/*create authors table*/
CREATE TABLE `authors` (
  `author_id` int(11) AUTO_INCREMENT,
  `author_nm` char(30),
  PRIMARY KEY (`author_id`)
) ;

/*create publishers table*/
CREATE TABLE `publishers` (
  `publisher_id` int(11) AUTO_INCREMENT,
  `publisher_nm` char(30),
  PRIMARY KEY (`publisher_id`)
) ;

/*create subjects table*/
CREATE TABLE `subjects` (
  `subject_id` int(11) AUTO_INCREMENT,
  `subject_nm` char(30),
  PRIMARY KEY (`subject_id`)
) ;

/*create titles table*/
CREATE TABLE `titles` (
  `title_id` int(11) AUTO_INCREMENT,
  `title_nm` char(30) ,
  `subject_id` int(11) ,
  `publisher_id` int(11) ,
  PRIMARY KEY (`title_id`),
  FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`) ON DELETE CASCADE,
  FOREIGN KEY (`publisher_id`) REFERENCES `publishers` (`publisher_id`) ON DELETE CASCADE
) ;

/*create books table*/
CREATE TABLE `books` (
  `accession_no` int(11) AUTO_INCREMENT,
  `title_id` int(11),
  `purchase_dt` date,
  `price` int(11),
  `status` varchar(10),
  PRIMARY KEY (`accession_no`),
 FOREIGN KEY (`title_id`) REFERENCES `titles` (`title_id`) ON DELETE CASCADE
) ;

/*create title_author table*/
CREATE TABLE `title_author` (
  `title_id` int(11) NOT NULL DEFAULT '0',
  `author_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`title_id`,`author_id`),
  FOREIGN KEY (`title_id`) REFERENCES `titles` (`title_id`) ON DELETE CASCADE,
  FOREIGN KEY (`author_id`) REFERENCES `authors` (`author_id`) ON DELETE CASCADE
) ;


/*create book_issue table*/
CREATE TABLE `book_issue` (
  `issue_dt` int(11)AUTO_INCREMENT,
  `accession_no` int(11),
  `member_id` int(11),
  `due_dt` date,
  PRIMARY KEY (`issue_dt`,`accession_no`,`member_id`),
  KEY `accession_no` (`accession_no`),
  FOREIGN KEY (`accession_no`) REFERENCES `books` (`accession_no`) ON DELETE CASCADE,
  FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`) ON DELETE CASCADE
) ;

/*create book_return table*/
CREATE TABLE `book_return` (
  `return_dt` date,
  `accession_no` int(11),
  `member_id` int(11),
  `issue_dt` date,
  PRIMARY KEY (`return_dt`,`accession_no`,`member_id`),
  FOREIGN KEY (`accession_no`) REFERENCES `books` (`accession_no`) ON DELETE CASCADE,
  FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`) ON DELETE CASCADE
) ;


/*To show tables*/
SHOW TABLES;

/*To alter time stamp of table to current*/
ALTER TABLE book_issue MODIFY issue_dt TIMESTAMP DEFAULT NOW();


/*To timestamp of due_dt to 15 + Now*/
DELIMITER ;;
CREATE TRIGGER book_due_date AFTER INSERT ON Book_Issue FOR EACH ROW
BEGIN
    SET NEW.due_Date = DATE_ADD(NOW(), INTERVAL 15 DAY)
END;;
DELIMITER ;

/*TO Drop Table*/
DROP TABLE book_return;
DROP TABLE book_issue;
DROP TABLE members;


/*create member table again*/
CREATE TABLE `members` (
  `member_id` int(11)AUTO_INCREMENT,
  `member_nm` char(20),
  `addressline1` varchar(30),
  `addressline2` varchar(30),
  `category` varchar(10),
  PRIMARY KEY (`member_id`)
) ;

CREATE TABLE `book_issue` (
  `issue_dt` DATE,
  `accession_no` int(11),
  `member_id` int(11),
  `due_dt` date,
  PRIMARY KEY (`issue_dt`,`accession_no`,`member_id`),
  FOREIGN KEY (`accession_no`) REFERENCES `books` (`accession_no`) ON DELETE CASCADE,
  FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`) ON DELETE CASCADE
) ;

/*To alter time stamp of table to current*/
ALTER TABLE book_issue MODIFY issue_dt TIMESTAMP DEFAULT NOW();


CREATE TABLE `book_return` (
  `return_dt` date ,
  `accession_no` int(11),
  `member_id` int(11),
  `issue_dt` date ,
  PRIMARY KEY (`return_dt`,`accession_no`,`member_id`),
  FOREIGN KEY (`accession_no`) REFERENCES `books` (`accession_no`) ON DELETE CASCADE,
  FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`) ON DELETE CASCADE
) ;

/* update addressline1*/
UPDATE members SET addressline1 = "EPIP, Sitapura" WHERE category ="F";

/*update addressline2*/
UPDATE members SET addressline2 = "Jaipur";	

