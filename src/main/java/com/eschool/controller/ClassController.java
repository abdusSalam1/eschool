package com.eschool.controller;

import com.eschool.delegate.ClassDelegate;
import com.eschool.model.ClassModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

public class ClassController {

    @Autowired
    private ClassDelegate classDelegate;

    @PostMapping
    public ResponseEntity addClass(ClassModel classModel){
        return classDelegate.addClass(classModel);
    }
}
