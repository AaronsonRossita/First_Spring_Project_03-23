DROP TABLE IF EXISTS users;

CREATE TABLE users(
    id int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    email varchar(50) NOT NULL DEFAULT ''
);