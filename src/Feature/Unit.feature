Feature: Unit List

  Background: Login successfully with valid WSM account
    Given User navigate to Login page of Fgoal
    When User navigate to Login page of WSM
    And User enter valid account as admin account
    And User enter valid password as password of admin
    Then User should be access Fgoal successfully

  Scenario: All item on Unit List page are display correctly
    Given User is on Unit List page
    Then Unit List page displays correctly with all item

  Scenario Outline: User can add an Unit successfully with valid input
    Given User is on Unit List page
    When User perform open add new Unit form
    And User input valid Unit as "<unit>"
    And User perform add new unit action
    Then Successfully added message displays
    And New "<unit>" displays correctly under the default Unit on Unit table

    Examples:
      | unit        |
      | unit test 5 |

  Scenario Outline: User can not add successfully an Unit with invalid input
    Given User is on Unit List page
    When User perform open add new Unit form
    And User input <invalid unit> data
    And User perform add new unit action
    Then User can not add successfully an Unit and <error message> display

    Examples:
      | invalid unit         | error message                      |
      | unit contain number  | input contain number error message |
      | unit already existed | duplicate unit error message       |

  Scenario Outline: Unit table show corresponding number of entries chosen by Show entries dropdown
    Given User is on Unit List page
    And Default number of entries show on Unit table is "<default number>"
    When User choose any number of entries as "<number of entries>" in Show entries dropdown
    Then Unit table show "<number of entries>" number of entries chosen before

    Examples:
      | default number | number of entries |
#      | 10             | 10                |
      | 10             | 25                |
#      | 10             | 50                |
#      | 10             | 100               |


  Scenario Outline: User can search Unit successfully with valid input
    Given User is on Unit List page
    When User can search by <item> with "<search condition>" in Search box
    Then Search result for <item> and "<search condition>" return correctly

    Examples:
      | item | search condition |
      | NO   | a number         |
      | Unit | a unit           |

  Scenario Outline: User can Edit an Unit successfully with valid input
    Given User is on Unit List page
    When User perform open edit Unit form
    And User input valid "<unit>" on edit Unit form
    And User perform edit Unit action
    Then Successfully edited message displays
    And Edited "<unit>" displays correctly on Unit table

    Examples:
      | unit        |
      | edited unit |

  Scenario Outline: User can not edit successfully an Unit with invalid input
    Given User is on Unit List page
    When User perform open edit Unit form
    And User input <invalid unit> data
    And User perform edit unit action
    Then User can not edit successfully an Unit and <error message> display

    Examples:
      | invalid unit         | error message                      |
      | unit contain number  | input contain number error message |
      | unit already existed | duplicate unit error message       |

  Scenario Outline: User can delete successfully an Unit that not Default Unit
    Given User is on Unit List page
    When User perform delete action an "<unit>" that not Default Unit
    And User confirm delete chosen unit
    Then Delete successfully message displays
    And "<unit>" deleted from Unit table

    Examples:
      | unit        |
      | delete unit |

  Scenario Outline: User can not delete successfully an Default Unit
    Given User is on Unit List page
    When User perform delete action an "<default unit>" that not Default Unit
    And User confirm delete chosen unit
    Then Delete unsuccessfully and error message displays

    Examples:
      | default unit        |
      | delete default unit |

  Scenario Outline: User can set Default Unit successfully by choosing in Unit dropdown
    Given User is on Unit List page
    When User choose an "<unit>" in Unit dropdown
    And User perform set Default Unit action
    Then "<unit>" set as Default Unit and display on top of Unit table

    Examples:
      | unit             |
      | unit set default |









