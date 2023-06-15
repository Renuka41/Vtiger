package vtiger;

import genereicUtilities.ExcelFileUtility;
import genereicUtilities.JavaUtility;
import genereicUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Exception {
		PropertyFileUtility pUtil=new PropertyFileUtility();
		String value = pUtil.readDataFromPropertyFile("url");
		System.out.println(value);
		ExcelFileUtility eUtil= new ExcelFileUtility();
		String data = eUtil.readDataFromExcel("Organization", 1, 2);
		System.out.println(data);
		// eUtil.writeDataDromExcel("Trial", 0, 0, "TC_07");
		// System.out.println("data added");
		 JavaUtility jUtil=new JavaUtility();
		int random = jUtil.getRandomNumber();
		System.out.println( jUtil.getSystemDate());
		System.out.println(jUtil.getSystemFormat());
		
	}

}
