package com.eschool.domain.classInfo;

import com.eschool.domain.Entity;
import com.eschool.domain.fee.Fee;

import java.util.List;

/**
 * Created by Abdus Salam on 9/1/2018.
 */
public class ClassInfo extends Entity {

    private String name;
    private List<Section> sections;
    private List<Fee> fees;
}
