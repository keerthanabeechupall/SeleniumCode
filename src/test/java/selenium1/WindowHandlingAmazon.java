package selenium1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingAmazon {

	public static void main(String[] args) throws AWTException, InterruptedException {
		 WebDriverManager.chromedriver().setup();
		   WebDriver driver=new ChromeDriver();
		   driver.get("https://www.amazon.in/");
		   driver.manage().window().maximize();
		   WebElement mobiles=driver.findElement(By.xpath("//a[text()='Mobiles']"));
		   Actions action=new Actions(driver);
		   action.contextClick(mobiles).build().perform();
		   Robot robo=new Robot();
		   robo.keyPress(KeyEvent.VK_DOWN);
		   robo.keyRelease(KeyEvent.VK_DOWN);
		   robo.keyPress(KeyEvent.VK_ENTER);
		   robo.keyRelease(KeyEvent.VK_ENTER);
		   String parentwindow=driver.getWindowHandle();
		   System.out.println("parent window:"+parentwindow);
		   Set<String> handles=driver.getWindowHandles();
		   System.out.println(handles);
			//to store handles in handle using for each loop
			for(String handle:handles) {
		    System.out.println(handle);
		    //for switch to child window
		    if(!handle.equalsIgnoreCase(parentwindow)) {
		    	driver.switchTo().window(handle);
		    	Thread.sleep(3000);
		    	driver.findElement(By.xpath("//a[text()='Accessories']")).click();
		    	
			   driver.close();

		    }
			}
			

		   


	}

}
