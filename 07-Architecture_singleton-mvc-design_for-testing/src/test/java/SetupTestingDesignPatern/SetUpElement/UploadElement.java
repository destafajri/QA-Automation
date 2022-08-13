package SetupTestingDesignPatern.SetUpElement;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import SetupTestingDesignPatern.DriverSingleton.DriverSingleton;

public class UploadElement {
	private WebDriver driver;

	public UploadElement() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	//Element

	@FindBy(xpath = "//span[normalize-space()='OK']")
	private WebElement pesan;

	@FindBy(id = "ui-id-11")
	private WebElement tabelData;

	@FindBy(xpath = "//span[normalize-space()='Upload Data']")
	private WebElement tabelUpload;

	@FindBy(xpath = "//input[@id='tl_upload_new--52043_text']")
	private WebElement importData;

	@FindBy(xpath = "//span[normalize-space()='Upload']")
	private WebElement tombolUpload;
	
	@FindBy(xpath = "//*[@id='tl_upload_new--52045_table']/tbody/tr")
	private List<WebElement> jumlahDataTabel;

	@FindBy(xpath = "//button[@id='52055_query']")
	private WebElement tombolSimpan;
	
	@FindBy(xpath = "//div[@id='formtl_upload_newdialog-123']")
	private WebElement pesanValidasiSimpan;
	
	@FindBy(xpath = "//span[normalize-space()='SIMPAN']")
	private WebElement tombolValidasiSimpan;
	
	@FindBy(xpath = "//button[@title='Close']")
	private WebElement tombolClose;
	
	@FindBy(xpath = "//*[@id='nikita-form-dialog']/p")
	private WebElement pesanValidasi;

	
	//method
	public void pesan(){
		pesan.click();;
	}

	public void tabelData() {
		tabelData.click();
	}

	public void tabelUpload() {
		tabelUpload.click();
	}
	
	public void importData(String excel) {
		importData.sendKeys(excel);;
	}
	
	public void tombolUpload() {
		tombolUpload.click();
	}
	
	public void jumlahDataTabel() {
		jumlahDataTabel.size();
	}
	
	public void tombolSimpan() {
		tombolSimpan.click();
	}
	
	public void pesanValidasiSimpan() {
		pesanValidasiSimpan.getText();
	}
	
	public void tombolValidasiSimpan() {
		tombolValidasiSimpan.click();
	}
	
	public void tombolCLose() {
		tombolClose.click();
	}
	
	public void pesanValidasi() {
		pesanValidasi.getText();
	}

}
