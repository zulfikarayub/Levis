#Author: Zulfikar Ayub
Feature: Sale link validation


@Sample123 
Scenario Outline: 
	To validate the link and name under sale category

	Given user Lauch the application url "<URL>" and verfiy page title 
	And user hover on sale link from menu bar
	Then user validate the submenu name and click link validation 
	
	Examples: 
	
		| URL  | 
		| BaseUrl  | 
		
