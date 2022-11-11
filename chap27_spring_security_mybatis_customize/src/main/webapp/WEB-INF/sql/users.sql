create table users(
    username varchar(45) not null primary key,
    password varchar(60) not null,
    enabled number(1) default 1
);