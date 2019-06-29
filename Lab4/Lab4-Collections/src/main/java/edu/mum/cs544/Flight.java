package edu.mum.cs544;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Flight {
    @Id
    @GeneratedValue
    private Long id;
    private String airlines;
    private String flightNumber;
    private String departure;
    private String destination;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Flight_Id")
    private List<Passenger> passengerList=new ArrayList<>();

    public Flight() {
    }

    public Flight(String airlines, String flightNumber, String departure, String destination) {
        this.airlines = airlines;
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirlines() {
        return airlines;
    }

    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean addPassenger(Passenger passenger) {
        if(passengerList.add(passenger)) {
            return true;
        }
        return false;
    }
    public boolean removePassenger(Passenger passenger) {
        if(passengerList.remove(passenger)) {
            return true;
        }
        return false;
    }
}
