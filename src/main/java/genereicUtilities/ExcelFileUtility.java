package genereicUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class consists of generic methods related to excel
 * 
 * @author user
 *
 */
public class ExcelFileUtility
/**
 * this method will read data into excel
 * 
 * @param sheet
 * @param row
 * @param cell
 * 
 */
{
	public static String readDataFromExcel(String sheet, int row, int cell) throws Exception {
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row r = sh.getRow(row);
		Cell c = r.getCell(cell);
		String value = c.getStringCellValue();
		wb.close();
		return value;

	}

	/**
	 * this method will write data into excel
	 * 
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param value
	 * @throws Exception
	 */
	public static void writeDataDromExcel(String sheet, int row, int cell, String value) throws Exception 
	{
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.createSheet(sheet).createRow(row).createCell(cell).setCellValue(value);
		FileOutputStream fos = new FileOutputStream(IConstantUtility.excelFilePath);
		wb.write(fos);
		wb.close();

	}

	private static int parseInt(String stringCellValue)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	public Object[][] readMultipleData(String sheetname) throws Exception
	{
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastrow = sh.getLastRowNum();
		 int lastcell = sh.getRow(0).getLastCellNum();
		 Object[][] data=new Object[lastrow][lastcell];
		 for(int i=0;i<lastrow;i++)
		 {
			 for(int j=0;j<lastcell;j++)
			 {
				 data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			 }
		 }
		 
return data;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
