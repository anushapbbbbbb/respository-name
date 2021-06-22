package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import setup.BaseUI;

public class Workflow extends BaseUI {

	public WebDriver driver;

	/** Getting all the locators **/
	By initiator = getLocator("initiator_xpath");
	By performer = getLocator("performer_xpath");
	By approver = getLocator("approver_xpath");
	By linkedCardsTab = getLocator("linkedCardsTab_xpath");
	By saveBtn=getLocator("saveBtn_id");

	public Workflow() {
	}

	public Workflow(WebDriver driver) {
		this.driver = driver;
	}

	public void setInitiator(String initiatorName) {
		Select selectInitiator = new Select(driver.findElement(initiator));
		selectInitiator.selectByVisibleText(initiatorName);
	}

	public void setPerformer(String performerName) {
		Select selectPerformer = new Select(driver.findElement(performer));
		selectPerformer.selectByVisibleText(performerName);
	}

	public void setApprover(String approverName) {
		Select selectApprover = new Select(driver.findElement(approver));
		selectApprover.selectByVisibleText(approverName);
	}
	
	public void clicksaveBtn() {
		// TODO Auto-generated method stub
		clickOn(saveBtn,30);
		
	}

	public LinkedCards clickLinkedCardsTab() {
		waitInSeconds(40);

		clickOn(linkedCardsTab, 40);

		waitInSeconds(40);

		return PageFactory.initElements(driver, LinkedCards.class);
	}

}
