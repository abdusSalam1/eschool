package com.eschool.domain.parent;

import com.eschool.domain.Entity;
import lombok.Getter;

import java.util.List;

/**
 * Created by Abdus Salam on 9/2/2018.
 */
@Getter
public abstract class Parent extends Entity {

    private final String name;
    private final String cnic;
    private final String occupation;
    private final Double monthlySalary;
    private List<String> contactNumbers;
    private String address;

    protected Parent(String name, String cnic, String occupation, Double monthlySalary, List<String> contactNumbers, String address) {
        super();
        this.name = name;
        this.cnic = cnic;
        this.occupation = occupation;
        this.monthlySalary = monthlySalary;
        this.contactNumbers = contactNumbers;
        this.address = address;
    }
}
