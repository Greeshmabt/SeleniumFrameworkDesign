package rahulshettyacademy.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class BaseTest {

	public WebDriver driver;    //declaring (driver,lp) as global variables and making it public for its access inside the class. 
	public LandingPage lp;
	
	public WebDriver initializeDriver() throws IOException {
		
		//Properties class 
		
		Properties prop= new Properties();
		// add global properties file location below
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
		prop.load(fis); //load method needs file stream as input so craete it
		String browserName = prop.getProperty("browser");
	
		if (browserName.equalsIgnoreCase("chrome"))
				{
			
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver(); // removing WevDriver driver from here to declare globally
				}
		
		else if(browserName.equalsIgnoreCase("edge")) {
			//edge driver code 
			System.setProperty("webdriver.edge.driver","edge.exe");
			driver= new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			//firefox driver code 
	}
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	return driver;
}
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException { //opening the url
		driver= initializeDriver();
		 lp = new LandingPage(driver); // LandingPage keyword removed as its initilazed globally
		lp.goTourl();
		return lp;	
	}
	@AfterMethod(alwaysRun=true)
	public void closeIt() {
		driver.close();
	}
}

/*System.getProperty("user.dir") this fecthes userpaths automatically  
 initially:  C://User/greeshma */
