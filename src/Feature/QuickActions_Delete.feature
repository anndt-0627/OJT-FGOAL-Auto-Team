Feature: Quick Actions
  Description: Testing Update weight Objective in Quick Actions      

Scenario: Verify the [Delete objective] popup show up when selecting [Delete] option in Quick Actions menu
    Given User goes to [Group Details] screen
    When User clicks on the 1st [Objective] item in Group's Objectives section
    And User clicks on the [Quick Actions] icon in Objective section
    And User clicks on [Delete] option in Quick Actions menu
    Then [Delete objective] popup displays
    
Scenario: Verify the components of [Delete objective] popup
    Given User goes to [Group Details] screen
    When User clicks on the 1st [Objective] item in Group's Objectives section
    And User clicks on the [Quick Actions] icon in Objective section
    And User clicks on [Delete] option in Quick Actions menu
    Then Title popup displays
    And Confirm delete content displays
    And Close button displays
    And Delete button displays
      
Scenario: Verify Group screen displays incase user deleted Objective successfully 
    Given User goes to [Group Details] screen
    When User clicks on the 1st [Objective] item in Group's Objectives section
    And User clicks on the [Quick Actions] icon in Objective section
    And User clicks on [Delete] option in Quick Actions menu
    And User clicks on [Delete] button
    Then [Delete objective] popup closes
    And Group screen displays
     
Scenario: Verify user is not able to delete Objective successfully
    Given User goes to [Group Details] screen
    When User clicks on the 1st [Objective] item in Group's Objectives section
    And User clicks on the [Quick Actions] icon in Objective section
    And User clicks on [Delete] option in Quick Actions menu
    And User clicks on [Close] button
    Then [Delete objective] popup closes 
