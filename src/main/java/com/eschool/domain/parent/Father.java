package com.eschool.domain.parent;

import java.util.List;
import java.util.UUID;

/**
 * Created by Abdus Salam on 9/2/2018.
 */
public class Father extends Parent {

    public Father(String name, String cnic, String occupation, Double monthlySalary, List<String> contactNumbers, String address) {
        super(name, cnic, occupation, monthlySalary, contactNumbers, address);
    }
}
