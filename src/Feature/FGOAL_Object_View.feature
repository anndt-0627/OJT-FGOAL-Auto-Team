Feature: FGOAL_Object_View
  Description: Objective View feature file
  
Background: 
    Given User goes to FGoal screen
    When User perform login into WSM
    Then FGoal is loggedin and Dashboard screen of FGoal displays

@Valid_case
Scenario Outline: User can navigate to screen objective detail to view
    Given User back to Dashboard screen
    When User select quarter is current quarter
    And User click on an "<ObjectiveName>" in My Objectives
    Then User navigates to Objective Details screen successfully
    
	Examples:
      |ObjectiveName		| 
      |ChauTTB_01			|
      
@Valid_case      
Scenario Outline: Quarter of objective is displayed corectly
    Given User is on Objective Details screen
    When User take a look on quarter of objective
    Then Quarter of objective is <CurrentQuarter>
    
	Examples:
      |CurrentQuarter							| 
      |Quarter 2 (01/04/2019 - 30/06/2019)		|
    
@Valid_case    
Scenario Outline: Name of objective is displayed corectly
    Given User is on Objective Details screen
    When User take a look on name of objective
    Then Quarter of objective is <objectiveName>
    
	Examples:
      |objectiveName	| 
      |ChauTTB			|

@Valid_case
Scenario: Percent user has done until curent time of objective is displayed corectly
    Given User is on Objective Details screen
    When User take a look on current percent user has done of objective
    Then Current percent user has done of objective is correctly
    
@Valid_case
Scenario Outline: Status of objective until curent time is displayed corectly base on percent user has done
    Given User is on Objective Details screen
    When User take a look on status of objective
    Then If percent use has done of objective is <CurrentPercent> then status of objective is <CurrentStatus> 
    
	Examples:
      |CurrentPercent					|CurrentStatus	| 
      |0% <= current percent <=29%		|AtRisk			|
      |30% <= current percent <=69%		| BeHind		|
      |70% <= current percent <=99%		| OnTrack		|
      |100% <= current percent			| Excellent		|
     
@Valid_case     
Scenario: Target percent user has to done to finish the objective is correctly
    Given User is on Objective Details screen
    When User take a look on  objective target percent done of objective
    Then Target percent user has to done to finish the objective is displayed correctly
    
@Valid_case  
Scenario: Total percent of objective is correctly
    Given User is on Objective Details screen
    When User take a look on total percent of objective
    Then Total percent of objective is always displayed 100%

@Valid_case    
Scenario: Weight of objective is correctly
    Given User is on Objective Details screen
    When User take a look on weight of objective
    Then Weight of objective is displayed correctly