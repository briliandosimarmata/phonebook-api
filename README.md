To run this project, u need to execute this script to create table in your PostgreSQL Database:

create table contact(
    id varchar(100) primary key ,
    name varchar(100),
    phone_number varchar(13),
    avatar bytea,
    version numeric
);
