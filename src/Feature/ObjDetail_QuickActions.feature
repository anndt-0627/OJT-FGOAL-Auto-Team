Feature: Objective_Quick Actions
  Description: Testing for the functions in Quick Actions of Objective

  Background: 
    Given User navigate to Login page of Fgoal
    When User navigate to Login page of WSM
    And User enter valid account as user account
    And User enter valid password as password of user
    And User navigates to Dashboard screen

  @obj_chang_name
  Scenario Outline: Verify the Update Objective title popup shows up when selecting Update Objective title option in Quick Actions menu
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Update Objective title popup
    Then Update Objective title popup opens

    Examples: 
      | objName               |
      | Improve English skill |

  @obj_chang_name
  Scenario Outline: Verify the value in Name textbox is correct with the Objective that user clicks on
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Update Objective title popup
    Then The value in Name textbox is equal to "<objName>"

    Examples: 
      | objName               |
      | Improve English skill |

  @obj_chang_name
  Scenario Outline: Verify Update Objective Name successfully with valid data
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Update Objective title popup
    And User updates the data with value is "<valid_value>" into Name textbox
    And User submits Update Objective title popup
    Then Update Objective title popup closes
    And Success objective update message displays
    And Objective Name in Objective section is equal to "<valid_value>"

    Examples: 
      | objName               | valid_value     |
      | Improve English skill | 123 456 789     |
      | 123 456 789           | !@$ %^& ***     |
      | !@$ %^& ***           | 123 qwe !@$     |
      | 123 qwe !@$           | <b>HTML tag</b> |

  @obj_chang_name
  Scenario Outline: Verify user is not able to update Objective Name that it is empty
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Update Objective title popup
    And User removes data in Name textbox
    And User submits Update Objective title popup
    Then The error message required data displays

    Examples: 
      | objName               |
      | Improve English skill |

  @obj_chang_name
  Scenario Outline: Verify user is not able to update Objective Name that it is existed in system
    Given User navigates to Dashboard screen
    When Checking the existence or creating Objective "<existedObjName>"
    And User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Update Objective title popup
    And User updates the data with value is "<existedObjName>" into Name textbox
    And User submits Update Objective title popup
    Then The error message existed data displays

    Examples: 
      | existedObjName | objName               |
      | Lala Objective | Improve English skill |

  @obj_chang_name
  Scenario Outline: Verify user is not able to update Objective Name in case user clicks on Close button
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Update Objective title popup
    And User updates the data with value is "<valid_value>" into Name textbox
    And User performs to close Update Objective title popup
    Then Update Objective title popup closes
    And Objective Name in Objective section is equal to "<objName>"

    Examples: 
      | objName               | valid_value  |
      | Improve English skill | Updated Name |

  @obj_chang_weight
  Scenario Outline: Verify the Update weight popup shows up when selecting Update weight option in Quick Actions menu
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Update weight popup
    Then Update weight popup opens

    Examples: 
      | objName        |
      | Improve Weight |

  @obj_chang_weight
  Scenario Outline: Verify Update Objective Weight successfully
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Update weight popup
    And User updates the data with value is "<valid_value>" into Weight textbox
    And User submits Update weight popup
    Then Update weight popup closes
    And Success objective update message displays
    And Objective Weight in Objective section is equal to "<valid_value>"

    Examples: 
      | objName        | valid_value |
      | Improve Weight |           5 |
      | Improve Weight |           1 |

  @obj_chang_weight
  Scenario Outline: Verify user is not able to update Objective Weight with invalid data
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Update weight popup
    And User updates the data with value is "<invalid_value>" into Weight textbox
    And User submits Update weight popup
    Then The <error_message> error message displays under Weight textbox

    Examples: 
      | objName        | invalid_value | error_message            |
      | Improve Weight |            -5 | invalid min or max value |
      | Improve Weight |             0 | invalid min or max value |
      | Improve Weight |             6 | invalid min or max value |
      | Improve Weight |           1.5 | invalid integer value    |

  @obj_chang_weight
  Scenario Outline: Verify user is not able to update Objective Weight in case user clicks on Close button
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Update weight popup
    And User updates the data with value is "<valid_value>" into Weight textbox
    And User performs to close Update weight popup
    Then Update weight popup closes

    Examples: 
      | objName        | valid_value |
      | Improve Weight |           3 |

  @obj_delete
  Scenario Outline: Verify the Delete objective popup show up when selecting Delete option in Quick Actions menu
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Delete objective popup
    Then Delete objective popup of "<objName>" opens

    Examples: 
      | objName         |
      | Test and Delete |

  @obj_delete
  Scenario Outline: Verify user is not able to delete Objective in case user clicks on Close button
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Delete objective popup
    And User performs to close Delete objective popup
    Then Delete objective popup closes
    And Objective Name in Objective section is equal to "<objName>"

    Examples: 
      | objName         |
      | Test and Delete |

  @obj_delete
  Scenario Outline: Verify user is able to delete Objective successfully
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User opens Quick Actions popup of Objective
    And User performs to open Delete objective popup
    And User confirms to delete Objective
    Then Objective "<objName>" did not display on Dashboard screen

    Examples: 
      | objName         |
      | Test and Delete |

  @obj_link_objective
  Scenario Outline: Verify the components of Select Group screen of Link to Key Result popup
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User performs to open Link to Key Result popup
    Then The components of Select Group screen displays

    Examples: 
      | objName               |
      | Improve English skill |

  @obj_link_objective
  Scenario Outline: Verify the Link to Key Result popup closes in case user clicks on Close icon
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User performs to open Link to Key Result popup
    And User performs to close Link to Key Result popup
    Then Link to Key Result popup closes

    Examples: 
      | objName               |
      | Improve English skill |

  @obj_link_objective
  Scenario Outline: Verify the options of Group dropdown displays in case user clicks on
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User performs to open Link to Key Result popup
    And User opens Group dropdown
    Then Group dropdown menu of Group dropdown displays
    And Search textbox displays in Group dropdown menu

    Examples: 
      | objName               |
      | Improve English skill |

  @obj_link_objective
  Scenario Outline: Verify displaying Nothing selected in Group dropdown in case user enters keyword not exist into Search textbox
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User performs to open Link to Key Result popup
    And User enters keyword not match into Search textbox
    Then Nothing selected text displays in Group dropdown

    Examples: 
      | objName               |
      | Improve English skill |

  @obj_link_objective
  Scenario Outline: Verify the error message for case no choice Group displays in case user has not chosen Group yet
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User performs to open Link to Key Result popup
    And User enters keyword not match into Search textbox
    And User performs to submit at Select Group screen
    Then The error message for case no choice Group displays

    Examples: 
      | objName               |
      | Improve English skill |

  @obj_link_objective
  Scenario Outline: Verify navigating to Select Objective screen successfully in case user does nothing and clicks on Next button
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User performs to open Link to Key Result popup
    And User performs to submit at Select Group screen
    Then The components of Select Objective screen displays

    Examples: 
      | objName               |
      | Improve English skill |

  @obj_link_objective
  Scenario Outline: Verify navigating to Select Objective screen successfully in case user chooses another Group and clicks on Next button
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User performs to open Link to Key Result popup
    And User enters keyword matched into Search textbox
    And User performs to submit at Select Group screen
    Then The components of Select Objective screen displays

    Examples: 
      | objName               |
      | Improve English skill |

  @obj_link_objective
  Scenario Outline: Verify message there is no objective displays in Link to Key Result popup in case there is NO Objective in the seleted Group
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User performs to open Link to Key Result popup
    And User enters keyword is a group that has no Objective into Search textbox
    And User performs to submit at Select Group screen
    Then Message there is no objective displays in Link to Key Result popup

    Examples: 
      | objName               |
      | Improve English skill |

  @obj_link_objective
  Scenario Outline: Verify the Objectives display in Select Objective screen in case there are Objective in Group
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User performs to open Link to Key Result popup
    And User enters keyword is a group that has Objective into Search textbox
    And User performs to submit at Select Group screen
    Then List of Objective displays in Link to Key Result popup

    Examples: 
      | objName               |
      | Improve English skill |

  @obj_link_objective
  Scenario Outline: Verify user is able to back Select Group screen in case he is in Select Objective screen and clicks on Back button
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User performs to open Link to Key Result popup
    And User enters keyword is a group that has Objective into Search textbox
    And User performs to submit at Select Group screen
    And User performs to back the previous screen at Select Objective screen
    Then The components of Select Group screen displays

    Examples: 
      | objName               |
      | Improve English skill |

  @obj_link_objective
  Scenario Outline: Verify the error message for case no choice Objective displays in case user has not chosen Objective yet
    Given User navigates to Dashboard screen
    When User navigates to Objective "<objName>"
    And User performs to open Link to Key Result popup
    And User enters keyword is a group that has Objective into Search textbox
    And User performs to submit at Select Group screen
    And User performs to submit at Select Objective screen
    Then The error message for case no choice Objective displays

    Examples: 
      | objName               |
      | Improve English skill |

  @obj_link_objective
  Scenario Outline: Verify the components of Select Key Result screen of Link to Key Result popup in case user chooses an Objective and clicks on Next button at Select Objective screen
    Given User navigates to Group details screen of another Group
    When User navigates to Objective "<objNameNew>" has Key Result "<krName>"
    And User goes to Dashboard screen and navigates to Objective "<objName>"
    And User performs to open Link to Key Result popup
    And User selects valid Group and go to the next step
    And User selects the Objective "<objNameNew>" and go to the next step
    Then The components of Select Key Result screen with the selected Objective "<objNameNew>" displays

    Examples: 
      | objNameNew                 | krName           | objName               |
      | Testing for Link Objective | Drink water more | Improve English skill |

  @obj_link_objective
  Scenario Outline: Verify user is able to back Select Objective screen in case he is in Select Key Result screen and clicks on Back button
    Given User navigates to Group details screen of another Group
    When User navigates to Objective "<objNameNew>" has Key Result "<krName>"
    And User goes to Dashboard screen and navigates to Objective "<objName>"
    And User performs to open Link to Key Result popup
    And User selects valid Group and go to the next step
    And User selects the Objective "<objNameNew>" and go to the next step
    And User performs to back the previous screen at Select Key Result screen
    Then The components of Select Objective screen displays

    Examples: 
      | objNameNew                 | krName           | objName               |
      | Testing for Link Objective | Drink water more | Improve English skill |

  @obj_link_objective
  Scenario Outline: Verify the error message for case no choice Key Result displays in case user has not chosen Key Result yet
    Given User navigates to Group details screen of another Group
    When User navigates to Objective "<objNameNew>" has Key Result "<krName>"
    And User goes to Dashboard screen and navigates to Objective "<objName>"
    And User performs to open Link to Key Result popup
    And User selects valid Group and go to the next step
    And User selects the Objective "<objNameNew>" and go to the next step
    And User performs to submit at Select Key Result screen
    Then The error message for case no choice Key Result displays

    Examples: 
      | objNameNew                 | krName           | objName               |
      | Testing for Link Objective | Drink water more | Improve English skill |

  @obj_link_objective
  Scenario Outline: Verify the options of Key Result dropdown displays in case user clicks on
    Given User navigates to Group details screen of another Group
    When User navigates to Objective "<objNameNew>" has Key Result "<krName>"
    And User goes to Dashboard screen and navigates to Objective "<objName>"
    And User performs to open Link to Key Result popup
    And User selects valid Group and go to the next step
    And User selects the Objective "<objNameNew>" and go to the next step
    And User opens Key Result dropdown
    Then Key Result dropdown menu of Key Result dropdown displays

    Examples: 
      | objNameNew                 | krName           | objName               |
      | Testing for Link Objective | Drink water more | Improve English skill |

  @obj_link_objective
  Scenario Outline: Verify the selected Key Result option displays in Key Result dropdown in case user clicks on
    Given User navigates to Group details screen of another Group
    When User navigates to Objective "<objNameNew>" has Key Result "<krName>"
    And User goes to Dashboard screen and navigates to Objective "<objName>"
    And User performs to open Link to Key Result popup
    And User selects valid Group and go to the next step
    And User selects the Objective "<objNameNew>" and go to the next step
    And User opens and selects Key Result "<krName>" in Key Result dropdown
    Then The selected Key Result "<krName>" displays in Key Result dropdown

    Examples: 
      | objNameNew                 | krName           | objName               |
      | Testing for Link Objective | Drink water more | Improve English skill |

  @obj_link_objective
  Scenario Outline: Verify all of the Key Result options display in Key Result dropdown in case user clicks on Select All button
    Given User navigates to Group details screen of another Group
    When User navigates to Objective "<objNameNew>" has Key Result "<krName1>" and "<krName2>"
    And User goes to Dashboard screen and navigates to Objective "<objName>"
    And User performs to open Link to Key Result popup
    And User selects valid Group and go to the next step
    And User selects the Objective "<objNameNew>" and go to the next step
    And User opens and performs to select all of Key Result in Key Result dropdown
    Then The all of Key Result "<krName1>" and "<krName2>" displays in Key Result dropdown

    Examples: 
      | objNameNew            | krName1          | krName2   | objName               |
      | Objective has many KR | Drink water more | Eat clean | Improve English skill |

  @obj_link_objective
  Scenario Outline: Verify reset the data and display the placeholder in Key Result dropdown in case user clicks on Deselect All button
    Given User navigates to Group details screen of another Group
    When User navigates to Objective "<objNameNew>" has Key Result "<krName1>" and "<krName2>"
    And User goes to Dashboard screen and navigates to Objective "<objName>"
    And User performs to open Link to Key Result popup
    And User selects valid Group and go to the next step
    And User selects the Objective "<objNameNew>" and go to the next step
    And User opens and performs to select all of Key Result in Key Result dropdown
    And The all of Key Result "<krName1>" and "<krName2>" displays in Key Result dropdown
    And User performs to deselect all of Key Result in Key Result dropdown
    Then Reset the data and display the placeholder with the selected Objective "<objNameNew>" in Key Result dropdown

    Examples: 
      | objNameNew            | krName1          | krName2   | objName               |
      | Objective has many KR | Drink water more | Eat clean | Improve English skill |

  @obj_link_objective
  Scenario Outline: Verify Link to Key Result successfully popup displays in case user submits form
    Given User navigates to Group details screen of another Group
    When User navigates to Objective "<objNameNew>" has Key Result "<krName1>" and "<krName2>"
    And User goes to Dashboard screen and navigates to Objective "<objName>"
    And User performs to open Link to Key Result popup
    And User selects valid Group and go to the next step
    And User selects the Objective "<objNameNew>" and go to the next step
    And User opens and performs to select all of Key Result in Key Result dropdown
    And User performs to submit at Select Key Result screen
    Then Link to Key Result successfully popup displays

    Examples: 
      | objNameNew            | krName1          | krName2   | objName               |
      | Objective has many KR | Drink water more | Eat clean | Improve English skill |
