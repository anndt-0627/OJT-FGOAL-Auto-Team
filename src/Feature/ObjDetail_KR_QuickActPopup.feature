Feature: Objective Detail - Quick Action of Key Result
  Description: Testing for Quick Action popup of Key Result

  Background: 
    Given User navigate to Login page of Fgoal
    When User navigate to Login page of WSM
    And User enter valid account as user account
    And User enter valid password as password of user
    Then User should be access Fgoal successfully

  Scenario Outline: Verify the Quick Actions popup of Key Result shows up when clicking on the Quick Action icon
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>" has Key Result "<krName>"
    And User opens Quick Actions popup of Key Result "<krName>"
    Then Quick Actions popup of Key Result opens

    Examples: 
      | objName            | krName               |
      | Key Result Testing | The first Key Result |

  Scenario Outline: Verify the corresponding popup of Key Result shows up when clicking on the item in Quick Action icon
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>" has Key Result "<krName>"
    And User opens Quick Actions popup of Key Result "<krName>"
    And User opens <itmQAct> popup of Key Result
    Then <itmQAct> popup of Key Result "<krName>" opens

    Examples: 
      | objName            | krName               | itmQAct                 |
      | Key Result Testing | The first Key Result | View Detail             |
      | Key Result Testing | The first Key Result | Update Key result title |
      | Key Result Testing | The first Key Result | Update weight           |
      | Key Result Testing | The first Key Result | Update target           |
      | Key Result Testing | The first Key Result | Delete                  |
