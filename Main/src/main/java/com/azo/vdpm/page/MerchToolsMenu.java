package com.azo.vdpm.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.azo.flexFrmwk.eventHandlers.SupplyLocatorInfo;

public enum MerchToolsMenu implements SupplyLocatorInfo{
	
	VDP(By.name("vdp"), "VDP option in MerchTools Menu");
	
	By element;
	String identified;
	WebElement webElement;
	
	MerchToolsMenu(By element, String identified){
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
