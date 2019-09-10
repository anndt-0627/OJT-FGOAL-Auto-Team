Feature: Objective_Key_Result_Add_New
  Description: File add new Key Result for Objective

Background: Login successfully with valid WSM account
    Given User is on Login page of Fgoal
    When User perform action Login via WSM action
    And User input valid email on WSM page
    And User input valid password on WSM page
    And User perform action Login on WSM page
    Then User can login successfully to Fgoal via WSM
    
    
@Valid_case
Scenario Outline: User can navigate to screen objective detail
    Given User is on Dashboard screen
    When User create a new Objective with "<Objective_Name>" and "<Objective_Weight>"
    And User click on "<Objective_Name>" item in My Objectives
    Then User navigates to Objective Details screen successfully
	
	Examples:
      |Objective_Name	|Objective_Weight	|
      |ChauTTB_01		|3				|
      
@Valid_case
Scenario Outline: User can open pop-up Add new key result for objective
    Given User is on Objective Details screen
    When User click on button Add a new key result
    Then Pop-up Add new key result for "<Objective_Name>" is displayed
    
    Examples:
      |Objective_Name	|
      |ChauTTB_01		|
      
@Valid_case
Scenario Outline: User can create a new key result for objective
    Given Given User is on Objective Details screen
    When User click on button Add a new key result
    And User input "<Keyresult_Name>"
    And User input "<Keyresult_Weight>"
    And User input "<Keyresult_Target>"
    And User select "<Keyresult_Unit>"
    And User click button Add new
    Then A new key result of object is created
    
    Examples:
    |Keyresult_Name	|Keyresult_Weight	|Keyresult_Target	|Keyresult_Unit	|
    |Keyresult_1	|3					|60					|%				|

@Invalid_case
Scenario Outline: User can't create anew key result for objective if leave key result name blank
    Given Given User is on Objective Details screen
    When User click on button Add a new key result
    And User leave Key result name blank
    And User input "<Keyresult_Weight>"
    And User input "<Keyresult_Target>"
    And User select "<Keyresult_Unit>"
    And User click button Add new
    Then An "<Error_Message>" is displayed at field Key result name
       
    Examples:
    |Keyresult_Weight	|Keyresult_Target	|Keyresult_Unit	|Error_Message			|
 	|3					|60					|%				|This field is required.| 

@Invalid_case
Scenario Outline: User can't create anew key result for objective if leave key result weight blank
    Given Given User is on Objective Details screen
    When User click on button Add a new key result
    And User input "<Keyresult_Name>"
    And User input "<Keyresult_Weight>"
    And User leave key result target blank
    And User select "<Keyresult_Unit>"
    And User click button Add new
    Then An "<Error_Message>" is displayed at field Key result weight
       
    Examples:
    |Keyresult_Name	|Keyresult_Weight	|Keyresult_Unit	|Error_Message			|
    |Keyresult_1	|3					|%				|This field is required.|
        
@Invalid_case
Scenario Outline: User can't create anew key result for objective if leave both key result name and key result weight blank
    Given Given User is on Objective Details screen
    When User click on button Add a new key result
    And User leave Key result name blank
    And User leave Key result weight as default
    And User leave Key result target blank
    And User leave Key result unit as default
    And User click button Add new
    Then An error message is displayed at field Key result name 
    And An error message is displayed at field Key result target
    
    Examples:
    |Error_Message			|
    |This field is required.|