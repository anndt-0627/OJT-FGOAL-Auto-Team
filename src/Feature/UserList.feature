Feature: User List
  Description: Test list user display and search users on User List

  Background: Login successfully with valid WSM account
    Given User navigate to Login page of Fgoal
    When User navigate to Login page of WSM
    And User enter valid account as admin account
    And User enter valid password as password of admin
    Then User should be access Fgoal successfully

  Scenario Outline: Verify list search result when search with exited input
    Given User navigate to User List
    When User search with <input_name>
    Then Display results mapping with <search_condition> of user

    Examples:
      | input_name                         | search_condition |
      | exited ID exactly match            | ID               |
      | existed ID partial match           | ID               |
      | exited Name exactly match          | Name             |
      | existed Name partial match         | Name             |
      | exited Email exactly match         | Email            |
      | existed Email partial match        | Email            |
      | exited Code exactly match          | Code             |
      | existed Code partial match         | Code             |
      | Gender is Male                     | Gender           |
      | Gender is Female                   | Gender           |
      | exited Phone number exactly match  | Phone            |
      | existed Phone number partial match | Phone            |
      | exited Position exactly match      | Position         |
      | existed Position partial match     | Position         |

  Scenario Outline: Verify list search result when search with no exited input
    Given User navigate to User List
    When User search with <input_name>
    Then Has no result on list search

    Examples:
      | input_name                |
      | special characters        |
      | not matching wit any data |

#  Scenario Outline: Verify can order list search result
#    Given User navigate to User List
#    When User orders <input_name> by <sort_by>
#    Then Display list results orders <input_name> by <sort_by> correctly
#
#    Examples:
#      | input_name | sort_by    |
#      | ID         | Ascending  |
#      | ID         | Descending |
#      | Name       | Ascending  |
#      | Name       | Descending |
#      | Email      | Ascending  |
#      | Email      | Descending |
#      | Code       | Ascending  |
#      | Code       | Descending |
#      | Gender     | Ascending  |
#      | Gender     | Descending |
#      | Phone      | Ascending  |
#      | Phone      | Descending |
#      | Position   | Ascending  |
#      | Position   | Descending |