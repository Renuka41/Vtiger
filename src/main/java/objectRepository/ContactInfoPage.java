package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
/*
 * Step 17: Validate for Organization
		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (ContactHeader.contains(LASTNAME)) {
			System.out.println(ContactHeader);
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
 */
	
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")private WebElement ContactHeader;
	public WebElement getContactHeader() {
		return ContactHeader;
	}
	public String conatctHeader()
	{
		return ContactHeader.getText();
	}
	
	
	
}
