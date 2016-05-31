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

import com.thoughtworks.selenium.webdriven.commands.TypeKeys;

import org.junit.Test;

public class CheckOutVarukorg {
	private static WebDriver driver;

	@BeforeClass
	public static void beforeclass(){
		driver = new FirefoxDriver();
		driver.get("http://store.demoqa.com/products-page/checkout/");
	}
	
	@Test
	public void Test1() {
		String Content = driver.findElement(By.className("entry-content")).getText();
		Assert.assertEquals("Incorrect message displayed", "Oops, there is nothing in your cart.", Content);
	}
	@Test
	public void Test2() {
		Boolean exist = driver.findElements(By.className("step2")).size() == 0;
	}
	@Test
	public void Test3() throws InterruptedException {
		driver.findElement(By.className("search")).sendKeys("Magic Mouse");
		driver.findElement(By.className("search")).sendKeys(Keys.ENTER);
		driver.findElement(By.className("wpsc_buy_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("continue_shopping")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("s")).sendKeys("iPhone 5");
		driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
		driver.findElement(By.className("wpsc_buy_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("continue_shopping")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("s")).sendKeys("iPod Nano Blue");
		driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
		driver.findElement(By.className("wpsc_buy_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("go_to_checkout")).click();
		
	/*	String prodnamn1 = driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[2]/td[2]/a")).getText();
		Assert.assertEquals("Error product not found", "Magic Mouse", prodnamn1);
		String prodnamn2 = driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[3]/td[2]/a")).getText();
		Assert.assertEquals("Error product not found", "iPhone 5", prodnamn2);
		String prodnamn3 = driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[4]/td[2]/a")).getText();
		Assert.assertEquals("Error product not found", "iPod Nano Blue", prodnamn3);
		
		String antal1 = driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[2]/td[3]/form/input[1]")).getText();
		Assert.assertEquals("Incorrect quantity", "1", antal1);
		String antal2 = driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[3]/td[3]/form/input[1]")).getText();
		Assert.assertEquals("Incorrect quantity", "1", antal2);
		String antal3 = driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[4]/td[3]/form/input[1]")).getText();
		Assert.assertEquals("Incorrect quantity", "1", antal3);
		*/ 
		}
	@Test
	 public void Test4(){
	     String Magic = driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[2]/td[2]/a")).getText();
	     Assert.assertEquals("Incorrect product", "Magic Mouse", Magic);
	     String iPhone = driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[3]/td[2]/a")).getText();
	     Assert.assertEquals("Incorrect product", "iPhone 5", iPhone);
	     String iPod = driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[4]/td[2]/a")).getText();
	     Assert.assertEquals("Incorrect product", "iPod Nano Blue", iPod);
	     
	     driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[4]/td[6]/form/input[4]")).click();
	     driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[3]/td[6]/form/input[4]")).click();
	     
	     String price = driver.findElement(By.className("pricedisplay")).getText();
	     Assert.assertEquals("Incorrect price which probably means it still exists:", "$150.00", price);
		}
		@Test
		public void Test5(){
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[2]/td[3]/form/input[1]")).click();
			driver.findElement(By.name("quantity")).clear();
			driver.findElement(By.name("quantity")).sendKeys("2");
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[2]/td[3]/form/input[4]")).click();
			String price2 = driver.findElement(By.className("pricedisplay")).getText();
			Assert.assertEquals("Incorrect price number", "$300.00", price2);
		}	
		 @Test
		 public void Test6() throws InterruptedException{
			driver.findElement(By.name("s")).sendKeys("iPhone 5");
			driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
			driver.findElement(By.className("wpsc_buy_button")).click();
			Thread.sleep(2000);				
			driver.findElement(By.className("go_to_checkout")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[2]/td[3]/form/input[1]")).click();
			driver.findElement(By.name("quantity")).clear();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[2]/td[3]/form/input[4]")).click();
			String price3 = driver.findElement(By.className("pricedisplay")).getText();
			Assert.assertEquals("Incorrect price number", "$12.00", price3);
		 }
		 @Test
		 public void Test7() throws InterruptedException{
			 String Color1 = driver.findElement(By.xpath("//*[@id='post-29']/div/div[1]/ul/li[1]")).getCssValue("color");
			  Assert.assertEquals("Incorrect color display on bar: ", "rgba(0, 0, 0, 1)", Color1);
			  String Color2 = driver.findElement(By.xpath("//*[@id='post-29']/div/div[1]/ul/li[2]")).getCssValue("color");
			  Assert.assertEquals("Incorrect color display on bar: ", "rgba(204, 204, 204, 1)", Color2);
			  String Color3 = driver.findElement(By.xpath("//*[@id='post-29']/div/div[1]/ul/li[3]")).getCssValue("color");
			  Assert.assertEquals("Incorrect color display on bar: ", "rgba(204, 204, 204, 1)", Color3);
			 Thread.sleep(2000);
		 }
		 @Test
		 public void Test8() throws InterruptedException{
			 driver.findElement(By.className("step2")).click();
			 Assert.assertEquals("Incorrect page: ", driver.getTitle(), "Checkout | ONLINE STORE");
		 }
}