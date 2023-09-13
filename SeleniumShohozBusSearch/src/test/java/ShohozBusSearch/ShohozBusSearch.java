package ShohozBusSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShohozBusSearch {
	
	WebDriver driver;
	String baseUrl = "https://www.shohoz.com/";
	

	
	
//	=========================
//	Browser Open Setup
//	=========================
	
	@BeforeMethod
	public void BrowserSetup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.get(baseUrl);
		Thread.sleep(3000);
	}
	
	
//	=========================
//	Browser Close Setup
//	=========================
	
	@AfterMethod
	public void BrowserClose() throws InterruptedException {
		Thread.sleep(2000);
		this.driver.quit();
		
	}
	
	
	
//	=========================
//	VerifyUrl Test
//	=========================
	@Test(priority = 1)
	public void VerifyUrl() {
		String ActualUrl = this.driver.getCurrentUrl();
		String ExpectedUrl = baseUrl;
		
		if(ActualUrl.equals(ExpectedUrl)) {
			System.out.println("URL Verified Success");
		}
		
		else {
			System.out.println("URL Verified Fail");
		}
		
		
		System.out.println("Actual URL is: "+ActualUrl);
		System.out.println("Expected URL is: "+ExpectedUrl);
		
//		Assert.assertEquals(ActualUrl, ExpectedUrl, "True");
	}
	
	
	
//	=========================
//	Verify Title Test
//	=========================
	@Test(priority = 2)
	public void VerifyTitle() {
		String ActualTitle = this.driver.getTitle();
		String ExpectedTitle = "Bangladesh's Largest Online Ticket Destination | Shohoz";
		
		if(ActualTitle.equals(ExpectedTitle)) {
			System.out.println("Title verified success");
		} else {
			System.out.println("Title verified fail");
		}
		
		
		System.out.println("Actual title is: "+ActualTitle);
		System.out.println("Expected title is: "+ExpectedTitle);
	}
	
	
	
//	=========================
//	Search Bus Test
//	=========================
	@Test(priority = 3)
	public void BusSearch() throws InterruptedException {

		
		
		WebElement BusIconClick = driver.findElement(By.xpath("//a[@title='Bus']"));
		BusIconClick.click();
		Thread.sleep(2000);
		
		
		WebElement FormCityName = driver.findElement(By.xpath("//input[@id='dest_from']"));
		FormCityName.sendKeys("Dhaka");
		Thread.sleep(2000);
		
		
		WebElement ToCityName = driver.findElement(By.id("dest_to"));
		ToCityName.sendKeys("Bogura");
		Thread.sleep(2000);
		
		
		
		WebElement JourneyDateInput = driver.findElement(By.id("doj"));
		JourneyDateInput.click();
		Thread.sleep(2000);
		

		
		WebElement JourneyDate = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]/a"));
		JourneyDate.click();
		Thread.sleep(2000);
		
		
		WebElement ReturnDateInput = driver.findElement(By.id("dor"));
		ReturnDateInput.click();
		Thread.sleep(2000);
		

		
		WebElement ReturnDate = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[6]/a"));
		ReturnDate.click();
		
			
		
		WebElement SearchBusButton = driver.findElement(By.xpath("//button[normalize-space()='Search Buses']"));
		SearchBusButton.click();
		Thread.sleep(10000);
	}

}
