package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

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
		
		//To click on WebTable
		WebElement webTable=driver.findElement(By.xpath("//span[text()='Web Tables']"));
		webTable.click();
	
		//To click on add button
		WebElement addButton=driver.findElement(By.xpath("//button[text()='Add']"));
		addButton.click();
		//To enter firstname
		WebElement firstName=driver.findElement(By.id("firstName"));
		firstName.sendKeys("keerthi");
		//to enter last name
		WebElement lastName=driver.findElement(By.id("lastName"));
		lastName.sendKeys("b");
		
		//to enter email
		WebElement email=driver.findElement(By.id("userEmail"));
		email.sendKeys("keerthi123@gmail.com");
		
		//To enter age
		WebElement Age=driver.findElement(By.id("age"));
		Age.sendKeys("23");
		
		//To enter salary
		WebElement salary=driver.findElement(By.id("salary"));
		salary.sendKeys("20000");
		
		//to enter department
		WebElement department=driver.findElement(By.id("department"));
		department.sendKeys("Testing");
		WebElement submitButton=driver.findElement(By.id("submit"));
		submitButton.click();
		
		//To click on edit button 
		WebElement editButton1=driver.findElement(By.xpath("//div[@class='action-buttons']/span[@id='edit-record-1']"));
		editButton1.click();
		//To edit age in record 1
		WebElement age=driver.findElement(By.xpath("//div[@class='col-md-2 col-sm-12']/input[@id='age']"));
		age.clear();
		age.sendKeys("29");
		
		//Click on submit button
		WebElement submitButton1=driver.findElement(By.xpath("//div[@class='text-right col-md-2 col-sm-12']/button[@id='submit']"));
		submitButton1.click();
		
		//To edit salary in record 2
		WebElement editButton2=driver.findElement(By.xpath("//div[@class='action-buttons']/span[@id='edit-record-2']"));
		editButton2.click();
		
		//To edit salary
		WebElement salaryEdit=driver.findElement(By.xpath("//div[@class='col-md-9 col-sm-12']/input[@id='salary']"));
		salaryEdit.clear();
		salaryEdit.sendKeys("50000");
		
		//Click on submit button
		WebElement submitButton2=driver.findElement(By.xpath("//div[@class='text-right col-md-2 col-sm-12']/button[@id='submit']"));
		submitButton2.click();
		
		//To delete row
		WebElement deleteRecord=driver.findElement(By.xpath("//span[@id='delete-record-4']"));
		deleteRecord.click();

		
		
		
		
		
		
	}

}
