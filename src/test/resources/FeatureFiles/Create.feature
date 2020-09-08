@CreateLead
Feature: FTR_01 - To be Tested in Chrome 
		I want to test the Create Lead functionality 
			in LeafTap Application 
				in Chrome Browser

Scenario: TC01_CreateLead
		Verify whether user is able to create Lead
			with valid data

Given User launches following url "http:/leaftaps.com/opentaps/control/main"
And Enter "demosalesmanager" as UserName
And Enter "crmsfa" as Password 
And Click on login button
And click on crm-sfa link
And click on createLead link