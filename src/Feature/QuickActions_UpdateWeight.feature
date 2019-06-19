Feature: Objective_Quick Actions
  Description: Testing Change Objective Weight in Quick Actions of Objective

  Background: 
    Given User goes to FGoal screen
    When User perform login into WSM
    Then FGoal is loggedin and Dashboard screen of FGoal displays

  Scenario Outline: Verify the Update weight popup shows up when selecting Update weight option in Quick Actions menu
    Given User is on Dashboard screen
    When Create a new Objective with "<objName>" and "<objWeight>"
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update weight option in Quick Actions menu
    Then Update weight popup opens

    Examples: 
      | objName        | objWeight |
      | Improve Weight |         4 |

  Scenario Outline: Verify the components of Update weight popup
    Given User is on Dashboard screen
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
    Given User is on Dashboard screen
    When Create a new Objective with "<objName>" and "<objWeight>"
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update weight option in Quick Actions menu
    Then The value in Weight textbox is equal to "<objWeight>"

    Examples: 
      | objName          | objWeight |
      | Improve Weight 2 |         4 |

  Scenario Outline: Verify Objective weight popup closes incase user updated Objective Weight successfully with valid data
    Given User is on Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update weight option in Quick Actions menu
    And User updates the data with value is "<valid_value>" into Weight textbox
    And User submits Update weight popup
    Then Update weight popup closes

    Examples: 
      | objName        | valid_value |
      | Improve Weight |           3 |

  Scenario Outline: Verify Success message displays incase user updated Objective Weight successfully
    Given User is on Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update weight option in Quick Actions menu
    And User updates the data with value is "<valid_value>" into Weight textbox
    And User submits Update weight popup
    Then Update weight popup closes
    And Success message displays

    Examples: 
      | objName        | valid_value |
      | Improve Weight |           2 |

  Scenario Outline: Verify Objective Weight in Objective section is updated also incase user updated Objective Weight successfully
    Given User is on Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update weight option in Quick Actions menu
    And User updates the data with value is "<valid_value>" into Weight textbox
    And User submits Update weight popup
    Then Update weight popup closes
    And Objective Weight in Objective section is equal to "<valid_value>"

    Examples: 
      | objName        | valid_value |
      | Improve Weight |           5 |
      | Improve Weight |           1 |

  Scenario Outline: Verify user is not able to update Objective Weight with invalid data
    Given User is on Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update weight option in Quick Actions menu
    And User updates the data with value is "<invalid_value>" into Weight textbox
    And User submits Update weight popup
    Then The "<error_message>" displays under Weight textbox

    Examples: 
      | objName        | invalid_value | error_message                                                |
      | Improve Weight |            -5 | Weight must greater than or equal 1 and less than or equal 5 |
      | Improve Weight |             0 | Weight must greater than or equal 1 and less than or equal 5 |
      | Improve Weight |             6 | Weight must greater than or equal 1 and less than or equal 5 |
      | Improve Weight |           1.5 | Weight must be digit                                         |

  Scenario Outline: Verify user is not able to update Objective Weight successfully
    Given User is on Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update weight option in Quick Actions menu
    And User updates the data with value is "<valid_value>" into Weight textbox
    And User clicks on Close button in Update weight popup
    Then Update weight popup closes

    Examples: 
      | objName        | valid_value |
      | Improve Weight |           3 |
