import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest{

  private static WebDriver driver;

  	@BeforeClass
  	public static void beforeclass(){
  		driver = new FirefoxDriver();
  		driver.get("http://store.demoqa.com/");
  }
  
  	@Test
  	public void Test1() {
  		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div[1]/div[3]/div/a/span")).click();
  		// driver.findElement(By.linkText("Buy Now")).click();
  		Assert.assertEquals("Error unexpected page: ", "Magic Mouse | ONLINE STORE", driver.getTitle());
  }
  
  	@Test
  	public void Test2(){
  		driver.findElement(By.xpath("//a[@href='http://store.demoqa.com/products-page/product-category/ipod-nano-blue/']")).click();
  		Assert.assertEquals("Error unexpected page: ", "iPod Nano Blue | ONLINE STORE", driver.getTitle());
         
  }
  
  	@Test
  	public void Test3(){
  		driver.findElement(By.xpath("//a[@href='http://store.demoqa.com/']")).click();
  		driver.findElement(By.partialLinkText("More Info")).click();
  		Assert.assertEquals("Error unexpected page: ", "Magic Mouse | ONLINE STORE", driver.getTitle());
  }
  
  	@Test
  	public void Test4() throws InterruptedException{
  		driver.findElement(By.xpath("//a[@href='http://store.demoqa.com/']")).click();
  		ArrayList<String> listOfSlides = new ArrayList<String>();
  		String currentSlide;
  		for(int i=0;i<5;i++) {
  			currentSlide = driver.findElement(By.cssSelector(".product_description>h2")).getText();
       			if( false == listOfSlides.contains(currentSlide) ) {
       			listOfSlides.add(currentSlide);

       			if( listOfSlides.size() == 3 ) {
       				break;
        }
       }

       Thread.sleep(5000);
      }

      Assert.assertEquals("Error unexpected number of slides: ", 3, listOfSlides.size());
     }
  
  
  	@Test
  	public void Test5(){
  		driver.findElement(By.xpath("//*[@id='slide_menu']/a[3]")).click();
  		driver.findElement(By.xpath("//*[@id='slide_menu']/a[2]")).click();
  		driver.findElement(By.xpath("//*[@id='slide_menu']/a[1]")).click();
  }
  
 /* 	@AfterClass
  	public static void afterClass(){
  		driver.close();
  } */

 }
