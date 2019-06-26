package com.fourthsource.cucumberhelloworld.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.fourthsource.cucumberhelloworld.common.*;

public class PrintHelloWorld {
	
	private WebElement element;
	By txt_search = By.name("q");
	//private final static String str_SearchParameter = "Hello World";
	
	@Given("^I have opened the browser$")
	public void openBrowser() {
		Driver.openBrowser("Chrome");
	}
	
	@When("^I open Google$")
	public void openWebSite() {
		Driver.openWebSite("http://www.google.com.mx");
	}
	
	@Then("^I write \"(.*)\"$")
	public void writeOnSearchField(String str_searchparameter) {
		element = Driver.findElement(txt_search);
		element.sendKeys(str_searchparameter);
		element.submit();	
	}
}
