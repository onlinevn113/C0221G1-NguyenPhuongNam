use a_casestudy4;
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
-- customer
INSERT INTO `a_casestudy4`.`customer` (`address`, `birthday`, `code`, `email`, `flag`, `gender`, `id_card`, `name`, `phone`, `customer_type_id`) VALUES ('K100', '1999-06-27', '1', 'onlinevn113', '0', '1', '201807687', 'Nguyễn Phương Nam', '0774501871', '1');
-- employee
INSERT INTO `a_casestudy4`.`employee` (`address`, `birthday`, `email`, `flag`, `id_card`, `name`, `phone`, `salary`, `division_id`, `education_degree_id`, `position_id`) VALUES ('K110/08 Nguyễn Phan Vinh', '2021-07-15', 'onlinev3@gmail.com', '0', '123456789', 'Nguyễn Phương', '0774501971', '4000000', '1', '1', '1');
-- service
INSERT INTO `a_casestudy4`.`service` (`area`, `code`, `cost`, `description`, `flag`, `floors`, `max_people`, `name`, `pool_area`, `standard_room`, `rent_type_id`, `service_type_id`) VALUES ('20', '1', '100', 'Vip', '0', '5', '20', 'House1', '10', 'Deluxe', '1', '1');

