package com.example.CrudDTO.controller;

import com.example.CrudDTO.dto.CreateStudentRequestDTO;
import com.example.CrudDTO.dto.CreateStudentResponseDTO;
import com.example.CrudDTO.dto.UpdateStudentReqDTO;
import com.example.CrudDTO.dto.UpdateStudentRespDTO;
import com.example.CrudDTO.entity.Students;
import com.example.CrudDTO.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DTO/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    ResponseEntity<CreateStudentResponseDTO> createStudent(@Valid @RequestBody CreateStudentRequestDTO studentReq){
        CreateStudentResponseDTO createdStudent=studentService.createStudent(studentReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<CreateStudentResponseDTO> getStudent(@PathVariable Long id){
        CreateStudentResponseDTO getStudent=studentService.getStudent(id);
        if(getStudent==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(getStudent);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<CreateStudentResponseDTO>> getAllStudent(){
        List<CreateStudentResponseDTO> studentlist=studentService.getAllStudent();
        if(studentlist.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(studentlist);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteStudent(@PathVariable Long id){
        if (!studentService.delete(id)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Student is deleted");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UpdateStudentRespDTO> update(
            @PathVariable Long id,
            @RequestBody UpdateStudentReqDTO studentReq) {

        UpdateStudentRespDTO updatedStudent = studentService.update(id, studentReq);

        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedStudent);
    }
    @PatchMapping("/softDelete/{id}")
    ResponseEntity<String> softDeleteStudent(@PathVariable Long id){
        if (!studentService.softDelete(id)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Student is soft deleted");
    }
}
