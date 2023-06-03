package com.practice.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class EmployeeDTO {


    private Integer id;


    private String name;
    @Email(message = "Please enter a valid email address")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "invalid mobile number entered ")
    private String number;

    @Size(min = 18, max = 65, message = "Age must be between 18 and 65")
    private Integer age;


    private Double salary;

//    @OneToMany
//    @Cascade(CascadeType.ALL)
//    @JoinColumn(name = "id")
//    private List<Address> address;
}
