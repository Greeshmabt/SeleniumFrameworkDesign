package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class testGreenCart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		additems(driver);
		 driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		 driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	 // Assert.assertEquals(driver.findElement(By.xpath("//b[text()='Total Amount']")), "Total Amount");
    	  driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
    	  driver.findElement(By.cssSelector("button.promoBtn")).click();
    	  driver.findElement(By.xpath("//button[text()='Place Order']")).click();
    	  
    	  WebElement dropdown1= driver.findElement(By.xpath("//div/select"));
    	  Select dropdown = new Select(dropdown1);
    	  dropdown.selectByVisibleText("India");
    	  driver.findElement(By.cssSelector(".chkAgree")).click();
    	  driver.findElement(By.xpath("//button[text()='Proceed']")).click();
    	  
	}
    	  
    	  public static void additems(WebDriver driver)
    	  {
    		  String[] itemsneeded= {"Cucumber","Brocolli","Carrot","Tomato"};
    			List itemsneededlist = Arrays.asList(itemsneeded);
    			List<WebElement> allproducts = driver.findElements(By.cssSelector("h4.product-name"));
    			 int j=0;
    	       for(int i=0;i<allproducts.size();i++)
    	       {
    	    	  String[] names=  allproducts.get(i).getText().split("-");
    	    	  String formattedname= names[0].trim();
    	    	 
    	    	  if(itemsneededlist.contains(formattedname))
    	    	  {
    	    		  j++;
    	    		
    	    		  if(formattedname.contains("Cucumber"))
    	    		  {
    	    			  driver.findElement(By.cssSelector("a.increment")).click();
    	    		  }
    	    		  driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
    	    		  
    	    		  System.out.println(formattedname);
    	    		  if(j>itemsneeded.length)
    	    		  {
    	    			  break;
    	    		  }
    	    	  }
    	       }
    	    
	}
    
	}
