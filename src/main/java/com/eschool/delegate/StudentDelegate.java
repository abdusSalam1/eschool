package com.eschool.delegate;

import com.eschool.domain.student.Student;
import com.eschool.model.StudentModel;
import com.eschool.service.StudentService;
import com.eschool.transformer.StudentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StudentDelegate {

    private final StudentService studentService;
    private final StudentTransformer studentTransformer;

    @Autowired
    public StudentDelegate(StudentService studentService, StudentTransformer studentTransformer) {
        this.studentService = studentService;
        this.studentTransformer = studentTransformer;
    }

    public ResponseEntity addStudent(StudentModel studentModel) {
        try {
            //  Link uri = linkTo(methodOn(StudentController.class).getStudent(studentModel.getId().toString())).withRel("self");
            studentService.addStudent(studentTransformer.transform(studentModel));
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity updateStudent(StudentModel studentModel) {
        try {
            //  Link uri = linkTo(methodOn(StudentController.class).getStudent(student.getId().toString())).withRel("self");
            studentService.updateStudent(studentTransformer.transform(studentModel));
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity getStudent(String studentId) {
        try {
            Student student = studentService.findByStudentId(UUID.fromString(studentId));
            return ResponseEntity.ok(student);
        } catch (Exception ex) {
            return ResponseEntity.noContent().build();
        }
    }

    public ResponseEntity getAllStudents() {
        try {
            return ResponseEntity.ok(studentService.findAllStudents());
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }
}
