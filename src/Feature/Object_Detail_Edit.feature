Feature: Object_Detail_Edit 
	Description: Objective View feature file
  
Background: Login successfully with valid WSM account 
	Given User is on Login page of Fgoal 
	When User perform action Login via WSM action 
	And User input valid email on WSM page 
	And User input valid password on WSM page 
	And User perform action Login on WSM page 
	Then User can login successfully to Fgoal via WSM 
	
	
@Valid_case 
Scenario Outline: 
	User can edit percent of objective user has done until current time with valid data 
	Given User is on Dashboard screen 
	When User navigate to screen detail of "<Objective_Name>" 
	And User open popup Configure the objective calculation progress 
	And User select item Update progress manual 
	And User input <Valid_Percent> for progress value and perform action update 
	Then New "<Valid_Percent>" of objective is accepted 
	And "<Status>" of objective is changed 
	
	Examples: 
		|Ojective_Name	|Valid_Percent	|Status			|
		|ChauTTB_01	 	|0				|AtRisk			|
		|30				|BeHind			|
		
		@Valid_case 
		Scenario Outline: User can edit weight of objective 
			Given User is on Dashboard screen 
			And User navigate to screen detail of "<Objective_Name>" 
			When User change "<Weight>" of objective and perform action update 
			Then New "<Weight>" of objective is updated 
			
			Examples: 
				|Weight			|Objective_Name	|
				|1				|ChauTTB_01	 	|
				|2				|				|
				|3				|				|
				|4				|				|
				|5				|				|
				
		@Valid_case 
		Scenario Outline: User can edit progress of objective 
			Given User is on Dashboard screen 
			And User navigate to screen detail of "<Objective_Name>" 
			When User change "<Progress>" of objective and perform action update 
			Then New "<Progress>" of objective is updated 
			And New "<Status>" of objective is also updated
			
			Examples: 
				|Ojective_Name	|Progress		|Status			|
				|ChauTTB_01	 	|0				|AtRisk			|
								|29				|AtRisk			|
								|30				|Behind			|
								|69				|Behind			|
								|70				|On track		|
								|99				|On track		|
								|100			|Excellent		|