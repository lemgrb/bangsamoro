package com.lemsst.bangsamoro.core.data;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Read more from https://stackoverflow.com/questions/666477/possible-to-pass-parameters-to-testng-dataprovider
 */

public class ExcelDataManager {

    private static final Logger LOGGER = LogManager.getLogger(ExcelDataManager.class.getName());

    private final static String PATH = "src/main/resources/common_test_data/";

    private final static int MINIMUM_COLUMN_COUNT = 4;

    private static String wbName = "";

    public static String getWbName() {
        return wbName;
    }

    public static void setWbName(String wbName) {
        ExcelDataManager.wbName = wbName;
    }

    public static void main(String[] args) throws Exception {
        getTestDataPerSheet("MODULE.xlsx", "TS.001");
    }

    public static Object[][] getTestDataPerSheet(String wbName, String sheetName) throws Exception {
        setWbName(wbName);
        if("".equals(wbName))
            throw new Exception("Please set the workBook name by calling setWbName(String wbName)");
        LOGGER.info("Opening the file");

        OPCPackage pkg = null;
        XSSFWorkbook wb2 = null;
        try {
            pkg = OPCPackage.open(new File(PATH + getWbName()));
            wb2 = new XSSFWorkbook(pkg);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Sheet sheet = wb2.getSheet(sheetName);

        // Decide which rows to process
        int rowStart = 0;
        int rowEnd = sheet.getLastRowNum();

        LOGGER.error("The last row num is " + rowEnd);

        // Instantiate the Object[][] placeholder
        Object[][] testData = new Object[rowEnd+1][];

        // Iterate over the rows

        for (int rowNum = rowStart; rowNum <= rowEnd; rowNum++) {
            Row r = sheet.getRow(rowNum);
            if (r==null)
                break;

            int lastColumn = r.getLastCellNum();

            testData[rowNum] = new Object[lastColumn];
            LOGGER.error("Instantiate testData["+rowNum+"]");

            for (int colNum = 0; colNum < lastColumn; colNum++) {
                Cell c = r.getCell(colNum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                if (c==null) {
                    // Empty cell
                } else {
                    // TODO: Replace with LOGGER
                    // System.out.println("Cell["+rowNum+"]["+colNum+"]=" + c.toString());
                    testData[rowNum][colNum] = c.toString();

                }
            }

        }

        //System.out.println(ReflectionToStringBuilder.toString(testData, ToStringStyle.MULTI_LINE_STYLE));

        pkg.close();

        return testData;
    }

    public static Object[][] convertToArrayOfHashMap(Object[][] testData) {
        // Skip column header
        Object[][] newTestData = new Object[testData.length-1][];

        System.out.println("[TESTDATA]: " + Arrays.deepToString(testData));

        // Skip column header
        for(int i=1; i<testData.length; i++) {
            HashMap<String, String> rowData = new HashMap<String, String>();
            newTestData[i-1] = new Object[1];
            for(int j=0, totalCols=testData[i].length; j<totalCols; j++) {
                rowData.put(testData[0][j].toString(), testData[i][j].toString());
            }
            newTestData[i-1][0] = rowData;
        }

        System.out.println("[CONVERTEDTESTDATA]: " + Arrays.deepToString(newTestData));

        return newTestData;

    }

    public static String normalize(String str) {
        return str.replace("_",".");
    }


    @DataProvider(name="dp")
    public static Object[][] getData(ITestContext i, Method m) throws Exception {
        Object[][] testData = getTestDataPerSheet(i.getCurrentXmlTest().getParameter("DATA_SHEET_NAME"), normalize(m.getName()));
        return convertToArrayOfHashMap(testData);
    }

}
