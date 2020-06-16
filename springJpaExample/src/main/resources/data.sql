create table PERSON
(
    ID INTEGER not null,
    NAME VARCHAR(255) not null,
    LOCATION VARCHAR(255),
    BIRTH_DATE TIMESTAMP,
    PRIMARY KEY(ID)
);

-- INSERT INTO person (id, name, location, birth_date) VALUES(10001, 'Shawn', 'NJ', sysdate());
-- INSERT INTO person (ID, NAME, LOCATION, BIRTH_DATE) VALUES(10002, 'Monica', 'NY', sysdate());
-- INSERT INTO person (ID, NAME, LOCATION, BIRTH_DATE) VALUES(10003, 'Evil Shawn', 'NJ', sysdate());


