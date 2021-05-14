use quanlysinhvien;
select * from student
where StudentName like "h%";
select * from class
where month(StartDate)=12;
select * from `subject`
where Credit between 3 and 5;

SET SQL_SAFE_UPDATES = 0;
update Student 
set ClassId =2
where StudentName='Hung';

select StudentName,Mark,SubName
from student
join mark on student.StudentId=mark.xStudentId
join `subject` on mark.SubId=`subject`.SubId
order by student.StudentName DESC, mark.Mark;
