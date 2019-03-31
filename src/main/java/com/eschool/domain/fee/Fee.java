package com.eschool.domain.fee;

import com.eschool.domain.Entity;

import java.util.UUID;

/**
 * Created by Abdus Salam on 9/2/2018.
 */
public class Fee extends Entity {

    private final Double fee;
    private final Double admissionFee;
    private final Double printingFee;

    public Fee(UUID id, Double fee, Double admissionFee, Double printingFee) {
        super(id);
        this.fee = fee;
        this.admissionFee = admissionFee;
        this.printingFee = printingFee;
    }
}