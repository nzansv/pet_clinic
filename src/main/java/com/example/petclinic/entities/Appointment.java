package com.example.petclinic.entities;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name="appointment")
@Component
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "app_id")
    private Long id;
    @Column(name="date")
    private String date;

    @Column(name="vet_id")
    private Long vet_id;

    @Column(name="petowner_id")
    private Long petowner_id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "petowner_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private PetOwner petOwner;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "vet_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Veterinarian veterinarian;

    public Appointment() {
    }

    public Appointment(String date, Long vet_id, Long petowner_id) {
        this.date = date;
        this.vet_id = vet_id;
        this.petowner_id = petowner_id;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", petOwner=" + petOwner +
                ", veterinarian=" + veterinarian +
                '}';
    }
}
