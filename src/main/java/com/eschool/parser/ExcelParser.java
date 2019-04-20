package com.eschool.parser;

import com.eschool.iterator.ExcelCellIterator;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public abstract class ExcelParser {

    public abstract void parse(InputStream inputStream, ExcelRowParser rowParser) throws IOException;

    protected void parseFile(InputStream inputStream, int columnCount, int sheetNo, ExcelRowParser rowParser) throws IOException {
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(sheetNo);
        Iterator<Row> rowIterator = sheet.iterator();
        if (rowIterator.hasNext()) {
            rowIterator.next();
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (isNonEmptyRow(row,columnCount)) {
                Iterator<Cell> cellIterator = row.cellIterator();
                if (cellIterator.hasNext()) {
                    rowParser.parse(new ExcelCellIterator(cellIterator));
                }
            }
        }
    }

    public boolean isNonEmptyRow(Row row, int columnCount) {
        for (int i = 0; i <= columnCount; i++) {
            if (row.getCell(i) != null && StringUtils.isNoneBlank(row.getCell(i).toString())) {
                return true;
            }
        }
        return false;
    }
}
