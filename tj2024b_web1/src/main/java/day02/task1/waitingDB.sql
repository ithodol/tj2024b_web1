drop database if exists waiting;
create database waiting;
use waiting;

create table waiting(
	tel int,
    count int,
    num int auto_increment,
    constraint primary key(num)
);
select * from waiting;