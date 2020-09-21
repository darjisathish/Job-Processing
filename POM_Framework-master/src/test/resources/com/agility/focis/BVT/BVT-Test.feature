@RcAir
Feature: Perform Activities-Air

# * This is for capturing all the active(Valid) link in page and Navigating to each URL
# * And, take screenshot if:
# * i  --- URL contains "ERROR"
# * ii --- Page Source contains "FORBIDDEN" and "SERVER ERROR"
# * iii--- Page title contains "ERROR"
# * iv --- X-path contains "ERROR" or "ERROR_IMG"
# * v  --- Table contains "ERROR"/"EXCEPTION"
# *Note: This will work for all environment LIVE,SIT,AGILE

@Air
Scenario Outline: Perform upload AF-P2PCharge template and all mandatory Activities - Air

Given User is logged into FOCiS Application
	When selects "<ChildSubMenu>" from "<ChildMenu>" from "<Menu>" Menu
	
	
Examples:	
	|	DataRow	|	Menu 							|	ChildMenu					|	ChildSubMenu		|
	|	DR11		|	Rate Cloud & NPC	|	Carrier Buy Rates	|   Air Freight		|