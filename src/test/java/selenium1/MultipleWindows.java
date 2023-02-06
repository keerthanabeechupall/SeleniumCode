package selenium1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows {
    static String expectedTitle="Window Handles Practice - H Y R Tutorials";
    static String ExpectedChildWindow1Title="Basic Controls - H Y R Tutorials";
    static String ExpectedChildWindowTitle2="XPath Practice - H Y R Tutorials";
   
     public static void main(String[] args) {
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
		// for to open multiple windows
		WebElement multipleWindows=driver.findElement(By.id("newWindowsBtn"));
		js.executeScript("arguments[0].scrollIntoView();",multipleWindows);
         multipleWindows.click();
		
         //to get child windows
         Set<String>handles=driver.getWindowHandles();
         for(String handle:handles) {
        	 System.out.println(handle);
        	String titles= driver.switchTo().window(handle).getTitle();
        	System.out.println(titles);
        	if(titles.equalsIgnoreCase(ExpectedChildWindow1Title)) {
        		driver.switchTo().window(handle);
        		 WebElement firstName=driver.findElement(By.xpath("//input[@id='firstName']"));
                 js.executeScript("arguments[0].scrollIntoView();",firstName);
                 firstName.sendKeys("keerthana");
                 //driver.close();	
        	}
        	 
         }
         //Switch to main window
         driver.switchTo().window(parentwindow);
         WebElement name=driver.findElement(By.id("name"));
         name.sendKeys("keerthi");
         //switch to another window
         for(String handle:handles) {
        	 System.out.println(handle);
        	String titles= driver.switchTo().window(handle).getTitle();
        	System.out.println(titles);
        	if(titles.equalsIgnoreCase(ExpectedChildWindowTitle2)) {
        		driver.switchTo().window(handle);
        		WebElement firstname=driver.findElement(By.xpath("//*[text()='First Name']"));
                js.executeScript("arguments[0].scrollIntoView();",firstname);
                firstname.sendKeys("keerthi");

        		
        		
        		
        		
                	
        	}
        	 
         }
         
	}

}
