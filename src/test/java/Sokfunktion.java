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

public class Sokfunktion {
	private static WebDriver driver;

	@BeforeClass
	public static void beforeclass(){
		driver = new FirefoxDriver();
		driver.get("http://store.demoqa.com/");
	}
	@Test
	public void Test1() {
		driver.findElement(By.className("search")).sendKeys("Magic Mouse");
		driver.findElement(By.className("search")).sendKeys(Keys.ENTER);
		String Mouse = driver.findElement(By.linkText("Magic Mouse")).getText();
		Assert.assertEquals("Incorrect item", "Magic Mouse", Mouse);
	}

}
