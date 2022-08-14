package SetupTesting.SetupDriverSingleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeExistingBrowser implements DriverStrategyInterface {

	public WebDriver setStrategy() {
		String path = System.getenv("WEBDRIVER");
		System.setProperty("webdriver.chrome.driver", path);
		// Create object of ChromeOptions Class
		ChromeOptions opt = new ChromeOptions();

		// pass the debuggerAddress and pass the port along with host. Since I am
		// running test on local so using localhost
		opt.setExperimentalOption("debuggerAddress", "localhost:9222 ");

		// pass ChromeOptions object to ChromeDriver constructor
		WebDriver driver = new ChromeDriver(opt);
		return driver;
	}
}
