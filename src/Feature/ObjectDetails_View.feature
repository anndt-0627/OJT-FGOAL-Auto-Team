Feature: ObjectDetails_View
  Description: Objective View feature file

Background: Login successfully with valid WSM account
    Given User is on Login page of Fgoal
    When User perform action Login via WSM action
    And User input valid email on WSM page
    And User input valid password on WSM page
    And User perform action Login on WSM page
    Then User can login successfully to Fgoal via WSM
    
    
@Valid_case
Scenario Outline: User can navigate to screen objective detail to view
    Given User back to Dashboard screen
    When User create a new Objective with "<ObjectiveName>" and "<ObjectWeight>"
    And User click on "<ObjectiveName>" item in My Objectives
    Then User navigates to Objective Details screen successfully
	Then Quarter of objective is <ExpectedQuarter>
	Then Current percent user has done of objective is <ExpectedPercent>
  	Then If percent use has done of objective is <CurrentPercent> then status of objective is <ExpectedStatus>
	Then Target percent user has to done to finish the objective is displayed correctly
	Then Total percent of objective is always displayed 100%
	Then Weight of objective is displayed correctly
	
	Examples:
      |ObjectiveName	|ObjectWeight	|ExpectedQuarter						|CurrentPercent						|ExpectedStatus	|
      |ChauTTB_01		|3				|Quarter 2 (01/04/2019 - 30/06/2019)	|0%									|AtRisk			|
