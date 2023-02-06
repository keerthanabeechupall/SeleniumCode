package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/sliders/");
		driver.manage().window().maximize();
		
	    WebElement ele=	driver.findElement(By.xpath("//*[@class='demo-frame lazyloaded']"));
		driver.switchTo().frame(ele);
		Thread.sleep(3000);
	   String text=	driver.findElement(By.xpath("//*[@class='ui-state-default ui-corner-all ui-helper-clearfix']")).getText();
		System.out.println(text);

		WebElement greenSlider=driver.findElement(By.xpath("//div[@id='green']/span"));
		System.out.println(greenSlider.getLocation());//(179,116)
		Actions action=new Actions(driver);
		Thread.sleep(3000);
		action.dragAndDropBy(greenSlider, 200, 0);
		Thread.sleep(3000);
		
		}

}
