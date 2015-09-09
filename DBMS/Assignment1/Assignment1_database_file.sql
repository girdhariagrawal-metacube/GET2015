/*create database*/
CREATE DATABASE lis1;

/*select database*/
USE lis1;

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
CREATE TRIGGER book_due_date AFTER INSERT ON Book_Issue FOR EACH ROW
BEGIN
    UPDATE Book_Issue SET due_Date = DATE_ADD(NOW(), INTERVAL 15 DAY) where issue_Date = NOW();
END;;
DELIMITER ;

/*TO Drop Table*/
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

/*To alter time stamp of table to current*/
ALTER TABLE book_issue MODIFY issue_dt TIMESTAMP DEFAULT NOW();


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

/* update addressline1*/
UPDATE members SET addressline1 = "EPIP, Sitapura" WHERE category ="F";

/*update addressline2*/
UPDATE members SET addressline2 = "Jaipur";	

