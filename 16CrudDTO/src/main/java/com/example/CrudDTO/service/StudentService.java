package com.example.CrudDTO.service;

import com.example.CrudDTO.dto.CreateStudentRequestDTO;
import com.example.CrudDTO.dto.CreateStudentResponseDTO;
import com.example.CrudDTO.dto.UpdateStudentReqDTO;
import com.example.CrudDTO.dto.UpdateStudentRespDTO;
import com.example.CrudDTO.entity.Students;
import com.example.CrudDTO.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDTO createStudent(CreateStudentRequestDTO studentReq){
        Students student=mapToEntity(studentReq); //we have to make the dto an entity so we convert it to students
        student.setCreatedAt(LocalDateTime.now()); /*we can also called it inside mapToEntity*/
        Students studentResp= studentRepository.save(student);
        return mapToDto(studentResp);  //we make these function in this file
    }

    public CreateStudentResponseDTO getStudent(Long id){
        Optional<Students> studentsResp=studentRepository.findById(id);
        if(studentsResp.isPresent()) return mapToDto(studentsResp.get());
        return null;
    }

    public List<CreateStudentResponseDTO> getAllStudent(){
//        if (studentRepository.findByDeletedFalse().isEmpty()) return null;
        List<Students> studentlist=studentRepository.findByDeletedFalse();
        return studentlist.stream().map(this::mapToDto).toList();
    }


    public Boolean delete(Long id){
        if(studentRepository.findByIdAndDeletedFalse(id).isEmpty()) return false;
        studentRepository.deleteById(id);
        return true;
    }

    public UpdateStudentRespDTO update(long id, UpdateStudentReqDTO studentReq){
        Optional<Students> existingStudent=studentRepository.findByIdAndDeletedFalse(id);
        if(existingStudent.isEmpty()) return null;
        Students studentToSave=existingStudent.get();
        studentToSave.setUpdatedAt(LocalDateTime.now());
        studentToSave.setName(studentReq.getName());
        Students savedStudent= studentRepository.save(studentToSave);
        return mapToUpdateDto(savedStudent);

    }
    public Boolean softDelete(Long id){
        Optional<Students> existingStudent=studentRepository.findByIdAndDeletedFalse(id);
        if(existingStudent.isEmpty()) return false;
        existingStudent.get().setDeleted(true);
        studentRepository.save(existingStudent.get());
        return true;
    }
    private Students mapToEntity(CreateStudentRequestDTO studentReqDTO){
        Students student=new Students();
//        student.setId(student.getId());
        student.setName(studentReqDTO.getName());
        student.setEmail(studentReqDTO.getEmail());
        student.setDeleted(false);
        return student;

    }

    private CreateStudentResponseDTO mapToDto(Students student){
        CreateStudentResponseDTO responseDTO=new CreateStudentResponseDTO();
        responseDTO.setId(student.getId());
        responseDTO.setName(student.getName());
        responseDTO.setEmail(student.getEmail());
        responseDTO.setCreatedAt(student.getCreatedAt());

        responseDTO.setMessage("Student is created");
        return responseDTO;
    }

    private UpdateStudentRespDTO mapToUpdateDto(Students student){
        UpdateStudentRespDTO responseDTO=new UpdateStudentRespDTO();
        responseDTO.setId(student.getId());
        responseDTO.setName(student.getName());
        responseDTO.setEmail(student.getEmail());
        responseDTO.setUpdatedAt(student.getUpdatedAt());

        responseDTO.setMessage("Student Updated successfully");
        return responseDTO;
    }


}