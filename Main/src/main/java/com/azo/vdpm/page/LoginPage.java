package com.azo.vdpm.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.azo.flexFrmwk.eventHandlers.SupplyLocatorInfo;

public enum LoginPage implements SupplyLocatorInfo {
	USERNAME(By.name("user"), "User Name field in login page"),
	PASSWORD(By.name("passwd"), "Password field in login page"),
	LOG_IN(By.name("Login"), "Sign In button in login page");
	
	By element;
	String identified;
	WebElement webElement;
	
	LoginPage(By element, String identified){
		this.element = element;
		this.identified = identified;
	}
	
	public WebElement getWebElement() {
		return this.webElement;
	}
	
	public By getLocatorBy() {
		return this.element;
	}
	
	public String getLabel() {
		return this.identified;
	}

}
