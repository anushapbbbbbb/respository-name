package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import setup.BaseUI;
import utilities.ReadPropertiesFile;

public class Comments extends BaseUI {
	public WebDriver driver;

	/** Getting all the locators **/
	By commentData = getLocator("commentData_xpath");
	By addCommentBtn = getLocator("addCommentBtn_xpath");
	By previousVersionsTab = getLocator("previousVersionsTab_xpath");

	public Comments() {
	}

	public Comments(WebDriver driver) {
		this.driver = driver;
	}

	public void setCommentData() {
		driver.findElement(commentData).sendKeys(ReadPropertiesFile.getProperties("comment"));
		waitInSeconds(40);
	}

	public void pressAddCommentBtn() {

		clickOn(addCommentBtn, 30);
		waitInSeconds(40);
	}

	public PreviousVersions clickpreviousVersionsTab() {

		clickOn(previousVersionsTab, 30);
		waitInSeconds(40);

		return PageFactory.initElements(driver, PreviousVersions.class);
	}

}
