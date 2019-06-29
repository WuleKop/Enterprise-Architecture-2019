package edu.mum.cs544;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class School {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;

    @OneToMany
    @JoinColumn(name = "School_Id")
    @MapKey(name="id")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private Map<Long,Student> students=new HashMap<>();

    public School() {
    }

    public School(String name, String address) {
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

    public void addStudent(Student student){

        students.put(student.getId(),student);
    }
    public void removeStudent(Student student) {
        students.remove(student);
    }
}
