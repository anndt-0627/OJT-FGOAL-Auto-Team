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
    When Create a new Objective with "<objName>" and "<objWeight>"
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update weight option in Quick Actions menu
    Then Update weight popup opens

    Examples: 
      | objName        | objWeight |
      | Improve Weight |         4 |

  Scenario Outline: Verify the components of Update weight popup
    Given User navigates to Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update weight option in Quick Actions menu
    Then Title of Update weight popup displays
    And Weight label and asterisk symbol displays in Update weight popup
    And Weight textbox displays in Update weight popup
    And Close button displays in Update weight popup
    And Update button displays in Update weight popup

    Examples: 
      | objName        |
      | Improve Weight |

  Scenario Outline: Verify the value in Weight textbox is correct with the Objective that user clicks on
    Given User navigates to Dashboard screen
    When Create a new Objective with "<objName>" and "<objWeight>"
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update weight option in Quick Actions menu
    Then The value in Weight textbox is equal to "<objWeight>"

    Examples: 
      | objName          | objWeight |
      | Improve Weight 2 |         4 |

  Scenario Outline: Verify Objective weight popup closes and Success message displays and Objective Weight in Objective section is updated also incase user updated Objective Weight successfully
    Given User navigates to Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update weight option in Quick Actions menu
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
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update weight option in Quick Actions menu
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
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update weight option in Quick Actions menu
    And User updates the data with value is "<valid_value>" into Weight textbox
    And User clicks on Close button in Update weight popup
    Then Update weight popup closes

    Examples: 
      | objName        | valid_value |
      | Improve Weight |           3 |
