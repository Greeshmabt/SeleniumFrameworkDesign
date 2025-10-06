package rahulshettyacademy.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.Abstactcomponents.AbstactComponent;

public class ProductCatalog extends AbstactComponent {
	WebDriver driver;	
	public ProductCatalog(WebDriver driver) { //Constructor class
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this); // u have to add this step in whichever class ur usi g pagefactory
	}
	// List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));----for this
	
	@FindBy(css=".mb-3")  //PAGE FACTORY
	List<WebElement> items;  // for findelements write as List<webelement>
	By productsBy= By.cssSelector(".mb-3"); 
	
	public List<WebElement> Productslist()  //changing method type to List<webelement> as u are returning list of products
	{
		waitForElementtoAppear(productsBy);
		return items; //returning so that any method can use it
	}
	public WebElement getProductByName(String productName)
	{                    //  here u can give method name also
		WebElement prod = items.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod; //returning so that any method can use it
	}
	//a1.moveToElement(prod.findElement(By.cssSelector(".card-body button:last-of-type"))).click();
	//Adding product to cart
	
	By additem = By.cssSelector(".card-body button:last-of-type");
	By toastw= By.cssSelector("#toast-container"); //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	// U CAN USE PAGE FACTORY LIKE BELOW
	@FindBy(css=".ng-animating")
	WebElement spinner; //wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	
	
	public void addProductToCart(String productName)
	{
		
		WebElement prod= getProductByName(productName);
		prod.findElement(additem).click();
		waitForElementtoAppear(toastw); //reuse this method again where ever u need to wait
		waitForWebElementInvisibility(spinner);
	}
}
