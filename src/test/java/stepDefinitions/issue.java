package stepDefinitions;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import pages.ActivityLog;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Attachments;
import pages.Comments;
import pages.Details;
import pages.HomePage;
import pages.LinkedCards;
import pages.PreviousVersions;
import pages.ProjectPage;
import pages.TestEventPage;
import pages.ValidateIssues;
import pages.Workflow;
import setup.BaseUI;
import utilities.CustomReports;
import utilities.ExcelUtils;
import utilities.ExtentReport;


//@Listeners(utilities.ListenerUtils.class)
public class issue extends BaseUI {

	
	public static WebDriver driver;
	public static ExtentReports report=ExtentReport.getReportInstance();
	HomePage home=new HomePage(driver);
	ProjectPage projectPage=new ProjectPage(driver);
	TestEventPage testEventPage=new TestEventPage(driver);
	Details details=new Details(driver);
	Workflow workflow=new Workflow(driver);
	LinkedCards linkedCards=new LinkedCards(driver) ;
	Comments comments=new Comments();
	PreviousVersions previousVersions=new PreviousVersions(driver);
	ActivityLog activityLog=new ActivityLog(driver);
	Attachments attachments=new Attachments(driver);
	ValidateIssues validateIssues=new ValidateIssues() ;
	

	public static int index = 1;
	public static String description;

	public static String[] data;
	
	static Logger log = Logger.getLogger(issue.class.getName());
	
	@Given("^Open the browser$")
	public void open_the_browser() throws Throwable {
		PropertyConfigurator.configure("log4j.properties");
		
		logger = report.createTest("Browser");

		validateIssues = new ValidateIssues();
		logger.log(Status.INFO, "Invoking the browser");
		driver = ValidateIssues.browserSetUp();
		logger.log(Status.PASS, "Successfully invoked the browser");
		
		log.info("Browser Opened");
	}

	@Then("^Enter the URL and login$")
	public void enter_the_URL_and_login() throws Throwable {
		PropertyConfigurator.configure("log4j.properties");
		logger = report.createTest("Mainspring webpage");

		validateIssues = new ValidateIssues();
		logger.log(Status.INFO, "Opening the Mainspring webpage");
		home = validateIssues.openURL();
		logger.log(Status.PASS, "Opened the Mainspring webpage");
		BaseUI.login();
		log.info("Logged in successfully");
	}

	@When("^Page is loaded click on burger icon$")
	public void page_is_loaded_click_on_burger_icon() throws Throwable {
		PropertyConfigurator.configure("log4j.properties");
		logger = report.createTest("Burger icon");
		home.clickBurgerIcon();
		logger.log(Status.PASS, "Successfully clicked on the burger icon");
	    log.info("Clicked on burger icon");
	}

	@Then("^Click on project name$")
	public void click_on_project_name() throws Throwable {
		PropertyConfigurator.configure("log4j.properties");
		logger = report.createTest("Project name");

	     home.clickCFOOnsiteProject();
		logger.log(Status.PASS, "Successfully selected the project name");
		 
		 log.info("Clicked on project name");
		
	}

	@Then("^Click on monitor tab$")
	public void click_on_monitor_tb() throws Throwable {
		PropertyConfigurator.configure("log4j.properties");
		logger = report.createTest("Monitor tab");
		logger.log(Status.INFO, "Selecting the monitor tab");
		 projectPage.tabSelect();
		logger.log(Status.PASS, "Successfully selected the monitor");
		 log.info("Clicked on monitor tab");
		
	}

	@Then("^Click on issue module$")
	public void click_on_issue_module() throws Throwable {
		PropertyConfigurator.configure("log4j.properties");
		logger = report.createTest("Issue option");
	    testEventPage.clickAddIssue();
		logger.log(Status.PASS, "Successfully clicked  the issue tab");

		
		 log.info("Clicked on issues module");
		
	}
	
	@Then("^Enter data in description field$")
	public void enter_data_in_description_field() throws Exception{
		PropertyConfigurator.configure("log4j.properties");
		driver.switchTo().frame("contentframe");
		String detailsData[] = ExcelUtils.readExcelDataForDetails("IssueInfo");
		details.setDescription(detailsData[9]);
		 log.info("Description is entered");
	}
	@Then("^Click on save button$")
	public void click_on_save_button() throws InterruptedException{
		PropertyConfigurator.configure("log4j.properties");
		boolean fname = driver.findElement(By.id("SaveBtn")).isEnabled();
		Assert.assertTrue(fname);
		log.info("Save button is enabled");
		workflow.clicksaveBtn();
		
		log.info("Data is saved");	
	}

	@Then("^Fetch error message from alert box$")
	public void fetch_error_message_from_alert_box(){
		PropertyConfigurator.configure("log4j.properties");
		String msg_in_alert=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(msg_in_alert);
		log.info("Message in alert is retrieved");
		driver.navigate().refresh();	
		 projectPage.tabSelect();
		 testEventPage.clickAddIssue();
		
	}
		
	@Then("^Fetch data from excel sheet and insert it$")
	public void fetch_data_from_excel_sheet_and_insert_it() throws Throwable {
		PropertyConfigurator.configure("log4j.properties");
		
		driver.switchTo().frame("contentframe");
		String detailsData[] = ExcelUtils.readExcelDataForDetails("IssueInfo");
		details.setReportedBy(detailsData[0]);
		details.setReportedDate(detailsData[1]);
		details.setSeverity(detailsData[2]);
		details.setName(detailsData[3]);
	    details.setIssueCategory(detailsData[4]);
	    details.setResponsibility(detailsData[5]);
		 details.setReportedBy(detailsData[6]);
		 details.setPriority(detailsData[7]);
		 details.setDueDate(detailsData[8]);
		 
		 details.clickWorkFlowTab();
		 log.info("Successfully fetched all the data from the excel sheet and inserted into their corresponding fields");
		
		
	}

	@Then("^Automate Workflow tab$")
	public void automate_Workflow_tab() throws Throwable {
		PropertyConfigurator.configure("log4j.properties");
		
		String WorkflowData[] =ExcelUtils.readExcelDataForWorkflow("IssueInfo");
		workflow.setInitiator(WorkflowData[0]);
		workflow.setPerformer(WorkflowData[1]);
		workflow.setApprover(WorkflowData[2]);
		workflow.clicksaveBtn();
		
		linkedCards =workflow.clickLinkedCardsTab();
		
		log.info("Initiator, Performer and Approver name was set");
		log.info("Successfully clicked on save button");
		log.info("Successfully clicked on Linked cards tab");
		
		
	}

	@Then("^Navigate to Linked Cards tab$")
	public void automate_Linked_Cards_tab() throws Throwable {
		PropertyConfigurator.configure("log4j.properties");
		
		linkedCards.clickCommentTab();
		log.info("Successfully clicked on comment tab");
	}

	@Then("^Navigate to Comments tab$")
	public void automate_Comments_tab() throws Throwable {
		PropertyConfigurator.configure("log4j.properties");
		
		comments.clickpreviousVersionsTab();
		log.info("Successfully clicked on Previous versions tab");
	}

	@Then("^Navigate to Previous Version tab$")
	public void automate_Previous_Version_tab() throws Throwable {
		PropertyConfigurator.configure("log4j.properties");
		
		previousVersions.clickActivityLogTab();
		log.info("Successfully clicked on Activity log");
		
	}

	@Then("^Navigate to Activity Log tab$")
	public void automate_Activity_Log_tab() throws Throwable {
		PropertyConfigurator.configure("log4j.properties");
		
		activityLog.clickAttachmentsTab();
		log.info("Successfully clicked on Attachments tab");
		
	}

	@Then("^Navigate to Attachment tab$")
	public void automate_Attachment_tab() throws Throwable {
		PropertyConfigurator.configure("log4j.properties");
		
		attachments.addFile();
		attachments.deleteFile();
		attachments.downloadFile();
	}

	@Then("^Close the browser$")
	public void close_the_browser() {
		PropertyConfigurator.configure("log4j.properties");
		closeDriver();
		//quitDriver();
		log.info("Browser closed");
	}
	@After
    public void doSomethingAfterStep(Scenario scenario) throws IOException{
		String[] tab = scenario.getId().split(";");
	     String ScenarioName=tab[0];
	    report.flush();

		if (scenario.isFailed() == true) {
			
				CustomReports.updateReport(index,ScenarioName, scenario.getName().toString(), "Fail",
						BaseUI.description);
			} else if (scenario.isFailed() == false) {

				CustomReports.updateReport(index,ScenarioName,scenario.getName().toString(), "Pass",
						BaseUI.description);
			} else {
				CustomReports.updateReport(index,ScenarioName,scenario.getName().toString(), "Other",
						"skipped");
			}
			index++;
	    }
    
}
