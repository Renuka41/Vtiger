package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactLookUpImage
{
 public ContactLookUpImage(WebDriver driver) {
	 PageFactory.initElements(driver, this);
 }
 
	//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
 
 @FindBy(xpath="//img[@alt='Create Contact...']")private WebElement ContactLookUpImg;

public WebElement getContactLookUpImg() {
	return ContactLookUpImg;
}
 public void clickContactLookUpImg()
 {
	 ContactLookUpImg.click();
 }
 
}
