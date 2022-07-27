Feature: Search Vacancy Test

	Scenario: search job vacancy
		Given User on the Home Page
		When User type job vacancy ""
		And User click search job
		Then User get validate ""
		
		