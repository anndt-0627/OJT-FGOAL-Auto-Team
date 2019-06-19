Feature: Objective_Quick Actions
  Description: Testing Delete Objective in Quick Actions of Objective

  Background: 
    Given User goes to FGoal screen
    When User perform login into WSM
    Then FGoal is loggedin and Dashboard screen of FGoal displays

  Scenario Outline: Verify the Delete objective popup show up when selecting Delete option in Quick Actions menu
    Given User is on Dashboard screen
    When Create a new Objective with "<objName>" and "<objWeight>"
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Delete option in Quick Actions menu
    Then Delete objective popup opens

    Examples: 
      | objName         | objWeight |
      | Test and Delete |         4 |

  Scenario Outline: Verify the components of Delete objective popup
    Given User is on Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Delete option in Quick Actions menu
    Then Title of Delete objective popup displays
    And Confirm delete content displays in Delete objective popup
    And Close button displays in Delete objective popup
    And Delete button displays in Delete objective popup

    Examples: 
      | objName         |
      | Test and Delete |

  Scenario Outline: Verify user is not able to delete Objective successfully
    Given User is on Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Delete option in Quick Actions menu
    And User clicks on Close button in Delete objective popup
    Then Delete objective popup closes
    And Objective Name in Objective section is equal to "<objName>"

    Examples: 
      | objName         |
      | Test and Delete |

  Scenario Outline: Verify user is  able to delete Objective successfully
    Given User is on Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Delete option in Quick Actions menu
    And User clicks on Delete button in Delete objective popup
    Then Delete objective popup closes
    And Group screen displays

    Examples: 
      | objName         |
      | Test and Delete |
