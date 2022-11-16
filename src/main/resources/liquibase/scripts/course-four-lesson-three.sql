-- liquibase formatted sql

-- changeset egorbacheva:1
CREATE INDEX student_name_index ON student(name);

-- changeset egorbacheva:2
CREATE INDEX faculty_name_color_index on faculty(name, color);
