CREATE SCHEMA IF NOT EXISTS test;
USE test;

CREATE TABLE players (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
gender VARCHAR(10),
name VARCHAR(100),
score INTEGER NOT NULL);


