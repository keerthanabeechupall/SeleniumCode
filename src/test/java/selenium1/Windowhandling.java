package selenium1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windowhandling {
    static String expectedTitle="Window Handles Practice - H Y R Tutorials";
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		  JavascriptExecutor js =(JavascriptExecutor)driver;
		  //To open URL
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		//Window maximization
		driver.manage().window().maximize();
		//To get a title
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		//Compare title
		if(actualTitle.equals(expectedTitle))
		
			System.out.println("title is matched");
		else
			System.out.println("title is not matched");
		//To get parent window id
		String parentwindow=driver.getWindowHandle();
		System.out.println("parent window:"+parentwindow);
		// for to open new tab
		WebElement openNewTab=driver.findElement(By.id("newWindowBtn"));
		//To scroll upto new tab window
		js.executeScript("arguments[0].scrollIntoView();", openNewTab);
		//To click on open new tab
		openNewTab.click();
		//To get parent and child window handles
		Set<String> handles=driver.getWindowHandles();
		//to store handles in handle using for each loop
		for(String handle:handles) {
	    System.out.println(handle);
	    //for switch to child window
	    if(!handle.equalsIgnoreCase(parentwindow)) {
	    	driver.switchTo().window(handle);
	    	driver.manage().window().maximize();
	    	Thread.sleep(3000);
	    WebElement firstName=driver.findElement(By.id("firstName"));
		js.executeScript("arguments[0].scrollIntoView();", firstName);
        Thread.sleep(3000);
	    firstName.sendKeys("Keerthana");
	    System.out.println("window switched");
		driver.close();

	    }
		}
		driver.switchTo().window(parentwindow);
		Thread.sleep(3000);
		WebElement name=driver.findElement(By.xpath("//input[@id='name']"));
		name.sendKeys("keerthi");
		driver.quit();
				
	}
}
