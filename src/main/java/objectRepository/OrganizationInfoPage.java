package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage 
{

	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;

	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}
public String getOrgHeader()
{
	return OrgHeaderText.getText();
}
	
}
