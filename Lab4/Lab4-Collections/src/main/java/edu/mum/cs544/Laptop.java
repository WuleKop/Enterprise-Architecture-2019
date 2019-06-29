package edu.mum.cs544;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Laptop {
    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String serialNumber;
    @ManyToOne()
    private Employee employee;

    public Laptop() {
    }

    public Laptop(String brand, String serialNumber) {
        this.brand = brand;
        this.serialNumber = serialNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return id.equals(laptop.id) &&
                brand.equals(laptop.brand) &&
                serialNumber.equals(laptop.serialNumber) &&
                employee.equals(laptop.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, serialNumber, employee);
    }
}
