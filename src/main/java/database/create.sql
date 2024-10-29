CREATE DATABASE login;
USE demo;

create table users (
 name varchar(120) NOT NULL,
 pass int(3) NOT NULL AUTO_INCREMENT
 PRIMARY KEY (pass)
);