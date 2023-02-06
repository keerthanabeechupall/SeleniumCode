package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fileuploading {
	static String ExpectedfileUploadText="C:\\fakepath\\add.txt";
	public static void main(String[] args) {
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
		wait.until(ExpectedConditions.elementToBeClickable(elementTab)); elementTab.click();
		
		
		   WebElement fileuploading=driver.findElement(By.xpath("//span[text()='Upload and Download']"));
		   
		   fileuploading.click();
		   WebElement fileUpload=driver.findElement(By.id("uploadFile"));
		   fileUpload.sendKeys("C:\\Users\\KeerthanaBeechupally\\Desktop\\add.txt");
		   WebElement fileText=driver.findElement(By.xpath("//p[text()='C:\\fakepath\\add.txt']"));
		   String ActualfileUploadText=fileText.getText();
		   if(ActualfileUploadText.equals(ExpectedfileUploadText))
			   System.out.println("text is matched");
		   else
			   System.out.println("text is not matched");
		   

	}

}
