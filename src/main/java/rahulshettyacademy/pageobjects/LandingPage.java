package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import rahulshettyacademy.Abstactcomponents.AbstactComponent;

public class LandingPage extends AbstactComponent { // Landing page is child class, Abstarct component is parent class
	WebDriver driver;
	
	
	public LandingPage(WebDriver driver) {       //Constructor class
		super(driver);  // sending driver life to parent method
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement Useremail; 
	@FindBy(id="userPassword")
	WebElement password; 
	@FindBy(id="login")
	WebElement Login; 
	
	@Test(groups={"Regression"})
	public void LoginApplication(String email, String  passwordd)
	{
		Useremail.sendKeys(email);
		password.sendKeys(passwordd);
		Login.click();
	}
	@FindBy(css="[class*='flyInOut']")
	WebElement loginerror; 
	public String loginErrorMessage()
	{
		waitForWebElementtAppear(loginerror);
		return loginerror.getText();
	}
	
	public void goTourl()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}
