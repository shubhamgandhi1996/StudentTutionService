package com.batch.batchDetails.controller;

import com.batch.batchDetails.entity.Student;
import com.batch.batchDetails.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tuition")
public class Controller {
    private final StudentService studentService;

    @Autowired
    public Controller(StudentService studentService) {
        this.studentService =   studentService;
    }

    // Endpoint    to get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students   =   studentService.getAllStudents();


        return ResponseEntity.ok(students);
    }

    // Endpoint to    get a student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student =
                studentService.getStudentById(id);

        return student.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint to create a new student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(201).body(createdStudent);
    }

    // Endpoint to update an existing student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {


        Student updated = studentService.updateStudent(id, updatedStudent);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }

        return ResponseEntity.notFound().build();
    }

    // Endpoint to delete a student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {

        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
