package demoblaze;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;


public class NavigationNew {
	
	static WebDriver driver;
	static String id;
	static double amount=0.0;
	static double actualAmount=0.0;
	static String aa;
	

	
	public static void customernavigation () throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id=\"cat\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id=\"itemc\" and text()='Phones']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id=\"itemc\" and text()='Laptops']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id=\"itemc\" and text()='Monitors']")).click();
		Thread.sleep(2000);
		
	}
	
	public void NavigationToCartSony() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@class=\"list-group-item\" and text()='Laptops']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(), 'Sony vaio i5')]")).click();
		Thread.sleep(2000);
		String p=driver.findElement(By.xpath("//h3[@class=\"price-container\"]")).getText();
		aa=p.substring(1, 4);
		actualAmount=Double.parseDouble(aa);
		System.out.println(actualAmount);
	//	actualAmount=Double.parseDouble(p.substring(0));
		driver.findElement(By.xpath("//a[@class=\"btn btn-success btn-lg\"]")).click();
		Thread.sleep(2000);
		Alert alt= driver.switchTo().alert();
		alt.accept();
		driver.findElement(By.xpath("//a[@class=\"nav-link\"  and text()='Home ']")).click();

}
	public static void NavigationToCartDell() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@id=\"itemc\" and text()='Laptops']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(), 'Dell i7 8gb')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(), 'Add to cart')]")).click();
		Thread.sleep(2000);
		Alert alt= driver.switchTo().alert();
		alt.accept();
		driver.findElement(By.xpath("//a[@class=\"nav-link\" and text()='Cart']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//tr[@class=\"success\"]//td[contains(text(),'Dell i7 8gb')]//following::td/a")).click();
		Thread.sleep(2000);
		
		/*WebElement price=driver.findElement(By.xpath("//div[@position=\"right\"]"));
		System.out.println("Text is Present ?" + price.getText() + "Yes");
		actualAmount = Double.parseDouble("790"); */
		driver.findElement(By.xpath("//button[@type=\"button\" and text()='Place Order']")).click();
		Thread.sleep(2000);
		
	}
	
	public static void Purchase (String name, String Country, String city , String creditcard, String month, String year) {
		
		driver.findElement(By.xpath("//div[@class=\"form-group\"]/following::input[@id=\"name\"]")).sendKeys(name);
		driver.findElement(By.xpath("//div[@class=\"form-group\"]/following::input[@id=\"country\"]")).sendKeys(Country);
		driver.findElement(By.xpath("//div[@class=\"form-group\"]/following::input[@id=\"city\"]")).sendKeys(city);
		driver.findElement(By.xpath("//div[@class=\"form-group\"]/following::input[@id=\"card\"]")).sendKeys(creditcard);
		driver.findElement(By.xpath("//div[@class=\"form-group\"]/following::input[@id=\"month\"]")).sendKeys(month);
		driver.findElement(By.xpath("//div[@class=\"form-group\"]/following::input[@id=\"year\"]")).sendKeys(year);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();		
		WebElement s=driver.findElement(By.xpath("/html/body/div[10]/p"));
		id=s.getText().split("\\n")[0].split(":")[1].trim();
		System.out.println(id);
		amount = Double.parseDouble(s.getText().split("\\n")[1].split(":")[1].split(" ")[1].trim());
		System.out.println(amount);
			
	}
	

	public static void takescreenshot(String FileName) throws IOException, InterruptedException {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File("C:\\Users\\lenovo\\eclipse-workspace\\Introduction\\src\\image" + FileName + ".jpg"));
		System.out.println("Screen taken");
		Assert.assertEquals(actualAmount, amount,"Amount Validated");
		driver.findElement(By.xpath("//button[@class=\"confirm btn btn-lg btn-primary\"]")).click();
		Thread.sleep(2000);
		driver.quit();	
		
	}
	
	
}

