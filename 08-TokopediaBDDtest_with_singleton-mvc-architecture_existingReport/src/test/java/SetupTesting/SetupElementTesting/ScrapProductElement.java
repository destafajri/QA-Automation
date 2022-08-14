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
	private void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int y = 0; y <= 110; y++) {
			js.executeScript("window.scrollBy(0," + y + ")");
		}
	}

	private List<WebElement> pagePrice(int page) {
		for (int i = 0; i < page; i++) {
			this.priceAllElem();
			WebDriverWait wait = new WebDriverWait(driver, 500);
			WebElement next = wait.until(ExpectedConditions.visibilityOf(this.next));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", next);
			this.scroll();
		}
		return priceAll;
	}
	private List<WebElement> pageName(int page) {
		for (int i = 0; i < page; i++) {
			this.produkNameElem();
			WebDriverWait wait = new WebDriverWait(driver, 500);
			WebElement next = wait.until(ExpectedConditions.visibilityOf(this.next));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", next);
			this.scroll();
		}
		return priceAll;
	}
	
	
	//name product
	public List<WebElement> produkNameElem() {
		this.scroll();
		return nameAll;
	}
	
	public List<WebElement> produkNameElem(int page) {
		this.scroll();
		this.pageName(page);
		return nameAll;
	}

	// product price
	public List<WebElement> priceAllElem() {
		this.scroll();
		return priceAll;
	}
	
	public List<WebElement> priceAllElem(int page) {
		this.scroll();
		this.pagePrice(page);
		return priceAll;
	}

}
