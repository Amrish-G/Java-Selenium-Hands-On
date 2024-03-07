package Base;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.soap.SOAPArrayType;

import net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForGivenType;

public class utils {
	
	public static String[][] readData() throws IOException{
		
		String fileLocation = "./Test-Data/TestData.xlsx" ;
		XSSFWorkbook wbook = new XSSFWorkbook(fileLocation);
		XSSFSheet sheet = wbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		String[][] testData = new String[rowCount][colCount];
		for(int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j = 0; j< colCount; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter formatValue = new DataFormatter();
				testData[i-1][j] = formatValue.formatCellValue(cell);
			}
		}
		wbook.close();
		return testData;
	}
	
	public static String[][] propetyFileData() throws FileNotFoundException, IOException {
		Properties property = new Properties();
		property.load(new FileInputStream("./propertyTestData.properties"));
		String[][] loginData = new String[1][2];
		loginData[0][0] = property.getProperty("username");
		loginData[0][1] = property.getProperty("password");
		return loginData;
	}
	
	public static char[] bubblesort(char[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length - 1 -i; j++) {
				if (arr[j]>arr[j+1]) {
					char temp = arr[j];
					arr[j]= arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
	
	public static boolean anagramCheck(char[] arr_1, char[] arr_2) {
		if (arr_1.length == arr_2.length){
			for (int i = 0; i<arr_1.length; i++) {
				if (arr_1[i] == arr_2[i]) {
					return true;
				}
				else {
					break;
				}
			}
		}
		return false;
	
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		propetyFileData();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter str_1 : ");
		String str_1 = sc.next();
		System.out.println("Enter str_2 : ");
		String str_2 = sc.next();
		char [] ch_1 = str_1.toLowerCase().toCharArray();
		char [] ch_2 = str_2.toLowerCase().toCharArray();
		bubblesort(ch_1);
		bubblesort(ch_2);
		if(anagramCheck(ch_1, ch_2)) {
			System.out.println("Given strings are anagram");
		}else {
			System.out.println("Given strings are not anagram");
		}
	}
}


