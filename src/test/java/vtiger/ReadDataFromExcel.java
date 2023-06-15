package vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws Exception {
		//Open the file in java readable format
FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
//Create the WorkbookFactory
 Workbook wb = WorkbookFactory.create(fise);
 //Get the sheet control
 Sheet sh = wb.getSheet("Organization");
 //Get the row control
 Row row = sh.getRow(1);
 //get the cell control
 Cell cell = row.getCell(0);
 Cell cell1 = row.getCell(1);

 Cell cell2 = row.getCell(2);
 //get the value from cell

 String value = cell.getStringCellValue();
 String value1 = cell1.getStringCellValue();

 String value2 = cell2.getStringCellValue();

 System.out.println(value);
 
 System.out.println(value1);

 System.out.println(value2);

	}

}
