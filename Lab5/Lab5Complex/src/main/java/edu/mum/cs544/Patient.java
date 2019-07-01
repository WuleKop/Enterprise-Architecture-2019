package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@SecondaryTable(name="Address")
public class Patient {
    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;
    @Column(name="NAME")
    private String name;
    @Column(name="STREET",table = "Address")
    private String street;
    @Column(name="ZIP", table = "Address")
    private String zip;
    @Column(name="CITY", table = "Address")
    private String city;

    public Patient(String name, String street, String zip, String city) {
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.city = city;
    }
}
