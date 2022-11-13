--Составить первый JOIN-запрос, чтобы получить информацию обо всех студентах (достаточно получить
-- только имя и возраст студента) школы Хогвартс вместе с названиями факультетов.
select student.name, age, faculty.name from student left join faculty on student.faculty_id = faculty.id;

--Составить второй JOIN-запрос, чтобы получить только тех студентов, у которых есть аватарки.
select student.* from student inner join avatar on student.id = avatar.student_id;
select student.* from student left join avatar on student.id = avatar.student_id;