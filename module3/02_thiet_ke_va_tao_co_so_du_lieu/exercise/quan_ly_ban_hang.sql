drop database if exists quan_ly_ban_hang;
create database if not exists quan_ly_ban_hang;
use quan_ly_ban_hang;
create table if not exists customer(
c_id int primary key,
c_name varchar(45),
c_age int
);

create table if not exists `order`(
o_id int primary key,
c_id int,
foreign key(c_id) references customer(c_id),
o_date date,
o_total_price double
);

create table if not exists product(
p_id int primary key,
p_name varchar(45),
p_price double
);

create table if not exists order_detail(
o_id int,
foreign key (o_id) references `order`(o_id),
p_id int,
foreign key (p_id) references product(p_id),
od_QTY varchar(45)
);