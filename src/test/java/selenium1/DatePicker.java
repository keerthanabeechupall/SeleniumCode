package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.get("https://jqueryui.com/datepicker/");
    driver.switchTo().frame(0);
    driver.manage().window().maximize();
    Thread.sleep(3000);
    driver.findElement(By.id("datepicker")).click(); 
    Thread.sleep(7000);
    for(int i=1;i<=6;i++) {
    	driver.findElement(By.xpath("//span[text()='Next']")).click();    }
	
	 WebElement date=driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr[2]/td[2]//a[text()='3']"
			
			));
	 date.click();
	
		

}
}
