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
    Then Browser Alert "<message>" displays

    Examples: 
      | value | message                    |
      |     3 | Please fill out this field |

  @invalid_case
  Scenario Outline: Error message displays when target is empty
    Given User is on Add Objective form
    When User enters valid "<obj_name>"
    And Weight is empty
    And User selects quarter value
    And User perform to add new Objective
    Then Browser Alert "<message>" displays

    Examples: 
      | obj_name            | message                    |
      | testing_Objective_1 | Please fill out this field |

  @invalid_case
  Scenario Outline: Error message displays when target is invalid
    Given User is on Add Objective form
    When User enters valid "<obj_name>"
    And User selects quarter value
    And User enters weight is "<value>" in step
    And User perform to add new Objective
    Then Error message "<content>" displays

    Examples: 
      | obj_name            | value | content                               |
      | testing_Objective_1 |     0 | Value must be less than or equal to 5 |
      | testing_Objective_2 |     6 | Value must be more than or equal to 1 |

  @valid_case
  Scenario Outline: User is able to create new objective with all valid data
    Given User is on Add Objective form
    When User enters valid "<obj_name>"
    And User enters weight is "<value>" in step
    And User selects quarter value
    And User perform to add new Objective
    Then Successfull message displays: Create successfull
    And Name, weight and quarter of new objective are matched with values user had seleted

    Examples: 
      | obj_name            | value |
      | testing_Objective_1 |     3 |
