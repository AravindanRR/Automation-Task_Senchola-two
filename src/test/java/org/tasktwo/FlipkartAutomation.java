package org.tasktwo;

import java.awt.AWTException;
import java.io.IOException;

public class FlipkartAutomation extends Baseclss {

	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Eclipse\\octworkspace\\Practiseselenium1\\chrdvr\\chromedriver.exe");
		FlipkartAutomation flip = new FlipkartAutomation();
		flip.launchBrowser("https://www.flipkart.com/");

		// 1.close the login tab page
		flip.clickButton(closeLoginTab, "Close the Login tab");

		// 2.Click the Terms of use & Privacy policy
		// flip.clickLinks("Terms of Use","Terms of Use", 2000);
		// flip.clickLinks("Privacy Policy", "Privacy Policy", 2000);

		// 3.Get the social media- failed
		// flip.getLinkText("Facebook",social, "SocialMedia - ");

		// 4.Click the social media
		// flip.clickLinkButton("Facebook", "Facebook link - ");
		// flip.clickLinkButton("Twitter", "Twitter link - ");
		// flip.clickLinkButton("YouTube", "YouTube link - ");

		// 5.Get the text from consumer policy
		// flip.getLinkText("Facebook",policy, "Consumer Policy - ");

		// 6.Click the CONSUMER POLICY
		// flip.clickLinkButton("Cancellation & Returns", "Cancellation & Returns link -
		// ");
		// flip.clickLinkButton("Terms Of Use", "Terms Of Use - ");
		// flip.clickLinkButton("Security", "Security - ");
		// flip.clickLinkButton("Privacy", "Privacy - ");
		// flip.clickLinkButton("Sitemap", "Sitemap - ");
		// flip.clickLinkButton("Grievance Redressal", "Grievance Redressal - ");
		// flip.clickLinkButton("EPR Compliance", "EPR Compliance - ");

		// 7.Get the text from help
		// flip.getLinkText("Facebook",help, "Help - ");

		// 8.Click the help
		// flip.clickLinkButton("Payments", "Payments - ");
		// flip.clickLinkButton("Shipping", "Shipping - ");
		// flip.clickLinkButton("Cancellation & Returns", "Cancellation & Returns - ");
		// flip.clickLinkButton("FAQ", "FAQ - ");
		// flip.clickLinkButton("Report Infringement", "Report Infringement - ");

		// 9.Get the text help
		// flip.getLinkText("Facebook",about, "About - ");

		// 10.Click the About
		// flip.clickLinkButton("Contact Us", "Contact Us - ");
		// flip.clickLinkButton("About Us", "About Us - ");
		// flip.clickLinkButton("Careers", "Careers - ");
		// flip.clickLinkButton("Flipkart Stories", "Flipkart Stories - ");
		// flip.clickLinkButton("Press", "Press - ");
		// flip.clickLinkButton("Corporate Information", "Corporate Information - ");

		// 11.Handle the window in About
		// flip.vindowHandl("Flipkart Wholesale", "Flipkart Wholesale - ");
		// flip.vindowHandl("Cleartrip", "Cleartrip - ");
		
		// 12.Get the more option title
		// flip.getMoreOptions(more, moreTitle, "MoreOptions - ");

		// 13.Click the more options list
//		flip.clickMoreOptions(more, "Notification Preferences", "Notification Preferences - ");
//		flip.clickMoreOptions(more, "24x7 Customer Care", "24x7 Customer Care - ");
//		flip.clickMoreOptions(more, "Advertise", "Advertise - ");
//		flip.clickMoreOptions(more, "Download App", "Download App - ");
		
		// 14.Enter the text in the searchbox
		// flip.enterTextXpath(searchBox, "fhone", "SearchBox - ");
		// flip.searchBoxClick(searchBox);
		
		// Profile related
		// flip.profilePage("Login","Flipkart Plus Zone", "Flipkart Plus Zone - ");
		// flip.profilePage("Login","Gift Cards","Gift Card Page - ");
		
		// Different Gift cards
//		flip.giftCard("Login", "Gift Cards", giftAnniversary);
//		flip.giftCard("Login", "Gift Cards", giftGeneric);
//		flip.giftCard("Login", "Gift Cards", giftMore);
//		flip.giftCard("Login", "Gift Cards", giftBirthday);
		
		// flip.logoValidation();
		// flip.mainMenuValidation();
		
		// flip.diffCategories();
		
		// flip.poster("Next Slide");
		// flip.poster("Previous Slide");
		
//		flip.flightPoster();
		
//		flip.product(bestofElectronic);
//		flip.product(beautyfood);
//		flip.product(sportsHealth);
		
		// flip.categories("Grocery");
		// flip.grocery();
		// flip.validateGroceryHome();
		// flip.getAllGroceryCate();
		// flip.flipkartCategories("Mobiles");
		
	//	flip.flipkrtcateDropdown("Fashion");
		
		
//		flip.flipkartCategories("Appliances");
//		flip.flipkartCategories("Travel");
		
		//flip.getMail();
//		flip.becomeSellerPage();
	//	flip.advertise();
		
		flip.cartPage();
		// flip.validateColor();
		// flip.clickButton(createAccount, "Create New account");
		// flip.enterTextXpath(createactphoneField, "9150925133", "PhonenumberField -
		// ");
		// flip.clickButton(createcontinuebtn, "Click continue - ");
		// flip.enterTextXpath(phoneNumberField, "9842961190", "PhoneNumber - ");
		// flip.clickButton(continueButton, "Click Continue Button");

	}

}
