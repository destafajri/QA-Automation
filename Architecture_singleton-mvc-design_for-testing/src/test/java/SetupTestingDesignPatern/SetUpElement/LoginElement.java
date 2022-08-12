package SetupTestingDesignPatern.SetUpElement;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import SetupTestingDesignPatern.DriverSingleton.DriverSingleton;

public class LoginElement {
	private WebDriver driver;

	public LoginElement() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "tl_login-1-51550_text")
	private WebElement input_username_login;

	@FindBy(id = "tl_login-1-51551_text")
	private WebElement input_password_login;

	@FindBy(id = "//span[normalize-space()='Sign In']")
	private WebElement btn_submit_login;

	@FindBy(xpath = "//*[@id='nikita-form-dialog']/p")
	private WebElement text_alert_error;

	@FindBy(xpath = "//*[@id='nikita-form-dialog']/p")
	private WebElement textValidation;

	
	
	public void formLogin(String user, String pass) {
		input_username_login.sendKeys(user);
		input_password_login.sendKeys(pass);
		btn_submit_login.click();
	}

	public String usernameEmpty() {
		return input_username_login.getText();
	}

	public String passwordEmpty() {
		return input_password_login.getText();
	}

	public String textValidation() {
		return textValidation.getText();
	}

	public String text_alert_error() {
		return text_alert_error.getText();
	}

}
