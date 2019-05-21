
Feature: Add Objective function

Background: Open Add Objective form

  @invalid_case
  Scenario: Error message display when name is empty
    Given user is on Add Objective form
    When name is emty
    And User enters Weight value
    And User selects quarter value
    And Click Add Objective button
    Then Browser Alert message displays: Please fill out this field
    
  @invalid_case
	Scenario: Error message displays when target is empty
 		Given user is on Add Objective form
    When User enters valid name
    And Weight is empty
    And User selects quarter value
    And Click Add Objective button
    Then Browser Alert message displays: Please fill out this field
    
  @invalid_case
  Scenario Outline: Error message displays when target is invalid
    Given user is on Add Objective form
    When User enters valid name
    And User selects valid quarter
    And user enters weight is <value> in step
    Then Error message <content> displays

    Examples: 
      | value | content  |
      | value is less than 1 | Value must be less than or equal to 5 |
      | value is less than 5 | Value must be more than or equal to 1 |
      
	@valid_case
	Scenario Outline:
   Given user is on Add Objective form
    When User enters valid name
    And User enters valid weight
    And user select valid quarter 
    And User clicks Add Objecttive button
    Then Successfull message displays: Create successfull
    And Name, weight and quarter of new objective are matched with values user had seleted
    
  
