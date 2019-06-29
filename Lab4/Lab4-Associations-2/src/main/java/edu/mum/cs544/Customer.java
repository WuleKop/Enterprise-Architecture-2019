package edu.mum.cs544;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> reservationList=new ArrayList<>();

    public Customer() {
    }

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void addReservation(Reservation reservation){
        reservationList.add(reservation);
    }
    public void removeReservation(Reservation reservation) {
        reservationList.remove(reservation);
    }

}
