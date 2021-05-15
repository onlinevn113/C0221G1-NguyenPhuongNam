use quan_ly_ban_hang;
insert into customer
value
(1,"Minh Quan",10),
(2,"Ngoc Oanh",20),
(3,"Hong Ha",50);
insert into `order`
value
(1,1,"2006-3-21",null),
(2,2,"2006-3-23",null),
(3,1,"2006-3-16",null);
insert into product
value
(1,"May Giat",3),
(2,"Tu Lanh",5),
(3,"Dieu Hoa",7),
(4,"Quat",1),
(5,"Bep Dien",2);
insert into order_detail
value
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select o_id,o_date,o_total_price
from `order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select customer.c_id ,customer.c_name,customer.c_age,`order`.o_date, product.p_name as san_pham_da_mua,product.p_price
from customer
left join `order` on customer.c_id=`order`.c_id
left join `order_detail` on `order_detail`.o_id=`order`.o_id
left join product on product.p_id=`order_detail`.p_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào  
select customer.c_id ,customer.c_name,customer.c_age,`order`.c_id as san_pham_da_mua
from customer
left join `order` on customer.c_id=`order`.c_id
where  `order`.c_id is null;


-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select o.o_id as ma_hoa_don,  o.o_date as ngay_ban, sum(od.od_qty * p.p_price) as gia_tien
from  `order` as o 
join order_detail as od on  o.o_id = od.o_id
join product as p on od.p_id = p.p_id 
group by o.o_id,  o.o_date;