package BaseTestCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTestClass {
	public static WebDriver driver; // as baseclass driver object created during screencapture which might conflict
    public Logger logger;
    public Properties p;
    

	@BeforeMethod(groups = {"sanity", "regression", "master"})	
	@Parameters({"os","browser"})
public void setUp(@Optional("DefaultOS") String os,@Optional("chrome") String br) throws IOException, InterruptedException {
		
		//loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
        p = new Properties(); 
        p.load(file);
        
		//load log4j xml file
		logger = LogManager.getLogger(this.getClass());
		
		
		switch(br.toLowerCase()) {
		case "chrome": {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\shank\\eclipse-workspace\\test.simplilearn\\test-output\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("autofill.profile_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
			break;
		}
		case "edge":
			
			driver = new EdgeDriver(); break;	
		case "firefox":
			System.setProperty("webdriver.firefox.driver", "C:\\Users\\shank\\eclipse-workspace\\test.simplilearn\\test-output\\geckodriver.exe");
			driver = new FirefoxDriver(); break;	
		default: System.out.println("----Invalid Browser Time----"); return; //as inalid browser come out of execution	
		}
		
		driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    //reading value from properties file
	    driver.get(p.getProperty("QAurl"));	
	    driver.manage().window().maximize();
	}
	
	@AfterMethod(groups = {"sanity", "regression", "master"})
    public void TearDown() {
	driver.quit();
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

        public String captureScreen(String tname) {
        	
        	String timeStamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
        	
        	TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
        	
        	File SourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
        	
        	String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname+"-"+timeStamp;
        	
        	File targetFile = new File(targetFilePath);
        	
        	SourceFile.renameTo(targetFile);
        	
        	return targetFilePath;
        	
        	
        	
        }
	
}



