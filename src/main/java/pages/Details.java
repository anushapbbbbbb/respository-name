package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import setup.BaseUI;

public class Details extends BaseUI {
	public WebDriver driver;

	/** Getting all the locators **/
	By issueType = getLocator("issueType_xpath");
	By reportedDate = getLocator("reportedDate_xpath");
	By severity = getLocator("severity_xpath");
	By name = getLocator("name_xpath");
	By issueCategory = getLocator("issueCategory_xpath");
	By responsibility = getLocator("responsibility_xpath");
	By priority = getLocator("priority_xpath");
	By dueDate = getLocator("dueDate_xpath");
	By reportedBy = getLocator("reportedBy_xpath");
	By workFlowTab = getLocator("workFlowTab_xpath");
    By description_field = getLocator("description_xpath");
    
	public Details() {
	}

	public Details(WebDriver driver) {
		this.driver = driver;
	}

	public void setReportedBy(String reportedByValue) {
		driver.findElement(reportedBy).sendKeys(reportedByValue);

	}

	public void setIssueType(String issueTypeValue) {
		Select selectIssue = new Select(driver.findElement(issueType));
		selectIssue.selectByVisibleText(issueTypeValue);

	}

	public void setReportedDate(String dateValue) {
		driver.findElement(reportedDate).sendKeys(dateValue);

	}

	public void setSeverity(String severityValue) {
		Select selectSeverity = new Select(driver.findElement(severity));
		selectSeverity.selectByVisibleText(severityValue);

	}

	public void setName(String nameValue) {
		System.out.println(driver.getTitle());
		driver.findElement(name).sendKeys(nameValue);
	}

	public void setIssueCategory(String issueCategoryValue) {
		Select selectIssueCategory = new Select(driver.findElement(issueCategory));
		selectIssueCategory.selectByVisibleText(issueCategoryValue);

	}

	public String getResponsibility() {
		return null;
	}

	public void setResponsibility(String responsibilityValue) {
		Select selectResponsibility = new Select(driver.findElement(responsibility));
		selectResponsibility.selectByVisibleText(responsibilityValue);

	}

	public void setPriority(String priorityValue) {
		Select selectPriority = new Select(driver.findElement(priority));
		selectPriority.selectByVisibleText(priorityValue);

	}

	public void setDueDate(String dueDateValue) {
		driver.findElement(dueDate).sendKeys(dueDateValue);

	}

	public void setDescription(String description){
		driver.findElement(description_field).sendKeys(description);
	}
	
	public Workflow clickWorkFlowTab() {

		clickOn(workFlowTab, 40);
		waitInSeconds(40);

		return PageFactory.initElements(driver, Workflow.class);
	}

}
