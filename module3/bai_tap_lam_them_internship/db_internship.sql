drop database if exists internship;
create database if not exists internship;
use internship;
create table faculty(
faculty_id int primary key,
faculty_name char(30),
phone char(10)
);
insert into faculty
value
(1,'Toan','1234567890'),
(2,'The Duc','0987654321'),
(3,'Ngoai Ngu','5432167890')
;
create table instructor(
instructor_id int primary key,
instructor_name char(30),
salary int,
faculty_id int,
foreign key (faculty_id) references faculty(faculty_id) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into instructor
value
(1,'Nam',200,1),
(2,'Tùng',300,1),
(3,'Hieu',400,2)
;


create table student(
student_id int primary key,
student_name char(40),
faculty_id int,
foreign key (faculty_id) references faculty(faculty_id) ON DELETE CASCADE ON UPDATE CASCADE,
date_of_birth date,
place_of_birth char(30)
);

insert into student
value
(1,'Nam Nguyen1',1,'2000-1-1','Hue'),
(2,'Nam Nguyen2',2,'2000-2-1','Da Nang'),
(3,'Nam Nguyen3',3,'2000-3-1','Da Nang')
;



create table project(
project_id int primary key,
project_name char(30),
expense int,
place_of_intern char(30)
);

insert into project
value
(1,'VIP1',500,'room1'),
(2,'VIP2',100,'room2'),
(3,'VIP3',200,'room3')
;



create table instructor_student(
instructor_student_id int primary key,
student_id int ,
foreign key (student_id) references student(student_id) ON DELETE CASCADE ON UPDATE CASCADE,

project_id int ,
foreign key (project_id) references project(project_id) ON DELETE CASCADE ON UPDATE CASCADE,

instructor_id int ,
foreign key (instructor_id) references instructor(instructor_id) ON DELETE CASCADE ON UPDATE CASCADE,
grade decimal
);

insert into instructor_student
value
(1,1,1,1,9.5),
(2,2,1,3,8),
(3,1,3,2,10)
;

