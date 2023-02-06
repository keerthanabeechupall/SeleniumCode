package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement scrollElement=driver.findElement(By.xpath("//h2[text()='Drag and Drop Images']"));
		js.executeScript("arguments[0].scrollIntoView();",scrollElement);
		Actions action=new Actions(driver);
		WebElement source=driver.findElement(By.xpath("//h5[text()='Mr John']"));
		WebElement target=driver.findElement(By.id("trash"));
		action.dragAndDrop(source,target ).build().perform();
		WebElement source1=driver.findElement(By.xpath("//h5[text()='Mary']"));
		WebElement target1=driver.findElement(By.id("trash"));
		action.dragAndDrop(source1,target1 ).build().perform();
		
	}

}
