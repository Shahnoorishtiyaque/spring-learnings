package com.example.SoftDelete.controller;

import com.example.SoftDelete.entity.Student;
import com.example.SoftDelete.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;

    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent (@RequestBody Student studentReq){
        Student createdStudent=studentService.createStudent(studentReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);

    }

    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam Long id){
        Student studentResp=studentService.getStudent(id);
        if(studentResp==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentlist=studentService.getAll();
        if(studentlist.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(studentlist);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestParam Long id,
                                                 @RequestBody Student studentReq){
        Student studentResp=studentService.updateStudent(id,studentReq);
        if(studentResp==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(studentResp);
    }

    @DeleteMapping("/delete")
    ResponseEntity<String> deleteStuident(@RequestParam Long id){ /*Request parameter*/
        Boolean isDeleted=studentService.deleteStudent(id);
        if(!isDeleted) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Student Deleted");
    }
   @PatchMapping("/deleteSoft/{id}")
    ResponseEntity<String> softdelete(@PathVariable long id){
        Boolean isDeleted=studentService.softDelete(id);
        if(!isDeleted) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("student is soft deleted");
   }
}
