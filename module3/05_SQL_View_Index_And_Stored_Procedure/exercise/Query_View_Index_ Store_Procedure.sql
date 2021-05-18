use demo;

-- Bước 3:
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
-- So sánh câu truy vấn trước và sau khi tạo index
create index productCode1 ON products(productCode); 
select * from productCode1;
explain  select * from productCode1;

create index productName1 on products(productName);
create index productPrice1 on products(productPrice);
select * from products p  where productName='Product1';
explain  select * from products p where productPrice;

-- Bước 4:
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
-- Tiến hành sửa đổi view
-- Tiến hành xoá view
create view show_products as
select productCode, productName, productPrice, productStatus
from products;
update show_products
set productStatus ='unvailable'
where productCode='P1';
select* from show_products;
select*from products;
drop view show_products;
-- Bước 5:

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create procedure show_all_infor_product()
begin
	select *
    from products;
end;
// delimiter ;
drop procedure if exists find_all_infor;
call show_all_infor_product();


-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure add_product(p_productCode varchar(45),p_productName varchar(45),p_productPrice double,p_productAmount double,p_productDescription varchar(45),p_productStatus varchar(45))
begin
	insert into products(productCode,productName,productPrice,productAmount,productDescription,productStatus)
    value(p_productCode,p_productName,p_productPrice,p_productAmount,p_productDescription,p_productStatus);
end;
// delimiter ;

drop procedure if exists add_product;
call add_product('P7','Product7',700,100,'Vip','available');


-- Tạo store procedure sửa thông tin sản phẩm theo id 
-- (không biết làm sữa thông tin chỉ sữa tên)
delimiter //
create procedure update_name_product(p_id_product int,p_name_change varchar(45))
begin
	update products p set p.productName=p_name_change where p.id=p_id_product;
end;
// delimiter ;

drop procedure if exists update_name_product;
call update_name_product(1,'Product1');

-- Tạo store procedure xoá sản phẩm theo id

delimiter //
create procedure delete_product(p_id_product int)
begin
	delete from products p where p.id=p_id_product;
end;
// delimiter ;

drop procedure if exists delete_product;
call delete_product(2);
call show_all_infor_product();