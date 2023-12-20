package org.practise;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HospitalDemo {
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Eclipse\\octworkspace\\Practiseselenium1\\chrdvr\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://smart-hospital.in/demo");
		
		//to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,850)", "");
		
		driver.findElement(By.xpath("//a[contains(text(),'Patient Login')]")).click();
		
//		WebElement userName= driver.findElement(By.xpath("//input[@id='email']"));
//		userName.clear();
//		userName.sendKeys("pat1");
//		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.className("btn")).click();

	}
}
