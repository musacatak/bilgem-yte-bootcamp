package yte.intern.springapp.student.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.springapp.common.response.MessageResponse;
import yte.intern.springapp.common.response.MessageType;
import yte.intern.springapp.student.entity.Student;
import yte.intern.springapp.student.repository.StudentRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public MessageResponse addStudent(Student student) {
        studentRepository.save(student);

        return new MessageResponse("Student has been addedd successfully", MessageType.SUCCESS);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student with ID %d not found".formatted(id)));
    }

    @Transactional
    public MessageResponse updateStudent(Long id, Student newStudent) {
        Student existingStudent = getStudentById(id);
        existingStudent.update(newStudent);
        studentRepository.save(existingStudent);
        return new MessageResponse("Student with id %d has been updated".formatted(id), MessageType.SUCCESS);
    }

    public MessageResponse deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            return new MessageResponse("Student can't be found", MessageType.ERROR);
        }
        studentRepository.deleteById(id);
        return new MessageResponse("Student has been deleted successfully", MessageType.SUCCESS);

    }
}
