package com.lemsst.bangsamoro.core.data.excel.poisamples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

public class SpreadsheetExample {

    private static final Logger LOGGER = LogManager.getLogger(SpreadsheetExample.class.getName());

    public static void main(String[] args) {
        final String PATH = "src/main/resources/";
        final String FILE_NAME = "MODULE.xlsx";

        // Create Workbook
        Workbook wb = new XSSFWorkbook();

        // Create worksheet
        String sheet1Str = "Sheet*1";
        String sheet2Str = "Sheet^2";
        Sheet sheet1 = wb.createSheet(WorkbookUtil.createSafeSheetName(sheet1Str));
        Sheet sheet2 = wb.createSheet(WorkbookUtil.createSafeSheetName(sheet2Str));

        // --
        CreationHelper creationHelper = wb.getCreationHelper();

        // Create some row and put some cells. Rows are 0 based
        Row row = sheet1.createRow(0);

        // Create cella and put some values
        Cell cell = row.createCell(0);
        cell.setCellValue("It works!");

        // Chained method
        sheet2.createRow(0)
                .createCell(0)
                .setCellValue(creationHelper.createRichTextString("It works!\n Yes!!!"));

        // Date cells / Not formatted as date
        sheet2.createRow(1)
                .createCell(0)
                .setCellValue(new Date());

        // Date cells / Formatted as date
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("dd/mm/yyyy h:mm"));
        Cell sheet2Row1Cell1 = sheet2.createRow(2)
                .createCell(0);
        sheet2Row1Cell1.setCellStyle(cellStyle);
        sheet2Row1Cell1.setCellValue(new Date());

        try {
            OutputStream fileOut = new FileOutputStream(PATH + FILE_NAME);
            // LOGGER.info("Done creating new FileOutputStream to " + FILE_NAME);
            wb.write(fileOut);
            // LOGGER.info("Done writing the file.");
            wb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Yucks. It's done.");

        System.out.println("Opening the file");
        OPCPackage pkg = null;
        XSSFWorkbook wb2 = null;
        try {
            pkg = OPCPackage.open(new File(PATH + FILE_NAME));
            wb2 = new XSSFWorkbook(pkg);

            pkg.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
