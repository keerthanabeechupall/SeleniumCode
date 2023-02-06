package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Buttons {
	static String ExpectedDoubleClickText="You have done a double click";
	static String ExpectedRightClickText="You have done a right click";
	static String ExpectedClickText="You have done a dynamic click";
			
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
		wait.until(ExpectedConditions.elementToBeClickable(elementTab)); 
		elementTab.click();
		
		//To click on buttons
		WebElement Buttons=driver.findElement(By.xpath("//*[@id='item-4']/span[text()='Buttons']"));
		Buttons.click();		
		
		//To do double click on element
		Actions action=new Actions(driver);
		WebElement doubleClickButton=driver.findElement(By.id("doubleClickBtn"));
		action.doubleClick(doubleClickButton).build().perform();
		
		//To compare double click syntax
		WebElement doubleClickText=driver.findElement(By.id("doubleClickMessage"));
		String actualDoubleClick=doubleClickText.getText();
		if(actualDoubleClick.contains(ExpectedDoubleClickText))
			System.out.println("Double click text is matched");
		else
			System.out.println("Double click text is not matched");
		
		//To do Right click
		WebElement RightClickButton=driver.findElement(By.id("rightClickBtn"));
		action.contextClick(RightClickButton).build().perform();
		
		//To compare right click
		WebElement rightclickText=driver.findElement(By.id("rightClickMessage"));
		String actualRightClickText=rightclickText.getText();
		
		if(actualRightClickText.contains(ExpectedRightClickText))
			System.out.println("Right click text is matched");
		else
			System.out.println("Right click text is not matched");
		
		//To do click action
		WebElement clickButton=driver.findElement(By.xpath("//button[text()='Click Me']"));
		clickButton.click();
		
		//To compare text of click button
		WebElement clickButtonText=driver.findElement(By.id("dynamicClickMessage"));
		String actualClickElementText=clickButtonText.getText();
		if(actualClickElementText.contains(ExpectedClickText))
			System.out.println("Click text is matched");
		else
			System.out.println("Click text is not matched");
		
		
		
		

			
		
		
	}

}
