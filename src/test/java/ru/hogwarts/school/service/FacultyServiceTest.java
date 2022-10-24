package ru.hogwarts.school.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Faculty;

import java.net.CookieHandler;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FacultyServiceTest {
    /*
    private FacultyService facultyService;

    @BeforeEach
    void setUp() {
        facultyService = new FacultyService();
        facultyService.add(new Faculty(1l, "Gryffindor", "red"));
    }

    @Test
    void shouldReturnCollectionOfFacultiesWhenAllFacultiesCalled() {
        HashSet<Faculty> expected = new HashSet<>();
        expected.add(new Faculty(1l, "Gryffindor", "red"));

        Set<Faculty> actual = new HashSet<>(facultyService.allFaculties());
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFacutiesByColor() {
        HashSet<Faculty> expected = new HashSet<>();
        expected.add(new Faculty(2l, "Slytherin", "green"));

        facultyService.add(new Faculty(2l, "Slytherin", "green"));
        HashSet<Faculty> actual = new HashSet<>(facultyService.getFacultiesByColor("green"));
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFacultyWhenAddCalled() {
        Faculty expected = new Faculty(2l, "Slytherin", "green");
        Faculty actual = facultyService.add(new Faculty(2l, "Slytherin", "green"));
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFacultyWhenGetCalled() {
        Faculty expected = new Faculty(1l, "Gryffindor", "red");
        Faculty actual = facultyService.get(1l);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFacultyWhenEditCalled() {
        Faculty expected = new Faculty(1l, "Griffindor", "red");
        Faculty actual = facultyService.edit(new Faculty(1l, "Griffindor", "red"));
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFacultyWhenDeleteCalled() {
        Faculty expected = new Faculty(1l, "Gryffindor", "red");
        Faculty actual = facultyService.delete(1l);
        assertEquals(expected, actual);
    }
    */
}