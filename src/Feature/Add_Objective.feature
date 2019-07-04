Feature: Add Objective function

  Background: User is able to open Fgoal Dashboard Page
    When User is on WSM Login screen
    And User inputs valid email on WSM page
    And User inputs valid password on WSM page
    And User perform to login on WSM page
    And User goes to fgoal login page
    And User perform to login fgoal via wsm

  @invalid_case
  Scenario: Error message display when name is empty
    Given User is on Add Objective form
    When Name is emty
    And User enters Weight value
    And User selects quarter value
    And User perform to add new Objective
    Then Browser Alert message displays: Please fill out this field

  @invalid_case
  Scenario: Error message displays when target is empty
    Given user is on Add Objective form
    When User enters valid name
    And Weight is empty
    And User selects quarter value
    And User perform to add new Objective
    Then Browser Alert message displays: Please fill out this field

  @invalid_case
  Scenario Outline: Error message displays when target is invalid
    Given User is on Add Objective form
    When User enters valid name
    And User selects valid quarter
    And User enters weight is "<value>" in step
    And User perform to add new Objective
    Then Error message "<content>" displays

    Examples: 
      | value | content                               |
      |     0 | Value must be less than or equal to 5 |
      |     6 | Value must be more than or equal to 1 |

  @valid_case
  Scenario: User is able to create new objective with all valid data
    Given User is on Add Objective form
    When User enters valid name
    And User enters valid weight
    And User select valid quarter
    And User clicks Add Objecttive button
    Then Successfull message displays: Create successfull
    And Name, weight and quarter of new objective are matched with values user had seleted
