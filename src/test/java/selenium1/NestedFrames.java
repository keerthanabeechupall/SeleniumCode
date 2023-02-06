package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//To open url
		driver.get("https://demoqa.com/nestedframes");
		//driver maximization
		driver.manage().window().maximize();
		driver.switchTo().frame("frame1");
		WebElement parentFrame=driver.findElement(By.xpath("//*[text()='Parent frame']"));
		String ele=parentFrame.getText();
		System.out.println(ele);
		WebElement ele2=driver.findElement(By.xpath("//p[text()='Child Iframe']"));
		driver.switchTo().frame(ele2);
		String ele3=ele2.getText();
		System.out.println(ele3);
	}

}
