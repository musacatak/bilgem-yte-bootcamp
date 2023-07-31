package org.example.entities.many2many;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@Entity(name = "students")
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    @ManyToMany(mappedBy = "students")
    //@ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Course> courses = new HashSet<>();

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }
}
