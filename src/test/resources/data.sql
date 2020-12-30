DROP TABLE IF EXISTS flightdetails;
CREATE TABLE flightdetails AS SELECT * FROM CSVREAD('classpath:tables/flight_info.csv');

DROP TABLE IF EXISTS user;
CREATE TABLE user AS SELECT * FROM CSVREAD('classpath:tables/user_visa.csv');