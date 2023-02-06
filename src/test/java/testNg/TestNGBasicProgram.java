package testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGBasicProgram {
	@Test
public void TestGoogle() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	WebElement searchBox=driver.findElement(By.name("q"));
	searchBox.sendKeys("HYR tutorials",Keys.ENTER);
	String title=driver.getTitle();
	System.out.println(title);
	driver.close();
	
}
	@Test
	public void TestFacebook() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement searchBox=driver.findElement(By.name("email"));
		searchBox.sendKeys("HYR tutorials",Keys.ENTER);
		String title=driver.getTitle();
		System.out.println(title);
		driver.close();
	}

}
