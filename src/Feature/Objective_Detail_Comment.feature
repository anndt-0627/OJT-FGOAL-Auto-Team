Feature: ObjectDetails_Comment 
	Description: Objective Comment feature file

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
	When User select <Objective> in My Objectives 
	And User click on icon text box in My Objectives 
	Then Text box comment of objective is displayed 
	
	Examples: 
		|Objective		|
		|ChauTTB_01		|
		
		
		@Valid_case 
		Scenario Outline: User can push a valid comment 
			Given User is on Dashboard screen 
			When User select <Objective> in My Objectives 
			And User click on icon text box in My Objectives 
			And User input a <ValidComment> 
			And User perform add comment action 
			Then The <ValidComment> user has just submit is displayed 
			And Number of comment is updated exactly 
			
			Examples: 
				|Objective		|ValidComment	|
				|ChauTTB_01		|test comment	|
				
				
				@Valid_case 
				Scenario Outline: User can push a comment with long omment 
					Given User is on Dashboard screen 
					When User select <Objective> in My Objectives 
					And User click on icon text box in My Objectives 
					And User input a <LongComment> 
					And User perform add comment action 
					Then The <LongComment> user has just submit is displayed 
					
					Examples: 
						|Objective		|LongComment	|
						|ChauTTB_01		|aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa	|
						
						
						@Valid_case 
						Scenario Outline: User can edit a comment 
							Given User is on Dashboard screen 
							When User select <Objective> in My Objectives 
							And User click on icon text box in My Objectives 
							And User input a <ValidComment> 
							And User perform add comment action 
							And The <ValidComment> user has just submit is displayed 
							And User update <Newcomment>
							Then The <Newcomment> user has just submit is displayed
							
							Examples: 
								|Objective		|ValidComment	|NewComment|
								|ChauTTB_01		|test comment	|test comment updated| 
								
								@Valid_case 
								Scenario: User can delete a comment 
									Given User is on Objective detail screen 
									When User click on icon text box in My Objectives 
									And User click on icon recycle bin of a comment 
									Then The comment is deleted 