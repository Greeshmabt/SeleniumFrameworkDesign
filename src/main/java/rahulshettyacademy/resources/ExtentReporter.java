package rahulshettyacademy.resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	@BeforeTest
	public static  ExtentReports reportconfig(WebDriver driver) {
		String path= System.getProperty("user.dir")+ "\\Reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web Automation report results");	
		ExtentReports ext= new ExtentReports();
		ext.attachReporter(reporter);
		ext.setSystemInfo("Tester", "Greeshma");
		return ext;
	}
	
}
