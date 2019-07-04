Feature: Check Link of Objective

  Background: User is able to open Fgoal Dashboard Page
    Given: User is on Fgoal Login screen

    When User performs to login via WSM
    And User inputs valid email on WSM page
    And User inputs valid password on WSM page
    And User perform to login on WSM page
    Then Fgoal Dashboard Page with corresponding account

  @link_view
  Scenario: Verify that each Link To Objective displays Group, Objective, Key result and Quick Action button
    Given User is on Objective Details
    When User checks any Link To
    Then Group, Objective, Key result and Quick Action button are displayed in each Link To

  @link_view
  Scenario: Verify that corresponding Group screen displays when clicking on group link of any Link To
    Given User is on Objective Details
    When User clicks "<group>" link
    Then Corresponding "<group>" screen dislays

  @link_view
  Scenario: Verify that corresponding Objective Details screen displays when clicking on Objective link of any Link To
    Given User is on Objective Details
    When user clicks "Objective" link
    Then corresponding "Objective" Details screen dislays

  @link_view
  Scenario: Verify that Quick Action popup displays when clicking on Quick Action button of any Link To
    Given User is on Objective Details
    When user clicks Quick Action button
    Then Quick Action popup dislays

  @link_cancel
  Scenario: Verify that Cancel link request dialog displays when clicking on Cancel option in Quick Action popup
    Given User is on Objective Details
    When user clicks Quick Action button
    And User clicks Cancel option
    Then Cancel link request dialog displays

  @link_cancel
  Scenario: Verify that Cancel link request dialog is closed, and Link To is not canceled when clicking on Close button in  Cancel link request dialog
    Given User is on Objective Details
    When user clicks Quick Action button of "Link To"
    And User clicks Cancel option
    And User clicks Close button
    Then Cancel link request dialog is closed
    And "Link To" is existing

  @link_cancel
  Scenario: Verify that Cancel link request dialog is closed, and Link To is not displayed when clicking on Cancel link request button in  Cancel link request dialog
    Given User is on Objective Details
    When user clicks Quick Action button of "Link To"
    And User clicks Cancel option
    And User clicks Cancel link request button
    Then Cancel link request dialog is closed
    And Message displays You have rejected a link request
    And "Link To" is not existing
