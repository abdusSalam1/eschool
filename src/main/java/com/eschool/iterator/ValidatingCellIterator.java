package com.eschool.iterator;

import com.eschool.error.ExcelParsingError;

import java.util.List;
import java.util.TimeZone;

public class ValidatingCellIterator {


    private final ExcelCellIterator cellIterator;
    private final List<ExcelParsingError> errors;

    public ValidatingCellIterator(ExcelCellIterator cellIterator, List<ExcelParsingError> errors) {
        this.errors = errors;
        this.cellIterator = cellIterator;
    }


    public String nextString(String field) {
        return nextString(field, "string", true);
    }

    public String nextAlphaNumericString(String field) {
        if (advanceAndCheckIfNonEmpty(field, true)) {
            return null;
        }
        if (!cellIterator.isEmptyCell() && !(cellIterator.getString().matches("^[a-zA-Z0-9-]*$"))) {
            errors.add(ExcelParsingError.alphaNumeric(getRowIndex(), field));
            return null;
        }

        return cellIterator.getString();
    }

    public boolean checkIfValidDate(String field, boolean requireNotEmpty) {
        cellIterator.next();
        boolean dateFormatError = false;
        if (cellIterator.isEmptyCell() && requireNotEmpty) {
            errors.add(ExcelParsingError.required(cellIterator.getRow(), field));
        }
        if (!cellIterator.isEmptyCell() && !(cellIterator.getString().matches(dateRegex()) || cellIterator.getString().matches("^(0|[1-9][0-9]*)$"))) {
            errors.add(ExcelParsingError.dateFormat(getRowIndex()));
            dateFormatError = true;
        }
        return cellIterator.isEmptyCell() || dateFormatError;
    }

    private String dateRegex() {
        return "^([0]\\d|[1][0-2])\\/([0-2]\\d|[3][0-1])\\/([2][01]|[1][6-9])\\d{2}(\\s([0-1]\\d|[2][0-3])(\\:[0-5]\\d){1,2})?$";
    }

    public String nextString(String field, int maxLength) {
        return nextString(field, "string", true, maxLength);
    }

    public String nextOptionalString(String field) {
        return nextString(field, "string", false, null);
    }

    public String nextOptionalString(String field, int maxLength) {
        return nextString(field, "string", false, maxLength);
    }

    public String nextString(String field, String expectedType, boolean requireNotEmpty, Integer maxLength) {
        if (advanceAndCheckIfNonEmpty(field, requireNotEmpty)) {
            return null;
        }
        String value = cellIterator.getString();
        if (maxLength != null && value.length() > maxLength) {
            errors.add(ExcelParsingError.tooLongError(cellIterator.getRow(), field, maxLength));
        }
        return value;
    }

    public String nextString(String field, String expectedType, boolean requireNotEmpty) {
        if (advanceAndCheckIfNonEmpty(field, requireNotEmpty)) {
            return null;
        }
        return cellIterator.getString();
    }

    private boolean advanceAndCheckIfNonEmpty(String field, boolean requireNotEmpty) {
        cellIterator.next();
        boolean emptyCell = cellIterator.isEmptyCell();
        if (emptyCell && requireNotEmpty) {
            errors.add(ExcelParsingError.required(cellIterator.getRow(), field));
        }
        return emptyCell;
    }


    private boolean checkValidations(String field, String regex, String errorMessage) {
        cellIterator.next();
        boolean isValid = field.matches(regex);
        if (!isValid) {
            errors.add(ExcelParsingError.error(cellIterator.getRow(), field, errorMessage));
        }
        return isValid;
    }

    public int getRowIndex() {
        return cellIterator.getRow();
    }


    public Long nextLongWithLimit(String field, long minLimit, long limit) {
        if (advanceAndCheckIfNonEmpty(field, true)) {
            return null;
        }
        try {
            return cellIterator.getLong(limit);
        } catch (IllegalArgumentException ex) {
            errors.add(ExcelParsingError.limit(cellIterator.getRow(), field, minLimit, limit));
            return null;
        }
    }

    public boolean nextBoolean(String field, String expectedValue) {
        if (advanceAndCheckIfNonEmpty(field, true)) {
            return false;
        }
        try {
            return cellIterator.getBoolean();
        } catch (IllegalArgumentException ex) {
            errors.add(ExcelParsingError.type(cellIterator.getRow(), expectedValue));
            return false;
        }
    }

    public Boolean nextOptionalBoolean(String field, String expectedValue) {
        if (advanceAndCheckIfNonEmpty(field, false)) {
            return false;
        }
        try {
            return cellIterator.getBoolean();
        } catch (IllegalArgumentException ex) {
            errors.add(ExcelParsingError.type(cellIterator.getRow(), expectedValue));
            return false;
        }
    }
}
