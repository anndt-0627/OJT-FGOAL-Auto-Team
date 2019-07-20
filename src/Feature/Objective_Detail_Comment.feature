Feature: Objective_Detail_Comment 
	Description: Objective Comment feature file

Background: Login successfully with valid WSM account 
	Given User is on Login page of Fgoal 
	When User perform action Login via WSM action 
	And User input valid email on WSM page 
	And User input valid password on WSM page 
	And User perform action Login on WSM page 
	Then User can login successfully to Fgoal via WSM 
	
@Invalid_case 
Scenario Outline: User can't submit an empty comment 
	Given User is on Dashboard screen 
	When User navigate to screen detail of "<Objective_Name>" 
	And User leave comment blank 
	And User perform add comment action 
	Then The blank comment isn't accepted 
	
	Examples: 
		|Objective_Name	|
		|ChauTTB_1		|
		
		@Valid_case 
		Scenario Outline: User can submit a valid comment on their 
			Given User is on Dashboard screen 
			When User navigate to screen detail of "<Objective_Name>" 
			And User input a "<Valid_Comment>" 
			And User perform add comment action 
			Then The comment user has just submit is displayed 
			And Number of comment is updated exactly 
			
			Examples: 
				|Objective_Name	|Valid_Comment		|
				|ChauTTB_1		|abc|
				|long content long content long content long content long content long content long content long content long content long content long content long content long content long content|
				
				@Valid_case 
				Scenario Outline: User can edit their own comment 
					Given User is on Dashboard screen 
					When User navigate to screen detail of "<Objective_Name>" 
					And User input "<Update_Valid_Comment>" 
					And User perform add comment action 
					Then The comment is updated 
					And Number of comment at icon text box is kept 
					
					Examples: 
						|Objective_Name	|Update_Valid_Comment	|
						|ChauTTB_1		|abc_updated			|
						
						@Valid_case 
						Scenario: User can delete their own comment 
							Given User is on Objective detail screen 
							When User click on icon text box in My Objectives 
							And User click on icon recycle bin of comment 
							Then The comment is deleted from objective 
							And Number of comment in their objective is updated exactly 
							
						@Valid_case 
						Scenario Outline:
						User can submit a valid comment on objective of other people 
							Given User is on Dashboard screen 
							When User navigate to screen objective detail of other people 
							And User try to input a "<Valid_Comment>"  for this objective 
							And User perform add comment action 
							Then The comment is accepted
							And Number of comment in objective is updated exactly 
							Examples: 
								|Valid_Comment	|
								|test			|