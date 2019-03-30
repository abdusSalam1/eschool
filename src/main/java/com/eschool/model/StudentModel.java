package com.eschool.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentModel {

    private String id;
    private String name;
    private String enrolmentNumber;
    private boolean active;
}