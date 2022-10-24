package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Collection<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Collection<Student> getStudentsByAge(int age){
        return studentRepository.findByAge(age);
    }

    public Student add(Student student){
        return studentRepository.save(student);
    }

    public Student get(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student edit (Student student) {
        return studentRepository.save(student);
    }

    public void delete(Long id){
        studentRepository.deleteById(id);
    }
}
