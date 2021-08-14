package io.pragra.framework.data;

import io.pragra.framework.conf.Config;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {
    private Workbook workbook;
    private List<Object[]> data = new ArrayList<>();

    public ExcelReader(){
        try {
            InputStream stream = new FileInputStream(Config.getProperty("excel.location"));
            workbook = new XSSFWorkbook(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public List<Object[]> getExcelData(boolean skipHead){
        Sheet contact = workbook.getSheet("Contact");
        Iterator<Row> rowIterator = contact.rowIterator();
        if(skipHead) {
            rowIterator.next();
        }
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            List<Object> celldata = new ArrayList<>();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                if ( cell.getCellType()== CellType.STRING) {
                    celldata.add(cell.getStringCellValue());
                }
                if ( cell.getCellType()== CellType.NUMERIC) {
                    celldata.add(cell.getNumericCellValue());
                }
                if ( cell.getCellType()== CellType.BOOLEAN) {
                    celldata.add(cell.getBooleanCellValue());
                }
            }
            data.add(celldata.toArray());
        }

        return data;

    }
}
