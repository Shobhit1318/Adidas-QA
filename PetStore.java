package swaggerio;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



public class PetStore {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.get("https://petstore.swagger.io/");
	driver.manage().window().maximize();
	Thread.sleep(3500);
	driver.findElement(By.xpath("//button[@class=\"btn authorize unlocked\"]")).click();
	Thread.sleep(1000);
	List<WebElement> element=driver.findElements(By.xpath("//div[@class=\"modal-ux\"]//input[@type=\"text\"]"));
	Thread.sleep(1000);
	element.get(0).sendKeys("special-key");
	driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	Thread.sleep(2000);
	List<WebElement> element1=driver.findElements(By.xpath("//button[@class=\"btn modal-btn auth btn-done button\"]"));
	element1.get(0).click();
	
	driver.findElement(By.xpath("//span[@data-path=\"/pet/findByStatus\"]")).click();
	driver.findElement(By.xpath("//button[@class=\"btn try-out__btn\"]")).click();
	driver.findElement(By.xpath("//option[@value=\"available\"]")).click();
	driver.findElement(By.xpath("//button[@class=\"btn execute opblock-control__btn\"]")).click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,800)");
	driver.findElement(By.xpath("//div[@class=\"download-contents\"]")).click();
	Thread.sleep(3000);
	
	String text=driver.findElement(By.xpath("//tr[@class=\"response\"]//td[@class=\"response-col_status\"]")).getText();
	System.out.println(text);
	Assert.assertEquals("200", text);
	
	
	}

}
