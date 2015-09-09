--Assignment 3
--to populate provide scenario
CREATE  DATABASE ecommerce;
USE ecommerce;

CREATE TABLE product( 
	id	INTEGER AUTO_INCREMENT  NOT NULL  PRIMARY KEY , 
	name	VARCHAR(30) NOT NULL,
	parentId INTEGER     null,
	FOREIGN KEY (parentid)  REFERENCES product (id)
);
INSERT INTO product(id,name) VALUES (1,'Mobiles & Tablets');
INSERT INTO product(name) VALUES ('Computers');
INSERT INTO product(name) VALUES ('Home Appliances');
INSERT INTO product(name, parentId) VALUES('MOBILES',1);
INSERT INTO product(name, parentId) VALUES('TABLETS',1);
INSERT INTO product(name, parentId) VALUES('Smart Phones',4);
INSERT INTO product(name, parentId) VALUES('Featured Phones',4);
INSERT INTO product(name, parentId) VALUES('2G',5);
INSERT INTO product(name, parentId) VALUES('3G',5);
INSERT INTO product(name, parentId) VALUES('ACCESSORIES',1);
INSERT INTO product(name, parentId) VALUES('CASE & COVERS',1);
INSERT INTO product(name, parentId) VALUES('DESKTOP',2);
INSERT INTO product(name, parentId) VALUES('LAPTOP',2);
INSERT INTO product(name, parentId) VALUES('LAPTOP ACCESSORIES',2);
INSERT INTO product(name, parentId) VALUES('PRINTERS',2);
INSERT INTO product(name, parentId) VALUES('Keyboard',14);
INSERT INTO product(name, parentId) VALUES('Mouse',14);
INSERT INTO product(name, parentId) VALUES('Headphones',14);
INSERT INTO product(name, parentId) VALUES('Inkjet',15);
INSERT INTO product(name, parentId) VALUES('Laser',15);
INSERT INTO product(name, parentId) VALUES('TVs',3);-- 21
INSERT INTO product(name, parentId) VALUES('Air Conditioners',3);
INSERT INTO product(name, parentId) VALUES('Washing Machines',3);
INSERT INTO product(name, parentId) VALUES('LED',21);
INSERT INTO product(name, parentId) VALUES('LCD',21);
INSERT INTO product(name, parentId) VALUES('PLASMA',21);
INSERT INTO product(name, parentId) VALUES('Full Automatic',23);
INSERT INTO product(name, parentId) VALUES('Semi Automatic',23);
INSERT INTO product(name, parentId) VALUES('Top Load',27);
INSERT INTO product(name, parentId) VALUES('Front Load',27);


SELECT name FROM product;
