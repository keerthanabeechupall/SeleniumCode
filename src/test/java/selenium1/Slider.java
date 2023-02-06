package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement slider=driver.findElement(By.xpath("//h2[text()='Slider']"));
		js.executeScript("arguments[0].scrollIntoView();",slider);
        //To do slider we need to install dimensions plugin which is available in  chrome webstore
		System.out.println("the location of the slider:"+slider.getLocation());//(987,1322)
		System.out.println("size of the element is:"+slider.getSize());//(340,33)
		Actions action=new Actions(driver);
		action.dragAndDropBy(slider,20 ,0).perform();
		
		
		
	}

}
