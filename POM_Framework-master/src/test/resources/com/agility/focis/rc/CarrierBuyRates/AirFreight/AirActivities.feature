@Rc
Feature: Perform Activities-Air

Scenario Outline: Perform upload AF-P2PCharge template and all mandatory Activities - Air

	Given User is logged into FOCiS Application
	When selects "<ChildSubMenu>" from "<ChildMenu>" from "<Menu>" Menu
	And clicks on "Upload" button from Air Freight-Carrier Contract-List page
	And clicks on "<CountryName>" from Air Freight Carrier Contract Upload screen
	And Selects Template Name
      |	TemplateName		|
      |	<Template_Name>	|
	And Click on "Choosefile" button and Upload Excel File
  And Click on "Upload" button
  And Verify text message File upload completed. Please continue with next file message after template upload
  And Wait for page load and click on "ReloadGrid" icon from Upload Files Status List page
	Then Upload status is display as COMPLETED

Examples:
      |	DataRow	|	Menu 							|	ChildMenu					|	ChildSubMenu		|	CountryName		|	TemplateName		|
      |	DR11		|	Rate Cloud & NPC	|	Carrier Buy Rates	| Air Freight			|	India					|	AF-P2P Charges	|