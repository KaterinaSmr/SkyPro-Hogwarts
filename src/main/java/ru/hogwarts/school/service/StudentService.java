package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Collection<Student> getAllStudents(){
        logger.info("Method getAllStudents was invoked");
        return studentRepository.findAll();
    }

    public Collection<Student> getStudentsByAge(int age){
        logger.info("Method getStudentsByAge was invoked");
        return studentRepository.findByAge(age);
    }

    public Collection<Student> getStudentsAgeBetween(int min, int max){
        logger.info("Method getStudentsAgeBetween was invoked");
        return studentRepository.findAllByAgeBetween(min,max);
    }

    public Faculty getFaculty(Long studentId){
        logger.info("Method getFaculty was invoked");
        return studentRepository.findById(studentId)
                .map(Student::getFaculty).orElse(null);
    }

    public Integer countAllStudents(){
        logger.info("Method countAllStudents was invoked");
        return studentRepository.countAllStudents();
    }

    public Student add(Student student){
        logger.info("Method for adding a student was invoked");
        return studentRepository.save(student);
    }

    public Student get(Long id){
        logger.info("Method for getting a student was invoked");
        return studentRepository.findById(id).orElse(null);
    }

    public Student edit (Student student) {
        logger.info("Method for editing a student was invoked");
        if (get(student.getId()) == null){
            logger.warn("Student with id = " + student.getId() + " not found");
            return null;
        }
        return studentRepository.save(student);
    }

    public void delete(Long id){
        logger.info("Method for student deletion was invoked");
        if (get(id) == null) {
            logger.warn("Student with id = " + id + " not found");
        }
        studentRepository.deleteById(id);
    }

    public Double getAverageAge() {
        logger.info("Method getAverageAge was invoked");
        return studentRepository.getAverageAge();
    }

    public List<Student> getLast5Students(Integer offset){
        logger.info("Method getLast5Students was invoked");
        int studentsQty = countAllStudents();
        if (studentsQty < 5){
            logger.warn("Only " + studentsQty + " exist");
        }
        return studentRepository.getLast5Students(offset);
    }

    public List<String> getStudentsNameStartsWith(Character startsWith) {
        return studentRepository.findAll().stream()
                .parallel()
                .filter(s -> s.getName().startsWith(startsWith + ""))
                .map(s -> s.getName().toUpperCase())
                .sorted()
                .collect(Collectors.toList());
    }

    public Double getAverageAgeNew() {
        return studentRepository.findAll().stream()
                .map(Student::getAge)
                .mapToDouble(age -> (double) age)
                .average().orElse(0);
    }
}
