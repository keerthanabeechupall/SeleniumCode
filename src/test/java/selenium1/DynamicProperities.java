package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicProperities {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/dynamic-properties");
		driver.getTitle();
		Thread.sleep(5000);
		WebElement willEnable5SecondsButton=driver.findElement(By.xpath("//button[text()='Will enable 5 seconds']"));
		willEnable5SecondsButton.click();
		Thread.sleep(3000);
		WebElement ColourChange=driver.findElement(By.xpath("//button[text()='Color Change']"));
		ColourChange.click();
		WebElement visibleAfter5seconds=driver.findElement(By.xpath("//button[text()='Visible After 5 Seconds']"));
		visibleAfter5seconds.click();

	}

}
