package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage extends BaseClass{
	
	
	public homePage(WebDriver driver){
		super(driver);
		}
		
	@FindBy(css = "a[href='/medicare3/membership']") WebElement lnkSignUp ;
	@FindBy(css = "a[href='/medicare3/login']") WebElement lnkLogin ;
	
	public void signUp() {
		lnkSignUp.click();
	}
	
	public void Login() {
		lnkLogin.click();
	}
	
	}
