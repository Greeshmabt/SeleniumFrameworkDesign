package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.Abstactcomponents.AbstactComponent;
 
public class cartPage extends AbstactComponent {
	WebDriver driver;
	public cartPage(WebDriver driver) {   //Constructor class
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (css=".cartSection h3")
	List<WebElement> cartproducts;
	public List<WebElement> cartProducts()
	{
		//List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		return cartproducts;
	}
	public Boolean cartProductMatch(String productName)
	{
		Boolean match = cartproducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
}
