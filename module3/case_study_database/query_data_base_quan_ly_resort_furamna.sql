use quan_ly_furama;

-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên 
-- bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select * 
from nhan_vien
where (ho_ten_nhan_vien like 'H%' or ho_ten_nhan_vien like 'T%' or ho_ten_nhan_vien like 'K%') and length(ho_ten_nhan_vien)<= 15 ;



-- 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và 
-- có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select *
from khach_hang
where (year(current_date())-year(ngay_sinh) between 18 and 50) and (dia_chi="Đà Nẵng" or dia_chi="Quảng Trị");


-- 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select  khach_hang.ho_ten,khach_hang.so_cmnd,count(hop_dong.id_hop_dong) "so_lan_dat_phong"
from khach_hang  
join hop_dong on khach_hang.id_khach_hang=hop_dong.id_khach_hang
where khach_hang.id_loai_khach = 1
group by khach_hang.id_khach_hang
order by "so_lan_dat_phong";



-- 5.Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, 
-- TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
-- (Với TongTien được tính theo công thức như sau: 
-- ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
-- cho tất cả các Khách hàng đã từng đặt phỏng. 
-- (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.id_khach_hang, kh.ho_ten, lh.ten_loai_khach, hd.id_hop_dong, dv.ten_dich_vu,
hd.ngay_lam_hop_dong, hd.ngay_ket_thuc,sum(dv.chi_phi_thue+hdct.so_luong*dvdk.gia) tong_tien
from khach_hang kh
left join loai_khach lh on kh.id_loai_khach=lh.id_loai_khach
left join hop_dong hd on kh.id_khach_hang=hd.id_khach_hang
left join dich_vu dv on hd.id_dich_vu=dv.id_dich_vu
left join hop_dong_chi_tiet hdct on hd.id_hop_dong=hdct.id_hop_dong
left join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem
group by kh.id_khach_hang,hd.id_hop_dong;



-- 6.Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ 
-- chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select dv.id_dich_vu, dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,dv.ten_dich_vu
from dich_vu dv
where dv.id_dich_vu not in (select hop_dong.id_dich_vu
						from hop_dong 
                        where (year(ngay_lam_hop_dong)=2019) and (month(ngay_lam_hop_dong) in (1,2,3))
                       );   
              
              
              
-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
-- nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
select dv.id_dich_vu, dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,dv.ten_dich_vu
from dich_vu dv
join hop_dong hd on dv.id_dich_vu=hd.id_dich_vu
where (year(hd.ngay_lam_hop_dong) = 2018)
		and hd.id_dich_vu not in (
								select hd.id_dich_vu
								from hop_dong hd
								where year(hd.ngay_lam_hop_dong)= 2019);



-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống,
--  với yêu cầu HoTenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
select distinctrow khach_hang.ho_ten
		from khach_hang;
 select distinct khach_hang.ho_ten
		from khach_hang;       
select kh.ho_ten from khach_hang kh
union 
select kh.ho_ten from khach_hang kh;
select  *
from khach_hang kh
group by kh.ho_ten;
select  *
from khach_hang kh
where kh.ho_ten in  (select distinct khach_hang.ho_ten
	   	from khach_hang );


-- 9.Thực hiện thống kê doanh thu theo tháng, 
-- nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu 
-- khách hàng thực hiện đặt phòng.
SELECT month(hd.ngay_lam_hop_dong) , sum(dv.chi_phi_thue) 'doanh_thu_'
FROM hop_dong hd 
join dich_vu dv on hd.id_dich_vu=dv.id_dich_vu
WHERE year(hd.ngay_lam_hop_dong)=2019
GROUP BY month(hd.ngay_lam_hop_dong);



-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm.
-- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, 
-- SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).
select hd.id_hop_dong,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc ,count(hdct.id_hop_dong_chi_tiet) 'so_luong_dich_vu_di_kem'
from hop_dong hd
join hop_dong_chi_tiet hdct on hd.id_hop_dong=hdct.id_hop_dong
group by hdct.id_hop_dong;



-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng
--  có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select dvdk.id_dich_vu_di_kem,ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung 
from khach_hang kh 
join hop_dong hd on kh.id_khach_hang=hd.id_khach_hang
join hop_dong_chi_tiet hdct on hd.id_hop_dong=hdct.id_hop_dong
join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem
where kh.id_loai_khach=1 and (kh.dia_chi='Vinh' or kh.dia_chi= 'Quảng Ngãi');



-- 12.Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
-- (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng
-- đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.
select hd.id_hop_dong,nv.ho_ten_nhan_vien,kh.ho_ten,kh.so_dien_thoai,dv.ten_dich_vu,sum(hdct.so_luong) 'so_luong_dich_vu_di_kem'
,hd.tien_dat_coc 'tien_dat_coc'
from hop_dong hd
join nhan_vien nv on hd.id_nhan_vien=nv.id_nhan_vien
join khach_hang kh on hd.id_khach_hang=kh.id_khach_hang
join dich_vu dv on  hd.id_dich_vu=dv.id_dich_vu
join hop_dong_chi_tiet hdct on hdct.id_hop_dong=hd.id_hop_dong
where ((year(hd.ngay_lam_hop_dong) = 2019 and month(hd.ngay_lam_hop_dong)>=10)
		and hd.id_dich_vu not in (select hd.id_dich_vu
								from hop_dong hd
								where (year(hd.ngay_lam_hop_dong)= 2019 AND month(hd.ngay_lam_hop_dong)<= 6)))
group by hdct.id_hop_dong;



-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

select  dvdk.id_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, dvdk.gia, dvdk.don_vi, dvdk.trang_thai_kha_dung, sum(hdct.so_luong)  as 'so_lan_su_dung'
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
group by dvdk.ten_dich_vu_di_kem,dvdk.id_dich_vu_di_kem
having so_lan_su_dung >= all (select  sum(hdct.so_luong) 
							from hop_dong_chi_tiet hdct
							group by hdct.id_dich_vu_di_kem
							);


-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

select  hd.id_hop_dong,dv.ten_dich_vu,dvdk.ten_dich_vu_di_kem,count(dvdk.ten_dich_vu_di_kem) 'so_lan_xuat_hien'
from dich_vu_di_kem dvdk 
join hop_dong_chi_tiet hdct on dvdk.id_dich_vu_di_kem=hdct.id_dich_vu_di_kem
join hop_dong hd on hd.id_hop_dong=hdct.id_hop_dong
join dich_vu dv on dv.id_dich_vu=hd.id_dich_vu
group by dvdk.id_dich_vu_di_kem
having  so_lan_xuat_hien = 1;


-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm
-- IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi 
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.
select nv.id_nhan_vien,nv.ho_ten_nhan_vien,td.trinh_do,bp.ten_bo_phan,nv.so_dien_thoai,nv.dia_chi
from nhan_vien nv
join bo_phan bp on nv.id_bo_phan=bp.id_bo_phan
join trinh_do td on nv.id_trinh_do=td.id_trinh_do
join hop_dong hd on nv.id_nhan_vien=hd.id_nhan_vien
group by hd.ngay_lam_hop_dong
having (year(hd.ngay_lam_hop_dong) between 2018 and 2019) and count(hd.id_nhan_vien)<=3;



-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
-- ON DELETE CASCADE
-- cách 1
delete from nhan_vien nv1
where nv1.id_nhan_vien in (
			select temp.id_nhan_vien 
			from (	select nv.id_nhan_vien
					from nhan_vien nv
					join hop_dong hd on nv.id_nhan_vien=hd.id_nhan_vien
					where not year(hd.ngay_lam_hop_dong) between 2017 and 2019
					group by nv.id_nhan_vien)  temp );

-- -- cách 2
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
update khach_hang kh
set id_loai_khach=1
where (kh.id_loai_khach =2) and (kh.id_loai_khach) in(
						select temp.id_loai_khach
						from(
							select kh.id_loai_khach
							from khach_hang kh
							left join loai_khach lh on kh.id_loai_khach=lh.id_loai_khach
							left join hop_dong hd on kh.id_khach_hang=hd.id_khach_hang
							left join dich_vu dv on hd.id_dich_vu=dv.id_dich_vu
							left join hop_dong_chi_tiet hdct on hd.id_hop_dong=hdct.id_hop_dong
							left join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem
							group by kh.id_khach_hang
							having sum(dv.chi_phi_thue+hdct.so_luong*dvdk.gia) >=10000000)temp);
			
            
-- 18.Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).

 delete from khach_hang kh
 where kh.id_khach_hang in (
				select temp.id_khach_hang
                from(
						select kh.id_khach_hang
						from khach_hang kh
						join hop_dong hd on kh.id_khach_hang=hd.id_khach_hang
						where year(hd.ngay_lam_hop_dong)<2016
						group by hd.id_khach_hang)temp );
					

-- 19.Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.

update dich_vu_di_kem dvdk
set dvdk.gia=dvdk.gia*2
where dvdk.id_dich_vu_di_kem in(
							select temp.id_dich_vu_di_kem
                            from(
							select dvdk.id_dich_vu_di_kem
							from dich_vu_di_kem dvdk 
							join hop_dong_chi_tiet hdct on dvdk.id_dich_vu_di_kem=hdct.id_dich_vu_di_kem
							join hop_dong hd on hd.id_hop_dong=hdct.id_hop_dong
							where year(hd.ngay_lam_hop_dong)=2019
							group by dvdk.id_dich_vu_di_kem
							having sum(hdct.so_luong)>=10) as temp);


-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm
-- ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
select nv.id_nhan_vien 'id', nv.ho_ten_nhan_vien 'ho_ten', nv.email'email', nv.so_dien_thoai'so_dien_thoai', nv.ngay_sinh'ngay_sinh', nv.dia_chi'dia_chi'
from nhan_vien nv
union 
select kh.id_khach_hang , kh.ho_ten, kh.email, kh.so_dien_thoai, kh.ngay_sinh,kh.dia_chi
from khach_hang kh;

select nv.id_nhan_vien, nv.ho_ten_nhan_vien, nv.email, nv.so_dien_thoai, nv.ngay_sinh, nv.dia_chi,kh.id_khach_hang , kh.ho_ten, kh.email, kh.so_dien_thoai, kh.ngay_sinh,kh.dia_chi
from nhan_vien nv,khach_hang kh;

-- 21.Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là 
-- “Hải Châu” và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”
create view v_nhanvien as(
		select nv.id_nhan_vien,nv.ho_ten_nhan_vien,nv.id_vi_tri,nv.dia_chi
		from nhan_vien nv 
		join hop_dong hd on nv.id_nhan_vien=hd.id_nhan_vien
		where (nv.dia_chi like '%Hải Châu%') and (hd.ngay_lam_hop_dong='2019/12/12')
);

-- 22.	Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.
select *
from v_nhanvien;
update  v_nhanvien
set dia_chi='Liên Chiểu'; 


-- 23.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với Id Khách hàng được truyền vào như là 1 tham số của Sp_1
delimiter //
create procedure Sp_1(p_id int)
begin
  delete from khach_hang where id_khach_hang=p_id;
end;
// delimiter ;
call Sp_1(1);
select* from khach_hang;


-- 24.	Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, 
--  với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
drop procedure Sp_2;
delimiter //
create procedure Sp_2(
p_id_hop_dong int,
p_id_nhan_vien int,
p_id_khach_hang int,
p_id_dich_vu int,
p_ngay_lam_hop_dong date,
p_ngay_ket_thuc_hop_dong date,
p_tien_dat_coc int
)
begin
	if (p_id_hop_dong not in(select id_hop_dong from hop_dong)
		and p_id_nhan_vien  in(select id_nhan_vien from nhan_vien)
		and p_id_khach_hang  in(select id_khach_hang from khach_hang)
		and p_id_dich_vu  in(select id_dich_vu from dich_vu))
		then 
		insert into hop_dong
		value(p_id_hop_dong,
		p_id_nhan_vien,
		p_id_khach_hang,
		p_id_dich_vu,
		p_ngay_lam_hop_dong,
		p_ngay_ket_thuc_hop_dong,
		p_tien_dat_coc);
		else
		SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'them that bai';
	end if;
end;
// delimiter ;

SET FOREIGN_KEY_CHECKS=1;
call Sp_2(10,1,1,1,'2020/2/2','2020/2/2',1);
select*from hop_dong;

-- 27.Tạo user function thực hiện yêu cầu sau:
-- a.Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 2.000.000 VNĐ;
DELIMITER //
CREATE FUNCTION func_1 ()
RETURNS INT
deterministic
BEGIN
   RETURN (select count(dv.id_dich_vu)
	from dich_vu dv
	where dv.id_dich_vu in(
						select hd.id_dich_vu
							from khach_hang kh
							left join loai_khach lh on kh.id_loai_khach=lh.id_loai_khach
							left join hop_dong hd on kh.id_khach_hang=hd.id_khach_hang
							left join dich_vu dv on hd.id_dich_vu=dv.id_dich_vu
							left join hop_dong_chi_tiet hdct on hd.id_hop_dong=hdct.id_hop_dong
							left join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem
							group by hd.id_dich_vu
							having sum(dv.chi_phi_thue+hdct.so_luong*dvdk.gia) >=2000000)
                            );
END; //
DELIMITER ;
select func_1();


-- b.Tạo user function Func_2: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp đồng
-- mà Khách hàng đã thực hiện thuê dịch vụ (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, 
-- không xét trên toàn bộ các lần làm hợp đồng). Mã của Khách hàng được truyền vào như là 1 tham số của function này.
DELIMITER //
CREATE FUNCTION func_2 (p_id_khach_hang int)
RETURNS INT
deterministic
BEGIN
   RETURN (
		select   max(datediff(hd.ngay_ket_thuc,hd.ngay_lam_hop_dong))
		from hop_dong hd
		where id_khach_hang=p_id_khach_hang
		group by hd.id_khach_hang
        );
END; //
DELIMITER ;
select func_2(4);

-- 28.	Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” 
-- từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong bảng DichVu) 
-- và xóa những HopDong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng HopDong) và những bản liên quan khác.

drop procedure Sp_3;
delimiter //
create procedure Sp_3(

)
begin
	
end;
// delimiter ;



select * from hop_dong
where (id_dich_vu=3) and (year(ngay_lam_hop_dong) between 2015 and 2019);