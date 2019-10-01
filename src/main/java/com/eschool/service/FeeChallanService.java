package com.eschool.service;

import com.eschool.model.ExcelTemplateResponseModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;


@Service
public class FeeChallanService {


    public ExcelTemplateResponseModel getTemplate() throws FileNotFoundException {
        return new ExcelTemplateResponseModel(getHeader(), getFileDetails());
    }

    private HttpHeaders getHeader(){
        org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        httpHeaders.add("cache control", "no cache, no store, must-revalidate");
        httpHeaders.add("pragma", "no cache");
        httpHeaders.add("Expire", "O");
        httpHeaders.setContentType(new MediaType("text", "json"));
        httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + getFileDetails().getName());
        return httpHeaders;
    }

    public File getFileDetails(){
        String filename = "D:\\template.xlsx";
        File file = new File(filename);
        return file;
    }

}
