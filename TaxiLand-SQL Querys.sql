show databases;

-- create the DB
CREATE DATABASE taxiland;

-- use the DB
use taxiland;

-- Customer Table
CREATE TABLE customers(
cName VARCHAR(32) PRIMARY KEY,
cPass VARCHAR(64)
);

-- altering the customers table to add the cash column
ALTER TABLE taxiland.customers MODIFY column cCash int DEFAULT 0;

-- 
use taxiland;

show tables;

describe customers;
truncate customers;
INSERT INTO taxiland.customers VALUES
("a","a",50000 );

delete from customers where cName ='lohithan';
select * from customers;

-- Routes Table
CREATE TABLE routes(
rName VARCHAR(32) PRIMARY KEY,
rDistance int NOT NULL,
rAddress VARCHAR(128) DEFAULT NULL
);

-- show routes
describe  routes;

INSERT INTO routes VALUES(
"Kilambakkam Bus Terminal", 8,"Peerakankaranai, Tamil Nadu 603210");

INSERT INTO routes VALUES(
"McDonald's
Vallal MGR Salai", 5,"McDonald's
Vallal MGR Salai, Maraimalai Nagar, Tamil Nadu 603203");



-- CAR
create TABLE cars(
carName VARCHAR(32) PRIMARY KEY,
carMilage int DEFAULT NULL
);
-- alterations to the table
ALTER TABLE cars ADD COLUMN cCapacity int DEFAULT 3;
ALTER TABLE cars ADD COLUMN cAvgSpeed int DEFAULT 65;
-- describe the table
describe cars;

select * from cars;
-- insert some cars
INSERT INTO cars values("TN08-CH0939", 35,5,70 );
INSERT INTO cars values("TN09-CH0936", 55,4,70 );
INSERT INTO cars values("TN10-CH0939", 35,5,70 );
INSERT INTO cars values("TN12-CX0999", 30 );
INSERT INTO cars values("TN49-CB1994", 30 );
-- TRIPS Table
create TABLE trips(
tID INT PRIMARY KEY auto_increment,
tCustomer VARCHAR(32),
tRoute VARCHAR(32),
tCar VARCHAR(32),
FOREIGN KEY (tCar) REFERENCES taxiland.cars(carName),
FOREIGN KEY (tRoute) REFERENCES taxiland.routes(rName),
FOREIGN KEY (tCustomer) REFERENCES taxiland.customers(cName)
);

ALTER TABLE trips ADD COLUMN tTravellers int DEFAULT 2;

INSERT INTO trips (tCustomer, tRoute,tCar, tTravellers)values ( "Subash","Auroville Township","TN08-CH0939",5);
INSERT INTO trips (tCustomer, tRoute,tCar, tTravellers)values ( "Subash","Kilambakkam Bus Terminal","TN49-CB1994",2);

select * from trips;
select * from routes;
select * from customers;

insert into taxiland.customers values (
"lohithan","hug65");

-- show trips
describe  trips;