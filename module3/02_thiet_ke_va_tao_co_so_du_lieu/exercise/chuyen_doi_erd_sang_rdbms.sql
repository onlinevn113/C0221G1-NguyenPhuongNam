DROP DATABASE IF EXiSTS chuyen_doi_ERD_sang_RDBMS;
CREATE DATABASE IF NOT EXISTS chuyen_doi_ERD_sang_RDBMS;
USE chuyen_doi_ERD_sang_RDBMS;


CREATE TABLE IF NOT EXISTS phieu_xuat( 
so_phieu_xuat int primary key,
ngay_xuat date
);

CREATE TABLE IF NOT EXISTS vat_tu( 
ma_vat_tu int primary key,
ten_vat_tu varchar(45)
);

CREATE TABLE IF NOT EXISTS phieu_nhap( 
so_phieu_nhap int primary key,
ngay_nhap date
);

CREATE TABLE IF NOT EXISTS chi_tiet_phieu_xuat( 
so_phieu_xuat int ,
foreign key (so_phieu_xuat) references phieu_xuat(so_phieu_xuat),
ma_vat_tu int,
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu),
primary key(so_phieu_xuat,ma_vat_tu),
don_gia_xuat int,
so_luong_xuat int
);

CREATE TABLE IF NOT EXISTS chi_tiet_phieu_nhap( 
so_phieu_nhap int ,
foreign key (so_phieu_nhap) references phieu_nhap(so_phieu_nhap),
ma_vat_tu int,
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu),
primary key(so_phieu_nhap,ma_vat_tu),
don_gia_nhap int,
so_luong_nhap int
);

CREATE TABLE IF NOT EXISTS don_hang( 
so_don_hang int primary key,
ngay_dat_hang date
);

CREATE TABLE IF NOT EXISTS chi_tiet_don_dat_hang( 
so_phieu_nhap int ,
foreign key (so_phieu_nhap) references phieu_nhap(so_phieu_nhap),
ma_vat_tu int ,
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu),
primary key(so_phieu_nhap,ma_vat_tu)
);

CREATE TABLE IF NOT EXISTS nha_cung_cap( 
ma_nha_cung_cap int primary key,
ten_nha_cung_cap varchar(45),
dia_chi varchar(45),
so_dien_thoai int(10)
);

CREATE TABLE IF NOT EXISTS cung_cap( 
so_don_hang int,
foreign key (so_don_hang) references don_hang(so_don_hang),
ma_nha_cung_cap int primary key,
foreign key (ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);
