package edu.mum.cs544;

import com.sun.xml.txw2.annotation.XmlCDATA;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Doctor {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "TYPE")
    private String doctortype;
    @Column(name="FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;

    public Doctor(String doctortype, String firstname, String lastname) {
        this.doctortype = doctortype;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
