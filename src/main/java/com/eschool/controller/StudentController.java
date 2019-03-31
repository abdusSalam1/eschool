package com.eschool.controller;

import com.eschool.domain.student.Student;
import com.eschool.model.StudentModel;
import com.eschool.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Abdus Salam on 8/24/2018.
 */
@RestController(value = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity addStudent(@RequestBody StudentModel studentModel) {
        try {
            //    Link uri = linkTo(methodOn(StudentController.class).getStudent(student.getId().toString())).withRel("self");
            //  studentService.addStudent(student);
            //  return new ResponseEntity(uri, HttpStatus.CREATED);
            return null;
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity updateStudent(@RequestBody Student student) {
        try {
            Link uri = linkTo(methodOn(StudentController.class).getStudent(student.getId().toString())).withRel("self");
            studentService.updateStudent(student);
            return new ResponseEntity(uri, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/{studentId}")
    public ResponseEntity getStudent(@PathVariable String studentId) {
        try {
            Student student = studentService.findByStudentId(UUID.fromString(studentId));
            return ResponseEntity.ok(student);
        } catch (Exception ex) {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(path = "/all")
    public ResponseEntity getAllStudents() {
        try {
            return ResponseEntity.ok(studentService.findAllStudents());
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }
}
