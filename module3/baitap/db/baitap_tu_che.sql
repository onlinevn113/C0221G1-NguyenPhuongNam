drop database if exists school;
create database school;
use school;

create table students(
	id int auto_increment primary key,
    s_name varchar(45),
    gender bit(1),
    birthday date,
    email varchar(45),
    address varchar(45)

);
drop table test;
create table test(
	id int auto_increment primary key,
    s_name varchar(45),
    gender bit(1),
    birthday date,
    email varchar(45),
    address varchar(45)

);







INSERT INTO `school`.`students` ( `s_name`, gender, birthday, `email`, `address`) VALUES ('Ha', 0, '2005-10-10', 'ha1@gmail.com', 'Ha noi');
INSERT INTO `school`.`students` ( `s_name`, gender, birthday, `email`, `address`) VALUES ('Nam', 0, '2006-10-10', 'ha2@gmail.com', 'Đà Nẵng');
INSERT INTO `school`.`students` ( `s_name`, gender, birthday, `email`, `address`) VALUES ('Tin', 0, '2007-10-10', 'ha3@gmail.com', 'Đà Nẵng');
INSERT INTO `school`.`students` ( `s_name`, gender, birthday, `email`, `address`) VALUES ('Toan', 0, '2008-10-10', '2ha@gmail.com', 'Đà Nẵng');
INSERT INTO `school`.`students` ( `s_name`, gender, birthday, `email`, `address`) VALUES ('Hau', 0, '2009-10-10', 'ha3@gmail.com', 'Đà Nẵng');
INSERT INTO `school`.`students` ( `s_name`, gender, birthday, `email`, `address`) VALUES ('Khanh', 0, '2001-10-10', 'h2a@gmail.com', 'Đà Nẵng');

UPDATE `school`.`students` 
SET `s_name` = 'Lai', `gender`=1,`birthday`='2000-12-10', `email` = 'lai@gmail.com', `address` = 'Da Nang' WHERE (`id` = '1');

-- UPDATE `school`.`students` 
-- SET `s_name` = ?, `gender`=?,`birthday`=?, `email` = ?, `address` = ? WHERE (`id` = ?);

select * from students;