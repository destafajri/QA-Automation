package com.kitalulus;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class bookmarkLove {
	WebDriver driver;
	String baseURL = "https://kerja.kitalulus.com/id";
	//Type it on your terminal
	//C:\Program Files (x86)\Google\Chrome\Application>chrome.exe --remote-debugging-port=9222 --user-data-dir="C:\webdriver\ChromeProfile"


	@BeforeSuite
	public void setupDriver() {
		try {
			System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
			WebDriver driver = new ChromeDriver(options);
			System.out.println(driver.getTitle());
			driver.get(baseURL);
			
			
			//Find Job

			WebElement search = driver.findElement(By.xpath("//input[@placeholder='Cari posisi dan perusahaan impianmu']"));
			search.sendKeys("QA Automation");
			search.sendKeys(Keys.ENTER);

		}catch(Exception e) {
			System.out.println("eror"+e);
		}
		
	}
	

	@Test(description = "Test date 26-July-22")
	public void bookmarkTest() {

//		//Find Job
//
//		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Cari posisi dan perusahaan impianmu']"));
//		search.sendKeys("QA Automation");
//		search.sendKeys(Keys.ENTER);

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

		// Assert bookmark
		state = true;
		while (state) {
			try {
				WebElement bookmark = driver.findElement(By.xpath("//button[@class='BookmarkButton___StyledButton-sc-10f0at4-1 cpgooR']/img[@alt='bookmark active']"));
				Assert.assertEquals(bookmark, true);

				state = false;
			} catch (Exception e) {
			}
		}

	}


}
