package com.example.petclinic.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name= "petowners")
@Component
@Data
public class PetOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "petowner_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phone_number;


    public PetOwner(String name, String email, String phone_number) {
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
    }

    public PetOwner() {
    }
}
