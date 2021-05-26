DROP DATABASE IF EXISTS quan_ly_furama;
CREATE DATABASE IF NOT EXISTS quan_ly_furama;
use quan_ly_furama;

-- 1.Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thõa mãn các yêu cầu bên dưới.

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
id_nhan_vien int primary key ,
ho_ten_nhan_vien varchar(45)  not null,
id_vi_tri int ,
foreign key  (id_vi_tri)references vi_tri(id_vi_tri) ON DELETE CASCADE ON UPDATE CASCADE,
id_trinh_do  int,
foreign key (id_trinh_do)references trinh_do(id_trinh_do) ON DELETE CASCADE ON UPDATE CASCADE,
id_bo_phan int,
foreign key (id_bo_phan)references bo_phan(id_bo_phan) ON DELETE CASCADE ON UPDATE CASCADE,
ngay_sinh date,
so_cmnd varchar(45) unique,
luong varchar(45),
so_dien_thoai varchar(45),
email varchar(45) unique,
dia_chi varchar(45)
);
insert into nhan_vien 
value (1,"Hùng qwertyuiopsdf ghjklz",1,1,1,"1999-06-27",201807687,4000,0774501871,"onlinevn113@gmail.com","K110/08 Nguyễn Phan Vinh"),
 (2,"Kiên",2,2,1,"1999-07-27",201807683,7000,0774501872,"onlinevn@gmail.com","K110/08 Nguyễn Vinh"),
 (3,"Tiến",2,2,3,"1999-08-22",201807682,5000,0774501873,"onlinevn1@gmail.com","K110/08 Nguyễn Vinh"),
 (4,"Nam",1,2,3,"2001-06-27",201807611,10000,0774501874,"onlinevn2@gmail.com","K110/08 Nguyễn Phan");


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
foreign key(id_loai_khach) references loai_khach(id_loai_khach) ON DELETE CASCADE ON UPDATE CASCADE, 
ho_ten varchar(45)  not null,
ngay_sinh date,
so_cmnd varchar(45),
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45)
);
insert into khach_hang
value 
(1,1,"Huy","1999-12-20",1234567890,0234567890,"qwe@gmail.com","Đà Nẵng"),
(2,1,"Huy","1999-12-20",0987654321,1234567890,"qwe@gmail.com","Quảng Ngãi"),
(3,1,"Hoàng","1990-3-21",1234561230,1234561230,"we@gmail.com","Quảng trị"),
(4,2,"Hùng","1990-2-20",1234569870,1234569870,"gwe@gmail.com","Huế");


create table if not exists kieu_thue(
id_kieu_thue int primary key,
ten_kieu_thue varchar(45),
gia int
);
insert into kieu_thue
value
(1,"Ngày",200),
(2,"Tuần",300),
(3,"Tháng",400);

create table if not exists loai_dich_vu(
id_loai_dich_vu int primary key,
ten_loai_dich_vu varchar(45)
);
insert into loai_dich_vu
value
(1,"Villa"),
(2,"House"),
(3,"Room");


create table if not exists dich_vu(
id_dich_vu int primary key,
ten_dich_vu varchar(45),
dien_tich int,
so_tang int,
so_nguoi_toi_da varchar(45),
chi_phi_thue varchar(45),
id_kieu_thue int,
foreign key(id_kieu_thue) references kieu_thue(id_kieu_thue) ON DELETE CASCADE ON UPDATE CASCADE,
id_loai_dich_vu int,
foreign key(id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu) ON DELETE CASCADE ON UPDATE CASCADE,
trang_thai varchar(45)
);
insert into dich_vu
value
 (1,"Villa",40,3,10,200,3,2,"available"),
 (2,"House",30,2,6,200,3,2,"available"),
 (3,"Room",20,0,4,100,1,2,"available"),
 (4,"Villa",40,4,14,250,3,1,"unavailable")
 ;


create table if not exists dich_vu_di_kem(
id_dich_vu_di_kem int primary key,
ten_dich_vu_di_kem varchar(45),
gia int,
don_vi varchar(45),
trang_thai_kha_dung varchar(45)
);
insert into dich_vu_di_kem
value
(1,"Massage",200,"hour","available"),
(2,"Room Service",100,"time","available"),
(3,"Spa",200,"hour","available"),
(4,"Buggy",300,"time","unavailable")
;


create table if not exists hop_dong(
id_hop_dong int primary key,
id_nhan_vien int,
foreign key(id_nhan_vien) references nhan_vien(id_nhan_vien) ON DELETE CASCADE ON UPDATE CASCADE,
id_khach_hang int,
foreign key(id_khach_hang) references khach_hang(id_khach_hang) ON DELETE CASCADE ON UPDATE CASCADE,
id_dich_vu int,
foreign key(id_dich_vu) references dich_vu(id_dich_vu) ON DELETE CASCADE  ON UPDATE CASCADE,
ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc int
);
insert into hop_dong
value
(1,1,1,1,"2021-10-12","2021-11-12",100),
(2,2,2,2,"2021-10-12","2021-11-12",100),
(3,2,3,2,"2018-10-12","2018-11-12",100),
(4,2,4,1,"2018-10-12","2018-11-12",100),
(5,2,4,1,"2018-10-12","2018-11-12",100)
;

create table if not exists hop_dong_chi_tiet(
id_hop_dong_chi_tiet int primary key,
id_hop_dong int,
foreign key(id_hop_dong) references hop_dong(id_hop_dong) ON DELETE CASCADE ON UPDATE CASCADE,
id_dich_vu_di_kem int,
foreign key(id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem) ON DELETE CASCADE ON UPDATE CASCADE,
so_luong int
);
insert into hop_dong_chi_tiet
value
(1,1,2,3),
(2,2,2,3),
(3,3,4,3),
(4,4,2,3)
;








