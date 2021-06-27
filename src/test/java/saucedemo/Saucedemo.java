package saucedemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class Saucedemo {
	
	private WebDriver driver;
	By userlocator = By.name("user-name");
	By passlocator = By.name("password");
	By signInBtnlocastor = By.name("login-button");
	By purchasesbutton_backpack = By.name("add-to-cart-sauce-labs-backpack");
	By purchasesbutton_jacket = By.name("add-to-cart-sauce-labs-fleece-jacket");
	By purchasesbutton_shirt = By.name("add-to-cart-sauce-labs-bolt-t-shirt");
    By shopping = By.id("shopping_cart_container");
   By Remove = By.name("remove-sauce-labs-backpack");
   By checkout1  = By.className("header_secondary_container");
   By checkout  = By.id("checkout");
	
   //checkout 
    By registerLinkLocator = By.linkText("Checkout: Your Information");
    By First_name  = By.id("first-name");
	By Last_name = By.id("last-name");
	By postal_code = By.id("postal-code");
	By continueBtnLocator = By.id("continue");
    By QTYDESCRIPTION  = By.className("cart_desc_label");
    By finishBtnLocator = By.id("finish");
	
    //logout
	By react = By.id("react-burger-menu-btn"); 


	@Before

	public void setUp () {
		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
	}
	

@Test
public void Sucedemo() throws InterruptedException {
	
	if(driver.findElement(userlocator).isDisplayed()) {
		Thread.sleep(3000);
		driver.findElement(userlocator).sendKeys("standard_user");
	    driver.findElement(passlocator).sendKeys("secret_sauce");
	    Thread.sleep(555);
		driver.findElement(signInBtnlocastor).click();

	if (driver.findElement(shopping).isDisplayed()) {
	    	Thread.sleep(3000);
			driver.findElement(purchasesbutton_backpack).click();
			driver.findElement(purchasesbutton_jacket).click();
			driver.findElement(purchasesbutton_shirt).click();
		    driver.findElement(shopping).click();
		   Thread.sleep(555);
		    driver.findElement(Remove).click();
		    
	 }else{System.out.print("Epic sadface: Username and password do not match any user in this service");}
	    
	    if (driver.findElement(checkout1).isDisplayed()) {
	    	driver.findElement(checkout).click();
	    }
	  
	
	    //Checkout 
	    driver.findElement(checkout1).click();
		Thread.sleep(2000);
		if(driver.findElement(checkout1).isDisplayed()) {
			driver.findElement(First_name).sendKeys("Jhofan");
			driver.findElement(Last_name).sendKeys("Florez");
			driver.findElement(postal_code).sendKeys("1258");
			 Thread.sleep(666);
			driver.findElement(continueBtnLocator).click();
		
			
			if(driver.findElement(QTYDESCRIPTION).isDisplayed()) {
				Thread.sleep(666);
				driver.findElement(finishBtnLocator).click();	
			}
	
		}
		else {
			System.out.print("Purchase error");
		}
	
	}
    //logout
	driver.findElement(react).click();
	Select exit = new Select (driver.findElement(By.id("bm-menu")));
exit.selectByIndex(1);
	
	
}

	
public void tearDown(){
	
	//driver.quit();

}
}



















