package com.eschool.parser;

import com.eschool.iterator.ExcelCellIterator;

public interface ExcelRowParser {

    void parse(ExcelCellIterator excelCellIterator);
}
