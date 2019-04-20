package com.eschool.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FeeController {


    @PostMapping
    public void generateFeeReportByFile(@PathVariable("file") MultipartFile file) {

    }
}