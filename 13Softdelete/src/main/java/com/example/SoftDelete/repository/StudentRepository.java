package com.example.SoftDelete.repository;

import com.example.SoftDelete.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByIdAndDeletedFalse(Long id);
    List<Student> findByAndDeletedIsFalse();

}
