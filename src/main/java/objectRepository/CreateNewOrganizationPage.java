package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genereicUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement OrgName;
	@FindBy(name="industry")
	private WebElement IndustryDropDown;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getOrgName() {
		return OrgName;
	}

	public WebElement getIndustry() {
		return IndustryDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createNewOrganization(String ORGNAME)
	{
		OrgName.sendKeys(ORGNAME);
		saveBtn.click();
	}
	public void createNewOrganizationWithIndustry(String ORGNAME,String INDUSTRY)
	{
		OrgName.sendKeys(ORGNAME);
		handleDropDown(IndustryDropDown,INDUSTRY);
		saveBtn.click();
	}
	

}
