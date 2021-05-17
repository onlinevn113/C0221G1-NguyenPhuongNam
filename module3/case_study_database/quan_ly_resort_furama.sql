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


-- -- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên 
-- -- bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
-- select * 
-- from nhan_vien
-- where (ho_ten_nhan_vien like 'H%' or ho_ten_nhan_vien like 'T%' or ho_ten_nhan_vien like 'K%') and length(ho_ten_nhan_vien)<= 15 ;

-- -- 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và 
-- -- có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
-- select *
-- from khach_hang
-- where (year(current_date())-year(ngay_sinh) between 18 and 50) and (dia_chi="Đà Nẵng" or dia_chi="Quảng Trị");

-- -- 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- -- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- -- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

-- select  khach_hang.ho_ten,khach_hang.so_cmnd,count(hop_dong.id_hop_dong) as "so_lan_dat_phong"
-- from khach_hang  
-- join hop_dong on khach_hang.id_khach_hang=hop_dong.id_khach_hang
-- where khach_hang.id_loai_khach = 1
-- group by khach_hang.id_khach_hang
-- order by "so_lan_dat_phong";

-- -- 5.Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, 
-- -- TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
-- -- (Với TongTien được tính theo công thức như sau: 
-- -- ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
-- -- cho tất cả các Khách hàng đã từng đặt phỏng. 
-- -- (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

-- select kh.id_khach_hang, kh.ho_ten, lh.ten_loai_khach, hd.id_hop_dong, dv.ten_dich_vu,
-- hd.ngay_lam_hop_dong, hd.ngay_ket_thuc,sum(dv.chi_phi_thue+hdct.so_luong*dvdk.gia) as tong_tien
-- from khach_hang kh
-- left join loai_khach lh on kh.id_loai_khach=lh.id_loai_khach
-- left join hop_dong hd on kh.id_khach_hang=hd.id_khach_hang
-- left join dich_vu dv on hd.id_dich_vu=dv.id_dich_vu
-- left join hop_dong_chi_tiet hdct on hd.id_hop_dong=hdct.id_hop_dong
-- left join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem
-- group by kh.id_khach_hang;

-- -- 6.Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ 
-- -- chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
-- select dv.id_dich_vu, dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,dv.ten_dich_vu
-- from dich_vu dv
-- where dv.id_dich_vu not in (select hop_dong.id_dich_vu
-- 						from hop_dong 
--                         where (year(ngay_lam_hop_dong)=2019) and (month(ngay_lam_hop_dong) in (1,2,3))
--                        );                     
-- -- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
-- -- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
-- -- nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
-- select dv.id_dich_vu, dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,dv.ten_dich_vu
-- from dich_vu dv
-- join hop_dong hd on dv.id_dich_vu=hd.id_dich_vu
-- where (year(hd.ngay_lam_hop_dong) = 2018)
-- 		and hd.id_dich_vu not in (select hd.id_dich_vu
-- 								from hop_dong hd
-- 								where year(hd.ngay_lam_hop_dong)= 2019);

-- -- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống,
-- --  với yêu cầu HoTenKhachHang không trùng nhau.
-- -- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
-- select distinctrow khach_hang.ho_ten
-- 		from khach_hang;
--  select distinct khach_hang.ho_ten
-- 		from khach_hang;       
-- select kh.ho_ten from khach_hang kh
-- union 
-- select kh.ho_ten from khach_hang kh;
-- select  *
-- from khach_hang kh
-- group by kh.ho_ten;
-- select  *
-- from khach_hang kh
-- where kh.ho_ten in  (select distinct khach_hang.ho_ten
-- 	   	from khach_hang );

-- -- 9.Thực hiện thống kê doanh thu theo tháng, 
-- -- nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu 
-- -- khách hàng thực hiện đặt phòng.
-- SELECT month(hd.ngay_lam_hop_dong) , sum(dv.chi_phi_thue) 'doanh_thu_'
-- FROM hop_dong hd 
-- join dich_vu dv on hd.id_dich_vu=dv.id_dich_vu
-- WHERE year(hd.ngay_lam_hop_dong)=2019
-- GROUP BY month(hd.ngay_lam_hop_dong);

-- -- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm.
-- -- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, 
-- -- SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).
-- select hd.id_hop_dong,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc ,count(hdct.id_hop_dong_chi_tiet) 'so_luong_dich_vu_di_kem'
-- from hop_dong hd
-- join hop_dong_chi_tiet hdct on hd.id_hop_dong=hdct.id_hop_dong
-- group by hdct.id_hop_dong;
-- -- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng
-- --  có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
-- select dvdk.id_dich_vu_di_kem,ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung 
-- from khach_hang kh 
-- join hop_dong hd on kh.id_khach_hang=hd.id_khach_hang
-- join hop_dong_chi_tiet hdct on hd.id_hop_dong=hdct.id_hop_dong
-- join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem
-- where kh.id_loai_khach=1 and (kh.dia_chi='Vinh' or kh.dia_chi= 'Quảng Ngãi');

-- -- 12.Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
-- -- (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng
-- -- đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.
-- select hd.id_hop_dong,nv.ho_ten_nhan_vien,kh.ho_ten,kh.so_dien_thoai,dv.ten_dich_vu,sum(hdct.so_luong) 'so_luong_dich_vu_di_kem'
-- ,hd.tien_dat_coc 'tien_dat_coc'
-- from hop_dong hd
-- join nhan_vien nv on hd.id_nhan_vien=nv.id_nhan_vien
-- join khach_hang kh on hd.id_khach_hang=kh.id_khach_hang
-- join dich_vu dv on  hd.id_dich_vu=dv.id_dich_vu
-- join hop_dong_chi_tiet hdct on hdct.id_hop_dong=hd.id_hop_dong
-- where ((year(hd.ngay_lam_hop_dong) = 2019 and month(hd.ngay_lam_hop_dong)>=10)
-- 		and hd.id_dich_vu not in (select hd.id_dich_vu
-- 								from hop_dong hd
-- 								where (year(hd.ngay_lam_hop_dong)= 2019 AND month(hd.ngay_lam_hop_dong)<= 6)))
-- group by hdct.id_hop_dong;
-- -- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- -- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
-- select max(dvdk.ten_dich_vu_di_kem) 'ten_dich_vu',dvdk.gia,count(dvdk.ten_dich_vu_di_kem) 'so_lan_su_dung'
-- from dich_vu_di_kem dvdk 
-- join hop_dong_chi_tiet hdct on dvdk.id_dich_vu_di_kem=hdct.id_dich_vu_di_kem
-- group by dvdk.ten_dich_vu_di_kem;

-- -- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- -- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

-- select hd.id_hop_dong,dv.ten_dich_vu,dvdk.ten_dich_vu_di_kem,count(dvdk.ten_dich_vu_di_kem) 'so_lan_su_dung'
-- from dich_vu_di_kem dvdk 
-- join hop_dong_chi_tiet hdct on dvdk.id_dich_vu_di_kem=hdct.id_dich_vu_di_kem
-- join hop_dong hd on hd.id_hop_dong=hdct.id_hop_dong
-- join dich_vu dv on dv.id_dich_vu=hd.id_dich_vu
-- group by dvdk.ten_dich_vu_di_kem
-- having count(dvdk.ten_dich_vu_di_kem)=1;

-- -- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm
-- -- IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi 
-- -- mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.
-- select nv.id_nhan_vien,nv.ho_ten_nhan_vien,td.trinh_do,bp.ten_bo_phan,nv.so_dien_thoai,nv.dia_chi
-- from nhan_vien nv
-- join bo_phan bp on nv.id_bo_phan=bp.id_bo_phan
-- join trinh_do td on nv.id_trinh_do=td.id_trinh_do
-- join hop_dong hd on nv.id_nhan_vien=hd.id_nhan_vien
-- group by hd.ngay_lam_hop_dong
-- having (year(hd.ngay_lam_hop_dong) between 2018 and 2019) and count(hd.id_nhan_vien)<=3;



-- -- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
-- -- ON DELETE CASCADE
-- delete from nhan_vien nv1
-- where nv1.id_nhan_vien in (
-- 			select temp.id_nhan_vien 
-- 			from (	select nv.id_nhan_vien
-- 					from nhan_vien nv
-- 					join hop_dong hd on nv.id_nhan_vien=hd.id_nhan_vien
-- 					where not year(hd.ngay_lam_hop_dong) between 2017 and 2019
-- 					group by nv.id_nhan_vien)  temp );


-- DELETE FROM nhan_vien 
-- WHERE
--     id_nhan_vien IN (SELECT 
--         id
--     FROM
--         (SELECT 
--             nv.id_nhan_vien AS id
--         FROM
--             hop_dong h
--         RIGHT JOIN nhan_vien nv ON h.id_nhan_vien = nv.id_nhan_vien
--         WHERE
--             (YEAR(h.ngay_lam_hop_dong) BETWEEN 2017 AND 2019)
--   --           OR h.ngay_lam_hop_dong IS NULL
--         GROUP BY nv.id_nhan_vien
--         HAVING COUNT(h.id_hop_dong) = 0) a);
        
        
        
-- 17.Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

-- update khach_hang kh
-- set `email`= "kjkjjk@gmail.com"
-- where kh.id_loai_khach in(select kh.id_loai_khach
-- 						from(
-- 							select kh.id_khach_hang
-- 							from khach_hang kh
-- 							left join loai_khach lh on kh.id_loai_khach=lh.id_loai_khach
-- 							left join hop_dong hd on kh.id_khach_hang=hd.id_khach_hang
-- 							left join dich_vu dv on hd.id_dich_vu=dv.id_dich_vu
-- 							left join hop_dong_chi_tiet hdct on hd.id_hop_dong=hdct.id_hop_dong
-- 							left join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem
-- 							group by kh.id_khach_hang
-- 							having sum(dv.chi_phi_thue+hdct.so_luong*dvdk.gia) >=10000000)temp);




-- 18.Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).
-- delete from khach_hang kh
-- where kh.id_khach_hang in (
-- 						
-- 							);
	select kh.id_khach_hang
							from khach_hang kh
                            join hop_dong hd on kh.id_khach_hang=hd.id_khach_hang
                            group hd.id_khach_hang
							having hd.ngay_lam_hop_dong


-- 19.Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.



-- -- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm
-- -- ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
-- select nv.id_nhan_vien,nv.ho_ten_nhan_vien,nv.email,nv.so_dien_thoai,nv.ngay_sinh,nv.dia_chi
-- from nhan_vien nv
-- union all
-- select kh.id_khach_hang,kh.ho_ten,kh.email,kh.so_dien_thoai,kh.ngay_sinh,kh.dia_chi
-- from khach_hang kh;





