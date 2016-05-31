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
import java.text.ParseException;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.CoreMatchers.*;

public class CheckoutInfo {
	private static WebDriver driver;

	@BeforeClass
	public static void beforeclass(){
		driver = new FirefoxDriver();
		driver.get("http://store.demoqa.com/products-page/product-category/accessories/magic-mouse/");
	}
	
	@Test
	public void Test1() throws InterruptedException {
	    driver.findElement(By.className("wpsc_buy_button")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.className("go_to_checkout")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.className("step2")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("uniform-current_country")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id='current_country']/option[233]")).click();
	    driver.findElement(By.name("wpsc_submit_zipcode")).click();
	    String priceUSA = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[2]/div/form/div[3]/table/tbody/tr[5]/td[2]/span/span")).getText();
	    Assert.assertEquals("Incorrect price", "$162.00" , priceUSA);
	    driver.findElement(By.xpath("//*[@id='current_country']/option[216]")).click();
	    driver.findElement(By.name("wpsc_submit_zipcode")).click();
	    String priceSWE = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[2]/div/form/div[3]/table/tbody/tr[5]/td[2]/span/span")).getText();
	    Assert.assertEquals("Incorrect price", "$173.00" , priceSWE);
	    String priceUSA2 = priceUSA.replace("$", "");
	    String priceSWE2 = priceSWE.replace("$", "");
	    double USA = Double.parseDouble(priceUSA2);
	    double SWE = Double.parseDouble(priceSWE2);
	    Assert.assertThat("Incorrect pricing: USA should be lower than SWE", Double.valueOf(USA), is(lessThan(SWE)));
	   }
	@Test
	public void Test2() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[2]/div/form/div[1]/div/p/label/input")).sendKeys("test@hotmail.com");
		driver.findElement(By.id("shippingSameBilling")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[2]/div/form/div[1]/table[1]/tbody/tr[2]/td[2]/input")).sendKeys("Thomas");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[2]/div/form/div[1]/table[1]/tbody/tr[3]/td[2]/input")).sendKeys("Nilsson");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[2]/div/form/div[1]/table[1]/tbody/tr[4]/td[2]/textarea")).sendKeys("Byn");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[2]/div/form/div[1]/table[1]/tbody/tr[5]/td[2]/input")).sendKeys("Stockholm");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[2]/div/form/div[1]/table[1]/tbody/tr[6]/td[2]/input")).sendKeys("Stockholm");
		driver.findElement(By.id("wpsc_checkout_form_7")).click();
		driver.findElement(By.id("wpsc_checkout_form_7")).sendKeys("SWEDEN");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[2]/div/form/div[1]/table[1]/tbody/tr[9]/td[2]/input")).sendKeys("07375547566");
		
		String text = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[2]/div/form/div[1]/table[2]/tbody/tr[2]/td/span")).getText();
		Assert.assertEquals("Incorrect message", "Your order will be shipped to the billing address", text);
		
		String Color1 = driver.findElement(By.xpath("//*[@id='post-29']/div/div[1]/ul/li[1]")).getCssValue("color");
		Assert.assertEquals("Incorrect color display on bar: ", "rgba(0, 0, 0, 1)", Color1);
		String Color2 = driver.findElement(By.xpath("//*[@id='post-29']/div/div[1]/ul/li[2]")).getCssValue("color");
		Assert.assertEquals("Incorrect color display on bar: ", "rgba(0, 0, 0, 1)", Color2);
		String Color3 = driver.findElement(By.xpath("//*[@id='post-29']/div/div[1]/ul/li[3]")).getCssValue("color");
		Assert.assertEquals("Incorrect color display on bar: ", "rgba(204, 204, 204, 1)", Color3);
		Thread.sleep(2000);
		
		String price = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[2]/div/form/div[3]/table/tbody/tr[5]/td[2]/span/span")).getText();
		String Totalship = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[2]/div/form/div[3]/table/tbody/tr[2]/td[2]/span/span")).getText();
		Assert.assertEquals("Incorrect pricing: ", price, "$173.00");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[2]/div/form/div[4]/div/div/span/input")).click();
		   
		Assert.assertEquals("Incorrect Total shipping price: ", Totalship, "$23.00");
		Assert.assertEquals("Incorrect pricing: ", price, "$173.00");
		   
		String Color4 = driver.findElement(By.xpath("//*[@id='post-30']/div/div[1]/ul/li[1]")).getCssValue("color");
		Assert.assertEquals("Incorrect color display on bar: ", "rgba(0, 0, 0, 1)", Color4);
		String Color5 = driver.findElement(By.xpath("//*[@id='post-30']/div/div[1]/ul/li[2]")).getCssValue("color");
		Assert.assertEquals("Incorrect color display on bar: ", "rgba(0, 0, 0, 1)", Color5);
		String Color6 = driver.findElement(By.xpath("//*[@id='post-30']/div/div[1]/ul/li[3]")).getCssValue("color");
		Assert.assertEquals("Incorrect color display on bar: ", "rgba(0, 0, 0, 1)", Color6);
	}
}
