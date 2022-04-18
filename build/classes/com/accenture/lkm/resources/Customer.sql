
DROP DATABASE IF EXISTS springmvcxyzmock;
CREATE DATABASE springmvcxyzmock; 
use springmvcxyzmock;

DROP TABLE if exists Customer CASCADE;
DROP TABLE if exists CustomerTypes CASCADE;

CREATE TABLE Customer(
 customerId int(10) AUTO_INCREMENT,
 customerName varchar(20),
 billingDate date,
 bill double,
 customerType varchar(3),
 PRIMARY KEY(customerId)) AUTO_INCREMENT = 1001;

CREATE TABLE CustomerTypes(
customerType varchar(3),
minimumBill double,
maximumBill double,
PRIMARY KEY(customerType));

INSERT INTO Customer (customerId, customerName, billingDate, bill, customerType) VALUES
(1001,'Jack','2018-01-28',6000,'P'),
(1002,'Mark','2019-04-10',3000,'G');

commit;

INSERT INTO CustomerTypes (customerType, minimumBill, maximumBill) VALUES 
('S',1001,2000),
('G',2001,5000),
('P',5001,10000);

commit;