Feature: Objective_Quick Actions
  Description: Testing Change Objective Name in Quick Actions of Objective

  Background: 
    Given User navigate to Login page of Fgoal
    When User navigate to Login page of WSM
    And User enter valid account as user account
    And User enter valid password as password of user
    And User navigates to Dashboard screen

  Scenario Outline: Verify the Update Objective title popup shows up when selecting Update Objective title option in Quick Actions menu
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Update Objective title popup
    Then Update Objective title popup opens

    Examples: 
      | objName               |
      | Improve English skill |

  Scenario Outline: Verify the value in Name textbox is correct with the Objective that user clicks on
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Update Objective title popup
    Then The value in Name textbox is equal to "<objName>"

    Examples: 
      | objName               |
      | Improve English skill |

  Scenario Outline: Verify Update Objective Name successfully with valid data
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Update Objective title popup
    And User updates the data with value is "<valid_value>" into Name textbox
    And User submits Update Objective title popup
    Then Update Objective title popup closes
    And Success objective update message displays
    And Objective Name in Objective section is equal to "<valid_value>"

    Examples: 
      | objName               | valid_value     |
      | Improve English skill | 123 456 789     |
      | 123 456 789           | !@$ %^& ***     |
      | !@$ %^& ***           | 123 qwe !@$     |
      | 123 qwe !@$           | <b>HTML tag</b> |

  Scenario Outline: Verify user is not able to update Objective Name that it is empty
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Update Objective title popup
    And User removes data in Name textbox
    And User submits Update Objective title popup
    Then The error message required name displays

    Examples: 
      | objName               |
      | Improve English skill |

  Scenario Outline: Verify user is not able to update Objective Name that it is existed in system
    Given User navigates to Dashboard screen
    When Checking the existence or creating Objective "<existedObjName>"
    And User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Update Objective title popup
    And User updates the data with value is "<existedObjName>" into Name textbox
    And User submits Update Objective title popup
    Then The error message existed data displays

    Examples: 
      | existedObjName | objName               |
      | Lala Objective | Improve English skill |

  Scenario Outline: Verify user is not able to update Objective Name in case user clicks on Close button
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Update Objective title popup
    And User updates the data with value is "<valid_value>" into Name textbox
    And User performs to close Update Objective title popup
    Then Update Objective title popup closes
    And Objective Name in Objective section is equal to "<objName>"

    Examples: 
      | objName               | valid_value  |
      | Improve English skill | Updated Name |
