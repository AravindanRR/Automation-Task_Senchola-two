package org.taskone;

import java.awt.AWTException;
import java.io.IOException;

public class Firsttaskauto extends Basecls {
	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"E:\\Eclipse\\octworkspace\\Practiseselenium1\\chrdvr\\chromedriver.exe");
		

	Firsttaskauto auto = new Firsttaskauto();
	auto.launchBrowser();
	auto.validateHomepage();
//	auto.enterTextJs();
	
	// for text box
	auto.enterText("name", "Aravindan","NameField - ");
	auto.enterText("email", "aravindan10@gmail.com","EmailField - ");
	auto.enterText("phone", "9842961190","Mobileno - ");
	auto.enterText("textarea", "Plotno10,Thaai Moogambihai nagar, Dindigul","AddressField - ");
	
	// for radiobutton
//	auto.radioButton("male","maleradiobtn");
//	auto.radioButton("female","femaleradiobtn");
	
	//for checkbox
//	auto.checkBox("sunday","Sun - ",450);
//	auto.checkBox("monday","Mon - ",0);
//	auto.checkBox("tuesday","Tues - ",0);
//	auto.checkBox("wednesday","Wed - ",0);
//	auto.checkBox("thursday","Thurs - ",0);
//	auto.checkBox("friday","Fri - ",0);
//	auto.checkBox("saturday","Sat - ",0);
	
	//for select
//	auto.slct("canada", "country","Countryname - ");
	
	//Choose the single colour
//	auto.colourChange("blue", "colors","color - ");
	
	//Choose the multiple color
//	auto.choosemulticolour(null, "colors","colors - ");
	
	//Add the date
//	auto.Dateselection("12/11/2023", "datepicker","Current date - ");
     
	//Click the link
//	auto.verifyLinks("open cart", "open cart","Opencartlink - ","0");
//	auto.verifyLinks("orange HRM", "orange HRM","OrangeHRMlink - ",2000);
	
	//Click the homepage
//	auto.Homepage("Home", "Home");
	
	//Click the Subscribe links
//	auto.Links("feed-link", "Posts (Atom)","Sublink - ");
	
	//WebTable
//	auto.webTable();
	
	//Pagination Table
//	auto.paginationTable();
	//Search in wikipedia
//	auto.wikipedia("Wikipedia1_wikipedia-search-input", "car", "wikipedia-search-button");
	
	//handle the new Windows
//	auto.newBrowser("Newbrowsercart - ");
	
	//Simple Alerts
//	auto.simpleAlrt();
	
	//Confirm Alerts
//	auto.confirmAlrt("demo");
	
	//Prompt Alerts
//	auto.promptAlrt("demo");
	
	//Double click on the page
//	auto.doubleclk("BeforeDoubleClick - ","AfterDoubleClick - ");
	
	//Drag and Drop function 
//	auto.draganddrp("draggable", "droppable");
	
	//slide the bar
//	auto.slide("slider");

	//Frame handle 
//	auto.handleFrame("RESULT_TextField-0","Aravindan");
	
	//Click the report link in iframe
//	auto.reportLinkIframe();

	
	//Click the powered by link
//	auto.formSite();
	
	//Resize the tab
//	auto.resizethetab();
	
	//Close the window
	auto.clseWindow();
	
	//Close all the windows
//	auto.clseallWindow();

	}

}
