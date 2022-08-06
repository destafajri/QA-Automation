package definitionData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditData {
	WebDriver driver;

	@Given("User login with username {string} and password {string}")
	public void user_login_with_username_and_password(String string, String string2) {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.get("https://sqa.peluangkerjaku.com/tele/");
		driver.findElement(By.id("tl_login-1-51550_text")).sendKeys(string);
		driver.findElement(By.id("tl_login-1-51551_text")).sendKeys(string2);
		driver.findElement(By.xpath("//span[normalize-space()='Sign In']")).click();
	}

	@When("User get login message {string}")
	public void user_get_login_message(String string) {
		try {
			Thread.sleep(1000);
			WebElement welcomeText = driver.findElement(By.xpath("//*[@id=\"nikita-form-dialog\"]/p"));
			System.out.println("Welcome validation => " + welcomeText.getText());
			Assert.assertEquals(welcomeText.getText(), string);
		} catch (Exception e) {

		}

	}

	@When("User click ok to the validate message")
	public void user_click_ok_to_the_validate_message() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='OK']")).click();

		} catch (Exception e) {
			System.out.println("1" + e);
		}

	}

	@When("User move to table Data")
	public void user_move_to_table_Data() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//h3[@id='ui-id-11']")).click();
		} catch (Exception e) {
			System.out.println("2" + e);
		}
	}

	@When("User move to table Edit Data")
	public void user_move_to_table_Edit_Data() {
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[normalize-space()='Edit Data']")).click();
				state = false;
			} catch (Exception e) {
				System.out.println("3" + e);
			}
		}
	}

	@When("User select the earliest data")
	public void user_select_the_earliest_data() {
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"tl_edit_data--52536_table\"]/tbody/tr[1]")).click();
				state = false;
			} catch (Exception e) {
				System.out.println("5" + e);
			}
		}
	}

	@When("User update or edit the data")
	public void user_update_or_edit_the_data() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("User confirm or click update button")
	public void user_confirm_or_click_update_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("User see data changed successfully")
	public void user_see_data_changed_successfully() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("User select the latest data")
	public void user_select_the_latest_data() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("User select earliest data")
	public void user_select_earliest_data() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("User not confirm or click close button")
	public void user_not_confirm_or_click_close_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("User see data not changed")
	public void user_see_data_not_changed() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
