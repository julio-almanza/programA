package com.azo.vdpm.steps;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

import com.azo.flexFrmwk.driver.SharedDriver;
import com.azo.flexFrmwk.helper.BaseHelper;
import com.azo.flexFrmwk.logger.LogFactory;
import com.azo.flexFrmwk.utilityclasses.ClassUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.azo.flexFrmwk.eventHandlers.InitializeEvents;

public class HelloWorld {
	
	private static final Logger log = LogFactory.getLogger(HelloWorld.class);
	private BaseHelper baseHelper;
	private WebDriver driver;
	private InitializeEvents iniEvent;
	
	public HelloWorld(BaseHelper baseHelper, SharedDriver sharedDriver) {
		this.baseHelper = baseHelper;
		this.driver = sharedDriver;
		this.iniEvent = new InitializeEvents(driver);
	}
	
	/***************************************************
	 * Function Name:                   Hello world
	 * Description:						Launch Firefox browser and open google to set HelloWorld
	 * Script Date:						10th July 2019
	 * Developed by:					Alberto Villa 
	 * 					
	 */
	
	
	

}
