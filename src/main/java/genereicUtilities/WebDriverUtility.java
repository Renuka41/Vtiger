package genereicUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;
import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * This method will maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * * This method will minimize the window
	 * 
	 * @param driver
	 */
	public void minimizeWndow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * * This method will wait for page to load for 20 the seconds
	 * 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	/*
	 * * * This method will wait for particular element to load for 10 the seconds
	 * 
	 */
	public void waitForElementtobeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void waitForElementtobeVisible(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * * this method will perform the dropdown action by using index value
	 * 
	 * @param element
	 * @param index
	 */

	public void handleDropDown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);

	}

	/**
	 * this method will perform the dropdown action by using string value
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);

	}

	/**
	 * * this method will perform the dropdown action by using visible value
	 * 
	 * @param visibleText
	 * @param element
	 */
	public void handleDropDown(String visibleText, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);

	}

	/**
	 * * this method will perform the mouse over action
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * * this method will perform the right click action any where on webpage
	 * 
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();

	}

	/**
	 * this method will perform the right click action particular element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();

	}

	/**
	 * this method will perform the double click action any where on webpage
	 * 
	 * @param driver
	 */

	public void doubleClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	/**
	 * this method will perform the double click action on particular element
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * this method will drag and drop from src element to target element
	 * 
	 * @param driver
	 * @param srcElement
	 * @param targetElement
	 */
	public void dropAndDrogAction(WebDriver driver, WebElement srcElement, WebElement targetElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, targetElement).perform();
	}

	/**
	 * this method will drag and drop from src element to target element off values
	 * 
	 * @param driver
	 * @param src
	 * @param x
	 * @param y
	 */
	public void dropAndDrogAction(WebDriver driver, WebElement src, int x, int y) {
		Actions act = new Actions(driver);
		act.dragAndDropBy(src, x, y).perform();
	}

	/**
	 * this method will handle frame by index
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * this method will handle frame by name Or Id
	 * 
	 * @param driver
	 * @param nameOrId
	 */
	public void switchTOFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	/**
	 * this method will handle frame by web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void SwitchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * this method will switch the control from child frame to immediate parent
	 * 
	 * @param driver
	 */
	public void switchtoParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * this method will switch to control from child from to default frame
	 * 
	 * @param driver
	 */
	public void swithToDefaultFrame(WebDriver driver) {

		driver.switchTo().defaultContent();
	}

	/**
	 * this method will accept the alert pop-up
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * this method will dismiss the alert pop-up
	 * 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * this method will accept and return the text value
	 * 
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	/**
	 * this method will take the screenshot and return the absolute value
	 * 
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws Exception
	 */
	public String takeScreenShot(WebDriver driver, String screenShotName) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots\\" + screenShotName + ".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath();// used to extend to report

	}

	/**
	 * this methos will used to scroll down the page
	 * 
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("windows.scrollBy(0,500)", null);
	}

	public void switchToWindow(WebDriver driver,String partialWindowTitle)
     {
	//Step1: Capture all the windows IDs
	Set<String> winIds = driver.getWindowHandles();
	
	//Step 2:Navigate to each browser
	for(String winId:winIds)
	{
	//Step3:capture the title of each window
		String actTitle=driver.switchTo().window(winId).getTitle();
		//step 4:compare the title
		if(actTitle.contains(partialWindowTitle))
		{
			break;
		}
	
	}}





}
