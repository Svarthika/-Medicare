package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage extends BaseClass{
	
	
	public homePage(WebDriver driver){
		super(driver);
		}
		
	@FindBy(css = "a[href='/medicare3/membership']") WebElement lnkSignUp ;
	@FindBy(css = "a[href='/medicare3/login']") WebElement lnkLogin ;
	@FindBy(xpath= "//*[contains(text(),'Medicare - Home')]") WebElement pageTitle ;
	
	public void validateHomePage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Medicare - Home')]")));
	}
	public void signUp() {
		
		lnkSignUp.click();
	}
	

	public void Login()  
	{
		
		lnkLogin.click();
	}
	
	}
