package com.example.CrudSpringBootDemo.repository;

import com.example.CrudSpringBootDemo.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    public Student saveStudent(Student studentReq){
        System.out.println("Inside Student Repository");
        System.out.println("Exiting student repository");
        Student s1=new Student();
        s1.setName("Shaan");
        s1.setAge(22);
        s1.setEmail("shahnoorishtiyaque687@gmail.com");
        s1.setRollNo(41);
        s1.setSubject("springBoot");
        return s1;
    }

}
