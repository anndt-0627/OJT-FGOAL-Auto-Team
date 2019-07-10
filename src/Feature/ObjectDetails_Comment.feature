Feature: ObjectDetails_Comment
  Description: Objective Comment feature file

Background: Login successfully with valid WSM account
    Given User is on Login page of Fgoal
    When User perform action Login via WSM action
    And User input valid email on WSM page
    And User input valid password on WSM page
    And User perform action Login on WSM page
    Then User can login successfully to Fgoal via WSM
    

@Valid_case
Scenario: User can navigate to screen objective detail
    Given User is on Dashboard screen
    When User select quarter is current quarter
    And User click on icon text box in My Objectives
    Then Text box comment of objective is displayed


@Valid_case
Scenario: User can push a valid comment
    Given User is on Objective detail screen
    When User click on icon text box in My Objectives
    And User input a valid comment
    And User perform add comment action
    Then The comment user has just submit is displayed
    And Number of comment at icon text box is updated exactly


@Valid_case
Scenario: User can push a comment with long content
    Given User is on Objective detail screen
    When User click on icon text box in My Objectives
    And User input comment text with long content
    And User perform add comment action
    Then The comment user has just submit is displayed
    And Number of comment at icon text box is updated exactly


@Valid_case
Scenario: User can edit a comment
    Given User is on Objective detail screen
    When User click on icon text box in My Objectives
    And User click on icon pen of a comment
    And User edit content of this comment
    And User perform add comment action
    Then The new content of comment is displayed
    
@Valid_case
Scenario: User can deletet a comment
    Given User is on Objective detail screen
    When User click on icon text box in My Objectives
    And User click on icon recycle bin of a comment
    Then The comment is deleted
    
        
@Invalid_case       
Scenario: User can't submit an empty comment 
    Given User is on Objective detail screen
    When User click on icon text box in My Objectives
    And User leave comment text box  blank
    And User perform add comment action
    Then The blank comment isn't accepted
    And Error message is displayed