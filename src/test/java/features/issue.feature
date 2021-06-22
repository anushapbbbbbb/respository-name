Feature: Mainspring issue module validation 

Scenario: User Login 
	Given Open the browser 
	Then  Enter the URL and login 
	
Scenario: Open the project and module 
	When Page is loaded click on burger icon 
	Then Click on project name 
	Then Click on monitor tab 
	And  Click on issue module
	
Scenario: Leave the mandatory fields empty
    Then Enter data in description field
    Then Click on save button
    And Fetch error message from alert box 
     
Scenario: Entering data from excel file 
	Then Fetch data from excel sheet and insert it 
	
Scenario: Tab Automation 
	Then Automate Workflow tab 
	Then Navigate to Linked Cards tab 
	Then Navigate to Comments tab 
	Then Navigate to Previous Version tab 
	Then Navigate to Activity Log tab 
	Then Navigate to Attachment tab 
	And  Close the browser 
	
      