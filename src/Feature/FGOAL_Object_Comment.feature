Feature: FGOAL_Object_Comment
  Description: Objective Edit feature file
  
#Scenario: Login FGoal
#    Given User goes to FGoal screen
#    When User clicks on [Login via WSM] button
#    And User perform Login
#    Then [Home] screen of FGoal display

Scenario: User can navigate to screen objective detail
    Given User is on Dashboard screen
    When User select quarter is current quarter
    And User click on icon text box in My Objectives
    Then Text box comment of objective is displayed
    
@Valid_case
Scenario: User can push a comment with min length
    Given User is on Objective detail screen
    When User click on icon text box in My Objectives
    And User input comment text with min length
    And User press Enter
    Then The comment user has just submit is displayed
    And Number of comment at icon text box is updated exactly
    
Scenario: User can push a comment with max length
    Given User is on Objective detail screen
    When User click on icon text box in My Objectives
    And User input comment text with max length
    And User press Enter
    Then The comment user has just submit is displayed
    And Number of comment at icon text box is updated exactly
    
@Invalid_case       
Scenario: User can't submit an empty comment 
    Given User is on Objective detail screen
    When User click on icon text box in My Objectives
    And User leave comment text box  blank
    And User press Enter
    Then The blank comment isn't accepted
    And Error message is displayed
    