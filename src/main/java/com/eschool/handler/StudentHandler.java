package com.eschool.handler;

import com.eschool.domain.student.Student;
import com.eschool.model.StudentModel;
import com.eschool.service.StudentService;
import com.eschool.transformer.StudentModelTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StudentHandler {

    private final StudentService studentService;
    private final StudentModelTransformer studentModelTransformer;

    @Autowired
    public StudentHandler(StudentService studentService, StudentModelTransformer studentModelTransformer) {
        this.studentService = studentService;
        this.studentModelTransformer = studentModelTransformer;
    }

    public ResponseEntity addStudent(StudentModel studentModel) {
        try {
            //  Link uri = linkTo(methodOn(StudentController.class).getStudent(studentModel.getId().toString())).withRel("self");
            studentService.addStudent(studentModelTransformer.transform(studentModel));
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity updateStudent(StudentModel studentModel) {
        try {
            //  Link uri = linkTo(methodOn(StudentController.class).getStudent(student.getId().toString())).withRel("self");
            studentService.updateStudent(studentModelTransformer.transform(studentModel));
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
