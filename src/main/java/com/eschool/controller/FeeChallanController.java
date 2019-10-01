package com.eschool.controller;

import com.eschool.delegate.FeeChallanDelegate;
import com.eschool.model.ExcelTemplateResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FeeChallanController {

    @Autowired
    private FeeChallanDelegate feeChallanDelegate;

//    @PostMapping(value = "fee-challans")
//    public void generateFeeChallansByFile(@PathVariable("file") MultipartFile file) {
//        feeChallanDelegate.generateFeeChallanByFile(file);
//    }


    @GetMapping(value = "/download")
    public ResponseEntity downloadExcelTemplate() {
        try {
            ExcelTemplateResponseModel response = feeChallanDelegate.getExcelTempalte();
            return response.getWebResponse();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }

    }
}