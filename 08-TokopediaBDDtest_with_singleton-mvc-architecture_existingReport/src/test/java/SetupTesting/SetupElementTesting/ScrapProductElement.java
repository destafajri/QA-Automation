package SetupTesting.SetupElementTesting;

import java.util.List;

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
	private List<WebElement> priceAll;
	
	@FindBy(xpath = "//button[@aria-label='Laman berikutnya']")
	private WebElement next;

	
	// method
	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int y = 0; y <= 80; y++) {
			js.executeScript("window.scrollBy(0," + y + ")");
		}
	}
	
	public void page(int page) {
		for (int i = 0; i < page; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", next);
			this.scroll();
		}
	}
	
	public String priceAllStr() {
		List<WebElement> priceAll = this.priceAll;
		for(WebElement price: priceAll) {
			return price.getText();
		}
		return null;
	}
	
	public int priceAllInt() {
		List<WebElement> priceAll = this.priceAll;
		for (int x = 0; x < priceAll.size(); x++) {
			priceAll.get(x).getText();
			int price = Integer.valueOf(priceAll.get(x).getText().replace(".", "").replace(" ", ""));
			return price;
		}
		return (Integer) null;
	}

}
