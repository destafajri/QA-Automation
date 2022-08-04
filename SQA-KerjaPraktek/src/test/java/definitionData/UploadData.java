package definitionData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UploadData {
	WebDriver driver;
	String baseURL = "https://sqa.peluangkerjaku.com/tele/";

	@Given("UserSpv on the login page")
	public void UserSpv_on_the_login_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.get(baseURL);

	}

	@When("UserSpv login with valid UserSpvname {string} and password {string}")
	public void UserSpv_login_with_valid_UserSpvname_and_password(String string, String string2) {
		try {
			Thread.sleep(1000);
			driver.findElement(By.id("tl_login-1-51550_text")).sendKeys(string);
			Thread.sleep(1000);
			driver.findElement(By.id("tl_login-1-51551_text")).sendKeys(string2);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='Sign In']")).click();
		} catch (Exception e) {
		}
	}

	@When("UserSpv get login validate {string}")
	public void UserSpv_get_login_validate(String string) {
		try {
			Thread.sleep(1000);
			WebElement welcomeText = driver.findElement(By.xpath("//*[@id=\"nikita-form-dialog\"]/p"));
			System.out.println("Welcome validation => " + welcomeText.getText());
			Assert.assertEquals(welcomeText.getText(), string);
		} catch (Exception e) {
		}

	}

	@When("UserSpv click ok to the validate message")
	public void UserSpv_click_ok_to_the_validate_message() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='OK']")).click();
		} catch (Exception e) {

		}
	}

	@When("UserSpv move to table Data")
	public void UserSpv_move_to_table_Data() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//h3[@id='ui-id-11']")).click();
		} catch (Exception e) {

		}
	}

	@When("UserSpv move to table {string}")
	public void UserSpv_move_to_table_upload(String string) {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='" + string + "']")).click();
		} catch (Exception e) {

		}
	}

	@When("UserSpv import excel file from directory {string}")
	public void UserSpv_import_excel_file_from_directory(String string) {
		try {
			Thread.sleep(1000);
			WebElement chooseFile = driver.findElement(By.xpath("//input[@id='tl_upload_new--52043_text']"));
			chooseFile.sendKeys(string);
		} catch (Exception e) {

		}
	}

	@When("UserSpv click {string} file")
	public void UserSpv_click_file(String string) {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='" + string + "']")).click();
		} catch (Exception e) {

		}

	}

	@When("UserSpv save the new file")
	public void UserSpv_save_the_new_file() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@id='52055_query']")).click();
		} catch (Exception e) {

		}

	}

	@When("UserSpv get measurement statement Yakin Menimpan ?")
	public void UserSpv_get_measurement_statement() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@id='formtl_upload_newdialog-123']"));
		} catch (Exception e) {

		}
	}

	@When("UserSpv click {string} button")
	public void UserSpv_click_button(String string) {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='" + string + "']")).click();
		} catch (Exception e) {

		}
	}

	@Then("UserSpv get validation message {string}")
	public void UserSpv_get_validation_message(String string) {
		try {
			Thread.sleep(1000);
			WebElement validation =driver.findElement(By.xpath("//*[@id=\"nikita-form-dialog\"]/p"));
			Assert.assertEquals(validation.getText(), string);
			driver.close();
		} catch (Exception e) {

		}
	}

	@Then("UserSpv get message {string}")
	public void UserSpv_get_message(String string) {
		try {
			Thread.sleep(1000);
			WebElement validation =driver.findElement(By.xpath("//*[@id=\"nikita-form-dialog\"]/p"));
			Assert.assertEquals(validation.getText(), string);
		} catch (Exception e) {

		}
	}

	@When("UserSpv close the validation message")
	public void UserSpv_close_the_validation_message() {
		try {
			Thread.sleep(1000);
			WebElement close =driver.findElement(By.xpath("//button[@title='Close']"));
			close.click();
		} catch (Exception e) {

		}
	}

}
