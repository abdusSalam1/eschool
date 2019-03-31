package com.eschool.model;

import com.eschool.domain.student.Student;
import com.eschool.model.parent.ParentModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class StudentModel {

    private String id;
    private String name;
    private String enrolmentNumber;
    private List<ParentModel> parents;
    private boolean active;
    private String feeFrequency;
    private StudentClassModel studentClass;


    public Student toStudent() {
        return null;
    }
}