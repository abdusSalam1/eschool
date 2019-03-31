package com.eschool.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentClassModel {

    private String name;
    private String startDate;
    private String endDate;
    private String sectionName;
}