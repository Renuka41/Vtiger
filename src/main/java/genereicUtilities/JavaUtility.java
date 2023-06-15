package genereicUtilities;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber()
	{
		Random r=new Random();
		return r.nextInt();
		
	}
	/**
	 * this method will get system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d =new Date();
		return d.toString();
	}

	/**
	 * this method will generate system date in required format
	 * @return
	 */
	public static  String getSystemFormat()
	{
		Date d =new Date();
String[] Darray = d.toString().split(" ");
String date = Darray[2];
String month = Darray[1];
String year = Darray[5];
String time=Darray[3].replace(":", "-");
return date+" "+month+" "+year+" "+time;

		
	}
}
