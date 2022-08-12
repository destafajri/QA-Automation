package runnerAndStepdefinition;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import SetupTestingDesignPatern.Config.AutomationFrameworkConfig;
import SetupTestingDesignPatern.DriverSingleton.DriverSingleton;
import SetupTestingDesignPatern.SetUp.ConfigurationProperties;
import SetupTestingDesignPatern.SetUp.SetUpUtils;
import SetupTestingDesignPatern.SetUpElement.LoginElement;
import io.cucumber.java.After;
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
	
	String direktoriFile = System.getProperty("user.dir") + "\\test-output\\myfileNeg";

	public static ExtentTest extentTest ;
	public static ExtentReports reports = new ExtentReports("ReportTest.html");;
	static int counter = 0;
	static int fileCounter = 0;
	static String[] testName = {
			"Test Scenario Login Valid",
			"Test Scenario Login dengan pasword kosong",
			"Test Scenario Login dengan kombinasi Capitalcase",
			"Test Scenario Login dengan username dan password kosong",
			"Test Scenario Upload data excel",
			"Test Scenario Upload data non excel",
			"Test Scenario Distribute Valid",
			"Test Scenario Distribute tidak mengisi agent",
			"Test Scenario Distribute tidak mengisi jumlah data",
			"Test Scenario Distribute tidak mengsi agent dan jumlah data",
			"Test Scenario Edit Data User awal",
			"Test Scenario Edit Data User akhir",
			"Test Scenario Edit Data User awal negatif",
			"Test Scenario Edit Data User akhir negatif",
	};
	

	//method screenshot
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
	}
	
	@AfterStep
	public void getResultScreenshot(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			fileCounter++;
			extentTest.log(LogStatus.FAIL, screenShot());
		} else {
			extentTest.log(LogStatus.PASS, "Step pass");
		}
	}

	@After
	public void endTestStep() {
		reports.endTest(extentTest);
		reports.flush();
//		driver.quit();
	}

	
	// User Admin mengakses website
		@Given("User Admin Mengakses URL sqa peluang kerjaku")
		public void admin_mengakses_url() {
			driver = DriverSingleton.getDriver();
			driver.get(SetUpUtils.URL);
			extentTest.log(LogStatus.PASS, "User Admin Mengakses Url "+SetUpUtils.URL);
		}
		
	// User Admin melakukan login
		@When("User Admin mengisi username")
		public void admin_mengisi_username() {
			loginPage.formUsername(config.getUsernameSuccess());
		}
		
		@When("User Admin mengisi password")
		public void admin_mengisi_password() {
			loginPage.formPassword(config.getPassword());
		}
		
		@When("User Admin menekan tombol submit")
		public void admin_menekan_submit() {
			loginPage.submitBtn();
		}
		
		@Then("User Admin mendapatkan notifikasi")
		public void notifikasi() {
			loginPage.textValidation();
			extentTest.log(LogStatus.PASS, "Welcome to Tele Kita");
		}
		
		
		
		
		
}
