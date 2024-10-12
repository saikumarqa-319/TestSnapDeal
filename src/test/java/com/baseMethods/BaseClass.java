package com.baseMethods;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass 
{
	public static WebDriver driver;
	

	
	
	public void launchURL(String url)
	{
		try {
			
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void Click(By locator)
	{
		
		try {
			WebElement ele =  driver.findElement(locator);
			ele.click();
			
		} catch (NullPointerException e) {
			 e.printStackTrace();
		}
	}
	
	public void waitClick(By locator)
	{
		try {
			WebElement ele =  driver.findElement(locator);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(ele)).click();
			
		} catch (NullPointerException e) {
			 e.printStackTrace();
		}
	}
	
	public void  sendInput(By locator , String input)

	{
		try {
			WebElement element = driver.findElement(locator);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(input);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	  public void getChromeBrowser() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	       
	    }

	    public void  getFireFoxDriver() {
	      driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	       
	    }

	    public void getHeadlessChromeBrowser() {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--headless");
	        options.addArguments("--disable-gpu");
	        options.addArguments("--window-size=1920,1080");
	         driver = new ChromeDriver(options);
	    
	    }

	    public void getEdgeBrowser() {
	      driver = new EdgeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        	    }

	    public void getIEDriver() {
	     driver = new InternetExplorerDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	       
	    }

	    public WebDriver getDriver() {
	        return driver;
	    }
	    public void quitDriver(WebDriver driver) {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	
	public void Driverinit( String browserName)
	{
		switch (browserName) {
		case "Chrome":
			getChromeBrowser();
			break;
			
		case "FireFox":
			getFireFoxDriver();
			
		break;
		case "Edge":
			getEdgeBrowser();
			break;
			
		case "Headeless":
			getHeadlessChromeBrowser();
			break;

		default:
		getIEDriver();
			break;
		}
	}
}
