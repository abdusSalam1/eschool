package com.eschool.domain.classInfo;

import com.eschool.domain.Entity;
import lombok.Getter;

import java.util.UUID;

/**
 * Created by Abdus Salam on 9/2/2018.
 */
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