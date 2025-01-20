drop database if exists waiting;
create database waiting;
use waiting;

create table waiting(
	tel varchar(20),
    count int,
    num int auto_increment,
    constraint primary key(num)
);
select * from waiting;