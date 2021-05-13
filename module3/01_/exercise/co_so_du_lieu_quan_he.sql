DROP DATABASE IF  EXISTS `my_database1`;
CREATE DATABASE IF NOT EXISTS `my_database1`;
use `my_database1`;

-- SET SQL_SAFE_UPDATES = 0;
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



insert into `Class`(`name`)
value ("VIP"),
("STANDARD");

select* from `Class`;


insert into  `student`(`name`,`age`,`country`,`id_class`,`email`)
value ("Hs1",18,"VN",1,"online@gmail.com"),
("Hs2",19,"Nhật",2,"onlinevn@gmail.com"),
("Hs3",20,"Trung",1,"onlinevn113@gmail.com");


insert into `Teacher` (`name`,`age`,`phone_number`,`country`)
value ("GV1",20,1,"Trung"),
("GV2",21,0774501871,"Hàn"),
("GV3",22,0774501872,"Việt");

DELETE FROM `my_database1`.`Teacher` WHERE (`id` = '5');
DELETE FROM `my_database1`.`Teacher` WHERE (`id` = '6');
DELETE FROM `my_database1`.`Teacher` WHERE (`id` = '7');
DELETE FROM `my_database1`.`Teacher` WHERE (`id` = '8');

update `student` set`country`="R" where`id`=3;


DELETE FROM `my_database1`.`student` WHERE (`id` = 19) or (`id` = 20) or (`id` = 21);

delete from `my_database1`.`Teacher` where exists (select * where `Teacher`.`id`>3);

-- thêm cột
ALTER TABLE `Teacher`
ADD `test` int; 
-- xoá cột
ALTER TABLE `Teacher`
DROP COLUMN `test`;
-- thay đổi thuộc tính của cột
ALTER TABLE `Teacher`
MODIFY COLUMN `test` varchar(100); 


-- -- xoá hết thuộc tính
TRUNCATE TABLE `student`;


-- -- tìm kiếm theo định dạng
SELECT `phone_number` FROM `Teacher` WHERE `phone_number`  NOT REGEXP '[0-9]{3}-[0-9]{3}-[0-9]{4}';







