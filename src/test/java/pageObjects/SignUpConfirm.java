package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpConfirm extends BaseClass{
	WebDriver driver;
		public SignUpConfirm(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		
		@FindBy(css = "a[class='btn btn-lg btn-primary']")
		public WebElement btnFinalConfirm;
		@FindBy(css= "a[href=\"/medicare3/membership?execution=e1s3&_eventId_billing\"]") 
		 WebElement btn_EditBillingAddress;
		@FindBy(css= "a[href='/medicare3/membership?execution=e1s3&_eventId_personal']") 
		 WebElement btn_EditPersonalAddress;		
		@FindBy(xpath="//h1[contains(text(),'Welcome!')]")WebElement txtWelcome;
		@FindBy(xpath="//a[@href='/medicare3/login')]")WebElement btnLogin;
		
		public void click_FinalConfirm() {
			btnFinalConfirm.click();
		}
public void click_EditPersonal() {
	btn_EditPersonalAddress.click();
		}
public void click_EditBilling() {
	btn_EditBillingAddress.click();
	}

public String Validate_SingupConfirmMessage() {
	return txtWelcome.getText();
	
}

public void Confirmpage_Login() {
	btnLogin.click();
	
}

		
		
		


	
	
	

}