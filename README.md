# SQA-Project
Selenium, TestNG, Maven, Cucumber, and using existing chrome selenium for login solution


How To Execute Selenium Scripts On Already Opened Browser
Step 1- Start Chrome in debug mode

      Navigate to chrome directory using the cd command
      In my case chrome.exe is under C:\Program Files (x86)\Google\Chrome\Application
    ==> cd C:\Program Files (x86)\Google\Chrome\Application

      Syntax
      chrome.exe –remote-debugging-port=any-free-port –user-data-dir=directory (path where you need to store data)

      Example in my case
    ==>  chrome.exe --remote-debugging-port=9222 --user-data-dir=C:\chromeData

Step 2- Execute Selenium test on port 9222

      // set the driver path- You can also use WebDriverManager for drivers
      System.setProperty("webdriver.chrome.driver","your chrome driver");

      // Create object of ChromeOptions Class
      ChromeOptions opt=new ChromeOptions();

      // pass the debuggerAddress and pass the port along with host. Since I am running test on local so using localhost
      opt.setExperimentalOption("debuggerAddress","localhost:9222 ");

      // pass ChromeOptions object to ChromeDriver constructor
      WebDriver driver=new ChromeDriver(opt);

      // now you can use now existing Browser
      driver.get(targetURL); ==>type the URL what you want to browse
      
      
      
      
#HOW TO OPEN EXCEL (.xlsx) using maven

Maven dependency
https://www.java67.com/2014/09/how-to-read-write-xlsx-file-in-java-apache-poi-example.html

                  <!--       
                        <dependency>
                            <groupId>org.apache.poi</groupId>
                            <artifactId>poi</artifactId>
                            <version>5.2.0</version>
                        </dependency>
                        <dependency>
                            <groupId>org.apache.poi</groupId>
                            <artifactId>poi-ooxml</artifactId>
                            <version>5.2.0</version>
                        </dependency>
                   -->

Library

      import org.apache.poi.ss.usermodel.Cell;
      import org.apache.poi.ss.usermodel.Row;
      import org.apache.poi.ss.usermodel.Sheet;
      import org.apache.poi.ss.usermodel.Workbook;
      import org.apache.poi.xssf.usermodel.XSSFRow;
      import org.apache.poi.xssf.usermodel.XSSFSheet;
      import org.apache.poi.xssf.usermodel.XSSFWorkbook;

      import java.io.File;
      import java.io.FileInputStream;
      import java.io.IOException;
      import java.util.Iterator;


