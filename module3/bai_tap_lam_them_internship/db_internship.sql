drop database if exists internship;
create database if not exists internship;
use internship;
create table faculty(
faculty_id int primary key,
faculty_name char(30),
phone char(10)
);

create table instructor(
instructor_id int primary key,
instructor_name char(30),
salary int,
faculty_id int,
foreign key (faculty_id) references faculty(faculty_id) ON DELETE CASCADE ON UPDATE CASCADE
);

create table student(
student_id int primary key,
student_name char(40),
faculty_id int,
foreign key (faculty_id) references faculty(faculty_id) ON DELETE CASCADE ON UPDATE CASCADE,
date_of_birth date,
place_of_birth char(30)
);

create table project(
project_id int primary key,
project_name char(30),
expense int,
place_of_intern char(30)
);


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


