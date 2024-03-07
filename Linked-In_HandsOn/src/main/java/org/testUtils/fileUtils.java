package org.testUtils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class fileUtils {

    @DataProvider(name = "login-credentials")
    public static String[][] readExcelData() throws IOException {
        String fileLocation = "./TestData/TestData.xlsx";
        XSSFWorkbook wbook = new XSSFWorkbook(fileLocation);
        XSSFSheet sheet = wbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        int cellCount = sheet.getRow(0).getLastCellNum();
        String test_Data[][] = new String[rowCount][cellCount];
        for (int i = 1; i <= rowCount; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < cellCount; j++) {
                XSSFCell cell = row.getCell(j);
                DataFormatter dft = new DataFormatter();
                test_Data[i-1][j] = dft.formatCellValue(cell);
            }
        }
        return test_Data;
    }

    public static String readPropertyFile() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("./TestData/PropertyFile.properties"));
        String propertyData = properties.getProperty("URL");
        return propertyData;
    }

}
