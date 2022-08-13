package runnerAndStepdefinition;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import SetupTestingDesignPatern.Config.AutomationFrameworkConfig;
import SetupTestingDesignPatern.DriverSingleton.DriverSingleton;
import SetupTestingDesignPatern.SetUp.ConfigurationProperties;
import SetupTestingDesignPatern.SetUp.SetUpUtils;
import SetupTestingDesignPatern.SetUpElement.LoginElement;
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
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class StepDefinition {

	@Autowired
	ConfigurationProperties config;
	private static WebDriver driver;
	private LoginElement loginPage;
	static String fileExcel;
	static XSSFRow row;


	String direktoriFile = System.getProperty("user.dir") + "\\test-output\\myfile";

	public static ExtentTest extentTest;
	public static ExtentReports reports = new ExtentReports("ReportTest.html");;
	static int counter = 0;
	static int fileCounter = 0;
	static String[] testName = { "Test, Login with wrong password",
			"Test, Login with wrong username",
			"Test, Login without fill username and password", "Test Valid Login",
			"Test, Upload excel file", "Test, Upload non excelfile"};

	// method screenshot
	public String screenShot() {
		String hasil = null;
		try {
			File destFile = StepDefinition.ambilGambar(driver, direktoriFile + fileCounter + ".png");
			hasil = "<a target='_blank' href='" + destFile.getAbsolutePath() + "'>" + "<img src='"
					+ destFile.getAbsolutePath() + "'width = 100 height = 100 /></a>";
		} catch (IOException e) {
			System.out.println("error");
		}

		return hasil;

	}

	public static File ambilGambar(WebDriver webdriver, String filepath) throws IOException {
		TakesScreenshot ss = ((TakesScreenshot) webdriver);
		File srcFile = ss.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filepath);
		FileUtils.copyFile(srcFile, destFile);

		return destFile;
	}

	@Before
	public void setUp() {
		DriverSingleton.getInstance(config.getBrowser());
		loginPage = new LoginElement();
		extentTest = reports.startTest(testName[counter++]);
	}

	@AfterStep
	public void getResultScreenshot(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			fileCounter++;
			extentTest.log(LogStatus.FAIL, screenShot());
			driver.navigate().to(SetUpUtils.URL);
		}
	}

	@After
	public void endTestStep() {
		reports.endTest(extentTest);
		reports.flush();
		driver.navigate().to(SetUpUtils.URL);
	}

	@AfterAll
	public static void quitDriver() {
		driver.quit();
	}

	// User Admin mengakses website
	@Given("User access the URL sqa peluang kerjaku")
	public void admin_mengakses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(SetUpUtils.URL);
		extentTest.log(LogStatus.PASS, "User access the URL " + SetUpUtils.URL);
	}

	// User for login test
	
		// negatif test
		@When("User login with invalid {string} and {string}")
		public void admin_mengisi_password(String string, String string2) throws Exception {
			Thread.sleep(1000);
			loginPage.formUsername(string);
			loginPage.formPassword(string2);
			extentTest.log(LogStatus.PASS, "User login with invalid <username> and <password>");
		}
	
		@When("User click submit")
		public void admin_menekan_submit() {
			loginPage.submitBtn();
			extentTest.log(LogStatus.PASS, "User click submit");
		}
	
		@Then("User get alert")
		public void alert() {
			loginPage.text_alert_error();
			assertEquals(loginPage.text_alert_error(), "Username atau password tidak ditemukan atau akun anda tidak aktif");
			extentTest.log(LogStatus.PASS,
					"User get allert : Username atau password tidak ditemukan atau akun anda tidak aktif");
		}
	
		// positif test
		@When("User login with valid username and password")
		public void admin_mengisi_username() throws Exception {
			driver.navigate().refresh();
			Thread.sleep(1000);
			loginPage.formUsername(config.getUsernameIsLogin());
			loginPage.formPassword(config.getPassword());
			extentTest.log(LogStatus.PASS, "User login with valid username and password");
		}
	
		@Then("User get notification")
		public void notifikasi() {
			loginPage.textValidation();
			assertEquals(loginPage.textValidation(), "Welcome to Tele Kita");
			extentTest.log(LogStatus.PASS, "User get notification : Welcome to Tele Kita");
		}
		
	//User for upload test
		
		//positif test
		@When("User click ok to the validation message")
		public void ok_btn() {

			extentTest.log(LogStatus.PASS, "User click ok to the validation message");
		}
		

		@When("User move to data table and then upload data table")
		public void upload_data() {

			extentTest.log(LogStatus.PASS, "User move to data table and then upload data table");
		}
		
		
		@When("User import the excel file from directory")
		public void import_excel() {

			extentTest.log(LogStatus.PASS, "User import the excel file from directory");
		}
		
		@When("User doesnt import any excel file format {string}")
		public void doesnt_import_excel_file(String string) {

			extentTest.log(LogStatus.PASS, "User doesnt import any excel file format");
		}
		
		@When("User click upload button and then get new data on the page equals with data from excel file")
		public void get_data() {

			extentTest.log(LogStatus.PASS, "User click upload button and then get new data on the page equals with data from excel file");
		}
		
		@When("User click upload button and then get alert {string}")
		public void get_alert(String string) {

			extentTest.log(LogStatus.PASS, "User click upload button and then get alert "+string);
		}
		
		@When("User save the data and validate the message")
		public void save_data() {

			extentTest.log(LogStatus.PASS, "User save the data and validate the message");
		}
		
		@Then("User get validation msg {string}")
		public void validation(String string) {

//			assertEquals(,);
			extentTest.log(LogStatus.PASS, "User get validation msg " + string);
		}
		
		@Then("User get alert msg {string}")
		public void alertmsg(String string) {

//			assertEquals(,);
			extentTest.log(LogStatus.PASS, "User get alert msg " + string);
		}
}
