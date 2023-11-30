
DROP DATABASE IF EXISTS aei_database;
CREATE DATABASE aei_database;
USE aei_database;

CREATE TABLE users(
	userName VARCHAR(15) NOT NULL,
    password VARCHAR(15) NOT NULL,
    userID int NOT NULL,
    PRIMARY KEY (userID)
);
CREATE TABLE schedules(
	scheduleID int NOT NULL,
    schedule_array BLOB NOT NULL,
    userID int NOT NULL,
    PRIMARY KEY (scheduleID),
    FOREIGN KEY (userID) REFERENCES users(userID)
);