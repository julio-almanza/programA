package com.org.common;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class Driver {
	private static WebDriver driver;
	
	
	public static void openBrowser(String str_browsername) {	
		try {
			switch(str_browsername) {	
			case "Chrome":
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "Firefox":
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;				
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public static void openWebSite(String str_url) {
		driver.get(str_url);	
	}	
	
	public static WebElement findElement(By byDef) {
		return (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(byDef));
	}
	
	public static List<WebElement> findElements(By byDef) {
		return (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(byDef));
	}
	
	public static String getNameTitle() {
		return driver.getTitle();
	}
	
	public static void getBack() {
		driver.navigate().back();
	}
	
	public static void close() {
		driver.close();
	}

}
