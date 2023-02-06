package selenium1;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenImages {

	public static void main(String[] args) {

	}
	public void brokenLinks() {
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
		//Click on broken links
		WebElement brokenLinks=driver.findElement(By.xpath("//span[text()='Broken Links - Images']"));
		brokenLinks.click(); 
		//To find all the images
		List<WebElement>images=driver.findElements(By.tagName("img"));
		//for how many images are present in webpage
		System.out.println(images.size());
		for(WebElement image:images) {
			//Get src tag attributes
			String imageSrc=image.getAttribute("src");
			try {
				//create url object
			URL url=new URL(imageSrc);
			//to get response we need to connect server so that we are using URL connection
			//URLConnection is abstract so we are unable to create object
			URLConnection urlconnection=url.openConnection();
		//Type cast the Http conncetion 
			HttpURLConnection httpURLconncetion=(HttpURLConnection)urlconnection;
			httpURLconncetion.setConnectTimeout(3000);
			httpURLconncetion.connect();
			if(httpURLconncetion.getResponseCode()==200)
			
				System.out.println(imageSrc+">>"+httpURLconncetion.getResponseCode()+">>"+" "+httpURLconncetion.getResponseMessage());
			else
				System.err.println(imageSrc+">>"+httpURLconncetion.getResponseCode()+">>"+" "+httpURLconncetion.getResponseMessage());

			httpURLconncetion.disconnect();
			}catch(Exception e) {
				System.err.println(imageSrc);
			}
		
			
		}
	}

}
