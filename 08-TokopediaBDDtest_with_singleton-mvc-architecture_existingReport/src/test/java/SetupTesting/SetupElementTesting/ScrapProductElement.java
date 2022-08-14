package SetupTesting.SetupElementTesting;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SetupTesting.SetupDriverSingleton.DriverSingleton;

public class ScrapProductElement {

	private WebDriver driver;

	public ScrapProductElement() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	// Element
	@FindBy(xpath = "//div[@data-testid='spnSRPProdName']")
	private WebElement nameAll;
	
	@FindBy(xpath = "//div[@data-testid='spnSRPProdPrice']")
	private WebElement priceAll;

	
	// method
	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int y = 0; y <= 80; y++) {
			js.executeScript("window.scrollBy(0," + y + ")");
		}
	}

}
