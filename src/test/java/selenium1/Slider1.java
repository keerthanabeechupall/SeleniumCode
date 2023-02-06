package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		WebElement sliderMinLocation=driver.findElement(By.xpath("//span"));
		System.out.println("Location of the element is"+sliderMinLocation.getLocation());//(59, 250)
		System.out.println("Size of the element is"+sliderMinLocation.getSize());//(21, 21)
		Actions action=new Actions(driver);
		action.dragAndDropBy(sliderMinLocation, 50, 0).build().perform();
		WebElement sliderMaxLocation=driver.findElement(By.xpath("//div[@id='slider-range']/span[2]"));
		System.out.println("Location of the element is"+sliderMaxLocation.getLocation());//(612, 250)
		System.out.println("Size of the element is"+sliderMaxLocation.getSize());//(21, 21)
		action.dragAndDropBy(sliderMaxLocation, -120, 0).build().perform();
		
		
		
	}

}
