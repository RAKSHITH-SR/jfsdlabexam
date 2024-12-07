package com.klef.jfsd.exam;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private int age;
    private String location;

    public Customer() {}
    public Customer(String name, String email, int age, String location) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.location = location;
    }

    // Getters and setters omitted for brevity
}