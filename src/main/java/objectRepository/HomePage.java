package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genereicUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{

	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsEdit;
	@FindBy(linkText="Contacts")
	private WebElement ContactsEdit;
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesEdit;
	@FindBy(linkText="Products")
	private WebElement ProductsEdit;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement AdminstratorImg;
	@FindBy(linkText="Sign Out")
	private WebElement SignOut;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getOrganizationsEdit() {
		return OrganizationsEdit;
	}


	public WebElement getContactsEdit() {
		return ContactsEdit;
	}


	public WebElement getOpportunitiesEdit() {
		return OpportunitiesEdit;
	}


	public WebElement getProductsEdit() {
		return ProductsEdit;
	}
	public WebElement getAdminstratorImg() {
		return AdminstratorImg;
	}


	public void setAdminstratorImg(WebElement adminstratorImg) {
		AdminstratorImg = adminstratorImg;
	}


	public WebElement getSignOut() {
		return SignOut;
	}


	public void setSignOut(WebElement signOut) {
		SignOut = signOut;
	}


	public void clickOrganizationLink()
	{
		OrganizationsEdit.click();
	}
	public void clickContactsLink()
	{
		ContactsEdit.click();
	}
	public void logOutApp(WebDriver driver)
	{
	   mouseHoverAction(driver,AdminstratorImg);
		SignOut.click();
	}

}
