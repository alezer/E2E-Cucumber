Feature: Regions and Wines list

@UI
Scenario: As a user I want to be able to see the Regions list
	Given I navigate to the Open Wine Database application
	Then I can see the following Regions
		|Bordeaux	|
		|Bourgogne	|
		|Champagne	|
		|Languedoc	|
		|Loire		|
		|Normandie	|

@UI
Scenario: As a user I want to be able to add a comment in a selected Wine 
	Given I navigate to the Open Wine Database application
	And I select "Champagne" from the Regions list
	And I select "Laurent-Perrier Brut" from the Wines list
	When I add a comment to the selected wine
	Then the comment is shown in the Wine Details section
	
	
@API
Scenario: I want to get a list of all Regions
	Given I have a list of Regions created in my database
	When I call the GET “Regions - All” endpoint
	Then I get a 200 response
	And I get the correct list of Regions
	
@API
Scenario: I want to add a Likes to a Wine
	Given I have a Wine created in my database
	When I call the POST “Wines - Like” endpoint with a valid Id and valid Payload
	Then I get a 200 response
	And the selected option is saved
	