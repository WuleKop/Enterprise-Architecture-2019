package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Appointment {
    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;
    @Column(name="APPDATE")
    private String appdate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PATIENT")
    private Patient patient;
    @Embedded
    private Payment payment;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DOCTOR")
    private Doctor doctor;

    public Appointment(String appdate) {
        this.appdate = appdate;
    }
}
