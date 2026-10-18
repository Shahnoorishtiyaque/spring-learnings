package com.example.CrudSpringBootDemo.service;

import com.example.CrudSpringBootDemo.entity.Student;
import com.example.CrudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){

            Student studentResp=studentRepository.save(studentReq);
            return studentResp;
    }
    public Student getStudent(Long id){
        Optional<Student> studentResp=studentRepository.findById(id);/* it give us option means id may not be present*/
        if(studentResp.isPresent()){
            return studentResp.get();
        }
        return null;
    }

    public List<Student> getAll(){
        List<Student> studentList=studentRepository.findAll();
        return studentList;
    }
    public Student updateStudent(Long id,Student studentReq){
        Optional<Student> existingStudent=studentRepository.findById(id);
        if(existingStudent.isEmpty()){
            return null;
        }
        Student studentToSave=existingStudent.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setAge(studentReq.getAge());

        return studentRepository.save(studentToSave);
    }

    public Boolean deleteStudent(Long id){
        Boolean isStudent=studentRepository.existsById(id);
        if(!isStudent)return false;
        studentRepository.deleteById(id);
        return true;
    }
}
