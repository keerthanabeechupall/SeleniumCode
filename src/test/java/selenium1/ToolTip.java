package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip {
	static String ExpectedText="You hovered over the Button";
	static String ExpectedText1="You hovered over the text field";

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,10);
		driver.get("https://demoqa.com/tool-tips");
		driver.manage().window().maximize();
		WebElement Tooltipmessage=driver.findElement(By.xpath("//button[text()='Hover me to see']"));
		Actions action=new Actions(driver);
		action.moveToElement(Tooltipmessage).build().perform();
		Thread.sleep(5000);
		WebElement toolTipMessage=driver.findElement(By.xpath("//div[text()='You hovered over the Button']"));
	    wait.until(ExpectedConditions.visibilityOf(toolTipMessage));
		String toolTipMessageText=toolTipMessage.getText();
		System.out.println(toolTipMessageText);
	    if(toolTipMessageText.equalsIgnoreCase(ExpectedText)) {
	    	System.out.println("tooltip message is matched");
	    }
	    else
	    	System.out.println("tooltip message is not matched");
	    Thread.sleep(5000);
	    WebElement toolTipTextBox=driver.findElement(By.xpath("//input[@id='toolTipTextField']"));
	    action.moveToElement(toolTipTextBox).build().perform();
	    Thread.sleep(5000);
	    WebElement toolTipMessage2=driver.findElement(By.xpath("//div[text()='You hovered over the text field']"));
	    wait.until(ExpectedConditions.visibilityOf(toolTipMessage2));
	    String toolTipMessageText1=toolTipMessage2.getText();
	    System.out.println(toolTipMessageText1);
	   if(toolTipMessageText1.equalsIgnoreCase(ExpectedText1))
	    System.out.println("Tool tip2 message is matched");
	    else
	    	System.out.println("Tool tip2 message is not matched");
		
	}

}
