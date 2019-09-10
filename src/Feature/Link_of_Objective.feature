Feature: Check Link of Objective

  Background: Login successfully with valid WSM user account
    Given User navigate to Login page of Fgoal
    When User navigate to Login page of WSM
    And User enter valid account as user account
    And User enter valid password as password of user
    Then User should be access Fgoal successfully

  @link_view
  Scenario: Verify that corresponding Group screen displays when clicking on group link of any Link To
    Given User navigates to Objective details has linkto
    When User clicks group link of linkto
    Then Corresponding group screen dislays

  @link_view
  Scenario: Verify that corresponding Objective Details screen displays when clicking on Object link of any Link To
    Given User navigates to Objective details has linkto
    When User clicks objective link
    Then corresponding objective Details screen dislays

  @link_view
  Scenario: Verify that Quick Action popup displays when clicking on Quick Action button of any Link To
    Given User navigates to Objective details has linkto
    When User performs to open Quick Action popup
    Then Quick Action popup dislays

  @link_cancel
  Scenario: Verify that Cancel link request dialog displays when clicking on Cancel option in Quick Action popup
    Given User navigates to Objective details has linkto
    When User performs to open Quick Action popup
    And User performs to open Cancel link request dialog
    Then Cancel link request dialog displays

  @link_cancel
  Scenario: Verify that Cancel link request dialog is closed, and Link To is not canceled when clicking on Close button in Cancel link request dialog
    Given User navigates to Objective details has linkto
    When User performs to open Quick Action popup
    And User performs to open Cancel link request dialog
    And User performs to close Cancel link request dialog
    Then Cancel link request dialog is closed
    And Linkto is existing

  @link_cancel
  Scenario Outline: Verify that Cancel link request dialog is closed, and Link To is not displayed when clicking on Cancel link request button in  Cancel link request dialog
    Given User navigates to Objective details has linkto
    When User performs to open Quick Action popup
    And User performs to open Cancel link request dialog
    And User performs to confirm cancel link to
    Then Cancel link request dialog is closed
    And Message displays "<message>"
    And linkto has been canceled is not existing

    Examples: 
      | message                          |
      | You have rejected a link request |
