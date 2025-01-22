drop database if exists board;
create database board;
use board;

create table board(
	bno int auto_increment,
	btitle varchar(30) not null,
    bcontent varchar(300)not null,
    bwriter varchar(10)not null,
    bpwd varchar(30)not null,
    bdate datetime default now(),
    bview int default 0,
    constraint primary key(bno)
);
insert into board(bno, btitle, bcontent, bwriter, bpwd, bdate, bview) values(1, '제목입니다1', '내용입니다1', '유재석', '123', '2025-01-22', 1);
insert into board(bno, btitle, bcontent, bwriter, bpwd, bdate, bview) values(2, '제목입니다2', '내용입니다2', '강호동', '456', '2025-01-23', 2);

select * from board;

update board set btitle = '안녕하세요1', bcontent = '저도 안녕하세요' where num = 1;
