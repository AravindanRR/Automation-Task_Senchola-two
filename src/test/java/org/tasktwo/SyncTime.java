package org.tasktwo;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncTime extends Baseclss {

	public static void implicitTime() {
		// 1
		// driver.manage().timeouts().implicitlyWait(time);
		// // 2.
		// try {
		// driver.manage().timeouts().wait(2000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// 3.
		// driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
	}

	public static void staleWait(WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.stalenessOf(element));
	}

	public static void visibleEleWait(WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void clickEleWait(WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void commonWait(int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.withTimeout(Duration.ofSeconds(sec));
	}
}
