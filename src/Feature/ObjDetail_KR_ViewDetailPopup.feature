Feature: ObjDetail_KR_ViewDetailPopup
  Description: Testing for View Detail popup of Key Result

  Background: 
    Given User navigate to Login page of Fgoal
    When User navigate to Login page of WSM
    And User enter valid account as user account
    And User enter valid password as password of user
    And User should be access Fgoal successfully

  Scenario Outline: Verify the View Detail popup of Key Result shows up
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>" has Key Result "<krName>"
    And User opens View Detail popup of Key Result "<krName>"
    Then The components of View Detail popup of Key Result "<krName>" displays

    Examples: 
      | objName            | krName               |
      | Key Result Testing | The first Key Result |

  Scenario Outline: Verify the View Detail popup of Key Result close
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>" has Key Result "<krName>"
    And User opens View Detail popup of Key Result "<krName>"
    And User performs to close View Detail popup
    Then View Detail popup of Key Result "<krName>" closes

    Examples: 
      | objName            | krName               |
      | Key Result Testing | The first Key Result |

  #=====Update Progress=====
  Scenario Outline: Verify the request enter data message shows up when clearing data in Progress textbox
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>" has Key Result "<krName>"
    And User opens View Detail popup of Key Result "<krName>"
    And User clears data in Progress textbox
    Then The request enter data message displays

    Examples: 
      | objName            | krName               |
      | Key Result Testing | The first Key Result |

  Scenario Outline: Verify user is able to update progress successfully when entering valid data into Progress textbox
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>" has Key Result "<krName>"
    And User opens View Detail popup of Key Result "<krName>"
    And User enters "<data>" into Progress textbox
    Then The success update message of Key Result displays
    And The progress of Key Result will be "<data>"

    Examples: 
      | objName            | krName               | data |
      | Key Result Testing | The first Key Result |  100 |
      | Key Result Testing | The first Key Result |   30 |
      | Key Result Testing | The first Key Result |   90 |

  Scenario Outline: Verify user is able to update progress successfully when entering INVALID data into Progress textbox
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>" has Key Result "<krName>"
    And User opens View Detail popup of Key Result "<krName>"
    And User enters "<data>" into Progress textbox
    Then The success update message of Key Result displays
    And The progress of Key Result will be "<updated_data>"

    Examples: 
      | objName            | krName               | data  | updated_data |
      | Key Result Testing | The first Key Result | -17.4 |            0 |
      | Key Result Testing | The first Key Result |  23.4 |           23 |
      | Key Result Testing | The first Key Result |  23.5 |           24 |
      | Key Result Testing | The first Key Result |   267 |          100 |

  Scenario Outline: Verify progress of Key Result on Objective Details screen will also update when user updates its value in View Detail popup
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>" has Key Result "<krName>"
    And User opens View Detail popup of Key Result "<krName>"
    And User enters "<data>" into Progress textbox
    And User closes View Detais popup of Key Result
    Then The progress of Key Result "<krName>" on Objective Details screen will be "<data>"

    Examples: 
      | objName            | krName               | data |
      | Key Result Testing | The first Key Result |   55 |

  #=====Update Weight=====
  Scenario Outline: Verify user is able to update weight successfully when entering valid data into Weight textbox
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>" has Key Result "<krName>"
    And User opens View Detail popup of Key Result "<krName>"
    And User enters "<data>" into Weight textbox
    Then The success update message of Key Result displays
    And The weight of Key Result will be "<data>"

    Examples: 
      | objName            | krName               | data |
      | Key Result Testing | The first Key Result |    5 |
      | Key Result Testing | The first Key Result |    1 |

  Scenario Outline: Verify user is able to update weight successfully when entering INVALID data into Weight textbox
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>" has Key Result "<krName>"
    And User opens View Detail popup of Key Result "<krName>"
    And User enters "<data>" into Weight textbox
    Then The success update message of Key Result displays
    And The weight of Key Result will be "<updated_data>"

    Examples: 
      | objName            | krName               | data | updated_data |
      | Key Result Testing | The first Key Result |   -7 |            1 |
      | Key Result Testing | The first Key Result |    0 |            1 |
      | Key Result Testing | The first Key Result |  3.4 |            3 |
      | Key Result Testing | The first Key Result |  3.5 |            4 |
      | Key Result Testing | The first Key Result |    6 |            5 |

  Scenario Outline: Verify weight of Key Result on Objective Details screen will also update when user updates its value in View Detail popup
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>" has Key Result "<krName>"
    And User opens View Detail popup of Key Result "<krName>"
    And User enters "<data>" into Weight textbox
    And User closes View Detais popup of Key Result
    Then The weight of Key Result "<krName>" on Objective Details screen will be "<data>"

    Examples: 
      | objName            | krName               | data |
      | Key Result Testing | The first Key Result |    3 |

  #=====Update Description=====
  Scenario Outline: Verify user is able to update description successfully when entering valid data into Description textbox
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>" has Key Result "<krName>"
    And User opens View Detail popup of Key Result "<krName>"
    And User enters "<data>" into Description textarea and submits
    Then The success update message of Key Result Description displays
    And The description of Key Result "<krName>" on Objective Details screen will be "<data>"

    Examples: 
      | objName            | krName               | data            |
      | Key Result Testing | The first Key Result | 123 456 789     |
      | Key Result Testing | The first Key Result | !@$ %^& ***     |
      | Key Result Testing | The first Key Result | 123 qwe !@$     |
      | Key Result Testing | The first Key Result | <b>HTML tag</b> |

  Scenario Outline: Verify user is able to update description successfully when entering data > 500 characters into Description textbox
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>" has Key Result "<krName>"
    And User opens View Detail popup of Key Result "<krName>"
    And User enters data greater than maxlength into Description textarea
    Then The number of characters of content in Description equal to maxlength

    Examples: 
      | objName            | krName               |
      | Key Result Testing | The first Key Result |

  Scenario Outline: Verify description of Key Result on Objective Details screen will also update when user updates its data in View Detail popup
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>" has Key Result "<krName>"
    And User opens View Detail popup of Key Result "<krName>"
    And User enters "<data>" into Description textarea and submits
    And User closes View Detais popup of Key Result
    Then The description of Key Result "<krName>" on Objective Details screen will be "<data>"

    Examples: 
      | objName            | krName               | data                   |
      | Key Result Testing | The first Key Result | Updated description OK |
