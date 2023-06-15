package genereicUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClasses
{
	public PropertyFileUtility	pUtil= new PropertyFileUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public JavaUtility jUtil=new JavaUtility();
	
	public WebDriver driver=null;
	public static WebDriver sDriver;

	private String USERNAME;
	
	
@BeforeSuite(groups={"SmokeSuite","RegressionSuite"})
public void bsConfig()
{
	System.out.println("=====DB CONNECTION SUCCESSFULL======");
}
//@Parameters("browser")it is used only in cross browser execution 
//@BeforeTest it is used only parallel execution 
@BeforeClass(alwaysRun=true)
public void bsLaunchBrowser(/*String BROWSER*/) throws Exception
{
	
	
	String BROWSER = pUtil.readDataFromPropertyFile("browser");
	String URL=pUtil.readDataFromPropertyFile("url");
	if(BROWSER.equalsIgnoreCase("edge"))
	{
		 EdgeOptions opt = new EdgeOptions();

	opt.addArguments("--remote-allow-origins=*");
	driver=new EdgeDriver(opt);
	System.out.println(BROWSER+":========LAUNCH THE  EDGE BROWSER==========");

	
	
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		FirefoxOptions opt1=new FirefoxOptions();
		opt1.addArguments("--remote-allow-origins=*");
		driver=new FirefoxDriver(opt1);
		System.out.println(BROWSER+":========LAUNCH THE FIREFOXBROWSER==========");


	}
	else if(BROWSER.equalsIgnoreCase("chrome"))
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(opt);
		System.out.println(BROWSER+":========LAUNCH THE CHROME BROWSER==========");

	}

	else
	{
		System.out.println("invalid browser");
	}
	
	sDriver=driver;

	wUtil.maximizeWindow(driver);
	wUtil.waitForPageLoad(driver);
	
	driver.get(URL);
}


@BeforeMethod(groups={"SmokeSuite","RegressionSuite"})
public void bmLoginApp() throws Exception

{
	String USERNAME=pUtil.readDataFromPropertyFile("username");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	LoginPage lp=new LoginPage(driver);
	lp.Login(USERNAME, USERNAME);
}

@AfterMethod(groups={"SmokeSuite","RegressionSuite"})
public void amLogoutApp()

{
	HomePage hp=new HomePage(driver);
	hp.logOutApp(driver);
}
//@AfterClass
@AfterClass(groups={"SmokeSuite","RegressionSuite"})
public void asLaunchBrowser()
{
	driver.quit();
	System.out.println("========BROWSER CLOSED SUCCESSFULLY==========");
	
	

}



@AfterSuite(groups={"SmokeSuite","RegressionSuite"})
public void asConfig()
{
	System.out.println("=====DB CONNECTION CLOSED SUCCESSFULL======");

}
}
