package yte.intern.springapp.student.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import yte.intern.springapp.common.validation.TcKimlikNo;
import yte.intern.springapp.student.entity.Student;


public record AddStudentRequest(

        @NotEmpty
        @Size(max = 255)
        String name,
        @NotEmpty
        @Size(max = 255)
        String surname,
        @TcKimlikNo
        String tcKimlikNo,
        @Email
        @Size(max = 255)
        String email,
        @NotEmpty
        @Size(min = 7, max = 7)
        String studentNumber

) {

    public Student toEntity() {
        return new Student(
                name,
                surname,
                email,
                tcKimlikNo,
                studentNumber
        );
    }
}
