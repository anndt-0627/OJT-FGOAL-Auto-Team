Feature: Quarter List

  Background: Login successfully with valid WSM user account
    Given User navigate to Login page of Fgoal
    When User navigate to Login page of WSM
    And User enter valid account as admin account
    And User enter valid password as password of admin
    Then User should be access Fgoal successfully

  Scenario: All item on Quarter List page are display correctly
    Given User is on Quarter List page
    Then All item on the Quarter screen displays correctly

  Scenario Outline: User can add an Year Plan successfully with valid input
    Given User is on Quarter List page
    When User perform open add new year plan page
    And User choose valid "<new year>" at Add new year plan page
    And User input valid quarter start time and quarter end time for each quarter at Add new year plan page
    And User perform add new year plan action
    Then User is back to Quarter List page and successfully added message displays
    And "<quarter1>" "<quarter2>" "<quarter3>" "<quarter4>" display successfully on Quarter List page
    Examples:
      | new year | quarter1 | quarter2 | quarter3 | quarter4 |
      | 2028     | Q1-2027  | Q2-2027  | Q3-2027  | Q4-2027  |


  Scenario Outline: User can not add an new Year Plan successfully with invalid input
    Given User is on Quarter List page
    When User perform open add new year plan page
    And User choose invalid "<existed year>" that already created at Add new year plan page
    Then Duplicate new year plan displays and user can not create new year plan
    Examples:
      | existed year |
      | 2019         |

  Scenario Outline: User can set Default Quarter successfully
    Given User is on Quarter List page
    When User choose any "<quarter>" in Quarter List dropdown
    And User perform set default quarter action
    Then Success message displays and "<quarter>" set as default quarter
    And Year plan of "<quarter>" quarter expand and show as default on Quarter List page
    Examples:
      | quarter |
      | Q4-2026 |

