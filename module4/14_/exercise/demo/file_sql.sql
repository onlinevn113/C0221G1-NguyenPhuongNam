
create table app_user(user_id bigint not null primary key,
                      user_name varchar(36)not null unique,
                      encryted_password varchar(128) not null,
                      enabled bit not null);
create table app_role(role_id bigint not null primary key,
                      role_name varchar(30) not null unique);
create table user_role(id binary not null primary key ,
                       user_id bigint not null,
                       role_id bigint not null,
                       foreign key(user_id) references app_user(user_id),
                       foreign key(role_id) references app_role(role_id));
create table persitent_logins(username varchar(64) not null,
							  series varchar(64) not null primary key,
                              token varchar(64) not null,
                              last_used timestamp not null);
                              
                              
insert into app_user(user_id,user_name,encryted_password,enabled)
			values(2, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
                  (1, 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
insert into app_role (ROLE_ID, ROLE_NAME) values (1, 'ROLE_ADMIN');

insert into app_role (ROLE_ID, ROLE_NAME) values (2, 'ROLE_USER');

insert into user_role (ID, USER_ID, ROLE_ID) values (1, 1, 1);

insert into user_role (ID, USER_ID, ROLE_ID) values (2, 1, 2);

insert into user_role (ID, USER_ID, ROLE_ID) values (3, 2, 2);