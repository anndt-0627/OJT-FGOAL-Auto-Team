Feature: Objective_Quick Actions
  Description: Testing Delete Objective in Quick Actions of Objective

  Background: 
    Given User navigate to Login page of Fgoal
    When User navigate to Login page of WSM
    And User enter valid account as user account
    And User enter valid password as password of user
    And User navigates to Dashboard screen

  Scenario Outline: Verify the Delete objective popup show up when selecting Delete option in Quick Actions menu
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Delete objective popup
    Then Delete objective popup of "<objName>" opens

    Examples: 
      | objName         |
      | Test and Delete |

  Scenario Outline: Verify user is not able to delete Objective in case user clicks on Close button
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Delete objective popup
    And User performs to close Delete objective popup
    Then Delete objective popup closes
    And Objective Name in Objective section is equal to "<objName>"

    Examples: 
      | objName         |
      | Test and Delete |

  Scenario Outline: Verify user is able to delete Objective successfully
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Delete objective popup
    And User confirms to delete Objective
    Then Objective "<objName>" did not display on Dashboard screen

    Examples: 
      | objName         |
      | Test and Delete |
