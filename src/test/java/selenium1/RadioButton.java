package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {
	 static String ExpectedYesButton="Yes";
	 static String ExpectedImpressiveButton="Impressive";

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
		
		//To click on radio buttons
		WebElement radioButton=driver.findElement(By.xpath("//span[text()='Radio Button']"));
		radioButton.click();
		
		//To click on yes button
		WebElement yesButton=driver.findElement(By.xpath("//label[@for='yesRadio']"));
		Thread.sleep(10000);
		yesButton.click();
		
		//To check yes button is enabled or not
		if(yesButton.isEnabled())
			System.out.println("yes button is enabled Return:"+yesButton.isEnabled());
		else
			System.out.println("Yes button is not enabled Return:"+yesButton.isEnabled());
		
		// yes button text compression
		WebElement yesButtonText=driver.findElement(By.xpath("//label[@for='yesRadio']"));
		String actualYesButtonText=yesButtonText.getText();
		if(actualYesButtonText.contains(ExpectedYesButton))
			System.out.println("yes button title is matched");
		else
			System.out.println("Yes button title is not matched");
		
		//To click on impressive button
		WebElement impressiveButton=driver.findElement(By.xpath("//label[@for=\"impressiveRadio\"]"));
		Thread.sleep(5000);
		impressiveButton.click();
		
		//To check impressive button is enabled or not
		if(impressiveButton.isEnabled())
			System.out.println("impressive button is enabled return:"+impressiveButton.isEnabled());
		else
			System.out.println("impressive button is not enabled Retrun:"+impressiveButton.isEnabled());
		
		//comapare impressive button text
		WebElement impressiveButtonText=driver.findElement(By.xpath("//span[text()='Impressive']"));
		String actualImpressiveButton=impressiveButtonText.getText();
		if(actualImpressiveButton.contains(ExpectedImpressiveButton))
			System.out.println("Impressive button text is matched");
		else
			System.out.println("Impressive button text is not matched");
		
		
		//to check No button is enabled or not
		WebElement noRadioButton=driver.findElement(By.id("noRadio"));
		if(noRadioButton.isEnabled())
			System.out.println("radio button is enabled return:"+noRadioButton.isEnabled());
		else
			System.out.println("radionbutton is disabled return:"+noRadioButton.isEnabled());
		
		
		
		
		
	}

}
