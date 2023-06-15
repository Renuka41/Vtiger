package vtiger;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
import java.time.Duration;
	import java.util.Properties;
	import java.util.Random;

	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;





import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import genereicUtilities.ExcelFileUtility;
import genereicUtilities.IConstantUtility;
import genereicUtilities.JavaUtility;
import genereicUtilities.PropertyFileUtility;
import genereicUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationPage;

public class CreateOrganizationIndustryTest 
{
	@Test
public void Demo()
{
	System.out.println("Demo executed");
}
		@Test
		public void  CreateOrganizationIndustryTest() throws Exception {
			
			Random ran = new Random();
			int random = ran.nextInt(1000);
			
			//FileInputStream fisp = new FileInputStream(IConstantUtility.propertyFilePath);
			PropertyFileUtility pUtil=new PropertyFileUtility();
			ExcelFileUtility eUtil=new ExcelFileUtility();
			WebDriverUtility wUtil=new WebDriverUtility();
			JavaUtility jUtil=new JavaUtility();
			WebDriver driver =null;
			/*Read all the required Data*/
System.out.println(pUtil.readDataFromPropertyFile("url"));




System.out.println(",,,,,,,,,,,,,,,,,,,,,");
			String BROWSER = pUtil.readDataFromPropertyFile("browser");
			String URL  = pUtil.readDataFromPropertyFile("url");

			String USERNAME = pUtil.readDataFromPropertyFile("username");

			String PASSWORD = pUtil.readDataFromPropertyFile("password");

			//System.out.println(value);
			/*Properties p = new Properties();
			p.load(fisp);
			String BROWSER = p.getProperty("browser");
			String URL = p.getProperty("url");
			String USERNAME = p.getProperty("username");
			String PASSWORD = p.getProperty("password");
			*/
			
			
			String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
			String INDUSTRY=eUtil.readDataFromExcel("Organization", 4, 3);
			/*
			FileInputStream fise = new FileInputStream(IConstantUtility.excelFilePath);
			Workbook wb = WorkbookFactory.create(fise);
			Row rw = wb.getSheet("Organization").getRow(4);
			String ORGNAME = rw.getCell(2).getStringCellValue()+random;
			String INDUSTRY = rw.getCell(3).getStringCellValue();
			*/
			//Step 1: launch the browser
			if(BROWSER.equalsIgnoreCase("edge"))
			{
				 EdgeOptions opt = new EdgeOptions();

			opt.addArguments("--remote-allow-origins=*");
			driver=new EdgeDriver(opt);
			
			
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				FirefoxOptions opt1=new FirefoxOptions();
				opt1.addArguments("--remote-allow-origins=*");
				driver=new FirefoxDriver(opt1);


			}
			else if(BROWSER.equalsIgnoreCase("chrome"))
			{
				ChromeOptions opt=new ChromeOptions();
				opt.addArguments("--remote-allow-origins=*");
				driver=new ChromeDriver(opt);
			}
		
			else
			{
				System.out.println("invalid browser");
			}
			
			
			wUtil.maximizeWindow(driver);
			wUtil.waitForPageLoad(driver);
			/*
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));*/
			driver.get(URL);
			
			LoginPage lp = new LoginPage(driver);
			lp.Login(USERNAME, PASSWORD);

			// Step 3: Click on Organizations link
			HomePage hp = new HomePage(driver);
			hp.clickOrganizationLink();

			// Step 4: Click on Create Org Look Up Image
			OrganizationPage op = new OrganizationPage(driver);
			op.oragnizationLookUpImg();

			// Step 5: Create Organization with mandatory fields
			CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			cnop.createNewOrganizationWithIndustry(ORGNAME, INDUSTRY);

			// Step 8: Validate
			OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			String orgHeader = oip.getOrgHeader();

			if (orgHeader.contains(ORGNAME)) {
				System.out.println(orgHeader);
				System.out.println("Test Script Passed");
			} else {
				System.out.println("FAIL");
			}

			// Step 9: Logout of App
			hp.logOutApp(driver);
			System.out.println("Logout is scuccessful");
		}
			
			
			
			
			
			
			
		}

	


