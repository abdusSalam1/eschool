package com.eschool.domain.classInfo;

import com.eschool.domain.Entity;
import com.eschool.domain.fee.Fee;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

/**
 * Created by Abdus Salam on 9/1/2018.
 */
@Document(collection = "class")
public class StudentClass extends Entity {

    private final ClassName name;
    private final Fee fee;
    private final Section section;
    private final Session session;

    public StudentClass(UUID id, ClassName name, Fee fee, Section section, Session session) {
        super(id);
        this.name = name;
        this.fee = fee;
        this.section = section;
        this.session = session;
    }
}