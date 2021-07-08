use a_casestudy4;
insert into app_user(user_id,user_name,encryted_password,enabled)
			values(2, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
                  (1, 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
insert into app_role (ROLE_ID, ROLE_NAME) values (1, 'ROLE_ADMIN');

insert into app_role (ROLE_ID, ROLE_NAME) values (2, 'ROLE_USER');

insert into user_role (ID, USER_ID, ROLE_ID) values (1, 1, 1);

insert into user_role (ID, USER_ID, ROLE_ID) values (2, 1, 2);

insert into user_role (ID, USER_ID, ROLE_ID) values (3, 2, 2);
-- customer type
INSERT INTO `a_casestudy4`.`customer_type` (`name`) VALUES ('Diamond');
INSERT INTO `a_casestudy4`.`customer_type` (`name`) VALUES ('Gold');
INSERT INTO `a_casestudy4`.`customer_type` (`name`) VALUES ('Silver');
INSERT INTO `a_casestudy4`.`customer_type` (`name`) VALUES ('Bronze');
-- service type
INSERT INTO `a_casestudy4`.`service_type` (`id`, `name`) VALUES ('1', 'Villa');
INSERT INTO `a_casestudy4`.`service_type` (`id`, `name`) VALUES ('2', 'House');
INSERT INTO `a_casestudy4`.`service_type` (`id`, `name`) VALUES ('3', 'Room');
-- rent type
INSERT INTO `a_casestudy4`.`rent_type` (`name`) VALUES ('Year');
INSERT INTO `a_casestudy4`.`rent_type` (`name`) VALUES ('Month');
INSERT INTO `a_casestudy4`.`rent_type` (`name`) VALUES ('Day');
INSERT INTO `a_casestudy4`.`rent_type` (`name`) VALUES ('12H');
-- position
INSERT INTO `a_casestudy4`.`position` (`name`) VALUES ('Director');
INSERT INTO `a_casestudy4`.`position` (`name`) VALUES ('Manager');
INSERT INTO `a_casestudy4`.`position` (`name`) VALUES ('Supervisor');
INSERT INTO `a_casestudy4`.`position` (`name`) VALUES ('Staff');
-- division
INSERT INTO `a_casestudy4`.`division` (`name`) VALUES ('HK');
INSERT INTO `a_casestudy4`.`division` (`name`) VALUES ('FO');
INSERT INTO `a_casestudy4`.`division` (`name`) VALUES ('FB');
-- education
INSERT INTO `a_casestudy4`.`education_degree` (`name`) VALUES ('University');
INSERT INTO `a_casestudy4`.`education_degree` (`name`) VALUES ('College');
INSERT INTO `a_casestudy4`.`education_degree` (`name`) VALUES ('None');
-- attachservice
INSERT INTO `a_casestudy4`.`attach_service` (`cost`, `name`, `status`, `unit`) VALUES ('100', 'Massage', 'Available', '1');
INSERT INTO `a_casestudy4`.`attach_service` (`cost`, `name`, `status`, `unit`) VALUES ('200', 'Chicken 50Kg', 'UnAvailable', '1');
INSERT INTO `a_casestudy4`.`attach_service` (`cost`, `name`, `status`, `unit`) VALUES ('300', 'Sauna', 'Available', '1');
-- employee
INSERT INTO `a_casestudy4`.`employee` (`address`, `birthday`, `email`, `flag`, `id_card`, `name`, `phone`, `salary`, `division_id`, `education_degree_id`, `position_id`) VALUES ('K110/08 Nguyễn Phan', '2021-07-09', 'onlinevn213@gmail.com', 0, 234567891, 'Nam Nguyễn', 0774501872, 1000, 1, 1, 1);
-- customer
INSERT INTO `a_casestudy4`.`customer` (`address`, `birthday`, `code`, `email`, `flag`, `gender`, `id_card`, `name`, `phone`, `customer_type_id`) VALUES ('K110/08 Nguyễn Phan Vinh', '2021-07-15', 'KH-1000', 'onlinevn113@gmail.com', 0, '1', '123456789', 'Nguyễn Phương Nam', '0774501871', '1');
-- service
INSERT INTO `a_casestudy4`.`service` (`area`, `code`, `cost`, `description`, `flag`, `floors`, `max_people`, `name`, `pool_area`, `standard_room`, `rent_type_id`, `service_type_id`) VALUES ('100', 'DV-1000', '100', 'OK', 0, '10', '10', 'Villa1', '20', 'Deluxe', '1', '1');



-- select ct.id,start_date,end_date,deposit,total_money,customer_id,employee_id,service_id,ct.flag
-- from contract ct 
-- join customer c on ct.customer_id=c.id
-- where c.name like '%%' and ct.flag=0
-- order by ct.id desc;



-- select * from contract;


