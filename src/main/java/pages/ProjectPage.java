package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import setup.BaseUI;

public class ProjectPage extends BaseUI {

	public ProjectPage(WebDriver driver) {
		BaseUI.driver = driver;
	}

	/** Getting all the locators **/
	By Monitor = getLocator("monitor_xpath");
	By issue = getLocator("issue_xpath");

	public TestEventPage tabSelect() {

		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitInSeconds(60);

		clickOn(Monitor, 30);

		waitInSeconds(40);
		clickOn(issue, 40);
		waitInSeconds(30);

		return PageFactory.initElements(driver, TestEventPage.class);
	}

}
