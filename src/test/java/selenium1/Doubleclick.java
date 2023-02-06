package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Doubleclick {

	public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    //To open url
    driver.get("https://testautomationpractice.blogspot.com/");
    //Window maximization
    driver.manage().window().maximize();
    //Create action driver class
    Actions action=new Actions(driver);
    //to do double click action
    WebElement doubleClickElement=driver.findElement(By.xpath("//button[text()='Copy Text']"));
    action.doubleClick(doubleClickElement).build().perform();
    String actualData=doubleClickElement.getText();
	String ExpectedData="Double click on button, the text from Field1 will be copied into Field2.";
	if(ExpectedData.contains(actualData)) 
		System.out.println("text is matched");
		else
			System.out.println("text is not matched");
    
    
    
    
	}

}
