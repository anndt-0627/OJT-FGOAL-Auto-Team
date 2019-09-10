Feature: Objective_Key_Result_View 
	Description: File View a Key Result of Objective

Background: Login successfully with valid WSM account 
	Given User is on Login page of Fgoal 
	When User perform action Login via WSM action 
	And User input valid email on WSM page 
	And User input valid password on WSM page 
	And User perform action Login on WSM page 
	Then User can login successfully to Fgoal via WSM 
	
	
@Valid_case 
Scenario Outline: User can navigate to screen objective detail 
	Given User is on Dashboard screen 
	When User create a new Objective with "<Objective_Name>" and "<Objective_Weight>" 
	And User open objective details 
	And User click on button Add a new key result 
	Then Popup Add new key result for "<Objective_Name>" is displayed 
	
	Examples: 
		|Objective_Name	|Objective_Weight	|
		|ChauTTB_01		|3					|
		
		@Valid_case 
		Scenario Outline: User can create a new key result for objective 
			Given User is on Dashboard screen 
			When User create a new Objective with "<Objective_Name>" and "<Objective_Weight>" 
			And User open objective details 
			And User click on button Add a new key result 
			And Popup Add new key result for "<Objective_Name>" is displayed 
			And User input valid value for "<Keyresult_Name>" and "<Keyresult_Weight>" and "<Keyresult_Target>" and "<Keyresult_Unit>" 
			And User perform Add new key result action 
			Then A new key result of object is created 
			
			Examples: 
				|Objective_Name	|Objective_Weight	||Keyresult_Name|Keyresult_Weight	|Keyresult_Target	|Keyresult_Unit	|
				|ChauTTB_01		|3					|Keyresult_1	|3					|60					|%				|
				
				@Valid_case 
				Scenario Outline: Key result is displayed in screen Objective details 
					Given User is on Dashboard screen 
					When User create a new Objective with "<Objective_Name>" and "<Objective_Weight>" 
					And User open objective details 
					And User click on button Add a new key result 
					And Popup Add new key result for "<Objective_Name>" is displayed 
					And User input valid value for "<Keyresult_Name>" and "<Keyresult_Weight>" and "<Keyresult_Target>" and "<Keyresult_Unit>" 
					And User perform Add new key result action 
					And User open popup detail "<Keyresult_Name>" 
					Then Popup key result details is displayed with exactly "<Keyresult_Name>" 
					And "<Keyresult_Weight>" is displayed exactly 
					
					Examples: 
						|Keyresult_Name	|Keyresult_Weight	|
						|Keyresult_1	|3					|
						
						@Valid_case 
						Scenario Outline: Pop-up key result details is closed 
							Given User is on Dashboard screen 
							When User create a new Objective with "<Objective_Name>" and "<Objective_Weight>" 
							And User open objective details 
							And User click on button Add a new key result 
							And Popup Add new key result for "<Objective_Name>" is displayed 
							And User input valid value for "<Keyresult_Name>" and "<Keyresult_Weight>" and "<Keyresult_Target>" and "<Keyresult_Unit>" 
							And User perform Add new key result action 
							And User open popup detail "<Keyresult_Name>" 
							And User click on button Close 
							Then Pop-up key result details is closed 
							
							Examples: 
								|Keyresult_Name	|
								|Keyresult_1	|