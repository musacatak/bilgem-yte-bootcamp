package yte.intern.springapp.student.controller;


import yte.intern.springapp.student.entity.Student;

public record StudentResponse(
        Long id,
        String name,
        String surname,
        String tcKimlikNo,
        String email,
        String studentNumber
) {
    public static StudentResponse fromEntity(Student student) {
        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getSurname(),
                student.getTcKimlikNo(),
                student.getEmail(),
                student.getStudentNumber()
        );
    }
}
