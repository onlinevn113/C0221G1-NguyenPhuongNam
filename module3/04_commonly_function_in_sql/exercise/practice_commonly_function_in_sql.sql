USE QuanLySinhVien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select *
from `subject` s
where s.credit =(select max(s.credit)
					from `subject` s
                  );

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select *
from `subject` s
join mark m on s.SubId=m.SubId
where m.Mark in(select max(m.Mark)
				from mark m
                );
-- Hiển thị các thông tin sinh viên và điểm trung bình 
-- của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần

select s.StudentId,s.StudentName,s.Address,s.Phone,s.Status,s.ClassId,avg(m.Mark)
from student s
left join mark m on s.StudentId=m.StudentId
group by s.StudentId
order by m.Mark desc;

