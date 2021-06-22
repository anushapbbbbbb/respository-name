package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import setup.BaseUI;


public class HomePage extends BaseUI {

	public HomePage(WebDriver driver) {
		BaseUI.driver = driver;
	}

	/** Getting all the locators **/
	By burgerIcon = getLocator("burgerIcon_xpath");
	By CFO = getLocator("project_xpath");
	By pgm=By.xpath("//span[contains(text(),'Project / Program')]");
	
	public void clickBurgerIcon() {

		clickOn(burgerIcon, 40);
		waitInSeconds(40);

	}

	public ProjectPage clickCFOOnsiteProject() {
		clickOn(pgm,20);
		clickOn(pgm,40);
		waitInSeconds(40);
		clickOn(CFO, 40);
		waitInSeconds(40);

		return PageFactory.initElements(driver, ProjectPage.class);
	}

}
