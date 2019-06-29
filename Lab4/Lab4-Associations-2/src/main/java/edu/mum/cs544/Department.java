package edu.mum.cs544;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;

    @OneToMany(mappedBy ="department", cascade = CascadeType.ALL)
    private List<Employee> employeeList=new ArrayList<>();

    public Department() {
    }

    public Department(String name, String address) {
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

    public boolean addEmployee(Employee employee) {
        if(employeeList.add(employee)) {
            employee.setDepartment(this);
            return true;
        }
        return false;
    }
    public boolean removeEmployee(Employee employee) {
        if(employeeList.remove(employee)) {
            employee.setDepartment(null);
            return true;
        }
        return false;
    }
}
