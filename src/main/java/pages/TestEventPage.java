package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import setup.BaseUI;

public class TestEventPage extends BaseUI {

	public TestEventPage(WebDriver driver) {
		BaseUI.driver = driver;
	}

	/** Getting all the locators **/
	By form = getLocator("createFormLogo_xpath");

	public WebDriver clickAddIssue() {

		waitInSeconds(20);
		clickOn(form, 30);
		waitInSeconds(20);

		return driver;

	}

}
