package com.example.petclinic.entities;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name="pets")
@Component
@Data
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "pet_id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="card_id")
    private Long card_id;
    @Column(name="animal_type")
    private String animal_type;

    @Column(name="petowner_id")
    private Long petowner_id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "petowner_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private PetOwner petOwner;

    public Pet() {

    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", card_id=" + card_id +
                ", animal_type='" + animal_type + '\'' +
                ", petOwner=" + petOwner +
                '}';
    }

    public Pet(String name, Long card_id, String animal_type, Long petowner_id) {
        this.name = name;
        this.card_id = card_id;
        this.animal_type = animal_type;
        this.petowner_id = petowner_id;
    }
}
