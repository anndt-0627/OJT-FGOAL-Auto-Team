Feature: Quick Actions
  Description: Testing Update weight Objective in Quick Actions      

Scenario: Verify the [Update weight] popup show up when selecting [Update weight] option in Quick Actions menu
    Given User goes to [Group Details] screen
    When User clicks on the 1st [Objective] item in Group's Objectives section
    And User clicks on the [Quick Actions] icon in Objective section
    And User clicks on [Update weight] option in Quick Actions menu
    Then [Update weight] popup displays
    
Scenario: Verify the components of [Update weight] popup
    Given User goes to [Group Details] screen
    When User clicks on the 1st [Objective] item in Group's Objectives section
    And User clicks on the [Quick Actions] icon in Objective section
    And User clicks on [Update weight] option in Quick Actions menu
    Then Title popup displays
    And Weight label and asterisk symbol displays
    And Weight textbox displays
    And Close button displays
    And Update button displays

Scenario: Verify the value in Weight textbox is correct with the Objective that user clicks on 
    Given User goes to [Group Details] screen
    When User clicks on the 1st [Objective] item in Group's Objectives section
    And User get the current Weight value of [Objective] item
    And User clicks on the [Quick Actions] icon in Objective section
    And User clicks on [Update weight] option in Quick Actions menu
    Then The value in Weight textbox equal to the Objective weight that user clicks on
    
Scenario Outline: Verify user is able to update Objective Weight successfully with "<value_type>"
    Given User goes to [Group Details] screen
    When User clicks on the 1st [Objective] item in Group's Objectives section
    And User clicks on the [Quick Actions] icon in Objective section
    And User clicks on [Update weight] option in Quick Actions menu
    And User updates "<valid_value>" into Weight textbox
    And User clicks on [Update] button
    Then [Update weight] popup closes
    
    Examples:
      | value_type			| valid_value		|
      | minimum value 	| 1							|
      | maximum value  	| 3							|
      | middle value  	| 5							|
      
Scenario: Verify Success message displays incase user updated Objective Weight successfully 
    Given User goes to [Group Details] screen
    When User clicks on the 1st [Objective] item in Group's Objectives section
    And User clicks on the [Quick Actions] icon in Objective section
    And User clicks on [Update weight] option in Quick Actions menu
    And User updates the valid value into Weight textbox 
    And User clicks on [Update] button
    Then [Update weight] popup closes
    And Success message displays
    
Scenario: Verify Objective Weight in Objective section is updated incase user updated Objective Weight successfully 
    Given User goes to [Group Details] screen
    When User clicks on the 1st [Objective] item in Group's Objectives section
    And User clicks on the [Quick Actions] icon in Objective section
    And User clicks on [Update weight] option in Quick Actions menu
    And User updates the valid value into Weight textbox 
    And User clicks on [Update] button
    Then [Update weight] popup closes
    And Objective Weight in Objective section is updated also
    
Scenario Outline: Verify user is not able to update Objective Weight with "<invalid_type>"
    Given User goes to [Group Details] screen
    When User clicks on the 1st [Objective] item in Group's Objectives section
    And User clicks on the [Quick Actions] icon in Objective section
    And User clicks on [Update weight] option in Quick Actions menu
    And User updates "<invalid_value>" into Weight textbox
    And User clicks on [Update] button
    Then The "<error_message>" displays
    
    Examples:
      | invalid_type										| value 	|error_message	|
      | alphabet character  						| abc			|error 1 				|
      | special character  							| !@$			|error 2 				|
      | negative number   							| -5			|error 3 				|
      | value is less than minimum   		|	0				|error 4 				|
      | value is greater than maximum 	| 6       |error 5 				|
      | space character									|        	|error 6 				|
     
Scenario: Verify user is not able to update Objective Weight successfully
    Given User goes to [Group Details] screen
    When User clicks on the 1st [Objective] item in Group's Objectives section
    And User clicks on the [Quick Actions] icon in Objective section
    And User clicks on [Update weight] option in Quick Actions menu
    And User updates the valid value into Weight textbox 
    And User clicks on [Close] button
    Then [Update weight] popup closes 
