package mainTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import SetupTesting.Configuration.AutomationFrameworkConfiguration;
import SetupTesting.SetupDriverSingleton.DriverSingleton;
import SetupTesting.SetupElementTesting.LoginElement;
import SetupTesting.SetupElementTesting.SearchProductElement;
import SetupTesting.SetupUtilsAndProperties.ConfigurationProperties;
import SetupTesting.SetupUtilsAndProperties.SetupUrlDriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {
	@Autowired
	ConfigurationProperties config;
	private static WebDriver driver;
	private LoginElement loginPage;
	private SearchProductElement searchProduct;
	
	//extent report
	String direktoriFile = System.getProperty("user.dir") + "\\test-output\\myfile";
	public static ExtentTest extentTest;
	public static ExtentReports reports = new ExtentReports("ReportTest.html");;
	static int counter = 0;
	static int fileCounter = 0;
	static String[] testName =new String[20000];
	
	@Before
	public void setUp() {
		DriverSingleton.getInstance(config.getBrowser());
		testName[0]="Test, Browser access";
		
		//login object
		loginPage = new LoginElement();
		testName[1] = "Test, Login with unregistered number";
		
		//search product objet
		searchProduct = new SearchProductElement();
		testName[2] = "Test, Search Product";
		
		extentTest = reports.startTest(testName[counter++]);
	}

	@AfterStep
	public void getResultScreenshot(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			fileCounter++;
			extentTest.log(LogStatus.FAIL, screenShot());
		}
	}

	@After
	public void endTestStep() {
		reports.endTest(extentTest);
		reports.flush();
		driver.navigate().to(SetupUrlDriverUtils.URL);
	}

	@AfterAll
	public static void quitDriver() {
		driver.quit();
	}

	// User access the tokoijo website
	@Given("User access the URL")
	public void admin_mengakses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(SetupUrlDriverUtils.URL);
		extentTest.log(LogStatus.PASS, "User access the URL " + SetupUrlDriverUtils.URL);
	}

	// User for login test

		// negative test
		@When("User move to login page")
		public void loginpage() throws Exception {
			Thread.sleep(100);
			loginPage.loginBtn();
			extentTest.log(LogStatus.PASS, "User move to login page");
		}

	
		@When("login with unregistered phone number")
		public void fill_phone_numb() throws Exception {
			Thread.sleep(1000);
			loginPage.formEmailPhone(config.getinvalidPhone());
			loginPage.submitBtn();
			extentTest.log(LogStatus.PASS, "User login with unregistered phone number " +config.getinvalidPhone());
		}
		
		@Then("User get allert {string}")
		public void allert(String string) throws Exception {
			Thread.sleep(1000);
			loginPage.text_alert_error();
			assertEquals(loginPage.text_alert_error(), string);
			extentTest.log(LogStatus.PASS, "User get allert "+string);
		}
		
		
	// User for searchProduct
		@When("User search a product {string}")
		public void search(String string) throws Exception {
			Thread.sleep(100);
			searchProduct.searchProduct(string);
			extentTest.log(LogStatus.PASS, "User search a product " + string);
		}
		
		@When("User send enter query")
		public void enter_search() throws Exception {
			Thread.sleep(100);
			searchProduct.enterSearch();;
			extentTest.log(LogStatus.PASS, "User send enter query");
		}

		@Then("User get the product display {string}")
		public void product(String string) throws Exception {
			Thread.sleep(1000);
			searchProduct.searchInfo();
			assertTrue(searchProduct.searchInfo().contains(string));
			extentTest.log(LogStatus.PASS, "User get the product display "+ searchProduct.searchInfo());
		}
		
		
		
		
	// method screenshot
	public String screenShot() {
		String hasil = null;
		try {
			File destFile = StepDefinition.takePicture(driver, direktoriFile + fileCounter + ".png");
			hasil = "<a target='_blank' href='" + destFile.getAbsolutePath() + "'>" + "<img src='"
					+ destFile.getAbsolutePath() + "'width = 100 height = 100 /></a>";
		} catch (IOException e) {
			System.out.println("error");
		}

		return hasil;

	}

	public static File takePicture(WebDriver webdriver, String filepath) throws IOException {
		TakesScreenshot ss = ((TakesScreenshot) webdriver);
		File srcFile = ss.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filepath);
		FileUtils.copyFile(srcFile, destFile);

		return destFile;
	}

}
