Feature: Objective_Key_Result_Add_New 
	Description: File add new Key Result for Objective

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
				
				@Invalid_case 
				Scenario Outline: 
					User can't create a new key result for objective if leave key result name blank 
					Given User is on Dashboard screen 
					When User create a new Objective with "<Objective_Name>" and "<Objective_Weight>" 
					And User open objective details 
					And User click on button Add a new key result 
					And Popup Add new key result for "<Objective_Name>" is displayed 
					And User leave key result name blank and input valid value for "<Keyresult_Weight>" and "<Keyresult_Target>" and "<Keyresult_Unit>" 
					And User perform Add new key result action 
					Then An "<Error_Message>" is displayed at field Key result name 
					
					Examples: 
						|Keyresult_Weight	|Keyresult_Target	|Keyresult_Unit	|Error_Message			|
						|3					|60					|%				|This field is required.| 
						
						@Invalid_case 
						Scenario Outline: 
							User can't create anew key result for objective if leave key result weight blank 
							Given User is on Dashboard screen 
							When User create a new Objective with "<Objective_Name>" and "<Objective_Weight>" 
							And User open objective details 
							And User click on button Add a new key result 
							And Popup Add new key result for "<Objective_Name>" is displayed 
							And User leave key result target blank and input valid value for "<Keyresult_Name>" and "<Keyresult_Weight>" and "<Keyresult_Unit>" 
							And User perform Add new key result action 
							Then An "<Error_Message>" is displayed at field Key result target 
							
							Examples: 
								|Keyresult_Name	|Keyresult_Weight	|Keyresult_Unit	|Error_Message			|
								|Keyresult_1	|3					|%				|This field is required.|
								
								@Invalid_case 
								Scenario Outline: 
									User can't create anew key result for objective if leave both key result name and key result weight blank 
									Given User is on Dashboard screen 
									When User create a new Objective with "<Objective_Name>" and "<Objective_Weight>" 
									And User open objective details 
									And User click on button Add a new key result 
									And Popup Add new key result for "<Objective_Name>" is displayed 
									And User leave key result name and target  blank and input valid value for "<Keyresult_Weight>" and "<Keyresult_Unit>" 
									And User perform Add new key result action 
									Then "<Error_Message1>" and "<Error_Message2>" are displayed
									
									Examples: 
										|Error_Message1			|Error_Message2			|
										|This field is required.|This field is required.|