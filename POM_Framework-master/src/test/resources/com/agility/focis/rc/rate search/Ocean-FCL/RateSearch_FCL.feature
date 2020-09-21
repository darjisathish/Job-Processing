@Rc
Feature: Perform Rate Search - Ocean-FCL(NVOCC)

@Ocean-FCL
Scenario Outline: Rate Search with Ocean - FCL
		
	Given User is logged into FOCiS Application
	When selects "<ChildSubMenu>" from "<ChildMenu>" from "<Menu>" Menu
	And Click on Product Type and select ProductTypeValue from Rate Search tab
		#|	ProductType				|
     	#|	<Product_Type_Value>	|
	And Select "<POL>" port as Port of Loading
	And Select "<POD>" port as Port of Discharge
	And Select "<Preferred_Currency>" as Preferred Currency
	And Clicks on "Search_Button" button
	Then Wait for Rate Search List or Please reach out to your local NPC for pricing message
	
	Examples:
	|	DataRow	|	Menu 		|	ChildMenu	|	ChildSubMenu	|	POL		|	POD		|	Preferred_Currency	|			
	|	DR14	|	Quotation	|	Rate Search	|   Ocean			|	INMAA	|	DEHAM	|	US Dollar			|