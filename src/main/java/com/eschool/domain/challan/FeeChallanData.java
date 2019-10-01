package com.eschool.domain.challan;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class FeeChallanData {

    private String studentName;
    private String studentClass;
    private String studentSection;
    private String rollNumber;
    private String issueDate;
    private String dueDate;
    private double tuitionFee;
    private double arrears;

    public FeeChallanData() {
    }
}