package vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import genereicUtilities.ExcelFileUtility;
import genereicUtilities.JavaUtility;
import genereicUtilities.PropertyFileUtility;
import genereicUtilities.WebDriverUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactLookUpImage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationPage;

public class EndtoEnd {

	public static void main(String[] args) throws Exception {

		// Create all the objects of All Utilities
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();

		WebDriver driver = null;

		/* Read all the required Data */
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL  = pUtil.readDataFromPropertyFile("url");

		String USERNAME = pUtil.readDataFromPropertyFile("username");

		String PASSWORD = pUtil.readDataFromPropertyFile("password");


		String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2) + jUtil.getRandomNumber();
		String INDUSTRY = eUtil.readDataFromExcel("Organization", 4, 3);
		String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);

		// Step 1: launch the browser - Run Time Polymorphism
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
		driver.get(URL);

		// Step 2: Login to Application
		
		LoginPage lp=new LoginPage(driver);
		lp.Login(USERNAME, PASSWORD);
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		System.out.println("Login successful");*/

		// Step 3: Click on Organizations link
		HomePage hp=new HomePage(driver);
		hp.clickOrganizationLink();
		//driver.findElement(By.linkText("Organizations")).click();

		// Step 4: Click on Create Org Look Up Image
		OrganizationPage op=new OrganizationPage(driver);
		op.oragnizationLookUpImg();
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		// Step 5: Create Organization with mandatory fields
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNewOrganizationWithIndustry(ORGNAME, INDUSTRY);
		//cnop.createNewOrganization(ORGNAME);
				//driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

				// Step 6: Save Organization
				//cnop.getSaveBtn();
				//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

				// Step 8: Validate for Organization
				//String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		

		if (orgHeader.contains(ORGNAME)) {
			System.out.println(orgHeader);
			System.out.println("Organization Created");
		} else {
			System.out.println("FAIL");
		}
		hp.clickContactsLink();
		// Step 9: Navigate to Contacts link
		ContactLookUpImage clp=new ContactLookUpImage(driver);
		clp.clickContactLookUpImg();
		
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		cnp.createContact(driver,LASTNAME,ORGNAME);
		
		/*driver.findElement(By.linkText("Contacts")).click();
		// Step 10: click on create contact look up Image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// Step 11: Create Contact
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		// Step 12: Click on Organization Look Up Image
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();

		// Step 13: Switch the control to child window
		wUtil.switchToWindow(driver, "Accounts");

		// Step 14: search for the required Organization Infosys123
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);

		driver.findElement(By.name("search")).click();

		driver.findElement(By.xpath("//a[.='" + ORGNAME + "']")).click();
		// a[.='Infosys123']

		// Step 15: switch the control back to main window
		wUtil.switchToWindow(driver, "Contacts");

		// Step 16: Save the contact - No such Element Exception
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 17: Validate for Organization
		 
		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (ContactHeader.contains(LASTNAME)) {
			System.out.println(ContactHeader);
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
		*/
		ContactInfoPage cip=new ContactInfoPage(driver);
		String ContactHeader = cip.conatctHeader();
		if (ContactHeader.contains(LASTNAME)) {
			System.out.println(ContactHeader);
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
		//Step 18: Logout of App
		WebElement adImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, adImg);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout is scuccessful");

	}

	}


