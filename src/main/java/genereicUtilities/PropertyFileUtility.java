package genereicUtilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
/**
 * this class consists of generic methods related to property file
 * @author Renuka
 *
 */
public class PropertyFileUtility {

/**
 * this method will read the data from propertify file and return value to caller
 * @param key
 * @return
 * 
 * @throws Exception 
 * 
 */
		public static  String readDataFromPropertyFile(String key) throws Exception
		
		{
			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.Properties.txt");
			Properties pobj=new Properties();
			pobj.load(fis);
			String value = pobj.getProperty(key);
			return value;
			
			
			
			

		}
	}


