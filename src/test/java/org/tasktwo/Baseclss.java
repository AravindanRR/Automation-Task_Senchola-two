package org.tasktwo;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tasktwo.SyncTime;

public class Baseclss extends Locators {
	static WebDriver driver = null;

	public void launchBrowser(String url) throws IOException, AWTException {
		driver = new ChromeDriver();
		driver.get(url);
		String ActualUrl = driver.getCurrentUrl();
		if (url.equals(ActualUrl)) {
			maxWindow();
			// scrollDownAct();
			// scrollDownSpecificElement("//h2[text()='Web Table']");
			// scrollDown();
			// robScrnshot("Home page - ");
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
		File storage = new File("E:\\Eclipse\\octworkspace\\Screenshot\\Flipkart\\" + title + timestamp + ".png");
		FileUtils.copyFile(file, storage);

	}

	public void robScrnshot(String title) throws AWTException, IOException {
		// get the current date and time
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String timestamp = sdf.format(new Date());
		// get the screen resolution
		Dimension browserSize = driver.manage().window().getSize();
		int width = browserSize.getWidth(); // 1366
		int height = browserSize.getHeight();// 768
		System.out.println("Width:-" + width + " Height:-" + height);
		// robot class used
		Robot rob = new Robot();
		BufferedImage screenshot = rob.createScreenCapture(new Rectangle(0, 0, 1366, 768));
		File storage = new File("E:\\Eclipse\\octworkspace\\Screenshot\\" + title + timestamp + ".png");
		ImageIO.write(screenshot, "png", storage);
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

	// Enter the text in the text field using sendkeys
	public void enterTextName(String id, String text) {
		WebElement textEnt = driver.findElement(By.name(id));
		textEnt.clear();
		textEnt.sendKeys(text);
		// scrnshot(fieldname);
	}

	// Enter the text in the text field using sendkeys
	public void enterTextXpath(By xpath, String text, String fieldname) throws IOException {
		WebElement textEnt = driver.findElement(xpath);
		textEnt.clear();
		textEnt.sendKeys(text);
		driver.findElement(By.xpath("//button[@class='_2iLD__']")).click();
		scrnshot(fieldname);
		driver.navigate().back();
		clseWindow();
	}

	public void searchBoxClick(By xpath) {
		driver.findElement(xpath).click();
		SyncTime.commonWait(3);
		clseWindow();
	}

	// Enter the text using Js
	public void enterTextJs() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('name').value='Aravind';");

	}

	public void getMoreOptions(By xpath, By xpath2, String clkbtn) throws IOException {
		WebElement moreOption = driver.findElement(xpath);
		moreOption.click();
		List<WebElement> moreOp = driver.findElements(xpath2);
		for (WebElement element : moreOp) {
			String moreOptions = element.getAttribute("title");
			System.out.println(moreOptions);
		}
		scrnshot(clkbtn);
		clseWindow();
	}

	public void mouseOverAct(String linkText) {
		WebElement element = driver.findElement(By.linkText(linkText));
		Actions act = new Actions(driver);
		act.moveToElement(element).click().build().perform();
	}

	public void clickMoreOptions(By xpath, String linkText, String clkbtn) throws IOException {
		WebElement moreOption = driver.findElement(xpath);
		moreOption.click();

		WebElement option = driver.findElement(By.linkText(linkText));
		Actions act = new Actions(driver);
		act.moveToElement(option).click().perform();
		scrnshot(clkbtn);
		scrollDown();
		clseWindow();
	}

	// Click the links through linkedtext
	public void clickLinkButton(String linkedtext, String clkbtn) throws IOException {
		WebElement linkButton = driver.findElement(By.linkText(linkedtext));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", linkButton);
		linkButton.click();
		SyncTime.commonWait(2);
		System.out.println("CurrentUrl: " + driver.getCurrentUrl());
		SyncTime.commonWait(2);
		scrnshot(clkbtn);
		driver.navigate().back();
		clseWindow();
	}

	// Click the links through linkedtext
	public void clickLnkButton(String linkedtext, By xpath, String clkbtn) throws IOException, InterruptedException {

		WebElement bottomButton = driver
				.findElement(By.xpath("//div[@class='_3I5N7v' and contains(text(),'CONSUMER POLICY')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", bottomButton);

		List<WebElement> all = driver.findElements(xpath);
		for (int i = 1; i < all.size(); i++) {
			WebElement linkButtons = driver.findElement(By.linkText(all.get(i).getText()));
			linkButtons.click();
			SyncTime.commonWait(2);
			System.out.println("CurrentUrl: " + driver.getCurrentUrl());
			SyncTime.commonWait(3);
			scrnshot(clkbtn);
			driver.navigate().back();
			WebElement btnButton = driver
					.findElement(By.xpath("//div[@class='_3I5N7v' and contains(text(),'CONSUMER POLICY')]"));
			JavascriptExecutor jas = (JavascriptExecutor) driver;
			jas.executeScript("arguments[0].scrollIntoView()", btnButton);
			SyncTime.commonWait(60);
		}

		scrnshot(clkbtn);
		clseWindow();
	}

	public void getLinkText(String linkedtext, By xpath, String clkbtn) throws InterruptedException {
		WebElement linkButton = driver.findElement(By.linkText(linkedtext));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", linkButton);
		List<WebElement> all = driver.findElements(xpath);
		for (WebElement element : all) {
			String socialMedia = element.getText();
			System.out.println(socialMedia);
		}
		SyncTime.commonWait(2);
		clseWindow();
	}

	// Click the given Subscribtion links
	public void vindowHandl(String linkText, String sublink) throws IOException {
		WebElement Sublinks = driver.findElement(By.linkText(linkText));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", Sublinks);
		Sublinks.click();
		SyncTime.commonWait(2);
		String parentwindow = driver.getWindowHandle();
		System.out.println("Parent Window: " + parentwindow);
		Set<String> allWindows = driver.getWindowHandles();

		for (String string : allWindows) {
			if (!(parentwindow.equals(string))) {
				driver.switchTo().window(string);
				System.out.println("Child Window: " + string);
				System.out.println(driver.getCurrentUrl());
				scrnshot(sublink);
				clseallWindow();
			}
		}

	}

	public void profilePage(String linkText, String linkText1, String shot) throws AWTException, IOException {
		WebElement login = driver.findElement(By.linkText(linkText));
		Actions act = new Actions(driver);
		SyncTime.commonWait(10);
		act.moveToElement(login).perform();
		WebElement navigation = driver.findElement(By.linkText(linkText1));
		act.moveToElement(navigation).click().perform();
		scrnshot(shot);
		SyncTime.commonWait(5);
		scrollDown();
	}

	public void giftCard(String linkText, String linkText1, By xpath) throws InterruptedException {
		WebElement login = driver.findElement(By.linkText(linkText));
		Actions act = new Actions(driver);
		SyncTime.commonWait(10);
		act.moveToElement(login).perform();
		WebElement navigation = driver.findElement(By.linkText(linkText1));
		act.moveToElement(navigation).click().perform();
		WebElement newPage = driver.findElement(xpath);
		newPage.click();

	}

	public void giftCardFilter(String linkText, String linkText1, By xpath) throws InterruptedException {
		WebElement login = driver.findElement(By.linkText(linkText));
		Actions act = new Actions(driver);
		SyncTime.commonWait(10);
		act.moveToElement(login).perform();
		WebElement navigation = driver.findElement(By.linkText(linkText1));
		act.moveToElement(navigation).click().perform();

		WebElement newPage = driver.findElement(By.xpath("//img[@class='kJjFO0 _3DIhEh'and @alt='generic']"));
		newPage.click();
		SyncTime.commonWait(6);
		scrollDown();
		SyncTime.commonWait(10);
		// bottom to top
		WebElement backToTop = driver.findElement(By.xpath("//span[contains(text(),'Back to top')]"));
		// backToTop.click();
		SyncTime.commonWait(10);
		// Navigate the filter
		WebElement lowToHigh = driver
				.findElement(By.xpath("//div[@class='_10UF8M' and contains(text(),'Price -- Low to High')]"));
		lowToHigh.click();
		WebElement highToLow = driver
				.findElement(By.xpath("//div[@class='_10UF8M' and contains(text(),'Price -- High to Low')]"));
		highToLow.click();
		WebElement newestFirst = driver
				.findElement(By.xpath("//div[@class='_10UF8M' and contains(text(),'Newest First')]"));
		newestFirst.click();
	}

	public void logoValidation() {
		WebElement logoPresent = driver.findElement(By.xpath("//img[@title='Flipkart']"));
		System.out.println("LogoPresent:- " + logoPresent.isDisplayed());
		System.out.println(logoPresent.getCssValue("color"));
		logoPresent.click();
	}

	public void mainMenuValidation() {
		WebElement logoPresent = driver.findElement(By.xpath("//img[@title='Flipkart']"));
		String Title = logoPresent.getAttribute("title");
		WebElement searchBox = driver.findElement(By.xpath("//input[@class='Pke_EE']"));
		String searchBoxTitle = searchBox.getAttribute("title");
		List<WebElement> login = driver.findElements(By.xpath("//a[@class='_1TOQfO']"));
		for (WebElement element : login) {
			String loginTitle = element.getAttribute("title");
			System.out.println("3. Login & MoreOptions:- " + loginTitle);
		}
		WebElement cart = driver.findElement(By.xpath("//a[@class='_3RX0a-']"));
		String cartPage = cart.getAttribute("title");
		WebElement seller = driver.findElement(By.xpath("//a[@class='_3RX0a- _3jeYYh']"));
		String sellerBecome = seller.getAttribute("title");
		System.out.println("1. Logo:- " + Title + "\n" + "2. SearchBox:- " + searchBoxTitle + "\n" + "4. Cart:- "
				+ cartPage + "\n" + "5. Seller:- " + sellerBecome);
	}

	public void diffCategories() {
		for (int i = 1; i <= 9; i++) {
			WebElement category = driver.findElement(By.xpath("(//span[@class='_1XjE3T'])[" + i + "]"));
			System.out.println(i + " - " + category.getText());
		}
	}

	public void poster(String direction) throws InterruptedException {
		WebElement slide = driver.findElement(By.xpath("//button[@title='" + direction + "']"));
		slide.click();
		Thread.sleep(5000);
	}

	public void flightPoster() throws InterruptedException, AWTException {
		WebElement flightpost = driver.findElement(By.xpath("(//div[@class='zlQd20 ']/picture/img)[7]"));
		Boolean post = flightpost.isDisplayed();
		System.out.println(post);
		scrollDownSpecificElement("(//div[@class='zlQd20 ']/picture/img)[7]");
		Thread.sleep(3000);
		flightpost.click();
		// Robot rob = new Robot();
		// for (int i = 1; i <=36; i++) {
		// rob.keyPress(KeyEvent.VK_TAB);
		// rob.keyRelease(KeyEvent.VK_TAB);
		// }
		//
		// rob.keyPress(KeyEvent.VK_ENTER);
		// rob.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		logoValidation();
		WebElement flightBookTab = driver.findElement(By.xpath("//div[@class='_3XCEEm']"));
		Boolean booking = flightBookTab.isDisplayed();
		System.out.println(booking);
		driver.navigate().back();

	}

	public void product(String xpath) throws InterruptedException {
		scrollDownSpecificElement(xpath);
		WebElement product = driver.findElement(By.xpath(xpath));
		product.click();
		Thread.sleep(4000);
		WebElement itemCount = driver.findElement(By.xpath("//div[@class='_3vaoUF']"));
		System.out.println(itemCount.getText());

		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='_1FNrEw'])[1]")).click();
		Thread.sleep(3000);
		String CurrentUrl = driver.getCurrentUrl();
		System.out.println(CurrentUrl);
	}

	public void categories(String categories) throws InterruptedException {
		WebElement list = driver.findElement(By
				.xpath("//div[@class='_3ETuFY']//following-sibling::span/span[contains(text(),'" + categories + "')]"));
		list.click();
		Thread.sleep(4000);
		Boolean homepage = driver.findElement(By.className("_1fqNI-")).isDisplayed();
		System.out.println("Flipkart Homepage Button Displayed :- " + homepage);
		Boolean GroceryPage = driver.findElement(By.className("_2xm1JU")).isDisplayed();
		System.out.println("GroceryPage Logo is Displayed :- " + GroceryPage);
	}

	public void flipkartCategories(String categories) throws InterruptedException {
		WebElement list = driver.findElement(By
				.xpath("//div[@class='_3ETuFY']//following-sibling::span/span[contains(text(),'" + categories + "')]"));
		list.click();
		Thread.sleep(4000);
		Boolean homepage = driver.findElement(By.className("_3qX0zy")).isDisplayed();
		System.out.println("Flipkart Homepage Button Displayed :- " + homepage);

	}
	public void getMail() {
		scrollDownSpecificElement("//div[@class='MkhHNl btl4ck']//following::div/p");
		List<WebElement> mailAddress=driver.findElements(By.xpath("//div[@class='MkhHNl btl4ck']//following::div/p"));
		for (WebElement element : mailAddress) {
			System.out.println(element.getText());
		}
	
		
	}
	public void flipkrtcateDropdown(String categories) throws InterruptedException, AWTException {
		WebElement list = driver.findElement(By
				.xpath("//div[@class='_3ETuFY']//following-sibling::span/span[contains(text(),'" + categories + "')]"));
		list.click();
		WebElement move = driver.findElement(By.xpath("//a[contains(text(),'Men Footwear')]"));
		Actions act = new Actions(driver);
		act.moveToElement(move).perform();
		WebElement moveInto = driver.findElement(By.xpath("//a[contains(text(),'Casual Shoes')and @class='_3490ry']"));
		act.moveToElement(moveInto).click().perform();
		Thread.sleep(5000);
		driver.findElement(By.className("_34uFYj")).sendKeys("WoodLand");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='_4921Z t0pPfW' and @title='WOODLAND']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='_13oc-S']//following::div/div[@data-id])[2]")).click();		
		Boolean homepage = driver.findElement(By.className("_3qX0zy")).isDisplayed();
		System.out.println("Flipkart Homepage Button Displayed :- " + homepage);
	}

	public void grocery() throws AWTException, InterruptedException {
		categories("Grocery");
		enterTextName("pincode", "624709");
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		enterTextName("q", "Coconut oil");
		clickButton(searchBtn, null);
		validateGroceryHome();
	}

	public void validateGroceryHome() {
		Boolean homepage = driver.findElement(By.className("_1fqNI-")).isDisplayed();
		System.out.println(homepage);
	}

	public void getAllGroceryCate() throws InterruptedException, AWTException {
		categories("Grocery");
		enterTextName("pincode", "624709");
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		List<WebElement> categories = driver.findElements(By.className("xtXmba"));
		for (WebElement element : categories) {
			System.out.println(element.getText());
		}
	}

	public void becomeSellerPage() {
		driver.findElement(By.xpath("//a[@class='_1krdK5 _3jeYYh' and contains(text(),'Become a Seller')]")).click();
		Boolean logo = driver.findElement(By.xpath("//div[contains(@class,'styles__StyledHeaderContainer')]//a/img")).isDisplayed();
		System.out.println("Become Seller Page Logo is Displayed :- "+logo);
		scrollDown();
	}
	
	public void advertise() {
		scrollDown();
		driver.findElement(By.xpath("//span[contains(text(),'Advertise')]")).click();
		scrollDown();
	}
	
	public void cartPage() throws InterruptedException, AWTException {
		WebElement textEnt = driver.findElement(searchBox);
		textEnt.clear();
		textEnt.sendKeys("Smart TV");
		driver.findElement(By.xpath("//button[@class='_2iLD__']")).click();
		
		WebElement list = driver.findElement(By
				.xpath("//div[@class='_4rR01T' and contains(text(),'Mi A series 80 cm (32 inch) HD Ready LED Smart Google TV 2023 Edition with HD |Dolby Audio | DTS:HD | ...')]"));
		list.click();
		
		Thread.sleep(3000);
		WebElement move = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", move);
	}
	
	// Click the button
	public void clickButton(By xpath, String clkbtn) {
		// scrolldown(0, 150);
		WebElement button = driver.findElement(xpath);
		button.click();
		// scrnshot(clkbtn);

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

	public void loadWaits(String id, String checkbx, Duration y) throws IOException {
		// WebDriverWait wait = new WebDriverWait(driver, y);
		WebElement checkBx = driver.findElement(By.id(id));
		checkBx.click();
		scrnshot(checkbx);
	}

	// Select the country
	public void selectedByValue(String text, String id, String contry) throws IOException {
		WebElement country = driver.findElement(By.id(id));
		Select sclt = new Select(country);
		sclt.selectByValue(text);
		scrnshot(contry);
	}

	// Choose the colour
	public void selectedByText(String text, String id, String color) throws IOException {
		WebElement Changecolor = driver.findElement(By.id(id));
		Select sltcolor = new Select(Changecolor);
		sltcolor.selectByValue(text);
		scrnshot(color);
	}

	// Choose the colour
	public void selectedByIndex(String text, String id, String color) throws IOException {
		WebElement Changecolor = driver.findElement(By.id(id));
		Select sltcolor = new Select(Changecolor);
		sltcolor.selectByValue(text);
		scrnshot(color);
	}

	// Choose the multiple colour
	public void selectMultipleOptionsByVisibleText(String text, String id, String color) throws IOException {
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

	public void validateColor() {
		WebElement ele = driver.findElement(By.xpath("//div[@class='_2NhoPJ']"));

		System.out.println(ele.getCssValue("color"));
	}

	// enter the date
	public void selectDates(String text, String id, String date) throws IOException, InterruptedException {
		scrolldown(0, 650);
		WebElement Datesclt = driver.findElement(By.id(id));
		Datesclt.clear();
		Datesclt.sendKeys(text);
		Datesclt.sendKeys(Keys.ENTER);
		scrnshot(date);
	}

	// Click the given links
	public void clickLinks(String Linktext, String currentlink, long y) throws IOException, InterruptedException {
		WebElement links = driver.findElement(By.linkText(Linktext));
		links.click();
		if (driver.getCurrentUrl().equals(links.getText()))
			links.click();
		Thread.sleep(y);
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String string : allWindows) {
			if (!(parentWindow.equals(string))) {
				System.out.println("Parent Window: " + parentWindow + "\n" + "Child Window: " + string);
				driver.switchTo().window(string);
				Boolean logoM = driver.findElement(By.xpath("//div[@class='_3qX0zy']")).isDisplayed();
				System.out.println(driver.getCurrentUrl() + "\n" + logoM + "\n"
						+ driver.findElement(By.xpath("//a[@class='_21ljIi']")).getText());
				scrnshot(currentlink);
				clseallWindow();
			}
		}
	}

	// Click the given Subscribtion links
	public void vindowHandle(String id, String text, String sublink) throws IOException {
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

	public void resizethetab() throws InterruptedException, IOException {
		scrolldown(0, 1550);
		scrnshot("Beforeresize - ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('resizable').style.width = '300px';"
				+ " document.getElementById('resizable').style.height = '300px';");
		scrnshot("Afterresize - ");
		Thread.sleep(3000);
		clseWindow();

	}

	// Scroll down to specific location using javaScript with height & width
	public void scrolldown(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
	}

	// Scroll down to the specific element
	public void scrollDownSpecificElement(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
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
		// act.scrollByAmount(0, 600).perform();
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
