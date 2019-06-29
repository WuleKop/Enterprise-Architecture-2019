package edu.mum.cs544;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Office {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "office")
    private List<Employee> employeeList=new ArrayList<>();

    public Office() {
    }

    public Office(String name, String address) {
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
    public boolean addEmployee (Employee employee) {
        if(employeeList.add(employee)) {
            employee.setOffice(this);
            return true;
        }
        return false;
    }
    public boolean removeEmployee(Employee employee) {
        if(employeeList.remove(employee)) {
            employee.setOffice(null);
            return true;
        }
        return false;
    }
}
