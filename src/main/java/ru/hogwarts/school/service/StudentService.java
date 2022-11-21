package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.List;

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

    public void printNamesInMultiThreads() {
        List<Student> students = (List<Student>) getAllStudents();
        new Thread(()->{
            System.out.println(students.get(2).getName());
            System.out.println(students.get(3).getName());
        }).start();

        new Thread(()->{
            System.out.println(students.get(4).getName());
            System.out.println(students.get(5).getName());
        }).start();

        System.out.println(students.get(0).getName());
        System.out.println(students.get(1).getName());
    }

    public void printNamesInMultiThreadsSync() {
        List<Student> students = (List<Student>) getAllStudents();

        printStudentName(students.get(0));
        printStudentName(students.get(1));
        Thread t1 = new Thread(()->{
            printStudentName(students.get(2));
            printStudentName(students.get(3));
        });

        Thread t2 = new Thread(()->{
            printStudentName(students.get(4));
            printStudentName(students.get(5));
        });

        t1.start();
        t2.start();
    }

        private synchronized void printStudentName(Student s){
        System.out.println(s.getName());
    }

    public void printNamesInMultiThreadsSyncVersion2() {
        List<Student> students = (List<Student>) getAllStudents();

        printStudentNameVersion2(students.get(0));
        printStudentNameVersion2(students.get(1));

        Thread t1 = new Thread(()->{
            synchronized (students) {
                printStudentNameVersion2(students.get(2));
                printStudentNameVersion2(students.get(3));
            }
        });

        Thread t2 = new Thread(()->{
            synchronized (students) {
                printStudentNameVersion2(students.get(4));
                printStudentNameVersion2(students.get(5));
            }
        });

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }

    private void printStudentNameVersion2(Student s){
        System.out.println(s.getName());
    }

    public void printNamesInMultiThreadsSyncVersion3() {
        List<Student> students = (List<Student>) getAllStudents();
        count = 0;

        printStudentNameVersion3(students);
        printStudentNameVersion3(students);
        Thread t1 = new Thread(()->{
            printStudentNameVersion3(students);
            printStudentNameVersion3(students);
        });

        Thread t2 = new Thread(()->{
            printStudentNameVersion3(students);
            printStudentNameVersion3(students);
        });

        t1.start();
        t2.start();
    }

    private int count;

    private synchronized void printStudentNameVersion3(List<Student> students){
        System.out.println(students.get(count).getName());
        count++;
    }
}
