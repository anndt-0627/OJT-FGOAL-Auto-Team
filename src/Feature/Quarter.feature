Feature: Quarter List

  Background: Login successfully with valid WSM account
    Given User is on Login page of Fgoal
    When User perform action Login via WSM action
    And User input valid email on WSM page
    And User input valid password on WSM page
    And User perform action Login on WSM page
    Then User can login successfully to Fgoal via WSM

  Scenario Outline: All item on Quarter List page are display correctly
    Given User is on Quarter List page
    Then <Item> displays correctly

    Examples:
      | Item                     |
      | Add new year plan button |
      | Year Plan List           |
      | Set Default Quarter      |

  Scenario Outline: User can add an Year Plan successfully with valid input
    Given User is on Quarter List page
    When User perform open add new year plan page
    And Only "<number of year>" from current year display in Select year dropdown
    And User choose valid "<new year plan>" at Add new year plan page
    And User input valid "<quarter name>" "<quarter start time>" "<quarter end time>" for each quarter at Add new year plan page
    And User perform add new year plan action
    Then User is back to Quarter List page and successfully added message displays
    And "<new year plan>" display successfully on Quarter List page

    Examples:
      | number of year | new year plan | quarter name         | quarter start time         | quarter end time         |
      | 10             | new year plan | default quarter name | default quarter start time | default quarter end time |

  Scenario Outline: User can not add an new Year Plan successfully with invalid input
    Given User is on Quarter List page
    When User perform open add new year plan page
    And Only "<number of year>" from current year display in Select year dropdown
    And User choose invalid "<existed year plan>" that already created at Add new year plan page
    Then Duplicate new year plan displays and user can not create new year plan

    Examples:
      | number of year | existed year plan |
      | 10             | existed year plan |

  Scenario Outline: User can set Default Quarter successfully
    Given User is on Quarter List page
    When User choose any "<quarter>" in Quarter List dropdown
    And User perform set default quarter action
    Then "<quarter>" set as default quarter
    And Year plan of that quarter expand and show as default on Quarter List page

    Examples:
      | quarter |
      | Q1-2020 |

