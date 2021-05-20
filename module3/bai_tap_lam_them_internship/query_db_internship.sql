use internship;
-- Phần 1
-- 1. Đưa ra thông tin gồm mã số, họ tên và tên khoa của tất cả các giảng viên
select instructor_id,instructor_name,faculty_name
from instructor i
join faculty f on i.faculty_id=f.faculty_id
;

-- 2.Đưa ra thông tin gồm mã số, họ tên và tên khoa của các giảng viên của khoa ‘DIA LY va QLTN’
select instructor_id,instructor_name,faculty_name
from instructor i
join faculty f on i.faculty_id=f.faculty_id
where faculty_name='DIA LY' or faculty_name='QLTN'
;


-- 3.	Cho biết số sinh viên của khoa ‘CONG NGHE SINH HOC’
select count(student_id) 'số sinh viên của khoa ‘CONG NGHE SINH HOC’'
from student s
join faculty f on s.faculty_id= f.faculty_id
where faculty_name='CONG NGHE SINH HOC'
group by s.faculty_id;

-- 4.	Đưa ra danh sách gồm mã số, họ tên và tuổi của các sinh viên khoa ‘TOAN’
select student_id, student_name, datediff(now(),date_of_birth) age
from student s
join faculty f on s.faculty_id= f.faculty_id
where faculty_name = 'TOAN';

-- 5.	Cho biết số giảng viên của khoa ‘CONG NGHE SINH HOC’
select count(instructor_id) 'số giảng viên của khoa ‘CONG NGHE SINH HOC'
from instructor t
join faculty f on t.faculty_id=f.faculty_id
where faculty_name='CONG NGHE SINH HOC'
group by t.faculty_id;

-- 6.	Cho biết thông tin về sinh viên không tham gia thực tập
select s.student_id,student_name,faculty_id,date_of_birth,place_of_birth 
from student s
left join instructor_student its on s.student_id=its.student_id
where instructor_student_id is null;
-- 7.	Đưa ra mã khoa, tên khoa và số giảng viên của mỗi khoa
select f.faculty_id,faculty_name, sum(instructor_id) 'số giảng viên của mỗi khoa' 
from faculty f
join instructor i on i.faculty_id=f.faculty_id
group by f.faculty_id;
-- 8.	Cho biết số điện thoại của khoa mà sinh viên có tên ‘Le van son’ đang theo học
select phone 
from faculty f
join student s on s.faculty_id=f.faculty_id
where student_name='Le van son';

-- Phần 2
-- 1.	Cho biết mã số và tên của các đề tài do giảng viên ‘Tran son’ hướng dẫn
select p.project_id,project_name
from project p
join instructor_student its on p.project_id=its.project_id
join instructor i on its.instructor_id=i.instructor_id
where instructor_name='Tran son' ;
-- 2.	Cho biết tên đề tài không có sinh viên nào thực tập
select project_name
from project p
left join instructor_student its on p.project_id=its.project_id
where student_id is null;
-- 3.	Cho biết mã số, họ tên, tên khoa của các giảng viên hướng dẫn từ 3 sinh viên trở lên.
select i.instructor_id,instructor_name,faculty_name
from instructor i
join faculty f on i.faculty_id=f.faculty_id
join instructor_student its on i.instructor_id=its.instructor_id
group by its.instructor_id
having count(its.student_id)>3;

-- 4. Cho biết mã số, tên đề tài của đề tài có kinh phí cao nhất
select project_id,project_name
from project
group by project_id
having max(expense);

-- 5.Cho biết mã số và tên các đề tài có nhiều hơn 2 sinh viên tham gia thực tập
select p.project_id, project_name
from project p
join instructor_student its on p.project_id=its.project_id
group by p.project_id
having count(student_id)>2;

-- 6.Đưa ra mã số, họ tên và điểm của các sinh viên khoa ‘DIALY và QLTN’

select s.student_id, student_name, grade
from student s
join instructor_student its on s.student_id=its.student_id
join faculty f on f.faculty_id=s.faculty_id
where faculty_name='DIALY' or faculty_name='QLTN';

-- 7.Đưa ra tên khoa, số lượng sinh viên của mỗi khoa
select faculty_name,count(s.student_id)
from faculty f
join student s on f.faculty_id=s.faculty_id
group by s.faculty_id;

-- 8.Cho biết thông tin về các sinh viên thực tập tại quê nhà
select s.student_id,student_name,faculty_id,date_of_birth,place_of_birth
from student s
join instructor_student its on s.student_id=its.student_id
join project p on its.project_id = p.project_id
where place_of_birth = place_of_intern;

-- 9.Hãy cho biết thông tin về những sinh viên chưa có điểm thực tập

select s.student_id,student_name,faculty_id,date_of_birth,place_of_birth 
from student s
left join instructor_student its on its.student_id=s.student_id
where grade is null;

-- 10.Đưa ra danh sách gồm mã số, họ tên các sinh viên có điểm thực tập bằng 0

select s.student_id,student_name
from student s
join instructor_student its on its.student_id=s.student_id
where grade =0
group by s.student_id
;
