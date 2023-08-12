package yte.intern.springapp.student.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.springapp.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {


}
