--Assignment 4
--create a table system which will populate city and state associated with zip code
CREATE DATABASE zipmapping;
USE zipmapping;

--create state table
CREATE TABLE states(
	states_id INT AUTO_INCREMENT,
	states_name CHAR(20),
	PRIMARY KEY(states_id)
);

--create city table
CREATE TABLE city(
	city_id INT PRIMARY KEY AUTO_INCREMENT,
	city_name CHAR(20),
	states_id INT,
	FOREIGN KEY(states_id) REFERENCES states(states_id)
);

--create ziptocity table
CREATE TABLE ziptocity(
	zipcode INT PRIMARY KEY,
	city_id INT,
	FOREIGN KEY(city_id) REFERENCES city(city_id) ON DELETE CASCADE
);

INSERT INTO states(states_name) VALUES
	("Uttar Pradesh"),
	("Rajsthan"),
	("Haryana"),
	("Punjab"),
	("Goa"),
	("Madhay Pradesh"),
	("Bihar"),
	("Maharastra");
	
INSERT INTO city(city_name,states_id) VALUES 
	("Mathura",1),
	("Agra",1),
	("Allahabad",1),
	("Hathras",1);
	
INSERT INTO city(city_name,states_id) VALUES 
	("Jaipur",2),
	("Bikaner",2),
	("Ajmer",2),
	("Chittorgarh",2);

INSERT INTO city(city_name,states_id) VALUES 
	("Patna",7),
	("Gaya",7),
	("Hajipur",7),
	("Sonpur",7); 
	
INSERT INTO city(city_name,states_id) VALUES 
	("Gurgaon",3),
	("Badshahpur",3),
	("Behrampur",3),
	("Ghata",3);

INSERT INTO ziptocity(zipcode,city_id) VALUES
	(281001,1),
	(281003,1),
	(281002,1),
	(282001,2),
	(535218,2),
	(522004,2),
	(385340,3),
	(456015,3),
	(211003,3),
	(204101,4),
	(204102,4),
	(261208,5),
	(221406,5),
	(303301,5),
	(305002,7),
	(382728,7),
	(360055,7),
	(503245,9),
	(530052,9),
	(754140,9),
	(228145,11),
	(855105,11),
	(276122,11),
	(122225,13),
	(12210,13),
	(12234,13),
	(721102,14),
	(443201,14),
	(736206,14);
	
SELECT c.city_name CITY, s.states_name "State Name" FROM city AS c JOIN states AS s ON c.states_id=s.states_id 
    JOIN ziptocity AS z ON z.city_id = c.city_id WHERE z.zipcode = "281001";
