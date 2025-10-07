package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.cartPage;
import rahulshettyacademy.pageobjects.checkoutPage;
import rahulshettyacademy.pageobjects.thankyouPage;


public class StandAloneTest extends BaseTest{
	//String productName = "ZARA COAT 3";
	@Test (dataProvider="getData", groups={"Purchase", "Smoke", "Regression"})
		public void submitOrder(String email, String password, String productName, String countryName ) throws IOException { //catching the email,pwd,productName here		
		//String countryName= "india, UAE";
		lp.LoginApplication(email,password);
		ProductCatalog productcat = new ProductCatalog(driver);// calling that method using object
		List<WebElement>products = productcat.Productslist();// storing in webelements again
        //productcat.getProductByName(productName);
		productcat.addProductToCart(productName);
		productcat.goToCartPage(); //inheriting from abstract class using child class object coz its linked.
	    /* List<WebElement> cartitems= driver.findElements(By.cssSelector(".cartSection h3"));
	     WebElement b= cartitems.stream().filter(s->s.findElement(By.xpath("//*[text()='ZARA COAT 3']")).getText().equals(productName))
	     .findFirst().orElse(prod);
	     Assert.assertTrue(true);*/
		cartPage cartpage= new cartPage(driver);	
	Boolean match = cartpage.cartProductMatch(productName);
	Assert.assertTrue(match); //giving assertTrue here because i know match be True so assertion will pass
	//driver.findElement(By.cssSelector(".totalRow button")).click();//checkout button
	cartpage.cartProducts();
	cartpage.cartProductMatch(productName);
	Assert.assertTrue(match);
	checkoutPage checkout= new checkoutPage(driver);
	checkout.checkout();
	checkout.selectCountry(countryName);
	checkout.submit();
	thankyouPage thanks= new thankyouPage(driver);  //this is how u call ur other classess into main class
	String thank= thanks.thankyou();  //this is how u call ur other classess into main class
	Assert.assertTrue(thank.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	}
	//Assert.assertEquals(confirmMessage, "Thank you for your order");
	
	@Test(dependsOnMethods={"submitOrder"})
	public void OrderHistory(String productName) { //catching the productName here
		lp.LoginApplication("greeshma@gmail.com", "Sonu@123");
		OrderPage op= new OrderPage(driver);
		op.goToOrderHistoryPage();
		Boolean match= op.verifyOrderDisplay(productName);
		Assert.assertTrue(match); //if order which u placed is in History , assertion passes
	}
	@DataProvider
	public Object[][] getData() {
		return new Object[][] { {"greeshma@gmail.com","Sonu@123","ZARA COAT 3","india"}, {"ani@gmail.com","ani@123","adidas","UAE"}};
	}
	
	}
