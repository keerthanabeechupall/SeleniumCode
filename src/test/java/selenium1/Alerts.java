package selenium1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
    static String okButtonExpectedText="You selected Ok";
    static String cancelButtonExpectedText="You selected Cancel";
    static String textBoxExpectedText="appearYou entered keerthana";
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		   WebDriver driver=new ChromeDriver();
		   WebDriverWait wait=new WebDriverWait(driver,5);
		   driver.get("https://demoqa.com/");
		   String Title1=driver.getTitle();
		   System.out.println(Title1);
		   driver.manage().window().maximize();
		   JavascriptExecutor js=(JavascriptExecutor)driver;
		   WebElement alertsElement=driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
		   js.executeScript("arguments[0].scrollIntoView();",alertsElement);
		   alertsElement.click();
		   WebElement Alert=driver.findElement(By.xpath("//span[text()='Alerts']"));
		   Alert.click();
		   WebElement clickMe1=driver.findElement(By.xpath("//div[@class='col']/button[@id='alertButton']"));
		   clickMe1.click();
		   wait.until(ExpectedConditions.alertIsPresent());
		   driver.switchTo().alert().accept();
		  			   
		   WebElement clickMe2=driver.findElement(By.xpath("//div[@class='col']/button[@id='timerAlertButton']"));
		   clickMe2.click();
		   wait.until(ExpectedConditions.alertIsPresent());
		   driver.switchTo().alert().accept();
		   WebElement clickMe3=driver.findElement(By.xpath("//div[@class='col']/button[@id='confirmButton']"));
           Thread.sleep(5000);
		   clickMe3.click();
		   driver.switchTo().alert().accept();
		   WebElement confirmPostive=driver.findElement(By.id("confirmResult"));
		   String okButtonActualText=confirmPostive.getText();
		   if(okButtonActualText.equals(okButtonExpectedText)) 
			   System.out.println("ok title is matched");
		   
		   else
			   System.out.println(" ok title is not matched");
		   
          Thread.sleep(5000);
	      clickMe3.click();
	      driver.switchTo().alert().dismiss();
      WebElement confirmNegative=driver.findElement(By.id("confirmResult")); 
      String cancelButtonActualText=confirmNegative.getText();
      if(cancelButtonActualText.equals(cancelButtonExpectedText))
    	  System.out.println("cancel title is matched");
      else
    	  System.out.println("cancel title is not matched");
      WebElement clickMe4=driver.findElement(By.id("promtButton"));
      clickMe4.click();
      Thread.sleep(1000);
	   wait.until(ExpectedConditions.alertIsPresent());

    driver.switchTo().alert().sendKeys("keerthana");
	   wait.until(ExpectedConditions.alertIsPresent());
	   driver.switchTo().alert().accept();
     WebElement textBoxActualText=driver.findElement(By.id("promptResult"));
     if(textBoxActualText.equals(textBoxExpectedText))
    	 System.out.println("expected text box title is matched");
     else
    	 System.out.println("expected text box title is  not matched");
     driver.quit();
      
      
      
      



	}

}
