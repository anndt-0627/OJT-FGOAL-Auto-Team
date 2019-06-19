Feature: Login by WSM
  Description: Test Login by WSM with Admin account

  Scenario Outline: Login successfully with valid WSM user account
    Given User navigate to Login page of Fgoal
    When User navigate to Login page of WSM
    And User enter valid account as <account>
    And User enter valid password as <password>
    Then User should be access Fgoal successfully
    Examples:
      | account       | password          |
      | user account  | password of user  |
      | admin account | password of admin |


