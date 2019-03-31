package com.eschool.model;

import com.eschool.model.parent.ParentModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class StudentModel {

    private String id;
    private String name;
    private String cnic;
    private String enrolmentNumber;
    private List<ParentModel> parents;
    private boolean active;
    private String feeFrequency;
    private String className;
    private String sectionName;
}