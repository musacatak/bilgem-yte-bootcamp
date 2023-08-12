package yte.intern.springapp.student.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yte.intern.springapp.common.response.MessageResponse;
import yte.intern.springapp.student.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public MessageResponse addStudent(@RequestBody @Valid AddStudentRequest request) {
        return studentService.addStudent(request.toEntity());
    }

    @GetMapping
    public List<yte.intern.springapp.student.controller.StudentResponse> getAllStudents() {
        return studentService.getAllStudents()
                .stream()
                .map(yte.intern.springapp.student.controller.StudentResponse::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public yte.intern.springapp.student.controller.StudentResponse getStudentById(@PathVariable Long id) {
        return StudentResponse.fromEntity(studentService.getStudentById(id));
    }

    @PutMapping("/{id}")
    public MessageResponse updateStudent(@RequestBody @Valid UpdateStudentRequest request,
                                         @PathVariable Long id) {
        return studentService.updateStudent(id, request.toEntity());
    }

    @DeleteMapping("/{id}")
    public MessageResponse deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

}
