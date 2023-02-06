package selenium1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//WebDriver wait object creation
		WebDriverWait wait = new WebDriverWait(driver,10);
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
		//Click on links button
		WebElement linksButton=driver.findElement(By.xpath("//*[@id='item-5']/span[text()='Links']"));
		linksButton.click();
		WebElement HomeButton=driver.findElement(By.xpath("//a[text()='Home']"));
		HomeButton.click();
		String parentWindow=driver.getWindowHandle();
		System.out.println(parentWindow);
		Set<String> childwindow=driver.getWindowHandles();
		System.out.println(childwindow);
		for(String handles:childwindow) {
			if(!handles.equals(parentWindow)) {
				String title=driver.switchTo().window(handles).getTitle();
			if(title.equalsIgnoreCase("ToolsQA")) {

				WebElement elementTab1=driver.findElement(By.xpath("//div[@class='card-body']/h5[text()='Elements']"));
				
				//To scroll upto element tab
				js.executeScript("arguments[0].scrollIntoView();", elementTab1);
				elementTab1.click();

			break;
		}}}
		driver.switchTo().window(parentWindow);
		WebElement homePALEC=driver.findElement(By.xpath("//a[@id='dynamicLink']"));
		homePALEC.click();
		
		

//		WebElement created=driver.findElement(By.id("created"));
//		created.click();
//		WebElement NoContent=driver.findElement(By.id("no-content"));
//		NoContent.click();
//	    WebElement Moved=driver.findElement(By.id("moved"));
//	    Moved.click();
//	    WebElement Badrequest=driver.findElement(By.id("bad-request"));
//	    Badrequest.click();
//	    WebElement unauthorized=driver.findElement(By.id("unauthorized"));
//	    unauthorized.click();
//	    WebElement forbidden=driver.findElement(By.id("forbidden"));
//	    forbidden.click();
//	    WebElement notFound=driver.findElement(By.id("invalid-url"));
//	    notFound.click();
//	    
	    
	    
			
		
	
		
		
	}

}
