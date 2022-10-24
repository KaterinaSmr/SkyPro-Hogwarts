package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private Map <Long, Faculty> faculties = new HashMap<>();
    private Long nextId = 0l;

    public Collection<Faculty> allFaculties(){
        return faculties.values();
    }

    public Collection<Faculty> getFacultiesByColor(String color){
        return faculties.values().stream().filter(f -> f.getColor().equals(color)).collect(Collectors.toSet());
    }

    public Faculty add(Faculty faculty){
        faculty.setId(++nextId);
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty get(Long id) {
        return faculties.get(id);
    }

    public Faculty edit (Faculty faculty) {
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty delete(Long id){
        return faculties.remove(id);
    }
}
