Feature: Quick Actions
  Description: Testing Change name Objective in Quick Actions      
      
#Scenario: Login FGoal
#    Given User goes to FGoal screen
#    When User clicks on [Login via WSM] button
#    And User perform Login
#    Then [Home] screen of FGoal display

Scenario: Verify the [Change name] popup show up when selecting [Change name] option in Quick Actions menu
    Given User goes to [Group Details] screen
    When User clicks on the 1st [Objective] item in Group's Objectives section
    And User clicks on the [Quick Actions] icon in Objective section
    And User clicks on [Change name] option in Quick Actions menu
    Then [Change name] popup displays
    
Scenario: Verify the components of [Change name] popup
    Given User goes to [Group Details] screen
    When User clicks on the 1st [Objective] item in Group's Objectives section
    And User clicks on the [Quick Actions] icon in Objective section
    And User clicks on [Change name] option in Quick Actions menu
    Then Title popup displays
    And Name label and asterisk symbol displays
    And Name textbox displays
    And Close button displays
    And Update button displays

Scenario: Verify the value in Name textbox is correct with the Objective that user clicks on  
    Given User goes to [Group Details] screen
    When User get the value of the 1st [Objective] item
    And User clicks on the 1st [Objective] item in Group's Objectives section
    And User clicks on the [Quick Actions] icon in Objective section
    And User clicks on [Change name] option in Quick Actions menu
    Then The value in Name textbox equal to the Objective name that user clicks on
    
Scenario Outline: Verify user is able to update Objective Name successfully with "<character_type>"
    Given User goes to [Group Details] screen
    When User clicks on the 1st [Objective] item in Group's Objectives section
    And User clicks on the [Quick Actions] icon in Objective section
    And User clicks on [Change name] option in Quick Actions menu
    And User updates "<valid_value>" into Name textbox
    And User clicks on [Update] button
    Then [Change name] popup closes
    
    Examples:
      | character_type			| valid_value 								|
      | alphabet character 	| Improve soft kill			|
      | numeric character  	| Improve skill 123			|
      | special character  	| Improve skill !@$%		|
      | HTML tag						| <b>Improve skill</b> 	|
      
Scenario: Verify Success message displays incase user updated Objective Name successfully 
    Given User goes to [Group Details] screen
    When User clicks on the 1st [Objective] item in Group's Objectives section
    And User clicks on the [Quick Actions] icon in Objective section
    And User clicks on [Change name] option in Quick Actions menu
    And User updates the valid value into Name textbox 
    And User clicks on [Update] button
    Then [Change name] popup closes
    And Success message displays
    
Scenario: Verify Objective Name in Objective section is updated incase user updated Objective Name successfully 
    Given User goes to [Group Details] screen
    When User clicks on the 1st [Objective] item in Group's Objectives section
    And User clicks on the [Quick Actions] icon in Objective section
    And User clicks on [Change name] option in Quick Actions menu
    And User updates the valid value into Name textbox 
    And User clicks on [Update] button
    Then [Change name] popup closes
    And Objective Name in Objective section is updated also
    
Scenario Outline: Verify user is not able to update Objective Name with "<invalid_type>"
    Given User goes to [Group Details] screen
    When User clicks on the 1st [Objective] item in Group's Objectives section
    And User clicks on the [Quick Actions] icon in Objective section
    And User clicks on [Change name] option in Quick Actions menu
    And User updates "<invalid_value>" into Name textbox
    And User clicks on [Update] button
    Then The "<error_message>" displays
    
    Examples:
      | invalid_type						| invalid_value						|error_message		|
      | Objective is existed   	| Improve soft kill				|error 1 					|
      | It's Key ressult    		|	Improve communication		|error 2 					|
      | Space character    			|                   			|error 3 					|
     
Scenario: Verify user is not able to update Objective Name successfully
    Given User goes to [Group Details] screen
    When User clicks on the 1st [Objective] item in Group's Objectives section
    And User clicks on the [Quick Actions] icon in Objective section
    And User clicks on [Change name] option in Quick Actions menu
    And User updates the valid value into Name textbox 
    And User clicks on [Close] button
    Then [Change name] popup closes 
