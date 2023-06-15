package vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataFromExcel {

	public static void main(String[] args) throws Exception {
		//open the file readable format
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//crete the workbookfactory
		 Workbook wb = WorkbookFactory.create(fise);
		 //get the sheet control 
		 Sheet sh = wb.getSheet("Organization");
		 //Create the row
		 Row row = sh.createRow(7);
		 //create the cell
		 Cell cell = row.createCell(0);
		 Cell cell1 = row.createCell(1);
		 Cell cell2 = row.createCell(2);
//set the cell value
	 cell.setCellValue("TC-ID");
	 cell1.setCellValue("TC-	Name");

	 cell2.setCellValue("OrgName");

	 FileOutputStream fos= new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	 wb.write(fos);
	 System.out.println("Data Written");
	 wb.close();
	}

}
