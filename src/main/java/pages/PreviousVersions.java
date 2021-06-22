package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import setup.BaseUI;

public class PreviousVersions extends BaseUI {
	public WebDriver driver;

	/** Getting all the locators **/
	By activityLogTab = getLocator("activityLogTab_xpath");

	public PreviousVersions(WebDriver driver) {
		this.driver = driver;
	}

	public ActivityLog clickActivityLogTab() {

		clickOn(activityLogTab, 30);

		waitInSeconds(40);

		return PageFactory.initElements(driver, ActivityLog.class);
	}

}