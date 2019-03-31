package com.eschool.domain.fee;

/**
 * Created by Abdus Salam on 9/8/2018.
 */
public class Discount {

    private final double monthlyDiscount;
    private final double admissionDiscount;
    private final double printingFeeDiscount;

    public Discount(double monthlyDiscount, double admissionDiscount, double printingFeeDiscount) {
        this.monthlyDiscount = monthlyDiscount;
        this.admissionDiscount = admissionDiscount;
        this.printingFeeDiscount = printingFeeDiscount;
    }
}
