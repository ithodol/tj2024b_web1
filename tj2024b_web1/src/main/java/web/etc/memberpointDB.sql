drop database if exists mydb0204;
create database mydb0204;
use mydb0204;


# 회원 테이블
create table member(
	mno int unsigned auto_increment,
    id varchar(20) not null,
    pwd varchar(20) not null,
    name varchar(10) not null,
    tel varchar(20) not null,
    date datetime default now(),
    newpoint int default 100,
    constraint primary key(mno)
);
-- 회원 샘플
insert into member(id, pwd, name, tel) values('qwe123', '111', '유재석', '010-1111-1111');
insert into member(id, pwd, name, tel) values('asd456', '222', '강호동', '010-2222-2222');
insert into member(id, pwd, name, tel) values('zxc789', '333', '신동엽', '010-3333-3333');

select * from member;


# 포인트 테이블
create table point(
	pno int unsigned auto_increment,
	loginpoint int,
    boardpoint int,
    bookingpoint int,
    mno int,
    constraint foreign key(mno) references member(mno),
    constraint primary key(pno)
);

insert into point(loginpoint, boardpoint, bookingpoint, mno) values('1', '-5', '10', '1');
insert into point(loginpoint, boardpoint, bookingpoint, mno) values('2', '-10', '20', '2');
insert into point(loginpoint, boardpoint, bookingpoint, mno) values('3', '-15', '30', '3');

select * from point;

