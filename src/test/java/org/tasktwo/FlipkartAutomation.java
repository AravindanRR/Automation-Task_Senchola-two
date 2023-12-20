package org.tasktwo;

import java.awt.AWTException;
import java.io.IOException;

public class FlipkartAutomation extends Baseclss{
	
	public static void main(String[] args) throws IOException, AWTException {
		System.setProperty("webdriver.chrome.driver", "E:\\Eclipse\\octworkspace\\Practiseselenium1\\chrdvr\\chromedriver.exe");
		FlipkartAutomation flip = new FlipkartAutomation();
		flip.launchBrowser("https://www.flipkart.com/");
		// close the login tab page
    	flip.clickButton(closeLoginTab, "Close the Login tab");
//		flip.validateColor();
//		flip.enterTextXpath(loginEmailfield, "9842961190", "PhonenumberField - ");
//		flip.clickButton(requestOTP, "Click Request OTP");
//		flip.enterTextXpath(phoneNumberField, "9842961190", "PhoneNumber - ");
//		flip.clickButton(continueButton, "Click Continue Button");
	}

}
