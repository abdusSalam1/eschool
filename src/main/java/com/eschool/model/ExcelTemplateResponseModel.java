package com.eschool.model;

import lombok.Getter;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import lombok.Getter;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@Getter
public class ExcelTemplateResponseModel {


    private HttpHeaders httpHeaders;
    private InputStreamResource inputStreamResource;


    public ExcelTemplateResponseModel(HttpHeaders httpHeaders, File file) throws FileNotFoundException {
        this.httpHeaders = httpHeaders;
        setInputStreamResource(file);
    }

    public void setInputStreamResource(File file) throws FileNotFoundException {
        inputStreamResource =new InputStreamResource(new FileInputStream(file));

    }


    public ResponseEntity getWebResponse(){
        return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.parseMediaType("application/txt")).body(inputStreamResource);
    }

}
