
Feature: Search testing
	
	Scenario Outline: Search with valid items
	Given StepUp Driver
	When User is on Home page
	Then User click on search bar and enter "<name>"
	Then validation how many items we get <number> items
	Then Close Browser
	Examples:
	|name 	 | number |
	|Cucumber| 1  	  |
	|Cu 		 | 2			|
	|W   		 | 5			|
	
	
	Scenario Outline: Search with invalid items
	Given StepUp Driver
	When User is on Home page
	Then User click on search bar and enter "<name>"
	Then Click enter and check there are no items
	Then Close Browser
	Examples:
	|name    |
	|abcd    |
	|12345   |
	|!@$%^   |
	