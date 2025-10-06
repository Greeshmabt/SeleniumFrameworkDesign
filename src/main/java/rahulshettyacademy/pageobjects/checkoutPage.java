package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstactcomponents.AbstactComponent;

public class checkoutPage extends AbstactComponent {

	WebDriver driver;
	public checkoutPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css=".totalRow button")
	WebElement checkout;
	public void checkout() {
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		checkout.click();
	}
	//a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
	@FindBy (css="[placeholder='Select Country']")
	WebElement country;
	//driver.findElement(By.xpath("//button[contains(@class,'ta-item')])[2]")).click();//selecting 2nd option ie India
	@FindBy (xpath="//button[contains(@class,'ta-item')])[2]")
	WebElement countryindropdown;
	By countryresults= By.cssSelector(".ta-results");
	public void selectCountry(String countryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitForElementtoAppear(countryresults);
		countryindropdown.click();
	}
	
	//driver.findElement(By.cssSelector(".action__submit")).click();
	@FindBy (css=".action__submit")
	WebElement submit;
	public void submit()
	{
		submit.click();
		//Now create object here only bcoz its obviuous that after submit ull land on Thank u page.
		
		
	}
	
}
