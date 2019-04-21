package com.eschool.error;

public class ExcelParsingError {


    private final Integer rowIndex;
    private final String message;

    public ExcelParsingError(String message) {
        this(null, message);
    }

    public ExcelParsingError(Integer rowIndex, String message) {
        this.rowIndex = rowIndex;
        this.message = message;
    }


    public static ExcelParsingError duplicate(int rowIndex, String field) {
        return new ExcelParsingError(rowIndex, field + " must be unique");
    }

    public static ExcelParsingError type(int rowIndex, String expectedType) {
        return new ExcelParsingError(rowIndex, "Invalid value, Please specify " + expectedType);
    }

    public static ExcelParsingError limit(int rowIndex, String field, long minLimit, long expectedLimit) {
        return new ExcelParsingError(rowIndex, field + " value must be within " + minLimit + " to " + expectedLimit);
    }

    public static ExcelParsingError required(int rowIndex, String field) {
        return new ExcelParsingError(rowIndex, RequiredColumnMessage(field));
    }

    public static ExcelParsingError dateFormat(int rowIndex) {
        return new ExcelParsingError(rowIndex, "Invalid Date");
    }

    public static ExcelParsingError alphaNumeric(int rowIndex, String field) {
        return new ExcelParsingError(rowIndex, "Special characters and spaces are not allowed in " + field);
    }


    public static String RequiredColumnMessage(String field) {
        return field + " is required";
    }

    public static ExcelParsingError error(int rowIndex, String field, String expectedType) {
        return new ExcelParsingError(rowIndex, wrongTypeMessage(field, expectedType));
    }

    public static ExcelParsingError tooLongError(int rowIndex, String field, int maxLength) {
        return new ExcelParsingError(rowIndex, field + " must be less than " + maxLength + " characters");
    }

    public static ExcelParsingError tooShortError(int rowIndex, String field, int minLength) {
        return new ExcelParsingError(rowIndex, field + " must be greater than " + minLength + " characters");
    }

    public static ExcelParsingError error(int rowIndex, String message) {
        return new ExcelParsingError(rowIndex, message);
    }

    public static ExcelParsingError missing(int rowIndex, String field) {
        return new ExcelParsingError(rowIndex, missingColumnMessage(field));
    }

    public static String wrongTypeMessage(String field, String expectedType) {
        return "Expected " + expectedType + " for " + field;
    }

    public static String missingColumnMessage(String field) {
        return "Missing column for " + field;
    }

    public static ExcelParsingError invalid(int rowIndex, String field) {
        return new ExcelParsingError(rowIndex, invalid(field));
    }

    private static String invalid(String field) {
        return "Invalid " + field;
    }

    public String getMessage() {
        return message;
    }

    public Integer getRowIndex() {
        return rowIndex;
    }
}