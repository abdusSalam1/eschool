package com.eschool.delegate;

import com.eschool.model.ExcelTemplateResponseModel;
import com.eschool.service.FeeChallanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;

@Configuration
public class FeeChallanDelegate {


   @Autowired
    private FeeChallanService feeChallanService;

   public ExcelTemplateResponseModel getExcelTempalte() throws FileNotFoundException {
       return feeChallanService.getTemplate();
   }

}
