package com.eschool.converter;

import com.eschool.domain.challan.FeeChallanData;
import com.eschool.error.ExcelParsingError;
import com.eschool.iterator.ExcelCellIterator;
import com.eschool.iterator.ValidatingCellIterator;

import java.util.ArrayList;
import java.util.List;

public class StudentFeeConverter {

    private final ValidatingCellIterator validatingCellIterator;
    private final List<ExcelParsingError> errors;

    public StudentFeeConverter(ExcelCellIterator excelCellIterator) {
        errors = new ArrayList<>();
        this.validatingCellIterator = new ValidatingCellIterator(excelCellIterator, errors);
    }

    public FeeChallanData convert() {
        try {
            String studentName = validatingCellIterator.nextAlphaNumericString("Student Name");
            String studentClass = validatingCellIterator.nextString("Student Class");
            String studentSection = validatingCellIterator.nextString("Student Section");
            String rollNumber = validatingCellIterator.nextOptionalString("Roll Number");
            String tuitionFee = validatingCellIterator.nextOptionalString("Tuition Fee");
            String Arrears = validatingCellIterator.nextOptionalString("Arrears");
            return new FeeChallanData().builder()
                    .studentName(studentName)
                    .studentClass(studentClass)
                    .studentSection(studentSection)
                    .rollNumber(rollNumber)
                    .build();
        } catch (Exception ex) {
            return null;
        }
    }
}
