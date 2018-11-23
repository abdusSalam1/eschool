package com.eschool.domain.student;

import com.eschool.domain.Entity;
import com.eschool.domain.parent.Parent;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abdus Salam on 8/24/2018.
 */
@Document(collection = "student")
public class Student extends Entity {

    private String name;
    private String cnic;
    private String enrollmentNumber;
    private List<StudentClass> classes;
    private List<Parent> parents;
    private List<StudentFee> fees;
    private boolean active;

    public Student() {
        super();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public void addClass(StudentClass studentClass) {
        if (this.classes == null) {
            this.classes = new ArrayList<>();
        }
        this.classes.add(studentClass);
    }
}