package com.example.SoftDelete.service;

import com.example.SoftDelete.entity.Student;
import com.example.SoftDelete.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Student createStudent(Student studentReq){
        studentReq.setDeleted(false); //deleted by default set to false
        Student studentResp=studentRepository.save(studentReq);
        return studentResp;
    }

    public Student getStudent(Long id){
        Optional<Student> studentResp=studentRepository.findByIdAndDeletedFalse(id);  /*implemented by spring*/
        if(studentResp.isPresent()) return studentResp.get();
        return null;
    }

    public List<Student> getAll(){
        List<Student> studentList=studentRepository.findByAndDeletedIsFalse(); /*select all student and deleted =false*/
        return studentList;

    }
    public Student updateStudent(Long id,Student studentReq){
        Optional<Student> existingStudent=studentRepository.findByIdAndDeletedFalse(id);
        if(existingStudent.isEmpty()) return null;

        Student studentToSave=existingStudent.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setRoll_no(studentReq.getRoll_no());
        studentToSave.setId(studentReq.getId());
        studentToSave.setDeleted(studentReq.getDeleted());
        studentToSave.setDeleted(false);
        return studentRepository.save((studentToSave));
    }

    public Boolean deleteStudent(Long id){  /*no changes required*/
        Boolean isStudent =studentRepository.existsById(id);
        if(!isStudent) return false;
        studentRepository.deleteById(id);
        return true;
    }

    public Boolean softDelete(Long id){
        Optional<Student> existingStudent=studentRepository.findByIdAndDeletedFalse(id);
        if(existingStudent.isEmpty()) return false;
        Student studentToSave=existingStudent.get();
        studentToSave.setDeleted(true);
        studentRepository.save((studentToSave));
        return true;

    }

}
