package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import setup.BaseUI;

public class ActivityLog extends BaseUI {

	public WebDriver driver;

	By serialNo;

	By description;

	By changedBy;

	By dateAndTime;

	By versionDifference;

	By attachmentTab = getLocator("attachmentTab_xpath");

	public ActivityLog() {
	}

	public ActivityLog(WebDriver driver) {
		this.driver = driver;
	}

	public String getSerialNo() {
		return null;
	}

	public String getDescription() {
		return null;
	}

	public String getChangedBy() {
		return null;
	}

	public String getDateAndTime() {
		return null;
	}

	public String getVersionDifference() {
		return null;
	}

	/** Click on attachment tab **/
	public Attachments clickAttachmentsTab() {

		clickOn(attachmentTab, 20);
		
		waitInSeconds(20);

		waitInSeconds(40);

		return PageFactory.initElements(driver, Attachments.class);
	}

}
