package com.example.petclinic.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name="veterinarians")
@Component
@Data
public class Veterinarian {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "vet_id")
    private Long id;
    @Column(name="fullname")
    private String fullname;
    @Column(name="cab_no")
    private int cabNo;

    @Override
    public String toString() {
        return "Veterinarian{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", cabNo=" + cabNo +
                '}';
    }

    public Veterinarian() {
    }

    public Veterinarian(String fullname, int cabNo) {
        this.fullname = fullname;
        this.cabNo = cabNo;
    }
}
