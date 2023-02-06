package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrmLogin {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,10);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		WebElement ele1=driver.findElement(By.xpath("//input[@placeholder='Username']"));
		wait.until(ExpectedConditions.elementToBeClickable(ele1)); 
		ele1.sendKeys("Admin");
		WebElement ele2=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		wait.until(ExpectedConditions.elementToBeClickable(ele2)); 
		ele2.sendKeys("admin123");
		WebElement loginButton=driver.findElement(By.xpath("//button[text()=' Login ']"));
		loginButton.click();
	 

}
}
