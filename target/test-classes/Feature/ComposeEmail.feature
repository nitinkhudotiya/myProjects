Feature: Compose an email and send it

Background: User login to the gmail
	Given User lands on the proton login homepage
	And User enters the emailId in the Email textbox 
	And User enters Password in the Enter your password textbox
	And User click on the Sign In button
	Then Wait for the email homepage to load
	
Scenario: Verify composing an email
 Given Verify User has successfully logged In
 When User click on the New Message button 
 And User validate that a new popup should be displayed with the headers as a new message
 And User validate clicking on the send button without entering anything in To field
 And User validate clicking on the send button without entering anything in Subject field
 And User enters the senders email address
 And User validate if multiple commas are allowed to separate multiple email ids of TO, CC, and BCC sections.
 And User click on the cc button
 And User enters the email in cc
 And User enters the Subject
 And User enter the body of the email
 #And User click on the send button
	