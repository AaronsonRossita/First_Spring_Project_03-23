DROP TABLE IF EXISTS customer;

CREATE TABLE customer(
    id int NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL DEFAULT '',
    last_name VARCHAR(255) NOT NULL DEFAULT '',
    email VARCHAR(255) NOT NULL DEFAULT '',
    customer_status VARCHAR NOT NULL DEFAULT 'REGULAR',
    PRIMARY KEY(id)
);

INSERT INTO customer (first_name,last_name,email,customer_status)
VALUES ('Tom','Sawyer','ts@mail.com','REGULAR'),
        ('Lara','Croft','lc@mail.com','REGULAR'),
        ('Harry','Potter','hp@mail.com','REGULAR'),
        ('John','Wick','jw@mail.com','REGULAR'),
        ('Harry','Potter','hp@mail.com','VIP'),
        ('Harry','Potter','hp@mail.com','VIP');