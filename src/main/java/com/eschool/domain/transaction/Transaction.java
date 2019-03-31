package com.eschool.domain.transaction;

import com.eschool.domain.date.OurDateTime;
import com.eschool.domain.fee.FeeFrequency;

/**
 * Created by Abdus Salam on 9/8/2018.
 */
public abstract class Transaction {

    private OurDateTime startDate;
    private OurDateTime endDate;
    private OurDateTime transactionDate;
    private FeeFrequency feeFrequency;
    private Double fee;
    private Double admissionFee;
    private Double printingFee;
}