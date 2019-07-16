package com.azo.flexFrmwk.eventHandlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface SupplyLocatorInfo {
	WebElement getWebElement();
	
	By getLocatorBy();
	
	String getLabel();

}
