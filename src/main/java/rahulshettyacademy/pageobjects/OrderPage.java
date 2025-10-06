package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import rahulshettyacademy.Abstactcomponents.AbstactComponent;

public class OrderPage extends AbstactComponent{
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//tr/td[2]")
	List<WebElement> orderlists;
	
	
	public Boolean verifyOrderDisplay(String productName) { //cheking if ZARA COAT 3 is present in orderHistory lists.
		Boolean match = orderlists.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		return match; 
		
		
	}
	
}
