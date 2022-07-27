package com.kitalulus;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class bookmarkLove {
	WebDriver driver;
	String baseURL = "https://kerja.kitalulus.com/id";
	
	//Type it on your terminal
	//	C:\Program Files (x86)\Google\Chrome\Application>chrome.exe --remote-debugging-port=9222 --user-data-dir="C:\webdriver\ChromeProfile"
	//		OR	
	//	C:\Program Files (x86)\Google\Chrome\Application>chrome.exe --remote-debugging-port=9222 --user-data-dir=C:\chromeData


	@BeforeSuite
	public void setupDriver() {
		
		// set the driver path- You can also use WebDriverManager for drivers
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

		// Create object of ChromeOptions Class
		ChromeOptions opt=new ChromeOptions();

		// pass the debuggerAddress and pass the port along with host. Since I am running test on local so using localhost
		opt.setExperimentalOption("debuggerAddress","localhost:9222 ");

		// pass ChromeOptions object to ChromeDriver constructor
		WebDriver driver=new ChromeDriver(opt);

		// now you can use now existing Browser
		driver.get(baseURL);
		
//		try {
//			System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");
//			ChromeOptions options = new ChromeOptions();
//			options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
//			WebDriver driver = new ChromeDriver(options);
//			System.out.println(driver.getTitle());
//			driver.get(baseURL);
//
//		}catch(Exception e) {
//			System.out.println("eror"+e);
//		}
		
		
		//Find Job		
		try {	

			WebElement search = driver.findElement(By.xpath("//input[@placeholder='Cari posisi dan perusahaan impianmu']"));
			search.sendKeys("QA Automation");
			search.sendKeys(Keys.ENTER);


		}catch(Exception e) {
			
		}
		
		// click job
		Boolean state = true;
		while (state) {
			try {
				WebElement job = driver
						.findElement(By.xpath("//body[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/a[1]"));
				job.click();
				state = false;
			} catch (Exception e) {
			}
		}

		// click bookmark
		state = true;
		while (state) {
			try {
				WebElement loveBookmark = driver
						.findElement(By.xpath("//button[@class='BookmarkButton___StyledButton-sc-10f0at4-1 cpgooR']"));
				loveBookmark.click();

				state = false;
			} catch (Exception e) {
			}
		}
		
		
	}
	

	@Test(description = "Test date 26-July-22")
	public void bookmarkTest() {
		
		// Assert bookmark
//		Boolean state = true;
//		while(state) {
		try {
				WebElement bookmark = driver.findElement(By.xpath("//button[@class='BookmarkButton___StyledButton-sc-10f0at4-1 cpgooR']/img[@alt='bookmark active']"));
				Assert.assertEquals(bookmark, true);

//				state = false;
			} catch (Exception e) {
				System.out.println(e);
			}
//		}
		

	}
	
	@AfterSuite
	public void closeDriver() {
		this.driver.close();

	}


}