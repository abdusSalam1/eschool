package com.eschool.handler;

import com.eschool.model.ClassModel;
import com.eschool.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Configuration
public class ClassHandler {

    @Autowired
    private ClassService classService;

    public ResponseEntity addClass(ClassModel classModel) {
        try {
            //  Link uri = linkTo(methodOn(StudentController.class).getStudent(studentModel.getId().toString())).withRel("self");
            classService.addClass(null);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}