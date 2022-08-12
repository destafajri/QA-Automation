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

	@FindBy(name = "username")
	private WebElement input_username_login;

	@FindBy(name = "password")
	private WebElement input_password_login;

	@FindBy(id = "button")
	private WebElement btn_submit_login;

	@FindBy(css = "body > div > div > div > form > div.alert.alert-success.alert-dismissable")
	private WebElement text_alert_error;

	@FindBy(xpath = "//*[@id=\"content\"]/h1")
	private WebElement textMenuForm;

	
	
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

	public String textDashboard() {
		return textMenuForm.getText();
	}

	public String text_alert_error() {
		return text_alert_error.getText();
	}

}
