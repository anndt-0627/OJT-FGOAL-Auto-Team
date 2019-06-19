Feature: User List
  Description: Test list user display and search users on User List

  Background: Login successfully with valid WSM account
    Given User navigate to Login page of Fgoal
    When User navigate to Login page of WSM
    And User enter valid account as admin account
    And User enter valid password as password of admin
    Then User should be access Fgoal successfully

  Scenario Outline: Verify list search result when search with exited input
    Given User navigates to User List
    When User search with <input_name>
    Then Display results mapping with <search_condition> of user

    Examples:
      | input_name                     | search_condition |
      | exited Name exactly match      | Name of user     |
      | existed Name partial match     | Name of user     |
      | exited Email exactly match     | Email of user    |
      | existed Email partial match    | Email of user    |
      | exited Code exactly match      | Code of user     |
      | existed Code partial match     | Code of user     |
      | Gender is Male                 | Gender of user   |
      | Gender is Female               | Gender of user   |
      | exited Position exactly match  | Position of user |
      | existed Position partial match | Position of user |

  Scenario Outline: Verify list search result when search with no exited input
    Given User navigate to User List
    When User search with <input_name>
    Then Has no result on list search

    Examples:
      | input_name                |
      | special characters        |
      | not matching wit any data |
