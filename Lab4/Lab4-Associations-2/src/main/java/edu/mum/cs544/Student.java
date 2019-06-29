package edu.mum.cs544;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Student_Courses",
            joinColumns = {@JoinColumn(name = "Student_ID")},
            inverseJoinColumns = {@JoinColumn(name="Course_ID")})
    private List<Course> courseList=new ArrayList<>();

    public Student() {
    }

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public void addCourse(Course course) {
       courseList.add(course);
    }
    public void removeCourse(Course course) {
        courseList.remove(course);
    }
}
