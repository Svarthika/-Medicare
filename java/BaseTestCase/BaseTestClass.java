package BaseTestCase;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestClass {
	protected WebDriver driver;
	public logger 


	@BeforeClass	
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shank\\eclipse-workspace\\test.simplilearn\\test-output\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("autofill.profile_enabled", false);
		options.setExperimentalOption("prefs", prefs);

		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    driver.get("http://localhost:8080/medicare3/home");	
	    driver.manage().window().maximize();
	}
	
	@AfterClass
    public void TearDown() {
	//driver.quit();
}
	
	//random string generation
		@SuppressWarnings("deprecation")
		public String randomeString() {
			String generateString = RandomStringUtils.randomAlphabetic(6);
			return generateString;
			}
		
		public String randomeNumber()
		{
			String generatedNumber  = RandomStringUtils.randomNumeric(6);
			return generatedNumber;
		}
		public String randomeAlphaNumber()
		{
			String generatedAlphaNumber  = RandomStringUtils.randomAlphanumeric(5);
			return generatedAlphaNumber;
		}
}

