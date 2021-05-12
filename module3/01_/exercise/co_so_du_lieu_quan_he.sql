create database if not exists `my_database1`;
use `my_database1`;
create table if not exists `student`(
`id` int auto_increment not null primary key,
`name` varchar(45) null,
`age` int null,
`country` varchar(45) null
);
create table if not exists `Teacher`(
`id` int auto_increment not null primary key,
`name` varchar(45) null,
`age` int null,
`country` varchar(45) null
);
create table if not exists `Class`(
`id` int auto_increment not null primary key,
`name` varchar(45) null
);

-- insert into `Class`(`name`)
-- value ("VIP");

-- insert into  `student`(`name`,`age`,`country`)
-- value ("Hs1",18,"VN"),
-- ("Hs2",19,"Nhật"),
-- ("Hs3",20,"Trung");

--  insert into `Teacher` (`name`,`age`,`country`)
-- value ("GV1",18,"VN"),
-- ("GV2",19,"Nhật"),
-- ("GV3",20,"Trung");

-- DELETE FROM `my_database1`.`Teacher` WHERE (`id` = '5');
-- DELETE FROM `my_database1`.`Teacher` WHERE (`id` = '6');
-- DELETE FROM `my_database1`.`Teacher` WHERE (`id` = '7');
-- DELETE FROM `my_database1`.`Teacher` WHERE (`id` = '8');

-- update `student`set`country`="R"where`id`=3;


DELETE FROM `my_database1`.`student` WHERE (`id` = '19') or (`id` = '20') or (`id` = '21');

delete from `my_database1`.`student` where exists (select * where `student`.`id`>1);
select * from `student`;


-- SET SQL_SAFE_UPDATES = 0;