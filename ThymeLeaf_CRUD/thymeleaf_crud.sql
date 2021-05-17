CREATE DATABASE thymeleaf_crud;
USE thymeleaf_crud;
CREATE TABLE product(
id INT(11) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`brand` VARCHAR(45) NOT NULL,
`madein` VARCHAR(45) NOT NULL,
`price` FLOAT NOT NULL,
PRIMARY KEY(`id`)
);

INSERT INTO product(name,brand,madein,price) VALUES ('iphone 12 pro max','iphone','China',1999);
INSERT INTO product(name,brand,madein,price) VALUES ('iphone 12 pro ','iphone','China',1999);
INSERT INTO product(name,brand,madein,price) VALUES ('iphone 11 pro max','iphone','China',1999);
INSERT INTO product(name,brand,madein,price) VALUES ('iphone 11 pro','iphone','China',1999);
INSERT INTO product(name,brand,madein,price) VALUES ('iphone 11 ','iphone','China',1999);
INSERT INTO product(name,brand,madein,price) VALUES ('iphone X','iphone','China',1999);

SELECT * FROM product;