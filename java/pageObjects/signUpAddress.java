package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class signUpAddress extends BaseClass{
	WebDriver driver;
	
	public signUpAddress(WebDriver driver)  {
		super(driver);
	}
	
	
	@FindBy(xpath="//h4[text()='Sign Up - Address']") WebElement AddressFormName;
	@FindBy(id="addressLineOne") WebElement txtAdd1;
	@FindBy(id="addressLineTwo") WebElement txtAdd2;
	@FindBy(xpath = "//*[@id='city' and @placeholder='Enter City Name']") WebElement txtCity;
	@FindBy(name="postalCode") WebElement txtPostalCode;
	@FindBy(css ="input[name='state']") WebElement txtState;
	@FindBy(css ="input[name='country']") WebElement txtCountry;
	@FindBy(xpath="//*[contains(text(),'Next - Confirm')]") WebElement btnConfirm;
	@FindBy(xpath="//*[contains(text(),'Back - Personal')]") WebElement btnBack;
	
	public void SetAddress1(String Add1) {
		txtAdd1.sendKeys(Add1);		
	}
	
	public void SetAddress2(String Add2) {
		txtAdd2.sendKeys(Add2);		
	}
	
	public void SetCity(String city) {
		txtCity.sendKeys(city);		
	}
	
	public void SetPostalCode(String Postal) {
		txtPostalCode.sendKeys(Postal);		
	}
	
	public void SetState(String state) {
		txtState.sendKeys(state);		
	}
	
	public void SetCountry(String country) {
		txtCountry.sendKeys(country);		
	}
	
	public void click_buttonConfirm()
	{
		btnConfirm.click();
	}
	public void click_buttonBack()
	{
		btnBack.click();
	
	
	}
	
	public String Validate_AddressPage() {
		return AddressFormName.getText();
		
	}

}


