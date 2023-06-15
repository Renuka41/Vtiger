package vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesFilePractice {

	public static void main(String[] args) throws Exception {
//open the file in readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.Properties.txt");
//create the object properties class from java.util
		Properties obj = new Properties();
		//load the obj
		obj.load(fis);
		//give the values and read the values
		String BROWSER = obj.getProperty("browser");
		String URL = obj.getProperty("url");
		String USERNAME = obj.getProperty("username");
		String PASSWORD = obj.getProperty("password");
		System.out.println(BROWSER);
		System.out.println(URL);

		System.out.println(USERNAME);

		System.out.println(PASSWORD);

	}

}
