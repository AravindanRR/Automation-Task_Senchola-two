package org.tasktwo;

import org.openqa.selenium.By;

public class Locators {
	public static final By closeLoginTab = By.xpath("//span[text()='✕']");
	public static final By loginEmailfield = By.xpath("//input[@class='_18u87m _3WuvDp']");
	public static final By requestOTP = By.xpath("//button[@class='_1wGnMD rX1XT4 _2nD2xJ']");
	public static final By phoneNumberField = By.xpath("//input[@class='_2IX_2- VJZDxU']");
	public static final By continueButton = By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']");
	public static final By createAccount = By.xpath("//a[@class='_1O7q6e']");
	public static final By createactphoneField = By.xpath("//input[@class='_2IX_2- VJZDxU']");
	public static final By createcontinuebtn = By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']");
	public static final By policy = By.xpath("//div[@class='_3I5N7v' and contains(text(),'CONSUMER POLICY')]//following-sibling::a");
	public static final By social = By.xpath("//div[@class='_3I5N7v' and contains(text(),'SOCIAL')]//following-sibling::a");
	public static final By help = By.xpath("//div[@class='_3I5N7v' and contains(text(),'HELP')]//following-sibling::a");
	public static final By about = By.xpath("//div[@class='_3I5N7v' and contains(text(),'ABOUT')]//following-sibling::a");
	public static final By more = By.xpath("//a[@class='_1TOQfO' and @title='Dropdown with more help links']");
	public static final By moreTitle = By.xpath("//div[@class='H6-NpN']//following-sibling::ul//descendant::a");
	public static final By searchBox = By.xpath("//input[@name='q']");
	public static final By giftGeneric = By.xpath("//img[@class='kJjFO0 _3DIhEh'and @alt='generic']");
	public static final By giftAnniversary = By.xpath("//img[@class='kJjFO0 _3DIhEh'and @alt='anniversary']");
	public static final By giftMore = By.xpath("//img[@class='kJjFO0 _3DIhEh'and @alt='more']");
	public static final By giftBirthday = By.xpath("//img[@class='kJjFO0 _3DIhEh'and @alt='birthday']");
	public static final By searchBtn = By.xpath("//button[@class='L0Z3Pu']");
	
	
	static String beautyfood = "//div[contains(text(),'Beauty, Food, Toys & more')]//parent::div//following-sibling::div/div";
	static String bestofElectronic = "//div[contains(text(),'Best of Electronics')]//parent::div//following-sibling::div/div";
	static String sportsHealth = "//div[contains(text(),'Sports, Healthcare & more')]//parent::div//following-sibling::div/div";
//	static String bestofElectronic = "//div[contains(text(),'Best of Electronics')]//parent::div//following-sibling::div/div";
	
	
	
	public static void loc(String argument) {
		By searchBox = By.xpath("//img[@class='kJjFO0 _3DIhEh'and @alt='"+argument+"']");
	}
}
