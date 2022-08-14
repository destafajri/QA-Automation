package SetupTesting.SetupElementTesting;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SetupTesting.SetupDriverSingleton.DriverSingleton;

public class ScrapProductElement {

	private WebDriver driver;

	public ScrapProductElement() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	// Element
	@FindBy(xpath = "//div[@data-testid='spnSRPProdName']")
	private List<WebElement> nameAll;

	@FindBy(xpath = "//div[@data-testid='spnSRPProdPrice']")
	private List<WebElement> priceAll;

	@FindBy(xpath = "//button[@aria-label='Laman berikutnya']")
	private WebElement next;

	// method
	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int y = 0; y <= 150; y++) {
			js.executeScript("window.scrollBy(0," + y + ")");
		}
	}

	public void page(int page) {
		for (int i = 0; i < page; i++) {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			WebElement next = wait.until(ExpectedConditions.visibilityOf(this.next));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", next);
			this.scroll();
		}
	}
	
	//name product
	public List<WebElement> nameProduk() {
		return nameAll;
	}

	public void nameAllStr() {
		for (WebElement name : nameAll) {
			name.getText();
		}
	}

	// product price
	public List<WebElement> priceAll() {
		return priceAll;
	}

	public void priceAllStr() {
		List<WebElement> priceAll = this.priceAll;
		for (WebElement price : priceAll) {
			price.getText();
		}
	}

	public void priceAllInt() {
		List<WebElement> priceAll = this.priceAll;
		for (int x = 0; x < priceAll.size(); x++) {
			priceAll.get(x).getText();
			int price = Integer.valueOf(priceAll.get(x).getText().replace(".", "").replace(" ", ""));
		}
	}

}
