drop database if exists mydb0123;
create database mydb0123;
use mydb0123;

create table parking(         
   cno int auto_increment ,        
    carNum varchar(20) ,              
    carLo int,             
    inCar datetime default now() ,            
    outCar datetime default now(),            
    state boolean default true ,
    primary key( cno )             
);
insert into parking(carNum,carLo,outCar) values("143구1234",1,null); 
select * from parking;


 
 	
# DML : insert , select , update , delete 
#(1) 입차
insert into parking(carNum,carLo,outCar) values("143구1234",1,null); 
#(2) 출차(수정)
update parking set state = false , outCar = "2025-01-22 17:51:33" where cno = 3;
-- update parking set state = false , outCar = ? where cno = ?;
#(3) 주차내역 전체 조회
select * from parking;
#(4) 주차내역 개별 삭제 
delete from parking where cno = 3;