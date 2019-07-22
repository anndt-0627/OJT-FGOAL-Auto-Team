Feature: Objective_Quick Actions
  Description: Testing Change Objective Weight in Quick Actions of Objective

  Background: 
    Given User navigate to Login page of Fgoal
    When User navigate to Login page of WSM
    And User enter valid account as user account
    And User enter valid password as password of user
    And User navigates to Dashboard screen

  Scenario Outline: Verify the Update weight popup shows up when selecting Update weight option in Quick Actions menu
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Update weight popup
    Then Update weight popup opens

    Examples: 
      | objName        |
      | Improve Weight |

  Scenario Outline: Verify Update Objective Weight successfully
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Update weight popup
    And User updates the data with value is "<valid_value>" into Weight textbox
    And User submits Update weight popup
    Then Update weight popup closes
    And Success objective update message displays
    And Objective Weight in Objective section is equal to "<valid_value>"

    Examples: 
      | objName        | valid_value |
      | Improve Weight |           5 |
      | Improve Weight |           1 |

  Scenario Outline: Verify user is not able to update Objective Weight with invalid data
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Update weight popup
    And User updates the data with value is "<invalid_value>" into Weight textbox
    And User submits Update weight popup
    Then The <error_message> error message displays under Weight textbox

    Examples: 
      | objName        | invalid_value | error_message            |
      | Improve Weight |            -5 | invalid min or max value |
      | Improve Weight |             0 | invalid min or max value |
      | Improve Weight |             6 | invalid min or max value |
      | Improve Weight |           1.5 | invalid integer value    |

  Scenario Outline: Verify user is not able to update Objective Weight in case user clicks on Close button
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Update weight popup
    And User updates the data with value is "<valid_value>" into Weight textbox
    And User performs to close Update weight popup
    Then Update weight popup closes

    Examples: 
      | objName        | valid_value |
      | Improve Weight |           3 |
