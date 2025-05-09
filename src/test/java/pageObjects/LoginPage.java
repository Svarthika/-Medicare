package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h4[text()='Login']") WebElement txtLoginPresent;
	@FindBy(name="username") WebElement txtEmail;
	@FindBy(name="password") WebElement txtPassword;
	@FindBy(xpath="//input[@class='btn btn-primary']") 	public WebElement btnLogin;
	@FindBy(xpath="//*[@id='username-error']") WebElement invalidEmailError;
	@FindBy(xpath="//*[contains(text(),'invalid!')]") WebElement invalidPassowrd;
	@FindBy(xpath="//*[contains(text(),'Categories')]") WebElement txtCategoriesPresent;
	
	public void setEmail(String Email) {
		txtEmail.sendKeys(Email);
	}
	
	public void SetPassword(String Password) {
		txtPassword.sendKeys(Password);
	}
	
	public void Click_Login() {
		btnLogin.click();
	}
	
	public String invalid_Email() {
		return invalidEmailError.getText();
	}
    public String invalid_Password() {
    	return invalidPassowrd.getText();
	}

	public String Categories_Present() {
		// TODO Auto-generated method stub
		return txtCategoriesPresent.getText();
	}
	

}
