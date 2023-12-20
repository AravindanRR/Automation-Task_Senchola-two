package org.taskone;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Basecls {
	static WebDriver driver = null;

	public void launchBrowser() throws IOException, AWTException {
		driver = new ChromeDriver();
		String BaseUrl = "https://testautomationpractice.blogspot.com/";
		driver.get(BaseUrl);
		String ActualUrl = driver.getCurrentUrl();
		if (BaseUrl.equals(ActualUrl)) {
			maxWindow();
			//scrollDownAct();
			//scrollDownSpecificElement("//h2[text()='Web Table']");
			//scrollDown();
			robScrnshot("Home page - ");
			// scrnshot("LaunchBrowser - ");
			// fullPagescrnshot("Launch - ");
		} else {
			driver.close();
		}

	}

	public void maxWindow() {
		driver.manage().window().maximize();
	}

	public static void scrnshot(String title) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String timestamp = sdf.format(new Date());

		TakesScreenshot shot = (TakesScreenshot) driver;
		File file = shot.getScreenshotAs(OutputType.FILE);
		File storage = new File("E:\\Eclipse\\octworkspace\\Screenshot\\" + title + timestamp + ".png");
		FileUtils.copyFile(file, storage);

	}
	
	public void robScrnshot(String title) throws AWTException, IOException {
		// get the current date and time
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String timestamp = sdf.format(new Date());
		// get the screen resolution
		Dimension browserSize = driver.manage().window().getSize();
		int width  = browserSize.getWidth(); //1366
		int height = browserSize.getHeight();// 768
		System.out.println("Width:-"+width+" Height:-"+height);
		// robot class used
		Robot rob = new Robot();
		BufferedImage screenshot = rob.createScreenCapture(new Rectangle(0, 0, 1366, 768));
		File storage = new File("E:\\Eclipse\\octworkspace\\Screenshot\\"+title + timestamp+".png");
		ImageIO.write(screenshot, "png", storage);
	}

	public static void fullPagescrnshot(String title) throws IOException {

		// WebDriverExtensions extensions = new WebDriverExtensions(driver);
		// File screenshotFile = extensions.getFullPageScreenshotAs(OutputType.FILE);
		// File storage = new File("E:\\Eclipse\\octworkspace\\Screenshot\\"+title
		// +".png");
		// FileUtils.copyFile(screenshotFile, storage);

		// TakesScreenshot shot = (TakesScreenshot) driver;
		// File storage = new File("E:\\Eclipse\\octworkspace\\Screenshot\\"+title
		// +".png");
		//
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// Long pageHeight = (Long) js.executeScript("return Math.max(
		// document.body.scrollHeight, "
		// + "document.body.offsetHeight, document.documentElement.clientHeight, "
		// + "document.documentElement.scrollHeight,
		// document.documentElement.offsetHeight );");
		//
		// js.executeScript("window.scrollTo(0, 0);");
		// int viewportHeight = driver.manage().window().getSize().getHeight();
		// int numberOfScreenshots = (int) Math.ceil((double) pageHeight /
		// viewportHeight);
		//
		// // Stitch the screenshots
		// for (int i = 0; i < numberOfScreenshots; i++) {
		// int yOffset = viewportHeight * i;
		// js.executeScript("window.scrollTo(0, arguments[0]);", yOffset);
		// File partialScreenshot = shot.getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(partialScreenshot, storage, true);
		// }

	}

	public void validateHomepage() throws IOException {
		String ActualHeading = "Automation Testing Practice";
		WebElement title = driver.findElement(By.className("title"));
		String ExpectedHeading = title.getText();

		if (ActualHeading.equalsIgnoreCase(ExpectedHeading)) {
			System.out.println("User land in Original Website");
			// scrnshot("ValidateHomepage - ");
		} else {
			System.out.println("User land in Wrong Website");
		}

	}

	// Enter the text in the text field using sendkeys
	public void enterText(String id, String text, String fieldname) throws IOException {
		WebElement textEnt = driver.findElement(By.id(id));
		textEnt.clear();
		textEnt.sendKeys(text);
		scrnshot(fieldname);
	}
	// Enter the text using Js
	public void enterTextJs() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('name').value='Aravind';");
		//js.executeScript("document.getElementByClassname('wikipedia-search-input').value='Aravind';");
	}
	// Select the radiobutton
	public void radioButton(String id, String radio) throws IOException {
		scrolldown(0, 150);
		WebElement buttonRadio = driver.findElement(By.id(id));
		buttonRadio.click();
		scrnshot(radio);
	}

	// Select the checkbox
	public void checkBox(String id, String checkbx, int y) throws IOException {
		scrolldown(0, y);
		WebElement checkBx = driver.findElement(By.id(id));
		checkBx.click();
		scrnshot(checkbx);
	}

	// Select the country
	public void slct(String text, String id, String contry) throws IOException {
		WebElement country = driver.findElement(By.id(id));
		Select sclt = new Select(country);
		sclt.selectByValue(text);
		scrnshot(contry);
	}

	// Choose the colour
	public void colourChange(String text, String id, String color) throws IOException {
		WebElement Changecolor = driver.findElement(By.id(id));
		Select sltcolor = new Select(Changecolor);
		sltcolor.selectByValue(text);
		scrnshot(color);
	}

	// Choose the multiple colour
	public void choosemulticolour(String text, String id, String color) throws IOException {
		WebElement Changecolor = driver.findElement(By.id(id));
		Select sltcolor = new Select(Changecolor);
		List<WebElement> options = sltcolor.getOptions();
		for (WebElement multicolor : options) {
			String colour = multicolor.getText();
			System.out.println(colour);
			sltcolor.selectByVisibleText(colour);
		}
		scrnshot(color);
	}

	// enter the date
	public void Dateselection(String text, String id, String date) throws IOException, InterruptedException {
		scrolldown(0, 650);
		WebElement Datesclt = driver.findElement(By.id(id));
		Datesclt.clear();
		Datesclt.sendKeys(text);
		Datesclt.sendKeys(Keys.ENTER);
		scrnshot(date);
	}

	// Click the given links
	public void verifyLinks(String id, String text, String currentlink, long y)
			throws IOException, InterruptedException {
		WebElement links = driver.findElement(By.partialLinkText(id));
		String ActualLinkName = links.getText();
		String ExpectedLinkName = text;
		if (ExpectedLinkName.equals(ActualLinkName))
			links.click();
		String Urllinks = driver.getCurrentUrl();
		System.out.println(Urllinks);
		if (Urllinks.equals(ActualLinkName))
			links.click();
		Thread.sleep(y);
		scrnshot(currentlink);
		driver.navigate().back();
	}

	// Click the homepage link
	public void Homepage(String id, String text) throws IOException {
		WebElement homepageLinks = driver.findElement(By.partialLinkText(id));
		String ActualHomepageLink = homepageLinks.getText();
		String ExpectedHomepageLink = text;
		if (ExpectedHomepageLink.equals(ActualHomepageLink))
			homepageLinks.click();
		scrnshot("Hompageloaded");
		String ActualHeading = "Automation Testing Practice";
		WebElement title = driver.findElement(By.className("title"));
		String ExpectedHeading = title.getText();
		scrnshot("Hompage");
		if (ActualHeading.equalsIgnoreCase(ExpectedHeading)) {
			System.out.println("User land in Original Website");
		} else {
			System.out.println("User land in Wrong Website");
		}
	}

	// Click the given Subscribtion links
	public void Links(String id, String text, String sublink) throws IOException {
		WebElement Sublinks = driver.findElement(By.className(id));
		String ActualLinkName = Sublinks.getText();
		String ExpectedLinkName = text;
		if (ExpectedLinkName.equals(ActualLinkName))
			Sublinks.click();
		String parentwindow = driver.getWindowHandle();
		System.out.println("Parent Window: " + parentwindow);

		Set<String> allWindows = driver.getWindowHandles();

		for (String string : allWindows) {
			if (!(parentwindow.equals(string))) {
				driver.switchTo().window(string);
				System.out.println("Child Window: " + string);
				System.out.println(driver.getCurrentUrl());
				scrnshot("Html Sublinks - ");
				clseWindow();
			}
		}

	}

	public void webTable() {
		// Get the row size
		int rowSize = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr")).size();
		System.out.println(rowSize);

		// Get the column size
		int columnSize = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th")).size();
		System.out.println(columnSize);

		// Get the table heading
		List<WebElement> heading = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th"));
		for (WebElement element : heading) {
			String text = element.getText();
			System.out.print(text + " ");
		}

		// get all the price
		List<WebElement> price = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/td[4]"));
		for (WebElement rate : price) {
			String total = rate.getText();
			int number = Integer.parseInt(total);
			System.out.println(number);
		}

		// get the Master selenium details

		for (int i = 1; i <= 4; i++) {
			WebElement details = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[5]/td[" + i + "]"));
			String course = details.getText();
			System.out.print(course + "|");
		}

		// get all the subject details
		WebElement details = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr/th[3]"));
		String head = details.getText();
		System.out.println(head);
		for (int i = 1; i <= 4; i++) {
			WebElement subdetails = driver
					.findElement(By.xpath("(//table[@name='BookTable']/tbody/tr/td[3])[" + i + "]"));
			String subject = subdetails.getText();
			System.out.println(subject);
		}
	}

	public void paginationTable() throws InterruptedException {
		// get the column count & value
		List<WebElement> columncount = driver.findElements(By.xpath("//table[@id=\"productTable\"]/thead/tr/th"));
		System.out.println("Size of Column: " + columncount.size());
		for (WebElement element : columncount) {
			System.out.println("->" + element.getText());
		}

		// get the row count & value
		List<WebElement> rowcount = driver.findElements(By.xpath("//table[@id=\"productTable\"]/tbody/tr"));
		System.out.println(rowcount.size());
		for (WebElement rowElement : rowcount) {
			System.out.println(rowElement.getText());
		}

		// get all row value
		int pagesize = driver.findElements(By.xpath("//ul[@id=\"pagination\"]/li")).size();
		System.out.println(pagesize);
		for (int i = 1; i <= pagesize; i++) {
			driver.findElement(By.xpath("(//ul[@id=\"pagination\"]/li)[" + i + "]")).click();
			Thread.sleep(2000);
			List<WebElement> rowcount1 = driver.findElements(By.xpath("//table[@id=\"productTable\"]/tbody/tr"));
			for (WebElement rowElement : rowcount1) {
				System.out.println(rowElement.getText());
			}
		}

		// get the 10th row value
		int pageIDsize = driver.findElements(By.xpath("//ul[@id=\"pagination\"]/li")).size();
		System.out.println(pageIDsize);
		for (int i = 1; i <= pageIDsize; i++) {
			driver.findElement(By.xpath("(//ul[@id=\"pagination\"]/li)[" + i + "]")).click();
			Thread.sleep(2000);
			for (int j = 1; j <= 5; j++) {
				WebElement id = driver
						.findElement(By.xpath("(//table[@id=\"productTable\"]/tbody/tr/td[1])[" + j + "]"));
				String idValue = id.getText();
				String row = "10";
				while (idValue.equals(row)) {
					WebElement valueoftheRow = driver
							.findElement(By.xpath("//table[@id=\"productTable\"]/tbody/tr[5]"));
					System.out.println(valueoftheRow.getText());
					break;
				}

			}

		}
	}

	public void wikipedia(String id, String text, String text1) throws IOException, AWTException, InterruptedException {
		WebElement search = driver.findElement(By.id(id));
		search.sendKeys(text);
		WebElement searchicon = driver.findElement(By.className(text1));
		searchicon.click();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Cartoon Network")).click();
		// Robot rob = new Robot();
		// for (int i = 0; i <= 4; i++) {
		// rob.keyPress(KeyEvent.VK_TAB);
		// rob.keyRelease(KeyEvent.VK_TAB);
		// }
		// rob.keyPress(KeyEvent.VK_ENTER);
		// rob.keyRelease(KeyEvent.VK_ENTER);
		// scrnshot("wikipedia CN page");

		String PageTitle = driver.getTitle();
		String PageCrtUrl = driver.getCurrentUrl();
		System.out.println("Page Title:" + PageTitle + "\n" + "Page CurrentUrl:" + PageCrtUrl);
		String parentwindow = driver.getWindowHandle();
		System.out.println("Parent Window: " + parentwindow);
		Set<String> allWindows = driver.getWindowHandles();
		for (String string : allWindows) {
			if (!(parentwindow.equals(string))) {
				driver.switchTo().window(string);
				scrnshot("Wikipedia - ");
				System.out.println("Child Window: " + string);
			}
		}
		String WikipediaCrtUrl = driver.getCurrentUrl();
		String WikipediaPageTitle = driver.getTitle();
		String ActualUrl = "https://en.wikipedia.org/wiki/Cartoon_Network";

		System.out.println("WikipediaPageTitle: " + WikipediaPageTitle + "\n" + "WikipediaUrl: " + WikipediaCrtUrl);
		if (ActualUrl.equals(WikipediaCrtUrl)) {
			driver.close();
		}
	}

	public void newBrowser(String browser) throws IOException {
		driver.findElement(By.xpath("//button[@onclick=\"myFunction()\"]")).click();
		String parentwindow = driver.getWindowHandle();
		System.out.println("Parent Window: " + parentwindow);
		Set<String> allWindows = driver.getWindowHandles();
		for (String string : allWindows) {
			if (!(parentwindow.equals(string))) {
				driver.switchTo().window(string);
				System.out.println("Child Window: " + string);
				System.out.println(driver.getCurrentUrl());
				scrnshot(browser);
				driver.close();
			}
		}
		driver.quit();
	}

	public void simpleAlrt() throws InterruptedException, IOException {
		WebElement alrt = driver.findElement(By.xpath("//button[@onclick='myFunctionAlert()']"));
		alrt.click();
		Thread.sleep(2000);
		Alert alts = driver.switchTo().alert();
		alts.accept();
		clseWindow();
	}

	public void confirmAlrt(String id) throws InterruptedException, IOException {
		// Click the ok button
		WebElement conalrt = driver.findElement(By.xpath("//button[@onclick='myFunctionConfirm()']"));
		conalrt.click();
		Thread.sleep(2000);
		Alert conalts = driver.switchTo().alert();
		conalts.accept();
		String ExpectedMsg = "You pressed OK!";
		String ActualMsg = driver.findElement(By.id(id)).getText();
		if (ActualMsg.equals(ExpectedMsg)) {
			System.out.println(ActualMsg);
			clseWindow();
		}

		// Click the cancel button
		conalrt.click();
		Thread.sleep(2000);
		conalts.dismiss();
		String ExpecteddismissMsg = "You pressed Cancel!";
		String ActualdismissMsg = driver.findElement(By.id(id)).getText();
		if (ActualdismissMsg.equals(ExpecteddismissMsg)) {
			System.out.println(ActualdismissMsg);
			clseWindow();
		}
	}

	public void promptAlrt(String id) throws InterruptedException, IOException {
		// Click the ok button
		WebElement promalrt = driver.findElement(By.xpath("//button[@onclick='myFunctionPrompt()']"));
		promalrt.click();
		Thread.sleep(1000);
		Alert promalts = driver.switchTo().alert();
		// promalts.sendKeys("Aravind");
		// promalts.accept();
		promalts.dismiss();
		String SuccessMsg = driver.findElement(By.id(id)).getText();
		System.out.println(SuccessMsg);
		clseWindow();
	}

	public void doubleclk(String beforedoubleclick, String afterdoubleclick) throws IOException {
		scrolldown(0, 450);
		scrnshot(beforedoubleclick);
		WebElement clkdouble = driver.findElement(By.xpath("//button[@ondblclick='myFunction1()']"));
		Actions act = new Actions(driver);
		act.doubleClick(clkdouble).build().perform();
		scrnshot(afterdoubleclick);
		clseWindow();
	}

	public void draganddrp(String drag, String drop) throws IOException {
		scrolldown(0, 550);
		WebElement drg = driver.findElement(By.id(drag));
		WebElement drp = driver.findElement(By.id(drop));
		scrnshot("draganddropbefore");
		Actions act = new Actions(driver);
		act.dragAndDrop(drg, drp).build().perform();
		scrnshot("draganddropafter");
		clseWindow();
	}

	public void slide(String id) throws IOException {
		scrolldown(0, 650);
		scrnshot("SlideBefore - ");
		WebElement slideBar = driver.findElement(By.id(id));
		int slidewidth = slideBar.getSize().getWidth();
		int halfslide = slidewidth / 4;
		Actions act = new Actions(driver);
		act.clickAndHold(slideBar).moveByOffset(halfslide, 0).release().perform();
		scrnshot("SlideAfter - ");
		clseWindow();
	}

	public void handleFrame(String id, String name) throws IOException, InterruptedException {
		scrolldown(0, 850);
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		driver.switchTo().frame(0);
		// Enter the name
		driver.findElement(By.id(id)).sendKeys(name);
		scrnshot("Namein_iFrame");
		// Click the radio button
		WebElement radio = driver.findElement(By.xpath("//input[@id='RESULT_RadioButton-1_0']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", radio);
		scrnshot("radiobtnin_iFrame");
		// Select the date
		WebElement Datesclt = driver.findElement(By.id("RESULT_TextField-2"));
		Datesclt.clear();
		Datesclt.sendKeys("13/11/2023");
		scrnshot("Dateselectionin_iFrame");
		Thread.sleep(1000);
		scrolldown(0, 850);
		// Select the job
		WebElement job = driver.findElement(By.id("RESULT_RadioButton-3"));
		Select sclt = new Select(job);
		sclt.selectByValue("Radio-1");
		scrnshot("Selectdropdownin_iFrame");
		Thread.sleep(1000);
		// Click the submit button
		clk("FSsubmit");
		scrnshot("Submitin_iFrame");
		clseWindow();
	}

	public void reportLinkIframe() throws InterruptedException, IOException {
		scrolldown(0, 850);
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		driver.switchTo().frame(0);
		WebElement reportLink = driver.findElement(By.partialLinkText("Report abuse"));
		reportLink.click();

		String parentWindow = driver.getWindowHandle();
		Set<String> AllWindows = driver.getWindowHandles();

		for (String Windows : AllWindows) {
			if (!(parentWindow.equals(Windows))) {
				String expectedUrl = driver.getCurrentUrl();
				System.out.println(expectedUrl);
				driver.switchTo().window(Windows);
				scrnshot("Reportlink - ");
				Thread.sleep(4000);
				clseWindow();
			}
		}
		clseallWindow();
	}

	public void formSite() throws InterruptedException, IOException {
		scrolldown(0, 850);
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		driver.switchTo().frame(0);
		WebElement formSitelink = driver.findElement(By.partialLinkText("Powered by"));
		formSitelink.click();
		Thread.sleep(2000);
		scrnshot("Formsite - ");
		driver.navigate().back();
		Thread.sleep(2000);
		clseWindow();
	}

	public void resizethetab() throws InterruptedException, IOException {
		scrolldown(0, 1550);
		scrnshot("Beforeresize - ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('resizable').style.width = '300px';"
				+ " document.getElementById('resizable').style.height = '300px';");
		scrnshot("Afterresize - ");
		Thread.sleep(3000);
		clseWindow();

		// Using action class
		// WebElement resizerBox=driver.findElement(By.xpath("//div[@id='resizable']"));
		// WebElement
		// resizer=driver.findElement(By.xpath("//div[@class='ui-resizable-handle
		// ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		// Actions act = new Actions(driver);
		// act.clickAndHold(resizer).moveToElement(resizerBox, 470, 162).perform();
		// Thread.sleep(4000);
		// driver.close();
	}
	// Scroll down to specific location using javaScript with height & width
	public void scrolldown(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
	}
	// Scroll down to the specific element 
	public void scrollDownSpecificElement(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	// Scroll down full down
	public void scrollDown() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	// Scroll down using action 
	public void scrollDownAct() {
		WebElement element = driver.findElement(By.xpath("//h2[text()='Web Table']"));
		Actions act = new Actions(driver);
		//act.scrollByAmount(0, 600).perform();
		act.scrollToElement(element).perform();
		WebElement scrollBar = driver.findElement(By.xpath("//scrollbar_locator"));
		act.clickAndHold(scrollBar).moveByOffset(0, 100).release().perform();
		}
	//
	public void clk(String id) {
		WebElement ele = driver.findElement(By.id(id));
		ele.click();
	}

	public void printDetails(String text) {
		System.out.println(text);
	}

	public void clseWindow() {
		driver.close();
	}

	public void clseallWindow() {
		driver.quit();
	}
}
