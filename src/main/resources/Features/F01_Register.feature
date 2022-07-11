@smoke
Feature: user try to Register Successfully

Scenario: user Registered. (Happy Scenario)

Given user navigate to register page
When user fill personal data detailes
And fill company details
And fill password fields
And click register button
Then user Registerd Successfully

