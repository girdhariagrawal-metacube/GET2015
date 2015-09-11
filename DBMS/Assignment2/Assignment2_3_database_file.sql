/* Assignment 2-3 */

/* Create a ECommerce application */
CREATE DATABASE ECommerce;

USE ECommerce;

/* Create Category Table */
CREATE TABLE Category (
	Category_Id INT AUTO_INCREMENT PRIMARY KEY,
	Category_Name VARCHAR(25)
);

/* Create Sub_Category Table */
CREATE TABLE Sub_Category (
	Sub_Category_Id INT AUTO_INCREMENT PRIMARY KEY,
	Sub_Category_Name VARCHAR(25),
	Category_Id INT,
	FOREIGN KEY(Category_Id) REFERENCES Category(Category_Id)
);

/* Create Product_Type_Category Table */

CREATE TABLE Product_Type_Category (
	Product_Type_Id INT AUTO_INCREMENT PRIMARY KEY,
	Product_Type_Name VARCHAR(30),
	Sub_Category_Id INT,
	FOREIGN KEY(Sub_Category_Id) REFERENCES Sub_Category(Sub_Category_Id)
);

/* Insert Data in Tables */

/* Category Table */
INSERT INTO Category(Category_Id,Category_Name) VALUES (1,'Mobiles & Tablets');
INSERT INTO Category(Category_Name) VALUES ('Computers');
INSERT INTO Category(Category_Name) VALUES ('Home Appliances');

/* Sub_Category Table */

INSERT INTO Sub_Category(Sub_Category_Name,Category_Id) VALUES('Mobiles',1);
INSERT INTO Sub_Category(Sub_Category_Name,Category_Id) VALUES('Tablets',1);
INSERT INTO Sub_Category(Sub_Category_Name,Category_Id) VALUES('Accessories',1);
INSERT INTO Sub_Category(Sub_Category_Name,Category_Id) VALUES('Cases & Covers',1);

INSERT INTO Sub_Category(Sub_Category_Name,Category_Id) VALUES('Desktop',2);
INSERT INTO Sub_Category(Sub_Category_Name,Category_Id) VALUES('Laptop',2);
INSERT INTO Sub_Category(Sub_Category_Name,Category_Id) VALUES('Laptop Accessories',2);
INSERT INTO Sub_Category(Sub_Category_Name,Category_Id) VALUES('Printers',2);

INSERT INTO Sub_Category(Sub_Category_Name,Category_Id) VALUES('TVs',3);
INSERT INTO Sub_Category(Sub_Category_Name,Category_Id) VALUES('Air Conditioners',3);
INSERT INTO Sub_Category(Sub_Category_Name,Category_Id) VALUES('Air Conditioners',3);
INSERT INTO Sub_Category(Sub_Category_Name,Category_Id) VALUES('Washing Machines',3);

/* Product_Type_Category Table */
INSERT INTO Product_Type_Category(Product_Type_Name,Sub_Category_Id) VALUES("Smart Phones",1);
INSERT INTO Product_Type_Category(Product_Type_Name,Sub_Category_Id) VALUES("Featured Phones",1);

INSERT INTO Product_Type_Category(Product_Type_Name,Sub_Category_Id) VALUES("2G",2);
INSERT INTO Product_Type_Category(Product_Type_Name,Sub_Category_Id) VALUES("3G",2);

INSERT INTO Product_Type_Category(Product_Type_Name,Sub_Category_Id) VALUES("Keyboard",7);
INSERT INTO Product_Type_Category(Product_Type_Name,Sub_Category_Id) VALUES("Mouse",7);
INSERT INTO Product_Type_Category(Product_Type_Name,Sub_Category_Id) VALUES("Headphones",7);

INSERT INTO Product_Type_Category(Product_Type_Name,Sub_Category_Id) VALUES("Inkjet",8);
INSERT INTO Product_Type_Category(Product_Type_Name,Sub_Category_Id) VALUES("Laser",8);

INSERT INTO Product_Type_Category(Product_Type_Name,Sub_Category_Id) VALUES("LED",9);
INSERT INTO Product_Type_Category(Product_Type_Name,Sub_Category_Id) VALUES("LCD",9);
INSERT INTO Product_Type_Category(Product_Type_Name,Sub_Category_Id) VALUES("Plasma",9);

INSERT INTO Product_Type_Category(Product_Type_Name,Sub_Category_Id) VALUES("Full Autometic",11);
INSERT INTO Product_Type_Category(Product_Type_Name,Sub_Category_Id) VALUES("Semi Automatic",11);


/* Select from database */

SELECT c.Sub_Category_Name, p.Category_Name "Top Category" FROM Category AS p JOIN Sub_Category AS c ON c.Category_Id = p.Category_Id ORDER BY p.Category_Name;

SELECT Category_Id, Category_Name From Category;































