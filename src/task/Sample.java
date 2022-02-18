package task;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\eclipse-workspace\\Data\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		//driver.manage().window().maximize();
		
		WebElement txtsearch = driver.findElement(By.id("twotabsearchtextbox"));
		txtsearch.sendKeys("iphone",Keys.ENTER);
		
		WebElement lnkiphone = driver.findElement(By.xpath("//span[text()='Apple iPhone 12 (128GB) - Black']"));
		lnkiphone.click();
		
		String parentwindowid = driver.getWindowHandle();
		System.out.println(parentwindowid);
		
		Set<String> allwindowid = driver.getWindowHandles();
		System.out.println(allwindowid);
		
		for (String eachwindowid : allwindowid) {
			if(!parentwindowid.equals(eachwindowid)) {
			driver.switchTo().window(eachwindowid);

			}		
			}
				
		Thread.sleep(10000);
		WebElement btnadd = driver.findElement(By.id("add-to-cart-button"));
		btnadd.click();
		driver.switchTo().window(parentwindowid);
		WebElement lnkphone = driver.findElement(By.xpath("//span[text()='Apple iPhone 12 (128GB) - Green']"));
		lnkphone.click();
		
		
	}

}
