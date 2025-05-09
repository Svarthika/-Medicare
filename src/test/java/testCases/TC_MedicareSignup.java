package testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseTestCase.BaseTestClass;
import io.reactivex.rxjava3.functions.Action;
import pageObjects.SignUpConfirm;
import pageObjects.homePage;
import pageObjects.signUpAddress;
import pageObjects.signUpPage;

public class TC_MedicareSignup extends BaseTestClass{

	@Test(groups ={"sanity"})
	public void Verify_MedicarSignUP() throws InterruptedException, AWTException, IOException {
		try {
		logger.info("----TC01 MeicareSignUP-----");
		homePage hp = new homePage(driver);
		logger.info("----click Signup Page-----");
		hp.signUp();
		
		signUpPage signUp = new signUpPage(driver);
		signUpAddress signUpAdd = new signUpAddress(driver);
		String formPersonalDetails = signUp.Validate_PagePersonal();
		Assert.assertEquals("Sign Up - Personal",formPersonalDetails);
		// Sinup personal details
		logger.info("----click user details-----");
		signUp.setFname(randomeString());
		signUp.setLname(randomeString());
		signUp.setEmail("Test24@gmail.com");
		signUp.SetContact(1234567890);
		signUp.SetPassword("new@123");
		signUp.setConfirmPassword("new@123");
		signUp.setRole("Supplier");
		signUp.click_submit();
		logger.info("----click submit-----");
		String formAddressDetails = signUpAdd.Validate_AddressPage();
		Assert.assertEquals("Sign Up - Address", formAddressDetails);
		
		//Address Details
		logger.info("----Enter Address Page-----");
		signUpAdd.SetAddress1(randomeString());
		signUpAdd.SetAddress2(randomeString());
		signUpAdd.SetCity("hyderabad");
		signUpAdd.SetPostalCode(randomeAlphaNumber());
		signUpAdd.SetState("Telangana");
		signUpAdd.SetCountry("India");
		signUpAdd.click_buttonConfirm();
		
		logger.info("----click Signup-----");
		/* not working as the popup is non java script
		 * JavascriptExecutor js = (JavascriptExecutor)driver; String saveScript =
		 * "var buttons = document.querySelectorAll('button'); " +
		 * "buttons.forEach(function(button) { " +
		 * "if (button.innerText.includes('Save')) { button.click(); } });";
		 * js.executeScript(saveScript);
		 */
		
		/*
		 * Actions ac = new Actions(driver); ac.moveToLocation(1312,
		 * 254).build().perform(); ac.doubleClick().build().perform(); Robot robot= new
		 * Robot();
		 * 
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		  
		// AuotIT exec file to handle popup closure
		
		//Runtime.getRuntime().exec("C:\\Users\\shank\\OneDrive\\Documents\\Varthypractice\\winpopup_x64.exe");
		
		SignUpConfirm userConfirm =new SignUpConfirm(driver);
		Thread.sleep(5000);	
		userConfirm.click_FinalConfirm();
		String SingupConfirmMessage = userConfirm.Validate_SingupConfirmMessage();
		logger.info("----User Created successully-----");		
		//user_Welcome.Confirmpage_Login();
		//put hello to fail TC's
		if(SingupConfirmMessage.equals("Welcome!"))  {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test Failed");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
					
		}
		}
		
		catch(Exception e) {
			Assert.fail();
			
		}
	logger.info("----- Finished TC01 MeicareSignUP-----");
}
}
