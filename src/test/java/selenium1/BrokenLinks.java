package selenium1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
	
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			//WebDriver wait object creation
			WebDriverWait wait = new WebDriverWait(driver,10);
			
			//JavascriptExcecutor object creation
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//To open url
			driver.get("https://demoqa.com/");
			
			//Window maximization 
			driver.manage().window().maximize();
			
			//for click on element tab
			WebElement elementTab=driver.findElement(By.xpath("//div[@class='card-body']/h5[text()='Elements']"));
			
			
			//To scroll upto element tab
			js.executeScript("arguments[0].scrollIntoView();", elementTab);
			
			//webdriver wait with element  clickable
			wait.until(ExpectedConditions.elementToBeClickable(elementTab)); 
			elementTab.click();
			WebElement brokenLinks=driver.findElement(By.xpath("//span[text()='Broken Links - Images']"));
			brokenLinks.click(); 
		//capture links from webpage
		List<WebElement> listOfLinksElement=driver.findElements(By.tagName("a"));
		int list=listOfLinksElement.size();
		System.out.println("Total links count"+list);
		
		//Validate valid links
		List<WebElement>activeLinks=new ArrayList<WebElement>();
		for(WebElement link:listOfLinksElement){
			if(link.getAttribute("href")!=null &&(!link.getAttribute("href").contains("javascript"))) {
				activeLinks.add(link);
				
			}
				
		}
		int activeList=activeLinks.size();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Total active links"+activeList);
		for (int i = 0; i < activeLinks.size(); i++) {
		URL url = new URL(activeLinks.get(i).getAttribute("href"));
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.connect();
        String response = httpURLConnection.getResponseMessage();
        int response1=httpURLConnection.getResponseCode();
        
        httpURLConnection.disconnect();
        System.out.println(activeLinks.get(i).getAttribute("href") + "----------------->" + response+" "+response1);
        if(response1>=400)
        	System.out.println("broken link");
        else
        	System.out.println("Active link");
		}  
	}
}

	


