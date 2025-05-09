package testCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseTestCase.BaseTestClass;
import io.reactivex.rxjava3.functions.Action;
import pageObjects.LoginPage;
import pageObjects.homePage;

public class TC_Invalid_Valid_Login_Credentials extends BaseTestClass{
	WebDriver driver;
	
		
@Test

public void Invalid_Email() {
    homePage home =new homePage(driver);
	LoginPage login = new LoginPage(driver);
	home.Login();
	login.setEmail("aaa");
	Actions ac = new Actions(driver);
	ac.click().build().perform();
	
	String invalid_email = login.invalid_Email();
	//assert.assertEquals(invalid_email, "Please enter a valid email address!");
	Assert.assertEquals(invalid_email, "Please enter a valid email address!");
		
	}

@Test

public void Invalid_Password() {

	homePage home =new homePage(driver);
	LoginPage login = new LoginPage(driver);
	home.Login();
	login.setEmail("Test5@gmail.com");
	login.SetPassword("sdsd1");
	login.Click_Login();
	String invalid_password = login.invalid_Password();
	//assert.assertEquals(invalid_email, "Please enter a valid email address!");
	Assert.assertEquals(invalid_password, "Username and Password is invalid!");
		
	}
@Test
public void valid_Credentials() {

	homePage home =new homePage(driver);
	LoginPage login = new LoginPage(driver);
	home.Login();
	login.setEmail("Test5@gmail.com");
	login.SetPassword("Test@123");
	login.Click_Login();
	String Categories = login.Categories_Present();
	//assert.assertEquals(invalid_email, "Please enter a valid email address!");
	Assert.assertEquals(Categories, "Categories");
		
	}

}
