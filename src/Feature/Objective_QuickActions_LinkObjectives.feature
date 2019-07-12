Feature: Objective_Quick Actions
  Description: Testing Link Objectives in Quick Actions of Objective

  Background: 
    Given User navigate to Login page of Fgoal
    When User navigate to Login page of WSM
    And User enter valid account as user account
    And User enter valid password as password of user
    And User navigates to Dashboard screen

  Scenario Outline: Verify the components of Select Group screen of Link to Key Result popup
    Given User navigates to Dashboard screen
    When Create a new Objective with "<objName>" and "<objWeight>"
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Link objectives option in Quick Actions menu
    Then The components of Select Group screen displays

    Examples: 
      | objName               | objWeight |
      | Improve English skill |         3 |

  Scenario Outline: Verify the Link to Key Result popup closes in case user clicks on Close icon
    Given User navigates to Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Link objectives option in Quick Actions menu
    And User clicks on Close icon
    Then Link to Key Result popup closes

    Examples: 
      | objName               |
      | Improve English skill |

  Scenario Outline: Verify the options of Group dropdown displays in case user clicks on
    Given User navigates to Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Link objectives option in Quick Actions menu
    And User clicks on Group dropdown
    Then Group dropdown menu of Group dropdown displays
    And Search textbox displays in Group dropdown menu

    Examples: 
      | objName               |
      | Improve English skill |

  Scenario Outline: Verify displaying Nothing selected in Group dropdown in case user enters keyword not exist into Search textbox
    Given User navigates to Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Link objectives option in Quick Actions menu
    And User clicks on Group dropdown
    And User enters keyword not match into Search textbox
    Then Nothing selected text displays in Group dropdown

    Examples: 
      | objName               |
      | Improve English skill |

  Scenario Outline: Verify the error message for case no choice Group displays in case user has not chosen Group yet
    Given User navigates to Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Link objectives option in Quick Actions menu
    And User clicks on Group dropdown
    And User enters keyword not match into Search textbox
    And User clicks on Next button at Select Group screen
    Then The error message for case no choice Group displays

    Examples: 
      | objName               |
      | Improve English skill |

  Scenario Outline: Verify navigating to Select Objective screen successfully in case user does nothing and clicks on Next button
    Given User navigates to Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Link objectives option in Quick Actions menu
    And User clicks on Next button at Select Group screen
    Then The components of Select Objective screen displays

    Examples: 
      | objName               |
      | Improve English skill |

  Scenario Outline: Verify navigating to Select Objective screen successfully in case user chooses another Group and clicks on Next button
    Given User navigates to Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Link objectives option in Quick Actions menu
    And User clicks on Group dropdown
    And User enters keyword matched into Search textbox
    And User clicks on Next button at Select Group screen
    Then The components of Select Objective screen displays

    Examples: 
      | objName               |
      | Improve English skill |

  Scenario Outline: Verify message there is no objective displays in Link to Key Result popup in case there is NO Objective in the seleted Group
    Given User navigates to Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Link objectives option in Quick Actions menu
    And User clicks on Group dropdown
    And User enters keyword is a group that has no Objective into Search textbox
    And User clicks on Next button at Select Group screen
    Then Message there is no objective displays in Link to Key Result popup

    Examples: 
      | objName               |
      | Improve English skill |

  Scenario Outline: Verify the Objectives display in Select Objective screen in case there are Objective in Group
    Given User navigates to Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Link objectives option in Quick Actions menu
    And User clicks on Group dropdown
    And User enters keyword is a group that has Objective into Search textbox
    And User clicks on Next button at Select Group screen
    Then List of Objective displays in Link to Key Result popup

    Examples: 
      | objName               |
      | Improve English skill |

  Scenario Outline: Verify user is able to back Select Group screen in case he is in Select Objective screen and clicks on Back button
    Given User navigates to Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Link objectives option in Quick Actions menu
    And User clicks on Group dropdown
    And User enters keyword is a group that has Objective into Search textbox
    And User clicks on Next button at Select Group screen
    And User clicks on Back button at Select Objective screen
    Then The components of Select Group screen displays

    Examples: 
      | objName               |
      | Improve English skill |

  Scenario Outline: Verify the error message for case no choice Objective displays in case user has not chosen Objective yet
    Given User navigates to Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Link objectives option in Quick Actions menu
    And User clicks on Group dropdown
    And User enters keyword is a group that has Objective into Search textbox
    And User clicks on Next button at Select Group screen
    And User clicks on Next button at Select Objective screen
    Then The error message for case no choice Objective displays

    Examples: 
      | objName               |
      | Improve English skill |

  Scenario Outline: Verify the components of Select Key Result screen of Link to Key Result popup in case user chooses an Objective and clicks on Next button at Select Objective screen
    Given User navigates to Group details screen of another Group
    When Create a new Objective with "<objNameNew>" and "<objWeightNew>"
    And User creates new Key Result "<krName>" for Objective
    And User navigates to Dashboard screen
    And User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Link objectives option in Quick Actions menu
    And User clicks on Group dropdown
    And User enters keyword is a group that has Objective into Search textbox
    And User clicks on Next button at Select Group screen
    And User clicks on Objective "<objNameNew>" at Select Objective screen
    And User clicks on Next button at Select Objective screen
    Then The components of Select Key Result screen with the selected Objective "<objNameNew>" displays

    Examples: 
      | objNameNew                 | objWeightNew | krName           | objName               |
      | Testing for Link Objective |            3 | Drink water more | Improve English skill |

  Scenario Outline: Verify user is able to back Select Objective screen in case he is in Select Key Result screen and clicks on Back button
    Given User navigates to Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Link objectives option in Quick Actions menu
    And User clicks on Group dropdown
    And User enters keyword is a group that has Objective into Search textbox
    And User clicks on Next button at Select Group screen
    And User clicks on Objective "<objNameNew>" at Select Objective screen
    And User clicks on Next button at Select Objective screen
    And User clicks on Back button at Select Key Result screen
    Then The components of Select Objective screen displays

    Examples: 
      | objNameNew                 | objName               |
      | Testing for Link Objective | Improve English skill |

  Scenario Outline: Verify the error message for case no choice Key Result displays in case user has not chosen Key Result yet
    Given User navigates to Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Link objectives option in Quick Actions menu
    And User clicks on Group dropdown
    And User enters keyword is a group that has Objective into Search textbox
    And User clicks on Next button at Select Group screen
    And User clicks on Objective "<objNameNew>" at Select Objective screen
    And User clicks on Next button at Select Objective screen
    And User clicks on Submit button at Select Key Result screen
    Then The error message for case no choice Key Result displays

    Examples: 
      | objNameNew                 | objName               |
      | Testing for Link Objective | Improve English skill |

  Scenario Outline: Verify the options of Key Result dropdown displays in case user clicks on
    Given User navigates to Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Link objectives option in Quick Actions menu
    And User clicks on Group dropdown
    And User enters keyword is a group that has Objective into Search textbox
    And User clicks on Next button at Select Group screen
    And User clicks on Objective "<objNameNew>" at Select Objective screen
    And User clicks on Next button at Select Objective screen
    And User clicks on Key Result dropdown
    Then Key Result dropdown menu of Key Result dropdown displays
    And Select All button displays in Key Result dropdown menu
    And Deselect All button displays in Key Result dropdown menu

    Examples: 
      | objNameNew                 | objName               |
      | Testing for Link Objective | Improve English skill |

  Scenario Outline: Verify the selected Key Result option displays in Key Result dropdown in case user clicks on
    Given User navigates to Dashboard screen
    When User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Link objectives option in Quick Actions menu
    And User clicks on Group dropdown
    And User enters keyword is a group that has Objective into Search textbox
    And User clicks on Next button at Select Group screen
    And User clicks on Objective "<objNameNew>" at Select Objective screen
    And User clicks on Next button at Select Objective screen
    And User clicks on Key Result dropdown
    And User clicks on Key Result "<krName>" in Key Result dropdown
    Then The selected Key Result "<krName>" displays in Key Result dropdown

    Examples: 
      | objNameNew                 | krName           | objName               |
      | Testing for Link Objective | Drink water more | Improve English skill |

  Scenario Outline: Verify all of the Key Result options display in Key Result dropdown in case user clicks on Select All button
    Given User navigates to Group details screen of another Group
    When Create a new Objective with "<objNameNew>" and "<objWeightNew>"
    And User creates new Key Result "<krName1>" for Objective
    And User creates new Key Result "<krName2>" for Objective
    And User navigates to Dashboard screen
    And User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Link objectives option in Quick Actions menu
    And User clicks on Group dropdown
    And User enters keyword is a group that has Objective into Search textbox
    And User clicks on Next button at Select Group screen
    And User clicks on Objective "<objNameNew>" at Select Objective screen
    And User clicks on Next button at Select Objective screen
    And User clicks on Key Result dropdown
    And User clicks on Select All button in Key Result dropdown
    Then The all of Key Result "<krName1>" and "<krName2>" displays in Key Result dropdown

    Examples: 
      | objNameNew            | objWeightNew | krName1          | krName2   | objName               |
      | Objective has many KR |            3 | Drink water more | Eat clean | Improve English skill |

  Scenario Outline: Verify reset the data and display the placeholder in Key Result dropdown in case user clicks on Deselect All button
    Given User navigates to Group details screen of another Group
    When User navigates to Dashboard screen
    And User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Link objectives option in Quick Actions menu
    And User clicks on Group dropdown
    And User enters keyword is a group that has Objective into Search textbox
    And User clicks on Next button at Select Group screen
    And User clicks on Objective "<objNameNew>" at Select Objective screen
    And User clicks on Next button at Select Objective screen
    And User clicks on Key Result dropdown
    And User clicks on Select All button in Key Result dropdown
    And The all of Key Result "<krName1>" and "<krName2>" displays in Key Result dropdown
    And User clicks on Deselect All button in Key Result dropdown
    Then Reset the data and display the placeholder with the selected Objective "<objNameNew>" in Key Result dropdown

    Examples: 
      | objNameNew            | krName1          | krName2   | objName               |
      | Objective has many KR | Drink water more | Eat clean | Improve English skill |

  Scenario Outline: Verify Link to Key Result successfully popup displays in case user submits form
    Given User navigates to Group details screen of another Group
    When User navigates to Dashboard screen
    And User clicks on "<objName>" item in My Objectives section
    And User clicks on the Quick Actions icon in Objective section
    And User clicks on Link objectives option in Quick Actions menu
    And User clicks on Group dropdown
    And User enters keyword is a group that has Objective into Search textbox
    And User clicks on Next button at Select Group screen
    And User clicks on Objective "<objNameNew>" at Select Objective screen
    And User clicks on Next button at Select Objective screen
    And User clicks on Key Result dropdown
    And User clicks on Select All button in Key Result dropdown
    And User clicks on Submit button at Select Key Result screen
    Then Link to Key Result successfully popup displays

    Examples: 
      | objNameNew            | krName1          | krName2   | objName               |
      | Objective has many KR | Drink water more | Eat clean | Improve English skill |
