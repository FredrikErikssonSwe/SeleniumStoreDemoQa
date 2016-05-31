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

public class Produktkategori {
	private static WebDriver driver;

	@BeforeClass
	public static void beforeclass(){
		driver = new FirefoxDriver();
		driver.get("http://store.demoqa.com/");
	}
	@Test
	public void Test1() throws InterruptedException{
		WebElement element1 = driver.findElement(By.linkText("Product Category"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(element1).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Accessories")).click();
		Assert.assertEquals("Error wrong page", "Accessories | ONLINE STORE", driver.getTitle());
	}
	
	@Test
	public void Test2() throws InterruptedException{
		WebElement element2 = driver.findElement(By.linkText("Product Category"));
		Actions action2 = new Actions(driver);
		action2.moveToElement(element2).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("iMacs")).click();
		Assert.assertEquals("Error wrong page", "iMacs | ONLINE STORE", driver.getTitle());
	}
	
	@Test
	public void Test3() throws InterruptedException{
		WebElement element3 = driver.findElement(By.linkText("Product Category"));
		Actions action3 = new Actions(driver);
		action3.moveToElement(element3).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("iPads")).click();
		Assert.assertEquals("Error wrong page", "iPads | ONLINE STORE", driver.getTitle());
	}
	
	@Test
	public void Test4() throws InterruptedException{
		WebElement element4 = driver.findElement(By.linkText("Product Category"));
		Actions action4 = new Actions(driver);
		action4.moveToElement(element4).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("iPhones")).click();
		Assert.assertEquals("Error wrong page", "iPhones | ONLINE STORE", driver.getTitle());
	}
	
	@Test
	public void Test5() throws InterruptedException{
		WebElement element5 = driver.findElement(By.linkText("Product Category"));
		Actions action5 = new Actions(driver);
		action5.moveToElement(element5).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("iPods")).click();
		Assert.assertEquals("Error wrong page", "iPods | ONLINE STORE", driver.getTitle());
	}
	
	@Test
	public void Test6() throws InterruptedException{
		WebElement element6 = driver.findElement(By.linkText("Product Category"));
		Actions action6 = new Actions(driver);
		action6.moveToElement(element6).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("MacBooks")).click();
		Assert.assertEquals("Error wrong page", "MacBooks | ONLINE STORE", driver.getTitle());
	}

}
