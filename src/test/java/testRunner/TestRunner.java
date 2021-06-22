package testRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import setup.BaseUI;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/Features",  //the path of the feature files
		glue = {"stepDefinitions"}, //the path of the step definition files
		format = {"pretty","html:test-output", "json:target/report_json/cucumber.json", "junit:target/report_xml/cucumber.xml"},
		strict=true,
		dryRun =false,
		monochrome= true
		)


	public class TestRunner{
		public static int index = 1;
		
	    private TestNGCucumberRunner testNGCucumberRunner;
	   
	     @BeforeClass(alwaysRun = true)
	    public void setUpCucumber() {
	    	 testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	    }
	    
	     @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	    public void feature(CucumberFeatureWrapper cucumberFeature) {
	        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	    }
	 
	    @DataProvider
	    public Object[][] features() {
	        return testNGCucumberRunner.provideFeatures();
	    }
	    
	 
	    @AfterClass(alwaysRun = true)
	    public void tearDownClass() throws Exception {
	        testNGCucumberRunner.finish();
	    }
	    
	    @AfterClass
		public static void closeDriver() {
			BaseUI.closeDriver();
			//BaseUI.quitDriver();
			
	    }
		
	}

