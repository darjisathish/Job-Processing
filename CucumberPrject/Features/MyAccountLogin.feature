Feature: MyAccount-Login Feature
Description: This feature will test a Login feature

#Simple login without parameters
	#Scenario: Log-in with valid username and password 
	#Given Open the browser
	#When Enter the URL "http://practice.automationtesting.in/"
	#And Click on My Account Menu
	#And Enter registered username and password
	#And Click on login button
	#Then User must successfully login to the web page
	
#Test case-1	
#Simple login without parameters - Single user Login
	#Scenario: Log-in with valid username and password 
	#Given Open the browser
	#When Enter the URL "http://practice.automationtesting.in/"
	#And Click on My Account Menu
	#And Enter registered username "darjisathish" and password "Aes!@#12"
	#And Click on login button
	#Then User must successfully login to the web page
	
#Test case-2	
#Simple login without parameters - Multiple users Login (By using Data Driven Framework)
	 #Scenario Outline: Log-in with valid username and password 
		 #Given Open the browser
		 #When Enter the URL "http://practice.automationtesting.in/"
		 #And Click on My Account Menu
		 #And Enter registered username "<username>" and password "<password>"
		 #And Click on login button
		 #Then Verify Login
	
		 #Examples:
			 #|	username	| password	|
			 #|	darjisathish	| Aes!@#12	|
		  	 #| darjisathish1	| Aes!@#123	|
		   	 #| darjisathish2	| Aes!@#124	|
		   
#Test case-3 		   
#Simple login with Data table params (Parameters)
 	#Scenario: Log-in with valid username and password
  	#Given Open the browser
  	#When Enter the URL "http://practice.automationtesting.in/"
  	#And Click on My Account Menu
  	#And Enter registered username and password
    #| darjisathish | Aes!@#12 |
    #And Click on login button
  	#Then User must successfully login to the web page
  	
#Test case-4  	
#Simple login with Data table params with header - Map table
 	Scenario: Log-in with valid username and password
  	Given Open the browser
  	When Enter the URL "http://practice.automationtesting.in/"
  	And Click on My Account Menu
  	And Enter registered username and password
  	|	user	|	password	|
    | darjisathish | Aes!@#12 |
    And Click on login button
  	Then User must successfully login to the web page
	
