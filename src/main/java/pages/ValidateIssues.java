package pages;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import setup.BaseUI;
import utilities.ExcelUtils;
import utilities.ExtentReport;

//@Listeners(ListenerUtils.class)
public class ValidateIssues extends BaseUI {

	public static WebDriver driver;
	public static ExtentReports report=ExtentReport.getReportInstance();
	HomePage home;
	ProjectPage projectPage;
	TestEventPage testEventPage;
	Details details;
	Workflow workflow;
	LinkedCards linkedCards;
	Comments comments;
	PreviousVersions previousVersions;
	ActivityLog activityLog;
	Attachments attachments;
	ValidateIssues validateIssues;

	public static int index = 1;
	public static String description;

	public static String[] data;

	public WebDriver configureBrowser() throws Exception {
		logger = report.createTest("Browser");

		validateIssues = new ValidateIssues();
		logger.log(Status.INFO, "Invoking the browser");
		driver = ValidateIssues.browserSetUp();
		logger.log(Status.PASS, "Successfully invoked the browser");
       return driver;
	}

	public void openingurl() throws Exception {
		logger = report.createTest("Mainspring webpage");

		validateIssues = new ValidateIssues();
		logger.log(Status.INFO, "Opening the Mainspring webpage");
		home = validateIssues.openURL();
		logger.log(Status.PASS, "Opened the Mainspring webpage");

	}

	public void clickingOnBurgerIcon() throws Exception {
		logger = report.createTest("Burger icon");
		home.clickBurgerIcon();
		logger.log(Status.PASS, "Successfully clicked on the burger icon");
	}

	public void selectProjectName() throws Exception {
		logger = report.createTest("Project name");

		projectPage = home.clickCFOOnsiteProject();
		logger.log(Status.PASS, "Successfully selected the project name");
	}

	public void testEventTab() throws Exception {
		logger = report.createTest("Monitor tab");
		logger.log(Status.INFO, "Selecting the monitor tab");
		testEventPage = projectPage.tabSelect();
		logger.log(Status.PASS, "Successfully selected the monitor");

	}

	public void clickIssueTab() throws Exception {
		logger = report.createTest("Issue option");
		driver = testEventPage.clickAddIssue();
		logger.log(Status.PASS, "Successfully clicked  the issue tab");

		setUp(driver);

	}

	public void setUp(WebDriver driver) {

		details = new Details(driver);
		workflow = new Workflow(driver);
		linkedCards = new LinkedCards(driver);
		comments = new Comments(driver);
		previousVersions = new PreviousVersions(driver);
		activityLog = new ActivityLog(driver);
		attachments = new Attachments(driver);
	}

	public void testDetailsTab() throws Exception {
		description = "Reading the data from excel";

		details = new Details(driver);
		logger.log(Status.INFO, "Switching to iframe");
		driver.switchTo().frame("contentframe");
		System.out.println("After content frame");
		System.out.println("fetching in  the excel data");

	    logger.log(Status.INFO, "Reading the data from excel");
		String detailsData[] = ExcelUtils.readExcelDataForDetails("IssueInfo");
		logger.log(Status.PASS, "Successfully fetched the data from excel");
		System.out.println("fetched the excel data");
		System.out.println("inserting the first data");
		details.setIssueType(detailsData[0]);
		logger.log(Status.PASS, "Selected the issue type");
		details.setReportedDate(detailsData[1]);
		logger.log(Status.PASS, "Selected the reported date");
		details.setSeverity(detailsData[2]);
		logger.log(Status.PASS, "Selected the type of severity");
		details.setName(detailsData[3]);
		logger.log(Status.PASS, "Entered the name successfully");
		details.setIssueCategory(detailsData[4]);
		logger.log(Status.PASS, "Selected the issue type successfully");
		details.setResponsibility(detailsData[5]);
		logger.log(Status.PASS, "Selected the Responsibilty successfully");
		details.setReportedBy(detailsData[6]);
		logger.log(Status.PASS, "Entered Reported By name Successfully");
		details.setPriority(detailsData[7]);
		logger.log(Status.PASS, "Selected the priority successfully");
		details.setDueDate(detailsData[8]);
		logger.log(Status.PASS, "Selected the due date successfully");

	}

	public void testWorkflowTab() throws Exception {
		description = "Automation of workflow tab";

		logger.log(Status.INFO, "Reading the data from excel");
		String WorkflowData[] = ExcelUtils.readExcelDataForWorkflow("IssueInfo");
		logger.log(Status.PASS, "Fetched the data successfully from the excel");
		logger.log(Status.INFO, "Clicking on the workflow tab");
		workflow = details.clickWorkFlowTab();
		logger.log(Status.PASS, "Successfully clicked on the workflow tab");
		logger.log(Status.INFO, "Selecting Initiator name");
		workflow.setInitiator(WorkflowData[0]);
		logger.log(Status.PASS, "Selected the initiator");
		logger.log(Status.INFO, "Selecting the performer name");
		workflow.setPerformer(WorkflowData[1]);
		logger.log(Status.PASS, "Selected the performer");
		logger.log(Status.INFO, "Selecting the approver name");
		workflow.setApprover(WorkflowData[2]);
		logger.log(Status.PASS, "Selected the approver");
		validateIssues.pressSaveBtn();
		logger.log(Status.PASS, "Saved the data successfully");

	}

	public void testLinkedCardsTab() throws Exception {
		description = "Automation of Linked Cards Tab";

		logger.log(Status.INFO, "Clicking on the linked Card tab");
		linkedCards = workflow.clickLinkedCardsTab();
		logger.log(Status.PASS, "Successfully clicked on the linked card tab");

	}

	public void testCommentsTab() throws Exception {
		description = "Automation of Comment Tab";

		logger.log(Status.INFO, "Clicking on Comment tab");
		comments = linkedCards.clickCommentTab();
		logger.log(Status.PASS, "Successfully clicked on the Comment tab");

	}

	public void testPreviousVersionTab() throws Exception {
		description = "Automation of Previous version Tab";

		logger.log(Status.INFO, "Clicking on the Previous Version Tab");
		previousVersions = comments.clickpreviousVersionsTab();
		logger.log(Status.PASS, "Clicked on the Previous Version Tab");
	}

	public void testActivityLogTab() throws Exception {
		description = "Automation of Activity Log Tab";

		logger.log(Status.INFO, "Clicking on Activity Log tab");
		activityLog = previousVersions.clickActivityLogTab();
		logger.log(Status.PASS, "Successfully clicked on the Activity Log tab");
	}

	public void testAttachmentTab() throws Exception {
		description = "Automation of Attachment Tab";

		logger.log(Status.INFO, "Clicking on the Attachments tab");
		attachments = activityLog.clickAttachmentsTab();
		logger.log(Status.PASS, "Successfully clicked on Attachments tab");
	}

	public void closeBrowser() {
		driver.close();
	}

}
