Feature: Add Objective function

  Background: Login successfully with valid WSM user account
    Given User navigate to Login page of Fgoal
    When User navigate to Login page of WSM
    And User enter valid account as user account
    And User enter valid password as password of user
    Then User should be access Fgoal successfully

  @invalid_case
  Scenario Outline: Error message display when name is empty
    Given User is on Add Objective form
    When Name is emty
    And User enters weight is "<value>" in step
    And User selects quarter value
    And User perform to add new Objective
    Then Name error "<message>" displays

    Examples: 
      | value | message                 |
      |     3 | This field is required. |

  @invalid_case
  Scenario Outline: Error message displays when weight is empty
    Given User is on Add Objective form
    When User enters valid objective name
    And Weight is empty
    And User selects quarter value
    And User perform to add new Objective
    Then Weight error "<message>" displays

    Examples: 
      | message                 |
      | This field is required. |

  @invalid_case
  Scenario Outline: Error message displays when weight is invalid
    Given User is on Add Objective form
    When User enters valid objective name
    And User selects quarter value  
    And User enters weight is "<value>" in step
    And User perform to add new Objective
    Then Weight error "<message>" displays

    Examples: 
      | value | message                               |
      |     0 | Value must be less than or equal to 5 |
      |     6 | Value must be more than or equal to 1 |


  @valid_case
  Scenario Outline: User is able to create new objective with all valid data
    Given User is on Add Objective form
    When User enters valid objective name
    And User enters weight is "<value>" in step
    And User selects quarter value
    And User perform to add new Objective
    Then Successfull "<message>" displays
    And Objective name, weight "<value>" and quarter of new objective are matched with values user had seleted

    Examples: 
      | value | message           |
      |     3 | Create successful |
