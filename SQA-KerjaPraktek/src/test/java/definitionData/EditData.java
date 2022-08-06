package definitionData;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditData {
	WebDriver driver;
	String agent;

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

	@When("User move to table_Data")
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
		// mengubah nama agent
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				// *[@id="tl_edit_user_activity-12-52807_text"]/option[5]
				WebElement agent = driver
						.findElement(By.xpath("//*[@id=\"tl_edit_user_activity-12-52807_text\"]/option[5]"));
				agent.click();
				System.out.println("agent dalam kotak yang dipilih " + agent.getText());
				this.agent = agent.getText();
				state = false;
			} catch (Exception e) {
				System.out.println("6" + e);
			}
		}

		// mengubah status activity
		/* on going
		 * wait a few moment
		 */
	}

	@When("User confirm or click update button")
	public void user_confirm_or_click_update_button() {
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[normalize-space()='UPDATE']")).click();
				state = false;
			} catch (Exception e) {
				System.out.println("8" + e);
			}
		}
		state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				WebElement updtMsg = driver.findElement(By.xpath("//*[@id=\"nikita-form-dialog\"]/p"));
				System.out.println(updtMsg.getText());
				driver.findElement(By.xpath("//span[normalize-space()='OK']")).click();
				state = false;
			} catch (Exception e) {
				System.out.println("7" + e);
			}
		}
	}

	@Then("User see data changed successfully for earliest data")
	public void user_see_data_changed_successfully() {
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				WebElement agentAct = driver.findElement(By.xpath("//td[@id='tl_edit_data--52536-cell-0-10']"));
				System.out.println("agent yang dilihat setelah di update " + agentAct.getText());
				Assert.assertEquals(agent, agentAct.getText());
				driver.close();
				state = false;
			} catch (Exception e) {
				System.out.println("9" + e);
			}
		}
	}

	@Then("User see data changed successfully for latest data")
	public void user_see_data_changed_successfully_change() {
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				WebElement agentAct = driver.findElement(By.xpath("//*[@id=\"tl_edit_data--52536-cell-6-10\"]"));
				System.out.println("agent yang dilihat setelah di update " + agentAct.getText());
				Assert.assertEquals(agent, agentAct.getText());
				driver.close();
				state = false;
			} catch (Exception e) {
				System.out.println("9" + e);
			}
		}
	}

	@When("User select the latest data")
	public void user_select_the_latest_data() {
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"tl_edit_data--52536\"]/div[9]/ul/li[8]/a")).click();
				state = false;
			} catch (Exception e) {
				System.out.println("5" + e);
			}
		}

		state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"tl_edit_data--52536_table\"]/tbody/tr[7]")).click();
				state = false;
			} catch (Exception e) {
				System.out.println("5" + e);
			}
		}
	}

	@When("User not confirm or click close button")
	public void user_not_confirm_or_click_close_button() {
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				WebElement agent = driver
						.findElement(By.xpath("//*[@id=\"tl_edit_user_activity-12-52807_text\"]/option[4]"));
				System.out.println("agent dalam kotak yang tidak jadi dipilih " + agent.getText());
				this.agent = agent.getText();
				state = false;
			} catch (Exception e) {
				System.out.println("6" + e);
			}
		}
		state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-close']")).click();
				state = false;
			} catch (Exception e) {
				System.out.println("8" + e);
			}
		}
	}

	@Then("User see data not changed for earliest data")
	public void user_see_data_not_changed() {
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				WebElement agentAct = driver.findElement(By.xpath("//td[@id='tl_edit_data--52536-cell-0-10']"));
				System.out.println("agent yang dilihat pada tabel " + agentAct.getText());
				Assert.assertNotEquals(agent, agentAct.getText());
				driver.close();
				state = false;
			} catch (Exception e) {
				System.out.println("9" + e);
			}
		}
	}

	@Then("User see data not changed for latest data")
	public void user_see_data_not_changed_for() {
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				WebElement agentAct = driver.findElement(By.xpath("//*[@id=\"tl_edit_data--52536-cell-6-10\"]"));
				System.out.println("agent yang dilihat pada tabel " + agentAct.getText());
				Assert.assertNotEquals(agent, agentAct.getText());
				driver.close();
				state = false;
			} catch (Exception e) {
				System.out.println("9" + e);
			}
		}
	}

}
