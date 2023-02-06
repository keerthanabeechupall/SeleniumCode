package selenium1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class automation {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
		   WebDriver driver=new ChromeDriver();
		   JavascriptExecutor js =(JavascriptExecutor)driver;

		   driver.get("https://testautomationpractice.blogspot.com/");
		   driver.switchTo().frame(0);
		   //driver.findElement(By.id("RESULT_TextField-1")).sendKeys("keerthana");

		   WebElement element=driver.findElement(By.xpath("//*[text()='Sunday']"));

		   js.executeScript("arguments[0].scrollIntoView();",element );
		  //element.click();
		  List<WebElement> listOfCheckBoxes=driver.findElements(By.xpath("//input[@class=\"multiple_choice\" and contains(@id,'RESULT_CheckBox-8_')]  "));
		  System.out.println("total no of checks boxes:"+listOfCheckBoxes.size());
		  for(int i=0;i<listOfCheckBoxes.size();i++)
		  {
			  if(i<2)
				  listOfCheckBoxes.get(i).click();
		  }
		   
	}

}
