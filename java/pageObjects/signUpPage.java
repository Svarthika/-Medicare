package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signUpPage extends BaseClass {
	
	
	public signUpPage(WebDriver driver) {
		super(driver);
			
	}
	
	@FindBy(xpath ="//*[text()='Sign Up - Personal']") WebElement txtFormPersonal;
	@FindBy(name = "firstName") WebElement txtfname;
	@FindBy(id = "lastName") WebElement txtlname;
	@FindBy(id = "email") WebElement txtemail;
	@FindBy(id = "contactNumber") WebElement txtContactNum;
	@FindBy(css = "#password") WebElement txtPwd;
	@FindBy(css = "#confirmPassword") WebElement txtConfPwd;
	@FindBy(id = "role1") WebElement rduserRole;
	@FindBy(id = "role2") WebElement rdSupplierRole;
	@FindBy(xpath = "//button[@name='_eventId_billing']") WebElement btnSubmit;
	

	public void setFname(String fname) {
		txtfname.sendKeys(fname);
	}
	
	public void setLname(String lname) {
		txtlname.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void SetContact(Integer ContactNum) {
		String contactNumStr = Integer.toString(ContactNum);
		txtContactNum.sendKeys(contactNumStr);
	}
	public void SetPassword(String Pwd) {
		txtPwd.sendKeys(Pwd);
	}
	
	public void setConfirmPassword(String cnfPwd) {
		txtConfPwd.sendKeys(cnfPwd);
	}
	public void setRole(String role) {
		System.out.println(role);
		 String user = rduserRole.getAttribute("value").trim().toLowerCase();
		 String supplier = rdSupplierRole.getAttribute("value").trim().toLowerCase() ;
		 String roleNormalised = role.trim().toLowerCase();
		if(user.equals(roleNormalised)){
			rduserRole.click();
			}		
			else if(supplier.equals(roleNormalised)) {
				rdSupplierRole.click();
							}
			else {
				System.out.println("No Such Role exists");	
			}
		}
	
	public void click_submit() {
		btnSubmit.click();
	}
	
	public String Validate_PagePersonal() {
		System.out.println(txtFormPersonal.getText());
		return txtFormPersonal.getText();
		
	
	}
}

	
	
		
	

