Feature: Forgot password action

Scenario: User is not able to Request forgot password with blank Email
	Given User has been on Forgot password screen
	When User clicks on OK button with Email field is empty
	Then Error message displays: Email is required
