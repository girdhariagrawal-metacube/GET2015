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
	Sub_Category_To_Category INT,
	FOREIGN KEY(Sub_Category_To_Category) REFERENCES Category(Category_Id)
);

/* Create Product_Type_Category Table */

CREATE TABLE Product_Type_Category (
	Product_Type_Id INT AUTO_INCREMENT PRIMARY KEY,
	Product_Type_Name VARCHAR(30),
	Product_Type_Category_To_Sub_Category INT,
	FOREIGN KEY(Product_Type_Category_To_Sub_Category) REFERENCES Sub_Category(Sub_Category_Id)
);

/* Insert Data in Tables */

/* Category Table */
INSERT INTO Category(Category_Id,Category_Name) VALUES (1,'Mobiles & Tablets');
INSERT INTO Category(Category_Name) VALUES ('Computers');
INSERT INTO Category(Category_Name) VALUES ('Home Appliances');

/* Sub_Category Table */

INSERT INTO Sub_Category(Sub_Category_Name,Sub_Category_To_Category) VALUES('Mobiles',1);
INSERT INTO Sub_Category(Sub_Category_Name,Sub_Category_To_Category) VALUES('Tablets',1);
INSERT INTO Sub_Category(Sub_Category_Name,Sub_Category_To_Category) VALUES('Accessories',1);
INSERT INTO Sub_Category(Sub_Category_Name,Sub_Category_To_Category) VALUES('Cases & Covers',1);

INSERT INTO Sub_Category(Sub_Category_Name,Sub_Category_To_Category) VALUES('Desktop',2);
INSERT INTO Sub_Category(Sub_Category_Name,Sub_Category_To_Category) VALUES('Laptop',2);
INSERT INTO Sub_Category(Sub_Category_Name,Sub_Category_To_Category) VALUES('Laptop Accessories',2);
INSERT INTO Sub_Category(Sub_Category_Name,Sub_Category_To_Category) VALUES('Printers',2);

INSERT INTO Sub_Category(Sub_Category_Name,Sub_Category_To_Category) VALUES('TVs',3);
INSERT INTO Sub_Category(Sub_Category_Name,Sub_Category_To_Category) VALUES('Air Conditioners',3);
INSERT INTO Sub_Category(Sub_Category_Name,Sub_Category_To_Category) VALUES('Air Conditioners',3);
INSERT INTO Sub_Category(Sub_Category_Name,Sub_Category_To_Category) VALUES('Washing Machines',3);

/* Product_Type_Category Table */
INSERT INTO Product_Type_Category(Product_Type_Name,Product_Type_Category_To_Sub_Category) VALUES("Smart Phones",1);
INSERT INTO Product_Type_Category(Product_Type_Name,Product_Type_Category_To_Sub_Category) VALUES("Featured Phones",1);

INSERT INTO Product_Type_Category(Product_Type_Name,Product_Type_Category_To_Sub_Category) VALUES("2G",2);
INSERT INTO Product_Type_Category(Product_Type_Name,Product_Type_Category_To_Sub_Category) VALUES("3G",2);

INSERT INTO Product_Type_Category(Product_Type_Name,Product_Type_Category_To_Sub_Category) VALUES("Keyboard",7);
INSERT INTO Product_Type_Category(Product_Type_Name,Product_Type_Category_To_Sub_Category) VALUES("Mouse",7);
INSERT INTO Product_Type_Category(Product_Type_Name,Product_Type_Category_To_Sub_Category) VALUES("Headphones",7);

INSERT INTO Product_Type_Category(Product_Type_Name,Product_Type_Category_To_Sub_Category) VALUES("Inkjet",8);
INSERT INTO Product_Type_Category(Product_Type_Name,Product_Type_Category_To_Sub_Category) VALUES("Laser",8);

INSERT INTO Product_Type_Category(Product_Type_Name,Product_Type_Category_To_Sub_Category) VALUES("LED",9);
INSERT INTO Product_Type_Category(Product_Type_Name,Product_Type_Category_To_Sub_Category) VALUES("LCD",9);
INSERT INTO Product_Type_Category(Product_Type_Name,Product_Type_Category_To_Sub_Category) VALUES("Plasma",9);

INSERT INTO Product_Type_Category(Product_Type_Name,Product_Type_Category_To_Sub_Category) VALUES("Full Autometic",11);
INSERT INTO Product_Type_Category(Product_Type_Name,Product_Type_Category_To_Sub_Category) VALUES("Semi Automatic",11);


/* Select from database */

SELECT c.Sub_Category_Name, p.Category_Name "Top Category" FROM Category AS p JOIN Sub_Category AS c ON c.Sub_Category_To_Category = p.Category_Id ORDER BY p.Category_Name;

SELECT Category_Id, Category_Name From Category;































