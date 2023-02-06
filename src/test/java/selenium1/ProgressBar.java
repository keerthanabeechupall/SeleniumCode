package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProgressBar {

	public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.get("https://demoqa.com/progress-bar");
    driver.manage().window().maximize();
   WebElement startButton= driver.findElement(By.xpath("//button[@id='startStopButton']"));
   startButton.click();
    WebElement progressBar=driver.findElement(By.xpath("//div[@role='progressbar']"));
    WebDriverWait wait=new WebDriverWait(driver,10);
    boolean progressBarStatus=wait.until(ExpectedConditions.attributeToBe(progressBar, "aria-valuenow", "50"));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Stop']"))).click();

    //if(progressBarStatus==true)
    	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='resetButton']"))).click();
    
	}

}
