package com.eschool.domain.classInfo;

import com.eschool.domain.Entity;
import com.eschool.domain.fee.Fee;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

/**
 * Created by Abdus Salam on 9/2/2018.
 */
@Document(collection = "section")
@Getter
public class Section extends Entity {

    private final String name;
    private final SectionType type;

    public Section(UUID id, String name, SectionType type) {
        super(id);
        this.name = name;
        this.type = type;
    }
}