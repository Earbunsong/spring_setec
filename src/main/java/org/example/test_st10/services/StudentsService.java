package org.example.test_st10.services;

import org.example.test_st10.Repository.StudentRepository;
import org.example.test_st10.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentsService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Students> getAll() {
        return studentRepository.findAll();
    }

    public Optional<Students> getById(Long id) {
        return studentRepository.findById(id);
    }

    public Students create(Students student) {
        return studentRepository.save(student);
    }

    public Students update(Long id, Students updatedStudent) {
        return studentRepository.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setSex(updatedStudent.getSex());
            student.setEmail(updatedStudent.getEmail());
            student.setScore(updatedStudent.getScore());
            student.setAge(updatedStudent.getAge());
            return studentRepository.save(student);
        }).orElse(null);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }


    /*private final Map<Long, Students> students = new HashMap<>();

    public StudentsService() {
        // Add some sample static students
        students.put(1L, new Students(1L, "Alice", "Female", "alice@example.com", 90));
        students.put(2L, new Students(2L, "Bob", "Male", "bob@example.com", 85));
    }

    public List<Students> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public Students getStudentById(Long id) {
        return students.get(id);
    }

    public Students addStudent(Students student) {
        students.put(student.getId(), student);
        return student;
    }

    public Students updateStudent(Long id, Students updatedStudent) {
        students.put(id, updatedStudent);
        return updatedStudent;
    }

    public void deleteStudent(Long id) {
        students.remove(id);
    }*/
}
