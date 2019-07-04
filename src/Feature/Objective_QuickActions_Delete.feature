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
    When Create a new Objective with "<objName>" and "<objWeight>"
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Delete option in Quick Actions menu
    Then Delete objective popup opens

    Examples: 
      | objName         | objWeight |
      | Test and Delete |         4 |

  Scenario Outline: Verify the components of Delete objective popup
    Given User navigates to Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Delete option in Quick Actions menu
    Then Title of Delete objective popup displays
    And Message confirming the deletion of "<objName>" displays in Delete objective popup
    And Close button displays in Delete objective popup
    And Delete button displays in Delete objective popup

    Examples: 
      | objName         |
      | Test and Delete |

  Scenario Outline: Verify user is not able to delete Objective in case user clicks on Close button
    Given User navigates to Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Delete option in Quick Actions menu
    And User clicks on Close button in Delete objective popup
    Then Delete objective popup closes
    And Objective Name in Objective section is equal to "<objName>"

    Examples: 
      | objName         |
      | Test and Delete |

  Scenario Outline: Verify user is able to delete Objective successfully
    Given User navigates to Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Delete option in Quick Actions menu
    And User clicks on Delete button in Delete objective popup
    Then Objective "<objName>" did not display on Dasdboard screen

    Examples: 
      | objName         |
      | Test and Delete |
