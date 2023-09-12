package com.batch.batchDetails.repository;

import com.batch.batchDetails.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

