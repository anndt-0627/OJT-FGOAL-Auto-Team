Feature: Objective_Quick Actions
  Description: Testing Change Objective Name in Quick Actions of Objective

  Background: 
    Given User goes to FGoal screen
    When User perform login into WSM
    Then FGoal is loggedin and Dashboard screen of FGoal displays

  Scenario Outline: Verify the Update Objective title popup shows up when selecting Update Objective title option in Quick Actions menu
    Given User is on Dashboard screen
    When Create a new Objective with "<objName>" and "<objWeight>"
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update Objective title option in Quick Actions menu
    Then Update Objective title popup opens

    Examples: 
      | objName               | objWeight |
      | Improve English skill |         3 |

  Scenario Outline: Verify the components of Update Objective title popup
    Given User is on Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update Objective title option in Quick Actions menu
    Then Title of Update Objective title popup displays
    And Name label and asterisk symbol displays in Update Objective title popup
    And Name textbox displays in Update Objective title popup
    And Close button displays in Update Objective title popup
    And Update button displays in Update Objective title popup

    Examples: 
      | objName               |
      | Improve English skill |

  Scenario Outline: Verify the value in Name textbox is correct with the Objective that user clicks on
    Given User is on Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update Objective title option in Quick Actions menu
    Then The value in Name textbox is equal to "<objName>"

    Examples: 
      | objName               |
      | Improve English skill |

  Scenario Outline: Verify Update Objective title popup closes incase user update Objective Name successfully with valid data
    Given User is on Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update Objective title option in Quick Actions menu
    And User updates the data with value is is "<valid_value>" into Name textbox
    And User submits Update Objective title popup
    Then Update Objective title popup closes #Display error page when submiting

    Examples: 
      | objName               | valid_value             |
      | Improve English skill | Improve English skill 1 |

  Scenario Outline: Verify Success message displays incase user updated Objective Name successfully with valid data
    Given User is on Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update Objective title option in Quick Actions menu
    And User updates the data with value is "<valid_value>" into Name textbox
    And User submits Update Objective title popup
    Then Update Objective title popup closes
    And Success message displays

    Examples: 
      | objName                 | valid_value             |
      | Improve English skill 1 | Improve English skill 2 |

  Scenario Outline: Verify Objective Name in My Objectives section is updated also incase user updated Objective Name successfully with valid data
    Given User is on Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update Objective title option in Quick Actions menu
    And User updates the data with value is "<valid_value>" into Name textbox
    And User submits Update Objective title popup
    Then Update Objective title popup closes
    And Objective Name in Objective section is equal to "<valid_value>"

    Examples: 
      | objName                 | valid_value                  |
      | Improve English skill 2 | 123 456 789                  |
      | 123 456 789             | !@$ %^& ***                  |
      | !@$ %^& ***             | 123 qwe !@$                  |
      | 123 qwe !@$             | <b>Improve English skill</b> |

  Scenario Outline: Verify user is not able to update Objective Name that it is existed in system
    Given User is on Dashboard screen
    When Create a new Objective with "<objNameNew>" and "<objWeightNew>"
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update Objective title option in Quick Actions menu
    And User updates the data with value is "<objName>" into Name textbox
    And User submits Update Objective title popup
    Then The "<error_message>" displays

    Examples: 
      | objNameNew                | objWeightNew | objName                      | error_message                 |
      | Improve English skill New |            3 | <b>Improve English skill</b> | Objective name already exists |

  Scenario Outline: Verify user is not able to update Objective Name successfully
    Given User is on Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Update Objective title option in Quick Actions menu
    And User updates the data with value is "<valid_value>" into Name textbox
    And User clicks on Close button in Update Objective title popup
    Then Update Objective title popup closes
    And Objective Name in Objective section is equal to "<objName>"

    Examples: 
      | objName                      | valid_value           |
      | <b>Improve English skill</b> | Improve English skill |
