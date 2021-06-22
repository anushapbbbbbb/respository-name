package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import setup.BaseUI;

import org.openqa.selenium.By;

public class LinkedCards extends BaseUI {
	public WebDriver driver;

	/** Getting all the locators **/
	By toggleBtn1 = getLocator("toggleBtn_xpath");
	By commentTab1 = getLocator("commentTab_xpath");

	public LinkedCards(WebDriver driver) {
		this.driver = driver;
	}

	public void clickListViewToggleBtn() {

		clickOn(toggleBtn1, 30);
		waitInSeconds(20);
	}

	public Comments clickCommentTab() {

		clickOn(commentTab1, 40);
		waitInSeconds(40);

		return PageFactory.initElements(driver, Comments.class);
	}

}
