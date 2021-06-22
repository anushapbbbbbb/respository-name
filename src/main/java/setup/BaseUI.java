package setup;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Log;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import utilities.ExtentReport;
import utilities.ReadPropertiesFile;


public class BaseUI {
	public ExtentReports report = ExtentReport.getReportInstance();
	public static ExtentTest logger;
	public static Log log;
	
	public static WebDriver driver;
	@FindBy(id = "i0116")
	public static WebElement email;
	@FindBy(id = "i0118")
	public static WebElement password;
	@FindBy(id = "idSIButton9")
	public static WebElement nextButton;
	@FindBy(id = "idSubmit_SAOTCC_Continue")
	public static WebElement continuebtn;
	public static SoftAssert softassert = new SoftAssert();
	public static String description;

	public static WebDriver browserSetUp() throws MalformedURLException// setting up browser
	{
		String browser = ReadPropertiesFile.getProperties("browserName");
		if (browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().arch64().setup();
			
			
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().arch64().setup();
			driver = new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("grid")) {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome() ;
			driver= new RemoteWebDriver(new URL("http://192.168.1.9:17362/wd/hub"),capabilities);
		}
		System.out.println("*****************************************************************************");
		System.out.println("Browser Initialized successfully");
		System.out.println("*****************************************************************************");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		return driver;
	}

	// To open the website URL
	public HomePage openURL() {
		driver.get(ReadPropertiesFile.getProperties("webSiteUrl"));
		driver.manage().window().maximize();
		waitInSeconds(100);
		return PageFactory.initElements(driver, HomePage.class);
	}

	public static void login()// login manually
	{

		BaseUI main = new BaseUI();
		PageFactory.initElements(driver, main);
		try {
			Thread.sleep(7500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("*****************************************************************************");
		System.out.println("Successfully Logged in");
		System.out.println("*****************************************************************************");
		}
	
	
	public static void closeDriver()// closing the browser
	{
		//driver.close();
		driver.quit();
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("closing the brower");
		System.out.println("-----------------------------------------------------------------------------");

	}

	/*public static void quitDriver()// quitting the driver
	{
		driver.quit();
		System.out.println("*****************************************************************************");
		System.out.println("Browser quitted successfully");
		System.out.println("*****************************************************************************");

	}*/




	// To set the time of wait.
	public static void waitInSeconds(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	// To Identify the Page WebElement
	public WebElement getElement(String locatorKey) {
		WebElement element = null;
		try {

			if (locatorKey.endsWith("_Id")) {
				element = driver.findElement(By.id(ReadPropertiesFile.getProperties(locatorKey)));
			} else if (locatorKey.endsWith("_xpath")) {
				element = driver.findElement(By.xpath(ReadPropertiesFile.getProperties(locatorKey)));
			} else if (locatorKey.endsWith("_CSS")) {
				element = driver.findElement(By.cssSelector(ReadPropertiesFile.getProperties(locatorKey)));
			} else if (locatorKey.endsWith("_Linktext")) {
				element = driver.findElement(By.linkText(ReadPropertiesFile.getProperties(locatorKey)));
			} else if (locatorKey.endsWith("_PartialLinkText")) {
				element = driver.findElement(By.partialLinkText(ReadPropertiesFile.getProperties(locatorKey)));
			} else if (locatorKey.endsWith("_Name")) {
				element = driver.findElement(By.name(ReadPropertiesFile.getProperties(locatorKey)));
			} else {
				reportFail("Failing the TestCase, Invalid Locator " + locatorKey);
				Assert.fail("Failing the TestCase : " + locatorKey);
				System.out.println("Failing the TestCase : " + locatorKey);
			}

		} catch (Exception e) {
			reportFail(e.getMessage());
			e.printStackTrace();

			Assert.fail("Failing the TestCase : " + e.getMessage());
		}

		return element;

	}

	/************** Click on element with WebElement ****************/
	public static void clickOn(By locator, int timeout) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(locator));
			driver.findElement(locator).click();
		} catch (Exception e) {
			e.printStackTrace();
//			log.error("Failed to click on element");
			reportFail(e.getMessage());
		}
	}

	/**************** Get By locator using locator key ****************/
	public static By getLocator(String locatorKey) {
		if (locatorKey.endsWith("_id")) {
			return By.id(ReadPropertiesFile.getProperties(locatorKey));
		}
		if (locatorKey.endsWith("_name")) {
			return (By.name(ReadPropertiesFile.getProperties(locatorKey)));
		}
		if (locatorKey.endsWith("_className")) {
			return (By.className(ReadPropertiesFile.getProperties(locatorKey)));
		}
		if (locatorKey.endsWith("_xpath")) {
			return (By.xpath(ReadPropertiesFile.getProperties(locatorKey)));
		}
		if (locatorKey.endsWith("_css")) {
			return (By.cssSelector(ReadPropertiesFile.getProperties(locatorKey)));
		}
		if (locatorKey.endsWith("_linkText")) {
			return (By.linkText(ReadPropertiesFile.getProperties(locatorKey)));
		}
		if (locatorKey.endsWith("_partialLinkText")) {
			return (By.partialLinkText(ReadPropertiesFile.getProperties(locatorKey)));
		}
		if (locatorKey.endsWith("_tagName")) {
			return (By.tagName(ReadPropertiesFile.getProperties(locatorKey)));
		}
      
		reportFail("Failing test case, Invalid locator key: " + locatorKey);
		return null;
	}

	
	

	/*************** reporting Function ************/
	public static void reportFail(String reportString) {
		System.out.println("Error is " + reportString);

	}

	/************** Take screenshot ****************/
	public static void takeScreenShot(String filepath) {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filepath);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void flushReports() {
		report.flush();
	}

	public void pressSaveBtn() {
		driver.findElement(By.id("SaveBtn")).click();
		waitInSeconds(5);
	}
	

}

