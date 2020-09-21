@Rc
Feature: Perform Activities-Ocean

@Ocean
Scenario Outline: Perform upload OF-P2PCharge template and all mandatory Activities - Ocean

	Given User is logged into FOCiS Application
	When selects "<ChildSubMenu>" from "<ChildMenu>" from "<Menu>" Menu
	And clicks on "Upload" button from Ocean Freight-Carrier Contract-List page
	And Select "<CountryName>" from Ocean Freight Carrier Contract Upload screen
	And Selects TemplateName
      |	TemplateName		|
      |	<Template_Name>	|
  And Select Trade Lane Name
  		| TradeLane			|
  		|	<Trade_Lane>	|
	And Clicks on "Choosefile" button and Upload Excel File
  And Clicks on "Upload" button from Ocean Freight Carrier Contract Upload
  And Verify text message is File upload completed. Please continue with next file message after template upload
  And Wait for page load and click on "ReloadGrid" icon from Ocean Freight Carrier Contract Upload
	Then Upload template status is display as COMPLETED
	
	
	Examples:
      |	DataRow	|	Menu 							|	ChildMenu					|	ChildSubMenu		|	CountryName		|	TemplateName				|	Trade Lane				|
      |	DR12		|	Rate Cloud & NPC	|	Carrier Buy Rates	| Ocean Freight		|	India					|	OF-FCL P2P Charges	|	AFAF-Intra Africa	|
      
      
      
      