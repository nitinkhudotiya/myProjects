Feature: Login to the proton email 

Scenario: User login to the gmail 
	Given User lands on the proton login homepage
	And User enters the emailId in the Email textbox 
	And User enters Password in the Enter your password textbox
	And User click on the Sign In button
	Then Wait for the email homepage to load