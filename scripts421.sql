--Возраст студента не может быть меньше 16 лет.
alter table student add constraint age_check check (age >= 16);

--Имена студентов должны быть уникальными и не равны нулю.
alter table student add constraint name_check unique (name);
alter table student alter column name set not null ;

--При создании студента без возраста ему автоматически должно присваиваться 20 лет.
alter table student alter age set default 20;

--Пара “значение названия” - “цвет факультета” должна быть уникальной.
alter table faculty add constraint color_name_unique unique (color, name);