package org.practise;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Omayo {
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"E:\\Eclipse\\octworkspace\\Practiseselenium1\\chrdvr\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.omayo.com/");
		
		//Homepage validation
		
		
	WebElement enterName= driver.findElement(By.id("name"));
	enterName.sendKeys("Testsample");
	WebElement enterEmail= driver.findElement(By.id("email"));
	enterEmail.sendKeys("Test@gmail.com");
	WebElement enterPhone= driver.findElement(By.id("phone"));
	enterPhone.sendKeys("9344196004");
	WebElement enterMessage= driver.findElement(By.name("message"));
	enterMessage.sendKeys("Self-review: This is carried out by the tester");
	
	Robot rob = new Robot();

		rob.keyPress(KeyEvent.VK_TAB);
		rob.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
	
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		
	WebElement sendButton= driver.findElement(By.xpath("//input[@type='submit']"));
	sendButton.click();
	
//	driver.close();
	}
	

}
