package com.example.bytefit.bytefit.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
public class Users {

    @Id
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private Integer mobileNum;
    private String password;

    public Users(String email, String password){
        this.email = email;
        this.password = password;
    }
}
