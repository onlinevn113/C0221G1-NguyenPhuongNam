-- tạo bảng

-- 1.	Thêm mới thông tin cho tất cả các bảng 
-- có trong CSDL để có thể thõa mãn các yêu cầu bên dưới.

-- SET SQL_SAFE_UPDATES = 0;

drop database if exists  case_study_db_web2;
create database if not exists case_study_db_web2;
use case_study_db_web2 ;
CREATE TABLE 	`position` (  -- vi tri
	position_id INT AUTO_INCREMENT PRIMARY KEY,
    position_name VARCHAR(45)
);

INSERT INTO `position`(position_name)
VALUES ("bảo vệ"),
	("phục vụ"),
	("lễ tân"),
	("quản lý"),
    ("giám đốc");
 
    
CREATE TABLE education_degree( -- trinh do
	education_degree_id INT AUTO_INCREMENT PRIMARY KEY,
    education_degree_name VARCHAR(45)
);

insert into education_degree(education_degree_name)
values ("lao động phổ thông "),
("trung cấp "),
("cao đẳng"),
("đại học "),
("sau đại học ");


CREATE TABLE division( -- bo phan
	division_id INT AUTO_INCREMENT PRIMARY KEY,
    division_name VARCHAR(45)
);


insert into division(division_name)
values ("bảo an"),
	("nhân sự"),
    ("hành chính"),
    ("quản lí"),
    ("giám đốc");



create table `role`( role_id int auto_increment primary key, 
					role_name varchar(255)
                    );
                    
insert into `role` (role_name)
values ("admin"),
		("staff"),
		("manager");


create table`user`( username varchar(255) primary key,
				`password` varchar(255)
                        );
insert into `user` (username,`password`)
values ("admin",123456),
		("staff",123456),
		("manager",123456);
  
  create table user_role (role_id int ,
						 username varchar(255),
                         primary key (role_id,username),
                         foreign key (role_id) references `role`(role_id)  on delete cascade on update cascade,
                         foreign key (username) references `user`(username)  on delete cascade on update cascade
                         );
insert into	user_role()
value(1,"admin"),
		(2,"staff"),
        (3,"manager");
        
						
  
CREATE TABLE employee(  -- nhan vien
	employee_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_name VARCHAR(45) NOT NULL,
    position_id INT NOT NULL, -- id vi tri
    education_degree_id INT NOT NULL,  -- id trinh do
    division_id INT NOT NULL, --  id bo phan
    employee_birthday DATE NOT NULL, -- ngay sinh 
    employee_id_card VARCHAR(45) NOT NULL, -- so cmnd
    employee_salary DOUBLE NOT NULL, -- tien luong 
    employee_phone VARCHAR(45), -- sdt
    employee_email VARCHAR(45), -- email
    employee_address VARCHAR(45), -- dia chi
    username varchar(255),
    foreign key (username) references `user` (username)  on delete cascade on update cascade,
    FOREIGN KEY (position_id) REFERENCES `position`(position_id)  on delete cascade on update cascade,
    FOREIGN KEY (education_degree_id) REFERENCES education_degree(education_degree_id)  on delete cascade on update cascade,
    FOREIGN KEY (division_id) REFERENCES division(division_id)  on delete cascade on update cascade
);

insert into employee(  employee_name,
						position_id,
						education_degree_id,
						division_id,
						employee_birthday,
						employee_id_card,
						employee_salary,
						employee_phone,
						employee_email,
						employee_address,
                       username )
values ("Duong Thanh Hau",1,1,1,"1997-02-24","194571756",15000000,"0399191054","thanhhau026@gmail.com","quang binh","admin"),
 ("Nguyen Phuong Nam",2,2,2,"1999-12-12","123456789",10000000,"0333313033","nam11@gmail.com","Da Nang","staff"),
("Dao Thao",3,3,3,"1993-12-12","123456789",10000000,"03932323223","thao22@gmail.com","quang binh","manager"),
("Le Phuoc Sy Phu",4,4,4,"1995-12-12","123400789",15000000,"03932323220","phule@gmail.com","Quang Tri","staff"),
("Nguyen Van cuong",5,5,5,"1997-12-12","10010000100",10000000,"03932323211","thao22@gmail.com","quang binh","admin");

update employee
set employee_name="Name",position_id=2,education_degree_id=1,division_id=1,employee_birthday="1999--06-27",employee_id_card="194571756",employee_salary=15000000,
employee_phone="0399191054",employee_email="thanhhau026@gmail.com",	employee_address="Da Nang",username="admin"
where employee_id=2;

CREATE TABLE customer_type(  
	customer_type_id INT AUTO_INCREMENT PRIMARY KEY, 
    customer_type_name VARCHAR(45) 
);


insert into customer_type(customer_type_name)
values ("Diamond"),
	("Platinium"),
	("Gold"),
	("Silver"),
    ("Member");
    
    
    
    
CREATE TABLE customer( -- khach hang
	customer_id INT AUTO_INCREMENT PRIMARY KEY, -- id khach hang 
    customer_type_id INT NOT NULL, -- id loai khach hang
    customer_name VARCHAR(45) NOT NULL, -- ten khach hang
    customer_birthday DATE NOT NULL, -- ngay sinh cua khach hang
    customer_id_card VARCHAR(45)  NOT NULL, -- so cmnd cua khach hang
    customer_phone VARCHAR(45)  NOT NULL, -- sdt cua khach hang
    customer_email VARCHAR(45), -- email khach hang
    customer_address VARCHAR(45), -- dia chi khach hang
    customer_gender bit(1)  NOT NULL, -- gioi tinh khach hang
    FOREIGN KEY (customer_type_id) REFERENCES customer_type(customer_type_id)   on delete cascade on update cascade
);



insert into customer(customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email, customer_address)
values (1,"Tran Van Nam","1999-11-11",1,"12345678","12345678","vannam@gmail.com","hue");
    
insert into customer(customer_type_id,customer_name,customer_birthday,customer_id_card,customer_phone,customer_email,customer_address,customer_gender)
values (1,"Tran Van Nam","1999-11-11","1234","12345678","vannam@gmail.com","hue",1),
		(2,"Nguyen Thi Binh","1990-02-02","1235","87654321","thibinh@gmail.com","da nang",1),
		(3,"Dao Ngoc Anh","1990-02-02","123000005","87654321","ngocanh@gmail.com","da nang",0),
		(4,"Tran Van Long","1991-02-02","123000005","87654321", "vanlong@gmail.com","quang ngai",1),
		(5,"Nguyen ANh Tuan","1990-02-02","123000005","87654321","anhtuan@gmail.com","Ha Noi",0),
		(5,"Nguyen ANh Tuan","1990-02-02","123000005","87654321","anhtuan@gmail.com","Ha Noi",1),
		(5,"Nguyen ANh Tuan","1990-02-02","123000005","87654321","anhtuan@gmail.com","Ha Noi",0),
		(5,"Nguyen ANh Tuan","1990-02-02","123000005","87654321","anhtuan@gmail.com","Ha Noi",1);
        
        

        
CREATE TABLE service_type( -- loai dich vu
	service_type_id INT AUTO_INCREMENT PRIMARY KEY,  -- id loai dich vu
    service_type_name VARCHAR(45)  -- ten loai dich vu
);

insert into service_type(service_type_name)
values  ("room"),
		("house"),
		("villa"),
		("room vp"),
		("villa vp");
    





-- ----------------------------------------------------------------------------------------------------

CREATE TABLE rent_type(
	rent_type_id INT AUTO_INCREMENT  PRIMARY KEY, -- id kieu thue
    rent_type_name VARCHAR(45),  -- ten kieu thue
    rent_type_cost INT
    );

insert into rent_type(rent_type_name,rent_type_cost)
values ("6h",500000),
	("12h",200000),
	("24h",400000),
	("48h",800000),
	("72h",3000000);
    
    

CREATE TABLE service(  -- dich vu
	service_id INT AUTO_INCREMENT PRIMARY KEY,  -- id dich vu
    service_name VARCHAR(45) NOT NULL, -- ten dich vu
    service_area INT, -- dien tich
    service_cost int NOT NULL, -- gia dich vu
    service_max_people int,  -- so nguoi toi da
	rent_type_id INT ,  -- id kieu thue
	service_type_id INT , -- id loai dich vu
    standrad_room varchar(45), -- tieu chuan phong
    description_other_convenience varchar(45),  -- trang thai
    pool_area int, -- dien tich ho boi
    number_of_floors int , -- so tang
     FOREIGN KEY (rent_type_id) REFERENCES rent_type(rent_type_id)  on delete cascade on update cascade,
     FOREIGN KEY (service_type_id) REFERENCES service_type(service_type_id)  on delete cascade on update cascade
     
     
     
);
/*
insert into service(service_id,
					service_name,
                    service_area,
                    service_cost,
                    service_max_people,
                    rent_type_id,
                    service_type_id,
                    standrad_room,
                    description_other_convenience,
                    pool_area,
                    number_of_floors)
                    
values ("house",20,2,3,1,1,"ok","close",50,3),
	   ("villa1",25,3,3,2,2,"ok","open",60,2),
	   ("villa2",26,3,3,2,2,"ok","open",60,4),
	   ("villa3",27,3,3,2,2,"ok","open",60,2),
	   ("villa5",28,3,3,2,2,"ok","open",55,4);


*/

CREATE TABLE  contract(  -- hop dong
	contract_id INT AUTO_INCREMENT PRIMARY KEY,  -- id hop dong
    employee_id INT NOT NULL, -- id nhan vien
    customer_id INT NOT NULL,   -- id khach hang
    service_id INT NOT NULL,  -- id dich vu
    contract_start_date DATE NOT NULL, -- ngay lam hop dong
    contract_end_date DATE NOT NULL, -- ngay ket thuc hop dong
    contract_deposit INT NOT NULL, -- tien dat coc
    contract_total INT NOT NULL, -- tong tien 
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)      on delete cascade on update cascade ,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)      on delete cascade on update cascade ,    
    FOREIGN KEY (service_id) REFERENCES service(service_id) on delete cascade on update cascade 
);
/*
insert into Contract (employee_id,customer_id,service_id,contract_start_date,contract_end_date,contract_deposit,contract_total)
values  (1,1,1,"2018-08-11","2019-10-10",5000,10000),
		(2,2,2,"2016-11-11","2017-11-11",3000,2000),
		(3,3,3,"2021-10-11","2021-11-11",5000,1000),
		(4,4,4,"2020-11-11","2022-11-11",15000,5000),
		(5,5,5,"2020-11-11","2021-11-11",6000,3000);

*/


 CREATE TABLE attach_service(  -- dich vu di kem
		attach_service_id INT AUTO_INCREMENT PRIMARY KEY, -- id dich vu di kem
        attach_service_name VARCHAR(45) NOT NULL,  -- ten dich vu di kem
        attach_service_cost INT NOT NULL, -- gia dich vu di kem
        attach_service_until INT NOT NULL, -- don vi
        attach_service_status VARCHAR(45)  -- trang thai
    );
    
    insert into attach_service(attach_service_name,
								attach_service_cost,
								attach_service_until,
								attach_service_status)
	values ("taxi",1000,5,"hop li"),
			("karaoke",1500,7,"hop li"),
			("cafe",2000,10,"dep"),
			("pizza",1200,10,"ngon"),
			("pizza vp",1700,10,"ngon");
    
    
    







    

CREATE TABLE contract_detail(  -- hop dong chi tiet 
	contract_detail_id INT AUTO_INCREMENT PRIMARY KEY,  -- id hop dong chi tiet
    contract_id INT ,  -- id hop dong 
    attach_service_id INT ,  -- id dich vu di kem
    quantity INT NOT NULL,  -- so luong
    FOREIGN KEY (contract_id) REFERENCES contract(contract_id)  on delete cascade on update cascade,
    FOREIGN KEY (attach_service_id) REFERENCES attach_service(attach_service_id)  on delete cascade on update cascade
    );
    
    
    /*
 insert into ContractDetail(contract_id,attach_service_id,quantity)
 values (1,1,5),
 	(2,2,3),
 	(3,3,7),
 	(4,4,5),
 	(5,5,9);

*/


--     use case_study_db; 
--     drop database case_study_db;
--     delete from case_study_db;

    
