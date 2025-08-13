package org.example.test_st10.controller;

import org.example.test_st10.exception.StudentNotFoundException;
import org.example.test_st10.model.Students;
import org.example.test_st10.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentsController {

    @Autowired
    private StudentsService studentService;

    @GetMapping
    public List<Students> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Students getById(@PathVariable Long id) {
        return studentService.getById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));
    }

    @PostMapping
    public Students create(@RequestBody Students student) {
        return studentService.create(student);
    }

    @PutMapping("/{id}")
    public Students update(@PathVariable Long id, @RequestBody Students student) {
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
