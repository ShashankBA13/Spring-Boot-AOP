package com.practice.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 65)
    private String name;

    @Column(name = "email", nullable = false, unique = true, updatable = false)
    @Email(message = "Please enter a valid email address")
    private String email;

    @Column(name = "number", length = 15, unique = true, nullable = false)
    @Pattern(regexp = "^\\d{10}$", message = "invalid mobile number entered ")
    private String number;

    @Column(name = "age", length = 02, nullable = false)
    @Size(min = 18, max = 65, message = "Age must be between 18 and 65")
    private Integer age;

    @Column(name = "salary", precision = 3)
    private Double salary;

    @OneToMany
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "id")
    private List<Address> address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}