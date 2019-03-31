package com.eschool.controller;

import com.eschool.handler.StudentHandler;
import com.eschool.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by Abdus Salam on 8/24/2018.
 */
@RestController(value = "/students")
public class StudentController {

    @Autowired
    private StudentHandler studentHandler;

    @PostMapping
    public ResponseEntity addStudent(@RequestBody StudentModel studentModel) {
        return studentHandler.addStudent(studentModel);
    }

    @PutMapping
    public ResponseEntity updateStudent(@RequestBody StudentModel studentModel) {
       return studentHandler.updateStudent(studentModel);
    }

    @GetMapping(path = "/{studentId}")
    public ResponseEntity getStudent(@PathVariable String studentId) {
       return studentHandler.getStudent(studentId);
    }

    @GetMapping
    public ResponseEntity getAllStudents() {
        return studentHandler.getAllStudents();
    }
}
