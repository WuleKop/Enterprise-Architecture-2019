package edu.mum.cs544;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String department;
    @ManyToMany(mappedBy = "courseList",cascade = CascadeType.ALL)
    private List<Student> studentList=new ArrayList<>();

    public Course() {
    }

    public Course(String name, String department) {
        this.name = name;
        this.department = department;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public void addStudent(Student student) {
        studentList.add(student);
    }
    public void removeStudent(Student student) {
        studentList.remove(student);
    }
}
