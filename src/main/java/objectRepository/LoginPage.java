package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name="user_name")
	private WebElement userNameEdit;
	@FindBy(name="user_password")
	private WebElement userPasswordEdit;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameEdit() {
		return userNameEdit;
	}

	public WebElement getUserPasswordEdit() {
		return userPasswordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public void Login(String userNameEdit,String userPasswordEdit)
	{

		 getUserNameEdit().sendKeys("admin");
		 getUserPasswordEdit().sendKeys("admin");
		 getLoginBtn().click();
		 
	
	}

}
