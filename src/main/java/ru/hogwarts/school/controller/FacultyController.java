package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public Collection<Faculty> getAllFaculties(){
        return facultyService.allFaculties();
    }

    @GetMapping(params = "color")
    public Collection<Faculty> getFacultiesByColor(@RequestParam String color){
        return facultyService.getFacultiesByColor(color);
    }

    @GetMapping("/{id}")
    public Faculty getFaculty(@PathVariable long id){
        return facultyService.get(id);
    }

    @PostMapping()
    public Faculty addFaculty(@RequestBody Faculty faculty){
        return facultyService.add(faculty);
    }

    @PutMapping()
    public Faculty editFaculty(@RequestBody Faculty faculty) {
        return facultyService.edit(faculty);
    }

    @DeleteMapping("/{id}")
    public Faculty deleteFaculty(@PathVariable long id){
        return facultyService.delete(id);
    }
}
