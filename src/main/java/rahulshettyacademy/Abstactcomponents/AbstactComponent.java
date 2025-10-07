package rahulshettyacademy.Abstactcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.OrderPage;

public class AbstactComponent {
   WebDriver driver;
	
	public AbstactComponent(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this); //Initializing pagefactory
	}

	public void waitForElementtoAppear(By findBy) {
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementtAppear(WebElement findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		}
	
	public void waitForWebElementInvisibility(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	@FindBy (css="[routerlink*='cart']")
	WebElement cart;
	public void goToCartPage()
	{
		cart.click();
	}
	
	@FindBy(css="button[routerlink*='myorders']")
	WebElement  orders;
	public WebElement goToOrderHistoryPage() {
		orders.click();
		return orders;
		
	}
}
