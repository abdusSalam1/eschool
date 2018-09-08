package com.eschool.domain.student;

import com.eschool.domain.fee.Discount;
import com.eschool.domain.fee.Fee;
import com.eschool.domain.fee.TransactionDetail;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Created by Abdus Salam on 9/2/2018.
 */
public class StudentFee {

    @DBRef
    private Fee fee;
    private Discount discount;
    private TransactionDetail transactionDetail;

    public Fee getMonthlyFee() {
        return null;
    }
}
