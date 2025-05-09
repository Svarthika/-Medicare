package testCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTestCase.BaseTestClass;
import io.reactivex.rxjava3.functions.Action;
import pageObjects.LoginPage;
import pageObjects.homePage;
import utilities.DataProviders;

public class TC03_LoginDD extends BaseTestClass{
	
	
		
@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class ,groups = {"regression","master"}) // if data provider class is in diferenet package

public void Invalid_Email(String Email, String Password, String Expected) {
	logger.info("----TC_Invalid_Valid_Login_Credentials-----");
    homePage home =new homePage(driver);
	LoginPage login = new LoginPage(driver);
	home.validateHomePage();
	home.Login();
	logger.info("----User enters invalid user name-----");
	
	login.setEmail(Email);
	//Actions ac = new Actions(driver);
	//ac.click().build().perform();
	login.SetPassword(Password);	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(login.btnLogin));
	try {
	login.Click_Login();
	String actualMessage = "";	
	if(Expected.equals("Username and Password is invalid!")) {
		actualMessage =login.invalid_Password();
	}
	else {
		actualMessage = login.Categories_Present();
	}
	//assert.assertEquals(invalid_email, "Please enter a valid email address!");
	Assert.assertEquals(actualMessage, Expected);
	}
	catch(Exception e){
		logger.error("Error while clicking login button" +e.getMessage());
		if(Expected.equals("Please enter a valid email address!")) {
			String actualMessage = login.invalid_Email();
			Assert.assertEquals(actualMessage, Expected);
		}
		else {
			System.out.println(e.getMessage());
		}
	}
	logger.info("----Finished Invalid Email Test-----");	
	}




}
