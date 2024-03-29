DROP DATABASE IF  EXISTS `my_database1`;
CREATE DATABASE IF NOT EXISTS `my_database1`;
use `my_database1`;

create table if not exists `Class`(
`id` int auto_increment not null primary key,
`name` varchar(45)
);
create table if not exists `student`(
`id` int auto_increment not null primary key,
`name` varchar(45) null,
`age` int null,
`country` varchar(45) null,
`email` varchar(50) unique,
`id_class` int,foreign key(`id_class`) references `Class`(id)
);

create table if not exists `Teacher`(
`id` int auto_increment not null primary key,
`name` varchar(45) null,
`age` int null,
`phone_number` varchar(10) ,
`country` varchar(45) null
);
create table if not exists test (
id int auto_increment not null primary key
);
drop table test;

insert into `Class`(`name`)
value ("VIP"),
("STANDARD");

insert into  `student`(`name`,`age`,`country`,`id_class`,`email`)
value ("Hs1",18,"VN",1,"online@gmail.com"),
("Hs2",19,"Nhật",2,"onlinevn@gmail.com"),
("Hs3",20,"Trung",1,"onlinevn113@gmail.com");
insert into `Teacher` (`name`,`age`,`phone_number`,`country`)
value ("GV1",20,1,"Trung"),
("GV2",21,0774501871,"Hàn"),
("GV3",22,0774501872,"Việt");

DELETE FROM `my_database1`.`Teacher` WHERE (`id` = '5');


DELETE FROM `my_database1`.`student` WHERE (`id` = 19) or (`id` = 20) or (`id` = 21);

delete from `my_database1`.`Teacher` where exists (select * where `Teacher`.`id`<3);
select * from `Teacher`;
select * from `Teacher` where exists (select * where `Teacher`.`id`<3);
select * from `Teacher` where `Teacher`.`id`<3;

-- thêm cột
ALTER TABLE `Teacher`
ADD `test` int; 
-- xoá cột
ALTER TABLE `Teacher`
DROP COLUMN `test`;
-- thay đổi kiểu dữ liệu của cột
ALTER TABLE `Teacher`
MODIFY COLUMN `test` varchar(100); 

-- set lai tu dong =1
ALTER TABLE `Teacher` AUTO_INCREMENT = 1;

-- -- xoá hết thuộc tính
TRUNCATE TABLE `student`;


-- -- tìm kiếm theo định dạng
SELECT `phone_number` FROM `Teacher` WHERE `phone_number` REGEXP '[0-9]{3}-[0-9]{3}-[0-9]{4}';

-- đổi tên bảng
ALTER TABLE   `oder` 
RENAME TO  `order`;


-- create procedure
delimiter //
create procedure name_(p_parameter int)
begin
-- detail
end;
// delimiter ;


-- CREATE FUNCTION
DELIMITER //
CREATE FUNCTION func_1 ()
RETURNS int
-- data_type
deterministic
BEGIN
   RETURN `data` ;
	
END; //
DELIMITER ;


-- create trigger
delimiter //
create trigger Tr_2
before update on hop_dong for each row
begin
       if (datediff(new.ngay_ket_thuc,old.ngay_lam_hop_dong)<2)
		 then SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày';
       end if;
end; //
delimiter ;


-- SET SQL_SAFE_UPDATES = 0;

update `student` set`country`="R" where`id`=3;


-- thông báo lỗi 
SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = '...';


-- kiểm tra kiểu dữ liêu của các cột
SELECT column_name,DATA_TYPE FROM INFORMATION_SCHEMA.COLUMNS 
  WHERE
  TABLE_SCHEMA = 'quan_ly_furama'
AND
  TABLE_NAME = 'hop_dong';