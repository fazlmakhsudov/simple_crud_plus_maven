package com.example.util;


import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * This class executes read, write data to excel file
 */

public class XlsHandler {
    private static List<List<Object>> xlsSheet;

    public static List<List<Object>> getXlsSheet() {
        return xlsSheet;
    }

    public static void setXlsSheet(List<List<Object>> xlsSheet) {
        XlsHandler.xlsSheet = xlsSheet;
    }

    public static void readXlsSourceFile(File sourceFile) {
        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(sourceFile));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;
            HSSFCell cell;
//            int rows = 7; // No of rows
            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells(); // No of columns
            for (int r = 0; r < rows; r++) {
                row = sheet.getRow(r);
                if (row != null) {
                    xlsSheet.add(new ArrayList<>());
                } else {
                    continue;
                }
                List<Object> currentRaw = xlsSheet.get(r);
                if (row != null) {
                    for (int c = 0; c < cols; c++) {
                        cell = row.getCell(c);
                        currentRaw.add(cell.toString());
                    }
                }
            }
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
    }

    public static void printXlsSourceFile() {
        for (List<Object> row : xlsSheet) {
            System.out.println(row.get(2) + " " + row.get(9) + " " + row.get(10) + " " + row.get(16) + " ");
        }
    }

    public static void writeXlsOutputFile(String sheetName, File sourceFile, boolean sourcefileFlag) {
        HSSFCell cell;
        HSSFRow row;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet(sheetName);
            HSSFFont font = workbook.createFont();
            font.setBold(true);
            font.setItalic(true);
            font.setFontHeight((short) 240);
            HSSFCellStyle style = workbook.createCellStyle();
            style.setFont(font);
            for (int rowIndex = 0; rowIndex < xlsSheet.size(); rowIndex++) {
                row = sheet.createRow(rowIndex);
                List<Object> currentRow = xlsSheet.get(rowIndex);
                for (int cellIndex = 0; cellIndex < currentRow.size(); cellIndex++) {
                    cell = row.createCell(cellIndex, CellType.STRING);
                    cell.setCellValue(currentRow.get(cellIndex).toString());
                    if (rowIndex == 0) cell.setCellStyle(style);
                }
            }
            if (sourcefileFlag) {
                workbook.write(new FileOutputStream(sourceFile));
            } else {
                workbook.write(new FileOutputStream(sourceFile.getParentFile().getPath() + "/" + "copy" +
                        sourceFile.getName()));
            }

        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
    }
}
