Feature: FGOAL_Object_Edit
  Description: Objective Edit feature file

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
    When User select quarter is current quarter
    And User click on an <ObjectiveName> in My Objectives
    Then User navigates to Objective Details screen successfully

	Examples:
      |OjectiveName	| 
      |ChauTTB		|


@Valid_case   
Scenario Outline: User can edit percent of objective user has done until current time with valid data
    Given User is on Objective Detail screen
    When User click on field percent of objective user has done
    And User enter a <ValidPercent> user has done into filed
    And User click outside of the field
    Then <ValidPercent> user has just input is accepted
    And New percent of objective user has done is updated
    And <Status> of objective is updated
    And Message update objective successfully is displayed

    Examples:
    |ValidPercent	|Status		|
    |0				|AtRisk		|
    |1				|AtRisk		|
    |29				|AtRisk		|
    |30				|BeHind		|
    |69				|BeHind		|
    |70				|OnTrack	|
    |99				|OnTrack	|
    |100			|Excellent	|


@Valid_case 
Scenario Outline: User can edit percent of objective user has done until current time when click on up-arrow of this field
    Given User is on Objective Detail screen
    When Each time user click on the up-arrow of field percent of objective user has done
    Then Percent of field objective user has done is increase 1 percent
    And New percent of objective user has done is updated
    And If <Percent> is updated then <Status> of objective is updated
    And Message update objective successfully is displayed

     Examples:
    |Percent	|Status		|
    |0				|AtRisk		|
    |1				|AtRisk		|
    |29				|AtRisk		|
    |30				|BeHind		|
    |69				|BeHind		|
    |70				|OnTrack	|
    |99				|OnTrack	|
    |100			|Excellent	|


@Valid_case 
Scenario Outline: User can edit percent of objective user has done until current time when click on down-arrow of this field
    Given User is on Objective Detail screen
    When Each time user click on the down-arrow of field percent of objective user has done
    Then Percent of field objective user has done is decrease 1 percent
    And New percent of objective user has done is updated
    And If <Percent> is updated then <Status> of objective is updated
    And Message update objective successfully is displayed

     Examples:
    |Percent		|Status		|
    |0				|AtRisk		|
    |1				|AtRisk		|
    |29				|AtRisk		|
    |30				|BeHind		|
    |69				|BeHind		|
    |70				|OnTrack	|
    |99				|OnTrack	|
    |100			|Excellent	|


@Valid_case 
Scenario Outline: User can edit weight of objective
    Given User is on Objective Detail screen
    When User click on field weight of objective
    And User enter a <ValidWeight> of objective
    And User click outside of the field
    Then <ValidWeight> user has just input is accepted
    And New weight of objective is updated
    And Message update objective successfully is displayed

    Examples:
    |ValidWeight	|
    |1				|
    |2				|
    |3				|
    |4				|
    |5				|


@Valid_case 
Scenario: User can edit weight of objective when click on up-arrow of this field
    Given User is on Objective Detail screen
    When Each time user click on the up-arrow of field weight of objective
    Then Weight of field objective is increase 1 unit
    And New weight of objective user has done is updated
    And Message update objective successfully is displayed


@Valid_case 
Scenario: User can edit weight of objective when click on down-arrow of this field
    Given User is on Objective Detail screen
    When Each time user click on the up-arrow of field weight of objective
    Then Weight of field objective is decrease 1 unit
    And New weight of objective user has done is updated
    And Message update objective successfully is displayed


@Invalid_case   
Scenario Outline: User can't edit percent of objective user has done until current time with invalid data
    Given User is on Objective Detail screen
    When User click on field percent of objective user has done
    And User enter a <InvalidPercent> user has done into field
    And User click outside of the field
    Then <InvalidPercent> user has just input isn't accepted
    And Error message is displayed

    Examples:
    |ValidWeight	|
    |-1				|
    |0.1			|
   	|101			|


@Invalid_case 
Scenario: User can't leave percent of objective user has done until current time is blank
    Given User is on Objective Detail screen
    When User  click on field percent of objective user has done and clear it
    And User click outside of the field
    Then Empty value isn't accepted
    And Error message is displayed


@Invalid_case 
Scenario: User can't edit weight of objective with invalid data
    Given User is on Objective Detail screen
    When User  click on field weight of objective and clear it
    And User click outside of the field
    Then Empty value isn't accepted
    And Error message is displayed


@Invalid_case 
Scenario Outline: User can't edit weight of objectiv with invalid data
    Given User is on Objective Detail screen
    When User click on field weight of objective
    And User enter a <InvalidWeight> user has done into field
    And User click outside of the field
    Then <InvalidWeidht> user has just input isn't accepted
    And Error message is displayed

    Examples:
    |ValidWeight	|
    |-1				|
    |0				|
   	|6				|