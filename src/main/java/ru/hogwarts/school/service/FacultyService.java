package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.Collections;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;
    private final Logger logger = LoggerFactory.getLogger(FacultyService.class);

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Collection<Faculty> allFaculties(){
        logger.info("Method allFaculties was invoked");
        return facultyRepository.findAll();
    }

    public Collection<Faculty> getFacultiesByColor(String color){
        logger.info("Method getFacultiesByColor was invoked");
        return facultyRepository.findByColor(color);
    }

    public Collection<Faculty> getFacultyByNameOrColor(String nameOrColor){
        logger.info("Method getFacultiesByNameOrColor was invoked");
        return facultyRepository.findAllByNameIgnoreCaseOrColorIgnoreCase(nameOrColor, nameOrColor);
    }

    public Faculty add(Faculty faculty){
        logger.info("Method to add a facutly was invoked");
        return facultyRepository.save(faculty);
    }

    public Faculty get(Long id) {
        logger.info("Method to get a faculty by id was invoked");
        Faculty faculty = facultyRepository.findById(id).orElse(null);
        if (faculty == null){
            logger.warn("Facutly with id = " + id + " not found");
        }
        return faculty;
    }

    public Collection<Student> getStudents(Long facultyId){
        logger.info("Method getStudents was invoked");
        return facultyRepository.findById(facultyId).map(Faculty::getStudents)
                .orElseGet(Collections::emptyList);
    }

    public Faculty edit (Faculty faculty) {
        logger.info("Method to edit a faculty was invoked");
        if (get(faculty.getId()) == null){
            logger.warn("Faculty with id = " + faculty.getId() + " not found");
            return null;
        }
        return facultyRepository.save(faculty);
    }

    public void delete(Long id){
        logger.info("Method to delete a faculty was invoked");
        facultyRepository.deleteById(id);
    }

}
