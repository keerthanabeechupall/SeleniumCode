package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeForm {

	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    WebDriverWait wait=new WebDriverWait(driver,10);
    JavascriptExecutor js =(JavascriptExecutor)driver;    
    driver.get("https://demoqa.com/automation-practice-form");
    driver.manage().window().maximize();
    WebElement firstName=driver.findElement(By.id("firstName"));
    firstName.sendKeys("Keerthana");
    WebElement lastName=driver.findElement(By.id("lastName"));
    lastName.sendKeys("B");
    WebElement email=driver.findElement(By.id("userEmail"));
    email.sendKeys("keerthana123@gmail.com");
    WebElement gender=driver.findElement(By.xpath("//label[text()='Female']"));
    gender.isEnabled();
    gender.click();
    WebElement userNumber=driver.findElement(By.id("userNumber"));
    userNumber.sendKeys("1234567890");
    WebElement dateOfBirthInput=driver.findElement(By.id("dateOfBirthInput"));
    dateOfBirthInput.click();
    WebElement month=driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
    month.click();
    Thread.sleep(2000);
    Select sel=new Select(month);
    sel.selectByValue("6");
    WebElement year=driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
    year.click();
   WebElement elements=driver.findElement(By.xpath("//option[text()='1999']"));
   js.executeScript("arguments[0].scrollIntoView();",elements );
   elements.click();
  Thread.sleep(3000);
  driver.findElement(By.xpath("//div[text()='3']")).click();
  Thread.sleep(3000);
  WebElement subject=driver.findElement(By.xpath("//div[@class='col-md-9 col-sm-12']/div[@id='subjectsContainer']"));
  wait.until(ExpectedConditions.visibilityOf(subject));
  wait.until(ExpectedConditions.elementToBeClickable(subject));
  Thread.sleep(3000);
  
  
    
    
	}

}
