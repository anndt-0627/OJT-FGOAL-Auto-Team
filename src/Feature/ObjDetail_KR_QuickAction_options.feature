Feature: Key result Quick Actions options in Objective details

  Background: Login successfully with valid WSM user account
    Given User navigate to Login page of Fgoal
    When User navigate to Login page of WSM
    And User enter valid account as user account
    And User enter valid password as password of user
    Then User should be access Fgoal successfully

  @change_name
  Scenario Outline: Verify that Pre-fill name in textbox is matched with current name of key result has been selected
    Given User navigates to Objective "<objName>" has Key Result "<krName>"
    When User opens Quick Actions popup of Key Result "<krName>"
    And User opens Change "<krName>" popup
    Then Pre-fill name in textbox is matched with current "<krName>"

    Examples: 
      | objName                 | krName                  |
      | Trinh_Objective_Testing | Trinh_KeyResult_Testing |

  @change_name
  Scenario Outline: Verify that error message displays when user submits to change KR name without entering KR name
    Given User navigates to Objective "<objName>" has Key Result "<krName>"
    When User opens Quick Actions popup of Key Result "<krName>"
    And User opens Change "<krName>" popup
    And User clear text in name textbox
    And User performs to change KR name
    Then Error "<message>" displays in Change KR name popup

    Examples: 
      | objName                 | krName                  | message                 |
      | Trinh_Objective_Testing | Trinh_KeyResult_Testing | This field is required. |

  @change_name
  Scenario Outline: Verify that error message displays when user submits to change KR name with existing KR name
    Given User navigates to Objective "<objName>" has Key Result "<krName>"
    And Check other Key Result is existing
    When User opens Quick Actions popup of Key Result "<krName>"
    And User opens Change "<krName>" popup
    And User enter name into textbox as name of exting key result
    And User performs to change KR name
    Then "<message>" displays on Objective Details screen

    Examples: 
      | objName                 | krName                  | message                  |
      | Trinh_Objective_Testing | Trinh_KeyResult_Testing | Key Result already exist |

  @change_name
  Scenario Outline: Verify that KR name is not changed when user submits to close popup
    Given User navigates to Objective "<objName>" has Key Result "<krName>"
    When User opens Quick Actions popup of Key Result "<krName>"
    And User opens Change "<krName>" popup
    And User enter valid name into textbox
    And User performs to close change name popup
    Then Name of KR "<krName>" is not changed

    Examples: 
      | objName                 | krName                  |
      | Trinh_Objective_Testing | Trinh_KeyResult_Testing |

  @KR_change_name
  Scenario Outline: Verify that succesfully message displays and name is updated after user performs change name of KR with valid name
    Given User navigates to Objective "<objName>" has Key Result "<krName>"
    When User opens Quick Actions popup of Key Result "<krName>"
    And User opens Change "<krName>" popup
    And User enter valid name into textbox
    And User performs to change KR name
    Then "<message>" displays on Objective Details screen
    And Name of KR is updated

    Examples: 
      | objName                 | krName                  | message           |
      | Trinh_Objective_Testing | Trinh_KeyResult_Testing | Update successful |

  @KR_change_weight
  Scenario Outline: Verify user is unable to update Weight with invalid data
    Given User navigates to Objective "<objName>" has Key Result "<krName>" and "<weight>" and "<target>"
    When User opens Quick Actions popup of Key Result "<krName>"
    And User opens Change Weight popup of KR "<krName>"
    And User updates the data with value is "<invalid_value>" into KR Weight textbox
    And User submits Update KR weight popup
    Then The <error_message> error message displays under KR Weight textbox

    Examples: 
      | objName                 | krName                  | invalid_value | error_message            | weight | target |
      | Trinh_Objective_Testing | Trinh_KeyResult_Testing |            -5 | invalid min or max value |      1 |     25 |
      | Trinh_Objective_Testing | Trinh_KeyResult_Testing |             0 | invalid min or max value |      1 |     25 |
      | Trinh_Objective_Testing | Trinh_KeyResult_Testing |             6 | invalid min or max value |      1 |     25 |
      | Trinh_Objective_Testing | Trinh_KeyResult_Testing |           1.5 | invalid integer value    |      1 |     25 |

  @KR_change_weight
  Scenario Outline: Verify that KR weight is not changed when user performs to close popup
    Given User navigates to Objective "<objName>" has Key Result "<krName>" and "<weight>" and "<target>"
    When User opens Quick Actions popup of Key Result "<krName>"
    And User opens Change Weight popup of KR "<krName>"
    And User updates the data with value is "<valid_value>" into KR Weight textbox
    And User performs to close change KR weight popup
    Then Change KR Weight popup is closed
    And KR weight is not changed

    Examples: 
      | objName                 | krName                  | valid_value | weight | target |
      | Trinh_Objective_Testing | Trinh_KeyResult_Testing |           3 |      1 |     25 |

  @KR_change_weight
  Scenario Outline: Verify that KR weight is changed successfully when user performs to update with valid weight
    Given User navigates to Objective "<objName>" has Key Result "<krName>" and "<weight>" and "<target>"
    When User opens Quick Actions popup of Key Result "<krName>"
    And User opens Change Weight popup of KR "<krName>"
    And User updates the data with value is "<valid_value>" into KR Weight textbox
    And User performs to update KR weight
    Then Change KR Weight popup is closed
    And "<message>" displays on Objective Details screen
    And KR weight is changed successfully

    Examples: 
      | objName                 | krName                  | valid_value | weight | target | message           |
      | Trinh_Objective_Testing | Trinh_KeyResult_Testing |           3 |      1 |     25 | Update successful |
