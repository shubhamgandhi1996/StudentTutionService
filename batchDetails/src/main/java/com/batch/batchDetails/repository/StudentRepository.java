package com.batch.batchDetails.repository;

import com.batch.batchDetails.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findBySubBatchId(Long subBatchId);
}

