package vtiger;
import java.time.Duration;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
public class CreateOrganizationWithIndustry {

	public static void main(String[] args) {



			
			Random ran = new Random();
			int r = ran.nextInt(1000);
			
			//Step 1: launch the browser
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			WebDriver driver=new ChromeDriver(opt);
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get("http://localhost:8888/");
			
			//Step 2: Login to Application
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			System.out.println("Login successful");
			
			//Step 3: Click on Organizations link
			driver.findElement(By.linkText("Organizations")).click();
			
			//Step 4: Click on Create Org Look Up Image
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
			//Step 5: Create Organization with mandatory fields
			driver.findElement(By.name("accountname")).sendKeys("landMark"+r);
			
			//Step 6: Choose 'Chemicals' on Industry drop-down
			WebElement industrydropdown = driver.findElement(By.name("industry"));
			Select sel = new Select(industrydropdown);
			sel.selectByValue("Chemicals");
			
			//Step 7: Save
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//Step 8: Validate
			String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(orgHeader.contains("landMark"))
			{
				System.out.println(orgHeader);
				System.out.println("Test Script Passed");
			}
			else
			{
				System.out.println("FAIL");
			}
			
			//Step 9: Logout of App
			WebElement adImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act = new Actions(driver);
			act.moveToElement(adImg).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			System.out.println("Logout is scuccessful");
			
			
			
			
			
			
			
			
			
			
			
		}

	}