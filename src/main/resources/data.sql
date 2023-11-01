DROP TABLE IF EXISTS customer;

CREATE TABLE customer(
    id int NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL DEFAULT '',
    last_name VARCHAR(255) NOT NULL DEFAULT '',
    email VARCHAR(255) NOT NULL DEFAULT '',
    PRIMARY KEY(id)
);

INSERT INTO customer (first_name,last_name,email)
VALUES ('Tom','Sawyer','ts@mail.com'),
        ('Lara','Croft','lc@mail.com'),
        ('Harry','Potter','hp@mail.com'),
        ('John','Wick','jw@mail.com');