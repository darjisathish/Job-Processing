Feature: Perform Rate Search - Air

Scenario Outline: Rate Search with Air

	Given User is logged into FOCiS Application
	When selects "<ChildSubMenu>" from "<ChildMenu>" from "<Menu>" Menu
	And Select "<AOD_PortCode>" from Airport of Departure-Origin Port list window
	And Select "<AOA_PortCode>" from Airport of Arrival-Destination Port list window
	And Select "<Preferred_Currency>" as Preferred Currency
	And Clicks on "SearchButton" button from Air Search Companion
	Then Wait for Rate Search List or Please reach out to your local NPC for pricing message
	
	Examples:
	|	DataRow	|	Menu 			|	ChildMenu		|	ChildSubMenu	|	AOD_PortCode	|	AOA_PortCode	| Preferred_Currency	|
	|	DR13		|	Quotation	|	Rate Search	| Air						|	MAA						|	HAM						|	INR									|