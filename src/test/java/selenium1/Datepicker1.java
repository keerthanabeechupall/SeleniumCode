package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Datepicker1 {

   public static void main(String[] args) {
   WebDriverManager.chromedriver().setup();
   WebDriver driver=new ChromeDriver();
   driver.get("https://jqueryui.com/datepicker/");
   driver.manage().window().maximize();
   driver.switchTo().frame(0);
   driver.findElement(By.id("datepicker")).click();
   for(int i=1;i<=6;i++) {
   driver.findElement(By.xpath("//span[text()='Prev']"));
   String ele=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
   if(ele.equalsIgnoreCase("April 2022")) 
	   break;
      
   
   }
   driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[1]/td[2]//a[text()='2']")).click();
 

	}
}


