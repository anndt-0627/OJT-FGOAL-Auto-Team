Feature: ObjDetail_KR_LinkObjectivePopup
  Description: Testing for Link Objective popup of Key Result

  Background: 
    Given User navigate to Login page of Fgoal
    When User navigate to Login page of WSM
    And User enter valid account as user account
    And User enter valid password as password of user
    And User should be access Fgoal successfully

  Scenario Outline: Verify the Link Objective popup of Key Result shows up
    Given User navigates to Objective "<objName>" has Key Result "<krName>" of another Group
    When User opens Link Objective popup of Key Result "<krName>"
    Then The components of Link Objective popup of Key Result "<krName>" displays

    Examples: 
      | objName                             | krName          |
      | Objective for LinkObjective Testing | Lala Key Result |

  Scenario Outline: Verify the Link Objective popup of Key Result closes in case user clicks on Close icon
    Given User navigates to Objective "<objName>" has Key Result "<krName>" of another Group
    When User opens Link Objective popup of Key Result "<krName>"
    And performs to close Link Objective popup
    Then Link Objective popup of Key Result "<krName>" closes

    Examples: 
      | objName                             | krName          |
      | Objective for LinkObjective Testing | Lala Key Result |

  Scenario Outline: Verify navigating to Select Objective step in case user chooses Group has NO Objective
    Given User navigates to Objective "<objName>" has Key Result "<krName>" of another Group
    When User opens Link Objective popup of Key Result "<krName>"
    And User chooses invalid Group and goes to the next step
    Then The message There are no Objective displays in Select Objective step

    Examples: 
      | objName                             | krName          |
      | Objective for LinkObjective Testing | Lala Key Result |

  Scenario Outline: Verify navigating to Select Objective step in case user chooses Group has Objective
    Given User navigates to Objective "<objName>" has Key Result "<krName>" of another Group
    When User opens Link Objective popup of Key Result "<krName>"
    And User chooses valid Group and goes to the next step
    Then The components of Select Objective step displays

    Examples: 
      | objName                             | krName          |
      | Objective for LinkObjective Testing | Lala Key Result |

  Scenario Outline: Verify user is able to back Select Group step in case user clicks on Back button
    Given User navigates to Objective "<objName>" has Key Result "<krName>" of another Group
    When User opens Link Objective popup of Key Result "<krName>"
    And User chooses valid Group and goes to the next step
    And User performs to back the previous screen at Select Objective step
    Then The components of Link Objective popup of Key Result "<krName>" displays

    Examples: 
      | objName                             | krName          |
      | Objective for LinkObjective Testing | Lala Key Result |

  Scenario Outline: Verify the error message for case no choice Objective displays in case user has not chooses Objective yet
    Given User navigates to Objective "<objName>" has Key Result "<krName>" of another Group
    When User opens Link Objective popup of Key Result "<krName>"
    And User chooses valid Group and goes to the next step
    And User performs to submit at Select Objective step
    Then The error message for case no choice Objective displays

    Examples: 
      | objName                             | krName          |
      | Objective for LinkObjective Testing | Lala Key Result |

  Scenario Outline: Verify user is able to link objective in case user chooses an Objective
    Given User goes to Dashboard screen has Objective "<desObj>"
    When User navigates to Objective "<objName>" has Key Result "<krName>" of another Group
    And User opens Link Objective popup of Key Result "<krName>"
    And User chooses valid Group and goes to the next step
    And User performs to choose an Objective "<desObj>"
    And User performs to submit at Select Objective step
    Then Link Objective successfully popup displays
    And Key Result "<krName>" displays in Link To section of Objective "<desObj>"

    Examples: 
      | objName                             | krName          | desObj             |
      | Objective for LinkObjective Testing | Lala Key Result | Key Result Testing |

  Scenario Outline: Verify user is able to link objective in case user chooses many Objectives
    Given User goes to Dashboard screen has Objective "<desObj1>" and "<desObj2>"
    When User navigates to Objective "<objName>" has Key Result "<krName>" of another Group
    And User opens Link Objective popup of Key Result "<krName>"
    And User chooses valid Group and goes to the next step
    And User performs to choose Objective "<desObj1>" and "<desObj2>" and submits
    Then Link Objective successfully popup displays
    And Key Result "<krName>" displays in Link To section of Objective "<desObj1>" and "<desObj2>"

    Examples: 
      | objName                             | krName          | desObj1                         | desObj2                          |
      | Objective for LinkObjective Testing | Lala Key Result | The first Destination Objective | The second Destination Objective |

  Scenario Outline: Verify user is unable to link objective in case user chooses the linked Objective
    Given User goes to Dashboard screen has Objective "<desObj>"
    When User navigates to Objective "<objName>" has Key Result "<krName>" of another Group
    And User opens Link Objective popup of Key Result "<krName>"
    And User chooses valid Group and goes to the next step
    And User performs to choose an Objective "<desObj>"
    And User performs to submit at Select Objective step
    And Link Objective successfully popup displays
    And User opens Link Objective popup of Key Result "<krName>" and link to Objective "<desObj>" again
    Then Link Objective failed popup displays

    Examples: 
      | objName                             | krName          | desObj                   |
      | Objective for LinkObjective Testing | Lala Key Result | Linked Objective Testing |

  Scenario Outline: Verify user is able to link KR with a new Objective
    Given User navigates to Objective "<objName>" has Key Result "<krName>" of another Group
    When User opens Link Objective popup of Key Result "<krName>"
    And User chooses valid Group and goes to the next step
    And User navigates to Add new Objective tab
    And User creates a new Objective "<newObj>" and submits
    Then Link Objective successfully popup displays
    And Key Result "<krName>" displays in Link To section of Objective "<newObj>"

    Examples: 
      | objName                             | krName          | newObj                            |
      | Objective for LinkObjective Testing | Lala Key Result | New Objective for link KR Testing |
