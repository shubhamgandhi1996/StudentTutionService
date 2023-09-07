package com.batch.batchDetails.service;

import com.batch.batchDetails.entity.Student;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(updatedStudent.getName());
            student.setSubBatch(updatedStudent.getSubBatch()); // Update subbatch if needed
            return studentRepository.save(student);
        }
        return null; // Handle not found case appropriately
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
