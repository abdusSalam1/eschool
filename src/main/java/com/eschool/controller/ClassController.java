package com.eschool.controller;

import com.eschool.handler.ClassHandler;
import com.eschool.model.StudentClassModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/classes")
public class ClassController {

    @Autowired
    private ClassHandler classHandler;


    @PostMapping
    public ResponseEntity addClass(StudentClassModel studentClassModel){
        return classHandler.addClass(studentClassModel);
    }
}
