package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private Map<Long, Student> students = new HashMap<>();
    private Long nextId = 0l;

    public Collection<Student> getAllStudents(){
        return students.values();
    }

    public Collection<Student> getStudentsByAge(int age){
        return students.values().stream().filter(s -> s.getAge() == age).collect(Collectors.toSet());
    }

    public Student add(Student student){
        student.setId(++nextId);
        students.put(student.getId(), student);
        return student;
    }

    public Student get(Long id){
        return students.get(id);
    }

    public Student edit (Student student) {
        students.put(student.getId(), student);
        return student;
    }

    public Student delete(Long id){
        return students.remove(id);
    }
}
