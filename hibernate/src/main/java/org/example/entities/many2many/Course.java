package org.example.entities.many2many;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@Entity(name = "courses")
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String instructor;
    private int credit;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "student_course",
    joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> students = new HashSet<>();

    public Course(String name, String instructor, int credit) {
        this.name = name;
        this.instructor = instructor;
        this.credit = credit;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }
}
