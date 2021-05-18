-- Bước 1: Tạo cơ sở dữ liệu demo
drop database if exists demo; 
-- Bước 2: Tạo bảng Products với các trường dữ liệu sau:
create database if not exists demo;
use demo;
create table products (
id int primary key auto_increment,
productCode  varchar(45),
productName varchar(45),
productPrice double,
productAmount double,
productDescription varchar(45),
productStatus varchar(45)
);
insert into products(productCode,productName,productPrice,productAmount,productDescription,productStatus)
value
('P1','Product1',100,500,'normal','available'),
('P2','product2',200,400,'Vip','available'),
('P3','Product3',300,300,'Vip','available'),
('P4','Product4',400,200,'Vip','unavailable'),
('P5','Product5',500,100,'normal','unavailable')
;
