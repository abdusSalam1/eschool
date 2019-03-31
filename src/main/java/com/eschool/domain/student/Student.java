package com.eschool.domain.student;

import com.eschool.domain.Entity;
import com.eschool.domain.classInfo.StudentClass;
import com.eschool.domain.fee.FeeFrequency;
import com.eschool.domain.parent.Parent;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Abdus Salam on 8/24/2018.
 */
@Document(collection = "student")
@Builder
@Getter
public class Student extends Entity {

    private final String name;
    private final String cnic;
    private final String enrollmentNumber;
    private final List<Parent> parents;
    private List<StudentClass> classes;
    private FeeFrequency feeFrequency;
    private boolean active;

    @PersistenceConstructor
    private Student(String name, String cnic, String enrollmentNumber, List<StudentClass> studentClasses,
                    List<Parent> parents, boolean active) {
        super();
        this.name = name;
        this.cnic = cnic;
        this.enrollmentNumber = enrollmentNumber;
        this.parents = parents;
        this.classes = studentClasses;
        this.active = active;
    }
}