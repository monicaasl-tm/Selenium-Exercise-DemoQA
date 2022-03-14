package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SeleniumDemo {
	
	public String baseURL = "https://demoqa.com";
	String driverPath = "src/test/resources/chromedriver";
	public ChromeDriver driver;
	
	@BeforeTest
	private void startTesting() {
		System.out.println("This is a Before Test");
	}
	
	@BeforeMethod
	private void startDriver(){
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseURL);
	    driver.manage().window().maximize();
	    System.out.println("Browser launched and maximized!");
	}
	
	@Test 
	public void sampleTestMethod() throws InterruptedException {
		
		Actions action = new Actions(driver);
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
		
        WebElement elementsSection = driver.findElement(By.xpath("//h5[text()='Elements']/../../../div"));
		action.moveToElement(elementsSection).click().perform();
		
		WebElement buttonSection = driver.findElement(By.xpath("//span[text()='Buttons']/.."));
		action.moveToElement(buttonSection).perform();
		executor.executeScript("arguments[0].click();", buttonSection);
		Thread.sleep(5000);
		
		WebElement singleClickButton = driver.findElement(By.xpath("//div[@class='mt-4'][2]//button"));
		singleClickButton.click();
		
		WebElement dynamicMessage = driver.findElement(By.cssSelector("#dynamicClickMessage"));
		Assert.assertEquals(dynamicMessage.getText(), "You have done a dynamic click");
	}
	
	
	//Homework
	@Test 
	public void sampleTestMethod2() throws InterruptedException {
		
		Actions action = new Actions(driver);
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
		
        WebElement elementsSection = driver.findElement(By.xpath("//h5[text()='Elements']/../../../div"));
		action.moveToElement(elementsSection).click().perform();
		
		WebElement checkBoxSection = driver.findElement(By.xpath("//span[contains(text(),'Check Box')]"));
		action.moveToElement(checkBoxSection).perform();
		executor.executeScript("arguments[0].click();", checkBoxSection);
		
		WebElement checkBoxHome = driver.findElement(By.xpath("//button[@aria-label='Toggle']"));
		checkBoxHome.click();
		
		WebElement documentsCheck = driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-6:nth-child(2) div.check-box-tree-wrapper:nth-child(2) div.react-checkbox-tree.rct-icons-fa4 li.rct-node.rct-node-parent.rct-node-expanded ol:nth-child(2) li.rct-node.rct-node-parent.rct-node-collapsed:nth-child(2) span.rct-text > button.rct-collapse.rct-collapse-btn:nth-child(1)"));
		documentsCheck.click();
		
		WebElement officeCheck = driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-6:nth-child(2) div.check-box-tree-wrapper:nth-child(2) div.react-checkbox-tree.rct-icons-fa4 li.rct-node.rct-node-parent.rct-node-expanded li.rct-node.rct-node-parent.rct-node-expanded:nth-child(2) ol:nth-child(2) li.rct-node.rct-node-parent.rct-node-collapsed:nth-child(2) span.rct-text > button.rct-collapse.rct-collapse-btn:nth-child(1)"));
		officeCheck.click();
		
		WebElement selectPublic = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/ol[1]/li[2]/ol[1]/li[2]/ol[1]/li[1]/span[1]/label[1]/span[1]/*[1]"));
		selectPublic.click();
		
		Thread.sleep(5000);
		
		WebElement messageResult = driver.findElement(By.xpath("//div[@id='result']"));
		Assert.assertEquals(messageResult.getText(), "You have selected :\n"
				+ "public");
	}
	
	//Homework
	@Test 
	public void sampleTestMethod3() throws InterruptedException {
		
		Actions action = new Actions(driver);
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
		
        WebElement elementsSection = driver.findElement(By.xpath("//h5[text()='Elements']/../../../div"));
		action.moveToElement(elementsSection).click().perform();
		
		WebElement linksSection = driver.findElement(By.cssSelector("#item-5"));
		action.moveToElement(linksSection).perform();
		executor.executeScript("arguments[0].click();", linksSection);
		Thread.sleep(5000);
		
		WebElement noContentLink = driver.findElement(By.xpath("//a[@id='no-content']"));
		noContentLink.click();
		Thread.sleep(5000);
		
		WebElement linkResponse = driver.findElement(By.cssSelector("#linkResponse"));
		Assert.assertEquals(linkResponse.getText(), "Link has responded with staus 204 and status text No Content");
	}
	
	
	@AfterTest
	public void terminateBrowser() {
		driver.close();
	    System.out.println("Browser closed!");
	}
	
	
}
