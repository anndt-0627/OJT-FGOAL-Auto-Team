Feature: ObjDetail_KR_DeletePopup
  Description: Testing for Delete popup of Key Result

  Background: 
    Given User navigate to Login page of Fgoal
    When User navigate to Login page of WSM
    And User enter valid account as user account
    And User enter valid password as password of user
    Then User should be access Fgoal successfully

  Scenario Outline: Verify the Delete key result popup show up when selecting Delete option in Quick Actions menu
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>" has Key Result "<krName>"
    And User opens Delete key result popup of Key Result "<krName>"
    Then The components of Delete key result popup of Key Result "<krName>" displays

    Examples: 
      | objName            | krName               |
      | Key Result Testing | The first Key Result |

  Scenario Outline: Verify user is not able to delete Key Result in case user clicks on Close button
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>" has Key Result "<krName>"
    And User opens Delete key result popup of Key Result "<krName>"
    And User performs to close Delete key result popup
    Then Delete key result popup closes
    And Key Result "<krName>" still displays on Objective Detail screen

    Examples: 
      | objName            | krName               |
      | Key Result Testing | The first Key Result |

  Scenario Outline: Verify user is able to delete Key Result successfully
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>" has Key Result "<krName>"
    And User opens Delete key result popup of Key Result "<krName>"
    And User confirms to delete Key Result
    Then Key Result "<krName>" did not display on Objective Detail screen

    Examples: 
      | objName            | krName               |
      | Key Result Testing | The first Key Result |
