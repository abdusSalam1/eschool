package com.eschool.controller;

import com.eschool.delegate.FeeChallanDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FeeChallanController {

    @Autowired
    private FeeChallanDelegate feeChallanDelegate;

    @PostMapping(value = "fee-challans")
    public void generateFeeChallansByFile(@PathVariable("file") MultipartFile file) {
        feeChallanDelegate.generateFeeChallanByFile(file);
    }
}