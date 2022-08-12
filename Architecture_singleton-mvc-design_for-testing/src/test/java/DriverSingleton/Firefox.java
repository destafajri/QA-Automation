package DriverSingleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategyInterface {

	public WebDriver setStrategy() {
//		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
}