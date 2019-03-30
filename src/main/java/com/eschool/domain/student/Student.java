package com.eschool.domain.student;

import com.eschool.domain.Entity;
import com.eschool.domain.parent.Parent;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Abdus Salam on 8/24/2018.
 */
@Document(collection = "student")
public class Student extends Entity {

    private final String name;
    private final String cnic;
    private final String enrollmentNumber;
    private final List<StudentClass> classes;
    private final List<Parent> parents;
    private final List<StudentFee> fees;
    private final boolean active;

    @PersistenceConstructor
    public Student(String name, String cnic, String enrollmentNumber, List<StudentClass> classes,
                   List<Parent> parents, List<StudentFee> fees, boolean active) {
        super();
        this.name = name;
        this.cnic = cnic;
        this.enrollmentNumber = enrollmentNumber;
        this.classes = classes;
        this.parents = parents;
        this.fees = fees;
        this.active = active;
    }
}