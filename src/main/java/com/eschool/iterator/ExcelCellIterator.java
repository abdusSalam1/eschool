package com.eschool.iterator;


import com.google.common.collect.Iterators;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import java.util.Iterator;

public class ExcelCellIterator implements Iterator<Cell> {

    private final Iterator<Cell> cellIterator;
    private Cell currentCell;
    private Cell nextCell;
    private int columnIndex = -1;

    public ExcelCellIterator(Iterator<Cell> cellIterator) {
        this.cellIterator = cellIterator;
    }

    public Cell next() {
        columnIndex++;
        if (nextCell == null && cellIterator.hasNext()) {
            nextCell = cellIterator.next();
        }
        if (columnIndex > nextCell.getColumnIndex() && cellIterator.hasNext()) {
            nextCell = cellIterator.next();
        }
        if (columnIndex == nextCell.getColumnIndex()) {
            currentCell = nextCell;
        } else {
            currentCell = null;
        }
        return currentCell;
    }

    @Override
    public boolean hasNext() {
        return cellIterator.hasNext() || (nextCell != null && columnIndex < nextCell.getColumnIndex());
    }

    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    public String getString() {
        return getString(currentCell);
    }

    private String getString(Cell cell) {
        if (cell == null) {
            return null;
        }
        if (cell.getCellType() == CellType.BLANK) {
            return String.valueOf((long) cell.getNumericCellValue()).trim();
        }
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue().trim();
        }
        return null;
    }

    public Long getLong() {
        if (isEmptyCell()) {
            return null;
        }
        if (currentCell.getCellType() == CellType.NUMERIC) {
            return (long) currentCell.getNumericCellValue();
        }
        return null;
    }

    public Long getLong(long limit) throws IllegalArgumentException {
        if (isEmptyCell()) {
            return null;
        }
        if (currentCell.getCellType() == CellType.NUMERIC && (long) currentCell.getNumericCellValue() <= limit) {
            return (long) currentCell.getNumericCellValue();
        } else {
            throw new IllegalArgumentException();
        }
    }


    public Boolean getBoolean() throws IllegalArgumentException {
        if (isEmptyCell()) {
            return null;
        }
        if (currentCell.getCellType() == CellType.STRING && currentCell.getStringCellValue().matches("^(?:Yes|No|no|NO|YES|yes)")) {
            String value = StringUtils.upperCase(currentCell.getStringCellValue());
            return StringUtils.equalsIgnoreCase("Yes", value);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Iterator<String> asStringIterator() {
        return Iterators.transform(this, cell -> getString(cell));
    }

    public int getRow() {
        return nextCell.getRowIndex();
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public boolean isEmptyCell() {
        return currentCell == null || currentCell.getCellType() == CellType.BLANK;
    }

}
