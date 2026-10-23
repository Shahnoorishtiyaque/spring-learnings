package com.example.CrudDTO.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateStudentRequestDTO {
    @NotBlank(message = "Name cant be blank")
    @Size(min = 2, max = 50,message = "at least 2 character is required")  //this will work when we override exception handlinggit status
    private  String name;
    @Email//these will not work until we use @valid whenever we use this values
    private  String email;
a

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //we want only these fields rather than all the fields
}
