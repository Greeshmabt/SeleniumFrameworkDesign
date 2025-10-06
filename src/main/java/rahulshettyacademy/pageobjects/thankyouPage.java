package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import rahulshettyacademy.Abstactcomponents.AbstactComponent;

public class thankyouPage extends AbstactComponent{

	WebDriver driver;
	public thankyouPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".hero-primary")  
	WebElement thankyoumsg;
	//String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	@Test(groups={"Regression"})
	public String thankyou() {
		return thankyoumsg.getText(); //its returning back string so change void to string
		
	}
}
