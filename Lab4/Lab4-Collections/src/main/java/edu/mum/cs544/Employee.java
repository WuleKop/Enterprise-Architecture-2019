package edu.mum.cs544;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "employee")
    @Cascade(CascadeType.PERSIST)
    private Set<Laptop> laptopList=new HashSet<>();

    public Employee() {
    }

    public Employee(String name, String address) {
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
    public boolean addLaptop(Laptop laptop) {
        if(laptopList.add(laptop)) {
            laptop.setEmployee(this);
            return true;
        }
        return false;
    }
    public boolean removeLaptop(Laptop laptop) {
        if(laptopList.remove(laptop)) {
            laptop.setEmployee(null);
            return true;
        }
        return false;
    }

}
