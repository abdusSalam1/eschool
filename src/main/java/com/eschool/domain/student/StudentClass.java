package com.eschool.domain.student;

import com.eschool.domain.Entity;
import com.eschool.domain.classInfo.ClassInfo;
import com.eschool.domain.classInfo.Section;
import com.eschool.domain.classInfo.Session;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Created by Abdus Salam on 9/2/2018.
 */
public class StudentClass extends Entity {

    @DBRef
    private ClassInfo classInfo;
    private Session session;
    private Section section;
}
