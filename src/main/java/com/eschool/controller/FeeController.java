package com.eschool.controller;

import com.eschool.delegate.FeeDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FeeController {

    @Autowired
    private FeeDelegate feeDelegate;

    @PostMapping
    public void generateFeeReportByFile(@PathVariable("file") MultipartFile file) {
        feeDelegate.generateFeeReportByFile(file);
    }
}