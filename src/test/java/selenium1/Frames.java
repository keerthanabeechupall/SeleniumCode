package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//To open url
		driver.get("https://demoqa.com/frames");
		//driver maximization
		driver.manage().window().maximize();
		//switch to frame 1
		driver.switchTo().frame("frame1");
		WebElement ele1=driver.findElement(By.xpath("//h1[text()='This is a sample page'][1]"));
		String el2=ele1.getText();
		System.out.println(el2);
		System.out.println("foucs switched to frame1");
		//back to main window
		driver.switchTo().defaultContent();
		//switch to frame2
		driver.switchTo().frame("frame2");
		WebElement ele2=driver.findElement(By.xpath("//h1[text()='This is a sample page'][1]"));
		String ele3=ele2.getText();
		System.out.println(ele3);

		
		System.out.println("focus switched to frame2");
		
		

	}

}
