Feature: Objective_Key_Result_View
  Description: File View a Key Result of Objective

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
    And User click on button Add a new key result
    And User input "<Keyresult_Name>"
    And User input "<Keyresult_Weight>"
    And User input "<Keyresult_Target>"
    And User select "<Keyresult_Unit>"
    And User click button Add new
    Then Then A new key result of object is created
	
	Examples:
      |Objective_Name	|Objective_Weight	|Keyresult_Name	|Keyresult_Weight	|Keyresult_Target	|Keyresult_Unit	|
      |ChauTTB_01		|3					|Keyresult_1	|3					|60					|%				|
      

@Valid_case
Scenario Outline: Key result is displayed in screen Objective details
    Given Given User is on Objective Details screen
    When User update "<Keyresult_Progress>"
    And User click on "<Keyresult_Name>"
    Then Pop-up key result details is displayed with exactly "<Keyresult_Name>"
    And "<Keyresult_Target>" is displayed exactly
    And "<Keyresult_Progress>" and "<Keyresult_Unit>" is displayed exactly
    And "<Keyresult_Weight>" is displayed exactly
       
    Examples:
    |Keyresult_Name	|Keyresult_Weight	|Keyresult_Target	|Keyresult_Unit	|Keyresult_Progress	|
    |Keyresult_1	|3					|60					|%				|50					|
    
@Valid_case
    Scenario: Pop-up key result details is closed 
    Given Given User is on Objective Details screen
    When User click on "<Keyresult_Name>"
    And user click on button Close
    Then Pop-up key result details is closed