Feature: _HelloWorld

Scenario Outline: _Print in Google
	Given I have opened the browser
	When I open Google
	Then I write "<ParameterSearch>"
	
Examples:
	| ParameterSearch |
	| hola mundo|
	| Cucumber on ruby|
	| BDD Cucumber |