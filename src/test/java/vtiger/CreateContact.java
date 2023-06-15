package vtiger;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import genereicUtilities.ExcelFileUtility;
import genereicUtilities.JavaUtility;
import genereicUtilities.PropertyFileUtility;
import genereicUtilities.WebDriverUtility;

public class CreateContact {

	public static void main(String[] args) throws Exception {
PropertyFileUtility pUtil=new PropertyFileUtility();
ExcelFileUtility eUtil=new ExcelFileUtility();
JavaUtility jUtil= new JavaUtility();
WebDriverUtility wUtil=new WebDriverUtility();
String BROWSER = pUtil.readDataFromPropertyFile("browser");
String USERNAME = pUtil.readDataFromPropertyFile("username");
String PASSWORD = pUtil.readDataFromPropertyFile("password");
String URL = pUtil.readDataFromPropertyFile("url");
String LASTNAME = eUtil.readDataFromExcel("Contact", 1, 2);
WebDriver driver=null;
ChromeOptions opt=new ChromeOptions();
opt.addArguments("--remote-allow-origins=*");
driver=new ChromeDriver(opt);
//Login the application
driver.get(URL);
wUtil.maximizeWindow(driver);
wUtil.waitForPageLoad(driver);
driver.findElement(By.name("user_name")).sendKeys(USERNAME);
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
driver.findElement(By.id("submitButton")).click();
System.out.println("Login successful");

driver.findElement(By.linkText("Contacts")).click();
driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
driver.findElement(By.xpath("//input[@name=\'button\']")).click();
System.out.println("saved the last name");
Thread.sleep(3000);

WebElement signout = driver.findElement(By.xpath("//img[@src=\'themes/softed/images/user.PNG\']"));
wUtil.mouseHoverAction(driver, signout);
driver.findElement(By.xpath("//a[.=\"Sign Out\"]")).click();

System.out.println("logout sucessful");
}

}
