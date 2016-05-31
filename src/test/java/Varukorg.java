import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Varukorg {
	private static WebDriver driver;

	@BeforeClass
	public static void beforeclass(){
		driver = new FirefoxDriver();
		driver.get("http://store.demoqa.com/products-page/product-category/accessories/magic-mouse/");
	}
	 @Test
	 public void Test1() throws InterruptedException{
	   driver.findElement(By.className("wpsc_buy_button")).click();
	   Thread.sleep(2000);
	   String Magic = driver.findElement(By.xpath("/html/body/div[4]/div[2]/span")).getText();
	   Assert.assertEquals("Incorrect message display: ", "You just added \"Magic Mouse\" to your cart.", Magic);
	   Thread.sleep(2000);
	   
	   driver.findElement(By.className("continue_shopping")).click();
	   Assert.assertEquals("Incorrect page display: ", "Magic Mouse | ONLINE STORE", driver.getTitle());
	   Thread.sleep(2000);
	   
	   driver.findElement(By.className("wpsc_buy_button")).click();
	   driver.findElement(By.className("go_to_checkout")).click();
	   String prodnamn = driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[2]/td[2]/a")).getText();
	   Assert.assertEquals("Error product not found", "Magic Mouse", prodnamn);
	  }
	}


