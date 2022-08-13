package runnerAndStepdefinition;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

	String direktoriFile = System.getProperty("user.dir") + "\\test-output\\myfile";

	public static ExtentTest extentTest;
	public static ExtentReports reports = new ExtentReports("ReportTest.html");;
	static int counter = 0;
	static int fileCounter = 0;
	static String[] testName = { "Test Scenario Login dengan pasword kosong",
			"Test Scenario Login dengan kombinasi Capitalcase",
			"Test Scenario Login dengan username dan password kosong", "Test Scenario Login Valid",
			"Test Scenario Upload data excel", "Test Scenario Upload data non excel", "Test Scenario Distribute Valid",
			"Test Scenario Distribute tidak mengisi agent", "Test Scenario Distribute tidak mengisi jumlah data",
			"Test Scenario Distribute tidak mengsi agent dan jumlah data", "Test Scenario Edit Data User awal",
			"Test Scenario Edit Data User akhir", "Test Scenario Edit Data User awal negatif",
			"Test Scenario Edit Data User akhir negatif", };

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
	}

	@AfterAll
	public static void quitDriver() {
		driver.quit();
	}

	// User Admin mengakses website
	@Given("User Admin Mengakses URL sqa peluang kerjaku")
	public void admin_mengakses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(SetUpUtils.URL);
		extentTest.log(LogStatus.PASS, "User Admin Mengakses Url " + SetUpUtils.URL);
	}

	// User Admin melakukan login

	// negatif test
	@When("User Admin mengisi username {string}")
	public void admin_mengisi_username2(String string) throws Exception {
		driver.navigate().refresh();
		Thread.sleep(1000);
		loginPage.formUsername(string);
		extentTest.log(LogStatus.PASS, "User Admin mengisi username invalid");
	}

	@When("User Admin mengisi password {string}")
	public void admin_mengisi_password(String string) throws Exception {
		Thread.sleep(1000);
		loginPage.formPassword(string);
		extentTest.log(LogStatus.PASS, "User Admin mengisi username invalid");
	}

	@When("User Admin menekan tombol submit")
	public void admin_menekan_submit() {
		loginPage.submitBtn();
		extentTest.log(LogStatus.PASS, "User Admin menekan tombol submit");
	}

	@Then("User Admin mendapatkan allert")
	public void alert() {
		loginPage.text_alert_error();
		assertEquals(loginPage.text_alert_error(), "Username atau password tidak ditemukan atau akun anda tidak aktif");
		extentTest.log(LogStatus.PASS,
				" User mendapatkan alert : Username atau password tidak ditemukan atau akun anda tidak aktif");
	}

	// positif test
	@When("User Admin mengisi username")
	public void admin_mengisi_username() throws Exception {
		driver.navigate().refresh();
		Thread.sleep(1000);
		loginPage.formUsername(config.getUsernameIsLogin());
		extentTest.log(LogStatus.PASS, "User Admin mengisi username valid");
	}

	@When("User Admin mengisi password")
	public void admin_mengisi_password() {
		loginPage.formPassword(config.getPassword());
		extentTest.log(LogStatus.PASS, "User Admin mengisi password valid");
	}

	@Then("User Admin mendapatkan notifikasi")
	public void notifikasi() {
		loginPage.textValidation();
		assertEquals(loginPage.textValidation(), "Welcome to Tele Kita");
		extentTest.log(LogStatus.PASS, " User mendapatkan notifikasi : Welcome to Tele Kita");
	}

}
