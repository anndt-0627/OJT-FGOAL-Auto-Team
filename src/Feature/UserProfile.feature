Feature: User List
  Description: Test list user display and search users on User List

  Background: Login successfully with valid WSM account
    Given User navigate to Login page of Fgoal
    When User navigate to Login page of WSM
    And User enter valid account as admin account
    And User enter valid password as password of admin
    Then User should be access Fgoal successfully

  Scenario: Verify list search result when search with exited input
    Given User opens Profile popup
    When User navigate to My Profile
    And User observers data on My Profile
    Then Display data profile correctly