CREATE DATABASE WhoHaveWashed;

USE WhoHaveWashed;

CREATE TABLE WhW(

cod INT PRIMARY KEY AUTO_INCREMENT,
dia DATE,
pessoa VARCHAR(50),
refeicao VARCHAR(50),
louca VARCHAR(200),
outros VARCHAR(200)
);

SELECT * FROM WhW