package com.azo.vdpm.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;

import com.azo.flexFrmwk.configuration.Configuration;
import com.azo.flexFrmwk.driver.SharedDriver;
import com.azo.flexFrmwk.eventHandlers.InitializeEvents;
import com.azo.flexFrmwk.helper.BaseHelper;
import com.azo.flexFrmwk.logger.LogFactory;
import com.azo.flexFrmwk.utilityclasses.ClassUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import com.azo.vdpm.page.LoginPage;;

public class Login{
	private static final Logger log = LogFactory.getLogger(HelloWorld.class);
	private BaseHelper baseHelper;
	private WebDriver driver;
	private InitializeEvents iniEvent;	
	private String AppURL;
	
	public Login(BaseHelper baseHelper, SharedDriver sharedDriver) {
		this.baseHelper = baseHelper;
		this.driver = sharedDriver;
		this.iniEvent = new InitializeEvents(driver);
		AppURL = Configuration.getInstance().getAppURL();

	}
	

	
	/***************************************************
	 * Function Name:                   Log in
	 * Description:						Launch MerchTools application and set username and click login button
	 * Script Date:						10th July 2019
	 * Developed by:					Alberto Villa 
	 * 					
	 */

	private LoginPage edtfld_username = LoginPage.USERNAME;
	private LoginPage edtfld_password = LoginPage.PASSWORD;
	private LoginPage bttn_login = LoginPage.LOG_IN;
	
	@Given("^MerchTools should be launched$")
	public void launch_MerchTools()throws Exception{
		this.baseHelper.reportStep(ClassUtils.getCurrentMethodName(Thread.currentThread()), driver);
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.get(AppURL);
		
		log.info("Page Source : " + this.driver.getCurrentUrl());
	}
	
	@Then("^Login$")
	public void login() {
		this.driver.findElement(edtfld_username.getLocatorBy()).sendKeys("10388940");
		this.driver.findElement(bttn_login.getLocatorBy()).sendKeys("10388940");
		
	}

}
