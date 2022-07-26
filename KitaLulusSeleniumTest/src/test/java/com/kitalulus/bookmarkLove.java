package com.kitalulus;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class bookmarkLove {
	WebDriver driver;
	String baseURL = "https://kerja.kitalulus.com/id";
	Scanner input = new Scanner(System.in);
	String inputEmail;
	String inputPass;
	

	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.get(this.baseURL);
		System.out.print("Please fill your email and pass");
		this.inputEmail = input.nextLine();
		this.inputPass = input.nextLine();

	}

	@Test(description = "Test date 26-July-22")
	public void bookmarkTest() {
		// login
		WebElement acount = driver.findElement(By.xpath("//*[@id=\"app-layout\"]/nav/div/a[4]/button"));
		acount.click();

		Boolean state = true;
		while (state) {
			try {
				WebElement login = driver.findElement(By.xpath("//button[@type='button']"));
				login.click();

				state = false;
			} catch (Exception e) {
				System.out.print(e);
			}
		}

		state = true;
		while (state) {
			try {
				WebElement email = driver.findElement(By.xpath("//input[@id='identifierId']"));
				email.sendKeys(this.inputEmail);
				email.sendKeys(Keys.ENTER);

				state = false;
			} catch (Exception e) {
				System.out.print(e);
			}
		}

		state = true;
		while (state) {
			try {
				WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
				pass.sendKeys(this.inputPass);
				pass.sendKeys(Keys.ENTER);

				state = false;
			} catch (Exception e) {
				System.out.print(e);
			}
		}

		this.driver.navigate();

		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Cari posisi dan perusahaan impianmu']"));
		search.sendKeys("QA Automation");
		search.sendKeys(Keys.ENTER);

		// click job
		state = true;
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
				WebElement loveBookmark = driver.findElement(By.xpath("//button[@class='BookmarkButton___StyledButton-sc-10f0at4-1 cpgooR']"));
				loveBookmark.click();

				state = false;
			} catch (Exception e) {
			}
		}
		
		// Assert bookmark
		state = true;
		while (state) {
			try {
				WebElement bookmark = driver.findElement(By.xpath("//img[@alt='bookmark active']"));
				Assert.assertEquals(bookmark, true);

				state = false;
			} catch (Exception e) {
			}
		}

	}

	@AfterSuite
	public void closeDriver() {
//		this.driver.close();

	}

}
