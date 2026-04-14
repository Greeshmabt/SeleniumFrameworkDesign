package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.cartPage;

public class ErrorValidations extends BaseTest {

	@Test(groups= {"Error Handling"})
	public void loginErrorValidations() throws IOException  {
		lp.LoginApplication("greeshma@gmail.com", "Sonu@124");
		Assert.assertEquals("Incorrect email or password.", lp.loginErrorMessage());
	}
	
	@Test
	public void productErrorValidations() {
		String productName = "ZARA COAT 33";
		lp.LoginApplication("greeshma@gmail.com", "Sonu@123");
		ProductCatalog productcat = new ProductCatalog(driver);// calling that method using object
		List<WebElement>products = productcat.Productslist();// storing in webelements again
		productcat.addProductToCart(productName);
		productcat.goToCartPage(); //inheriting from abstract class using child class object as its linked.
		cartPage cartpage= new cartPage(driver);	
	    Boolean match = cartpage.cartProductMatch(productName);
	    Assert.assertFalse(match); //giving assertFalse here as match goes false and assertion will pass
	}
}

