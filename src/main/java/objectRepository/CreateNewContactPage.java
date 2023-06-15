package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import genereicUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{

	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="lastname")private WebElement lastName;
	public WebElement getLastName() {
		return lastName;
	}
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@alt='Select']")private WebElement OrgLookUpImag;
	////td[@name='related_to_display']/following-sibling::img[@src='themes/softed/images/select.gif']
    @FindBy(name="search")private WebElement searchBtn;
    @FindBy(name="search_text")private WebElement searchEdit;
   // @FindBy(xpath="//a[.='\" + ORGNAME + \"']") private WebElement orgname;
    
    @FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	//public WebElement getOrgname() {
	//	return orgname;
//	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getOrgLookUpImag() {
		return OrgLookUpImag;
	}
public WebElement getSaveBtn() {
		return saveBtn;
	}
public WebElement getSearchEdit() {
	return searchEdit;
}
public void createContact(WebDriver driver ,String lastname,String Orgname)
	
	{
	 lastName.sendKeys(lastname);
	 OrgLookUpImag.click();
switchToWindow(driver,"Accounts");
searchEdit.sendKeys(Orgname);
searchBtn.click();
driver.findElement(By.xpath("//a[.='" + Orgname + "']")).click();

switchToWindow(driver,"Contacts");
saveBtn.click();



	}


	
}
