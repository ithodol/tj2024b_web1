drop database if exists mydb0201;
create database mydb0201;
use mydb0201;

create table member(
	custno int auto_increment,
    custname varchar(20),
    phone varchar(13),
    address varchar(60),
    joindate date,
    grade varchar(5),
    city varchar(5),
    constraint primary key (custno)
);
select * from member;
insert into member(custno, custname, phone, address, joindate, grade, city) values('100001', '김행복', '010-1111-2222', '서울 동대문구 휘경1동', '2015-12-02', 'A', '01');
insert into member(custno, custname, phone, address, joindate, grade, city) values('100002', '이축복', '010-1111-3333', '서울 동대문구 휘경2동', '2015-12-06', 'B', '01');
insert into member(custno, custname, phone, address, joindate, grade, city) values('100003', '장믿음', '010-1111-4444', '울릉군 울릉읍 독도1리', '2015-10-01', 'B', '30');
insert into member(custno, custname, phone, address, joindate, grade, city) values('100004', '최사랑', '010-1111-5555', '울릉군 울릉읍 독도2리', '2015-11-13', 'A', '30');
insert into member(custno, custname, phone, address, joindate, grade, city) values('100005', '진평화', '010-1111-6666', '제주도 제주시 외나무골', '2015-12-25', 'B', '60');
insert into member(custno, custname, phone, address, joindate, grade, city) values('100006', '차공단', '010-1111-7777', '제주도 제주시 감나무골', '2015-12-11', 'C', '60');


create table money(
	custno int,
    saleno int auto_increment,
    pcost int,
    amount int,
    price int,
    pcode varchar(4),
    sdate date,
    constraint primary key (saleno),
    constraint foreign key (custno) references member(custno)    
);
select * from money;
insert into money(custno, saleno, pcost, amount, price, pcode, sdate) values('100001', '20160001', '500', '5', '2500', 'A001', '20160101');
insert into money(custno, saleno, pcost, amount, price, pcode, sdate) values('100001', '20160002', '1000', '4', '4000', 'A002', '20160101');
insert into money(custno, saleno, pcost, amount, price, pcode, sdate) values('100001', '20160003', '500', '3', '1500', 'A008', '20160101');
insert into money(custno, saleno, pcost, amount, price, pcode, sdate) values('100002', '20160004', '2000', '1', '2000', 'A004', '20160102');
insert into money(custno, saleno, pcost, amount, price, pcode, sdate) values('100002', '20160005', '500', '1', '500', 'A001', '20160103');
insert into money(custno, saleno, pcost, amount, price, pcode, sdate) values('100003', '20160006', '1500', '2', '3000', 'A003', '20160103');
insert into money(custno, saleno, pcost, amount, price, pcode, sdate) values('100004', '20160007', '500', '2', '1000', 'A001', '20160104');
insert into money(custno, saleno, pcost, amount, price, pcode, sdate) values('100004', '20160008', '300', '1', '300', 'A005', '20160104');
insert into money(custno, saleno, pcost, amount, price, pcode, sdate) values('100004', '20160009', '600', '1', '600', 'A006', '20160104');
insert into money(custno, saleno, pcost, amount, price, pcode, sdate) values('100004', '20160010', '3000', '1', '3000', 'A007', '20160106');

