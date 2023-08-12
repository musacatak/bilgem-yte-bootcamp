package yte.intern.springapp.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.springapp.book.entity.Book;
import yte.intern.springapp.common.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor
public class Student extends BaseEntity {

    private String name;
    private String surname;
    private String email;
    private String tcKimlikNo;
    private String studentNumber;

    public Student(String name, String surname, String email, String tcKimlikNo, String studentNumber) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.tcKimlikNo = tcKimlikNo;
        this.studentNumber = studentNumber;
    }

    @OneToMany
    @JoinColumn(name = "student_id")
    private List<Book> books = new ArrayList<>();

    public void update(Student newStudent) {
        this.name = newStudent.name;
        this.surname = newStudent.surname;
        this.email = newStudent.email;
        this.studentNumber = newStudent.studentNumber;
    }
}
