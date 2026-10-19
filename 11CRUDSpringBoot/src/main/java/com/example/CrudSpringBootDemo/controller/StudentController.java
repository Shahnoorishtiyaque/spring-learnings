package com.example.CrudSpringBootDemo.controller;

import com.example.CrudSpringBootDemo.entity.Student;
import com.example.CrudSpringBootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

//    create student
    @PostMapping("/create")
     public ResponseEntity<Student>/*Student */ createStudent(@RequestBody Student student){
        Student createdStudent=studentService.createStudent(student);
//        return createdStudent;
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
     }

     //read one student
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
         Student studentResp=studentService.getStudent(id);
         if(studentResp==null){
             return ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok(studentResp);
    }

    //read all
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList=studentService.getAll();
        if(studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }

//    Update Student
@PutMapping("/update/{id}")
public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                             @RequestBody Student studentReq){
    Student studentResp=studentService.updateStudent(id,studentReq);
    if(studentResp==null){
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(studentResp);
}

//Delete Student
@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
         Boolean isDeleted=studentService.deleteStudent(id);
         if(!isDeleted){
             return ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok("Records deleted");

    }

}
