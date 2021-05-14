DROP DATABASE IF EXISTS quan_ly_furama;
CREATE DATABASE IF NOT EXISTS quan_ly_furama;
use quan_ly_furama;

create table if not exists vi_tri(
id_vi_tri int primary key,
ten_vi_tri varchar(45)
);
insert into vi_tri
value(1,"lễ tân"),
(2,"phục vụ"),
(3,"chuyên viên"),
(4,"giám sát"),
(5,"quản lý"),
(6,"giám đốc");


create table if not exists trinh_do(
id_trinh_do int primary key,
trinh_do varchar(45)
);
insert into trinh_do
value(1,"Trung cấp"),
(2,"Cao đẳng"),
(3,"Đại học"),
(4,"Sau đại học");


create table if not exists bo_phan(
id_bo_phan int primary key,
ten_bo_phan varchar(45)
);
insert into bo_phan
value(1,"Sale – Marketing"),
(2,"Hành Chính"),
(3,"Phục vụ"),
(4,"Quản lý");


create table if not exists nhan_vien(
id_nhan_vien int primary key,
ho_ten_nhan_vien varchar(45)  not null,
id_vi_tri int ,
foreign key  (id_vi_tri)references vi_tri(id_vi_tri),
id_trinh_do  int,
foreign key (id_trinh_do)references trinh_do(id_trinh_do),
id_bo_phan int,
foreign key (id_bo_phan)references bo_phan(id_bo_phan),
ngay_sinh date,
so_cmnd varchar(45) unique,
luong varchar(45),
so_dien_thoai varchar(45),
email varchar(45) unique,
dia_chi varchar(45)
);
insert into nhan_vien 
value (1,"Nguyễn Phương Nam",1,1,1,"1999-06-27",201807687,1000,0774501871,"onlinevn113@gmail.com","K110/08 Nguyễn Phan Vinh"),
      (2,"Nguyễn Nam",3,3,3,"2000-06-27",201807610,1000,0774501872,"onlinevn@gmail.com","K110/08 Nguyễn Phan Vinh");


create table if not exists loai_khach(
id_loai_khach int primary key,
ten_loai_khach varchar(45)
);
insert into loai_khach
value(1,"Diamond"),
(2,"Platinium"),
(3,"Gold"),
(4,"Silver"),
(5,"Member");


create table if not exists khach_hang(
id_khach_hang int primary key,
id_loai_khach int,
foreign key(id_loai_khach) references loai_khach(id_loai_khach),
ho_ten varchar(45)  not null,
ngay_sinh date,
so_cmnd varchar(45) unique,
so_dien_thoai varchar(45),
email varchar(45) unique,
dia_chi varchar(45)
);
insert into khach_hang
value (1,3,"Nguyễn Phương Na","1999-06-27",211827890,0774501871,"onlinevn1111@gmail.com","K110/08 Nguyễn Phan Vinh"),
     (2,3,"Nguyễn Nam","2000-06-27",221807610,0774501872,"onlinevn1@gmail.com","K110/08 Nguyễn Phan Vinh"),
     (2,3,"Nguyễn ","2000-06-27",221807610,0774501872,"onlinevn1@gmail.com","K110/08 Nguyễn Phan Vinh");


create table if not exists kieu_thue(
id_kieu_thue int primary key,
ten_kieu_thue varchar(45),
gia int
);
-- insert into kieu_thue
-- value();


create table if not exists loai_dich_vu(
id_loai_dich_vu int primary key,
ten_loai_dich_vu varchar(45)
);
-- insert into loai_dich_vu
-- value(),


create table if not exists dich_vu(
id_dich_vu int primary key,
ten_dich_vu varchar(45),
dien_tich int,
so_tang int,
so_nguoi_toi_da varchar(45),
chi_phi_thue varchar(45),
id_kieu_thue int,
foreign key(id_kieu_thue) references kieu_thue(id_kieu_thue),
id_loai_dich_vu int,
foreign key(id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu),
trang_thai varchar(45)
);
-- insert into dich_vu
-- value ();


create table if not exists dich_vu_di_kem(
id_dich_vu_di_kem int primary key,
ten_dich_vu_di_kem varchar(45),
gia int,
don_vi int,
trang_thai_kha_dung varchar(45)
);
-- insert into dich_vu_di_kem
-- value();


create table if not exists hop_dong(
id_hop_dong int primary key,

id_nhan_vien int,
foreign key(id_nhan_vien) references nhan_vien(id_nhan_vien),

id_khach_hang int,
foreign key(id_khach_hang) references khach_hang(id_khach_hang),

id_dich_vu int,
foreign key(id_dich_vu) references dich_vu(id_dich_vu),

ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc int,
tong_tieng int
);
-- insert into hop_dong
-- value();


create table if not exists hop_dong_chi_tiet(
id_hop_dong_chi_tiet int primary key,

id_hop_dong int,
foreign key(id_hop_dong) references hop_dong(id_hop_dong),

id_dich_vu_di_kem int,
foreign key(id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem),

so_luong int
);
-- insert into hop_dong_chi_tiet
-- value();

