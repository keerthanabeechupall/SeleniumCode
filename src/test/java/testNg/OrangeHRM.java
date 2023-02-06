package testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	WebDriver driver;
	WebDriverWait wait;
	@Test
	public void TestLaunchURL() throws Exception {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    wait=new WebDriverWait(driver,30);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement userName=driver.findElement(By.name("username"));
		wait.until(ExpectedConditions.elementToBeClickable(userName));
		userName.sendKeys("Admin");
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("admin123");
		WebElement loginButton=driver.findElement(By.xpath(" //button[@type='submit']"));
		loginButton.click();
	}
	@Test
	public void TestMyinfo() throws Exception {
		Thread.sleep(5000);
		WebElement  MyInfo=driver.findElement(By.xpath("//a[@class='oxd-main-menu-item']/span[text()='My Info']"));
		wait.until(ExpectedConditions.elementToBeClickable(MyInfo));
		Thread.sleep(5000);
		MyInfo.isDisplayed();		
		
		
	}

}
