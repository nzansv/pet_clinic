package com.example.petclinic.entities;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="payments")
@Component
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "payment_id")
    private Long id;

    @Column(name="status")
    private String status;

    @Column(name="date")
    private String date;

    @Column(name="app_id")
    private Long app_id;

    @Column(name="petowner_id")
    private Long petowner_id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "petowner_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private PetOwner petOwner;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "app_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Appointment appointment;


    public Payment(String status, String date, Long app_id, Long petowner_id) {
        this.status = status;
        this.date = date;
        this.app_id = app_id;
        this.petowner_id = petowner_id;
    }

    public Payment() {

    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", petOwner=" + petOwner +
                ", appointment=" + appointment +
                '}';
    }
}
