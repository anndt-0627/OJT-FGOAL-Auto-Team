Feature: Objective_Key_Result_Edit 
	Description: File edit Key Result of Objective

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
	And User click on "<Objective_Name>" item in My Objectives 
	Then User navigates to Objective Details screen successfully 
	
	Examples: 
		|Objective_Name	|Objective_Weight	|
		|ChauTTB_02		|3					|
		
		@Valid_case 
		Scenario Outline: User can open pop-up Add new key result for objective 
			Given User is on Objective Details screen 
			When User open screen create new key result 
			Then Pop-up Add new key result for "<Objective_Name>" is displayed 
			
			Examples: 
				|Objective_Name	|
				|ChauTTB_02		|
				
				@Valid_case 
				Scenario Outline: User can create a new key result for objective 
					Given Given User is on Objective Details screen 
					When User open screen Add a new key result 
					And User input "<Keyresult_Name>" 
					And User input "<Keyresult_Weight>" 
					And User input "<Keyresult_Target>" 
					And User select "<Keyresult_Unit>" 
					And User perform action create new key result 
					Then A new key result of object is created 
					
					Examples: 
						|Keyresult_Name	|Keyresult_Weight	|Keyresult_Target	|Keyresult_Unit	|
						|Keyresult_1	|3					|60					|%				|
						
						@Valid_case 
						Scenario Outline: 
							User can edit name of key result
							Given Given User is on Objective Details screen 
							When User open screen edit of "<Keyresult_Name>" 
							And User input "<New_Keyresult_Name>" 
							And User perform action edit name of key result 
							Then Name of key result is updated 
							
							Examples: 
								|Keyresult_Name	|New_Keyresult_Name	|
								|Keyresult_1	|Keyresult_updated	|
								
								@Valid_case 
								Scenario Outline: 
									User can edit weight of key result
									Given Given User is on Objective Details screen 
									When User open screen edit of "<Keyresult_Name>" 
									And User input "<New_Keyresult_Weight>" 
									And User perform action edit name of key result 
									Then Weight of key result is updated 
									
									Examples: 
										|Keyresult_Name	|New_Keyresult_Weight	|
										|Keyresult_1	|2						|
										
										@Valid_case 
										Scenario Outline: 
											User can edit target of key result
											Given Given User is on Objective Details screen 
											When User open screen edit of "<Keyresult_Name>" 
											And User input "<New_Keyresult_Target>" 
											And User perform action edit name of key result 
											Then Weight of key result is updated 
											
											Examples: 
												|Keyresult_Name	|New_Keyresult_Target	|
												|Keyresult_1	|50						|
												
												@Valid_case 
												Scenario Outline: 
													User can edit unit of key result
													Given Given User is on Objective Details screen 
													When User open screen edit of "<Keyresult_Name>" 
													And User input "<New_Keyresult_Unit>" 
													And User perform action edit name of key result 
													Then Weight of key result is updated 
													
													Examples: 
														|Keyresult_Name	|New_Keyresult_Unit	|
														|Keyresult_1	|kg					|