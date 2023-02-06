package selenium1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompleteFeature {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.in");
		WebElement input=driver.findElement(By.xpath("//input[@name='q']"));
		input.sendKeys("Selenium");
		List<WebElement>elements=driver.findElements(By.xpath("//ul/li[@class='sbct']"));
		System.out.println(elements.size());
		for(WebElement b:elements)
		{
			String element=b.getText();
			
			System.out.println(element);
		}
	}

}
