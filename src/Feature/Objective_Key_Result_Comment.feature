Feature: Objective_Key_Result_Comment 
	Description: Objective Comment of Ket Result feature file

Background: Login successfully with valid WSM account 
	Given User is on Login page of Fgoal 
	When User perform action Login via WSM action 
	And User input valid email on WSM page 
	And User input valid password on WSM page 
	And User perform action Login on WSM page 
	Then User can login successfully to Fgoal via WSM 
	
@Invalid_case 
Scenario Outline: User can't submit an empty comment for key result 
	Given User is on Dashboard screen 
	When User navigate to screen detail of "<Objective_Name>" and "<Objective_Keyresult>" 
	And User leave comment blank for key result 
	And User perform add comment action 
	Then The blank comment isn't accepted 
	
	Examples: 
		|Objective_Name	|Objective_Keyresult|
		|ChauTTB_1		|Keyresult_1		|	
		
		@Valid_case 
		Scenario Outline: User can submit a valid comment for key result 
			Given User is on Dashboard screen 
			When User navigate to screen detail of "<Objective_Name>" and "<Objective_Keyresult>" 
			And User input a "<Valid_Comment_Keyresult>" for key result 
			And User perform action add comment for key result 
			Then The comment of key result user has just submit is displayed 
			And Number comment of key result is updated exactly 
			
			Examples: 
				|Objective_Name	|Objective_Keyresult|Valid_Comment_Keyresult|
				|ChauTTB_1		|Keyresult_1		|abc|
				|long content long content long content long content long content long content long content long content long content long content long content long content long content long content|
				
				@Valid_case 
				Scenario Outline: User can edit their own comment for key result 
					Given User is on Dashboard screen 
					When User navigate to screen detail of "<Objective_Name>" and "<Objective_Keyresult>" 
					And User input a new "<Update_Valid_Comment>" for keyresult 
					And User perform action add comment for key result 
					Then The new comment of key result user has just submit is displayed 
					And Number comment of key result at icon text box is kept 
					
					Examples: 
						|Objective_Name	|Objective_Keyresult|Update_Valid_Comment|
						|ChauTTB_1		|Keyresult_1		|abc_updated|
						
						@Valid_case 
						Scenario Outline: User can delete their own comment of key result 
							Given User is on Objective detail screen 
							When User navigate to screen detail of "<Objective_Name>" and "<Objective_Keyresult>" 
							And User delete a "<Valid_Comment_Keyresult>" of key result 
							Then The comment of key result is deleted 
							And Number of comment in their objective key result is updated exactly 
							
							Examples: 
								|Objective_Name	|Objective_Keyresult|Update_Valid_Comment|
								|ChauTTB_1		|Keyresult_1		|abc_updated|