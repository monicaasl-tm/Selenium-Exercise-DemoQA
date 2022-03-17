package dataDrivenTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DataProviderTest {
	
	public String baseURL = "https://demoqa.com";
	String driverPath = "src/test/resources/chromedriver";
	public ChromeDriver driver;
	ExtentReports report;
	ExtentTest test;
	
		
	
	@BeforeTest
	private void startTesting() {
		report = new ExtentReports("/Users/monicasanchez/logintest.html");
		test = report.startTest("Verify Welcome Text");
		test.log(LogStatus.INFO, "Browser Started");
		//System.out.println("This is a Before Test");
	}
	
	@BeforeMethod
	private void startDriver(){
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseURL);
	    driver.manage().window().maximize();
	    test.log(LogStatus.INFO, "Browser Maximized");
	    //System.out.println("Browser launched and maximized!");
	}
	
	@Test(dataProvider="loginData", dataProviderClass = ExcelRead.class)
	public void loginTest(String usernames, String passwords){
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card mt-4 top-card'][6]")));
		WebElement bookStoreSection = driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][6]"));
		bookStoreSection.click();
		test.log(LogStatus.INFO, "Clicked on Book Store Application");
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Login')]")));
		WebElement login = driver.findElement(By.xpath("//span[contains(text(),'Login')]"));
		login.click();
		test.log(LogStatus.INFO, "Clicked on login");
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='userName']"));
		userName.sendKeys(usernames);
		
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys(passwords);
		
		WebElement loginButton = driver.findElement(By.xpath("//button[@id='login']"));
		loginButton.click();
	

	}
	
	@AfterMethod
	public void terminateBrowser() {
		driver.close();
		report.endTest(test);
		report.flush();
		test.log(LogStatus.INFO, "Browser closed");
	    //System.out.println("Browser closed!");
	}
	

}
