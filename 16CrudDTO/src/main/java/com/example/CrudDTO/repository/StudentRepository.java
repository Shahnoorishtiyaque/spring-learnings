package com.example.CrudDTO.repository;

import com.example.CrudDTO.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long>{
    Optional<Students> findByIdAndDeletedFalse(Long id);
    List<Students> findByDeletedFalse();

}
