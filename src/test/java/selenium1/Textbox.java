package selenium1;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Textbox {
	static String expectedName="keerthana";
	static String expectedEmail="keerthana123@gmail.com";
	static String expectedCurrentAddress="HYD";
	static String expectedPermanentAddress="MNT";
    public static void main(String[] args) throws InterruptedException {
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
		
		//To click on textbox
		WebElement textBox=driver.findElement(By.xpath("//span[text()='Text Box']"));
		textBox.click();
		
		//To give a full name
		WebElement userName=driver.findElement(By.id("userName"));
		userName.sendKeys("keerthana");
		
		//to give a user email
		WebElement emailID=driver.findElement(By.id("userEmail"));
		emailID.sendKeys("keerthana123@gmail.com");
		
		//To give current address
		WebElement currentAddress=driver.findElement(By.id("currentAddress"));
		currentAddress.sendKeys("HYD");
	   
		//To giver permanent address
		WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
		permanentAddress.sendKeys("MNT");
		
		//To click on submit button
		WebElement submitButton=driver.findElement(By.xpath("//div[@class='text-right col-md-2 col-sm-12']/button[@id='submit']"));
		js.executeScript("arguments[0].scrollIntoView();", submitButton);
		submitButton.click();
		
		
		//To validate name text
		WebElement name1=driver.findElement(By.id("name"));
		String actualName=name1.getText();
		System.out.println(actualName);
		if(actualName.contains(expectedName))
			System.out.println("name matched");
		else
			System.out.println("name not matched");
		
		
		//To validate email
		WebElement Email1=driver.findElement(By.id("email"));
		String actualEmail=Email1.getText();
		System.out.println(actualEmail);
		if(actualEmail.contains(expectedEmail))
			System.out.println("email is mathched");
		else
			System.out.println("email is not matched");
		
		
		//To validate the current address
		 WebElement currentAddress1=driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12']/p[@id='currentAddress']"));
		    String actualCurrentAddress=currentAddress1.getText();
		    System.out.println(actualCurrentAddress);
		    if(actualCurrentAddress.contains(expectedCurrentAddress))
		    
		    	System.out.println("current address is matched");
		    
		    else
		    	System.out.println("current address is not matched");
		    
		    //To validate permanent address
		    WebElement permanentAddress1=driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12']/p[@id='permanentAddress']"));
			String ActualPermanentAddress=permanentAddress1.getText();
			System.out.println(ActualPermanentAddress);
			if(ActualPermanentAddress.contains(expectedPermanentAddress))
				System.out.println("Permanent address is matched");
			else
				System.out.println("permanent address is not matched");
		    
		
		
	}

}
