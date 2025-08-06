@background 
Feature: Background Example

Background: 
	Given Precondition1
	And Precondition2
		
	Scenario: Example1
		When Test Step nr1
		And Test Step nr2
		And Test Step nr3
		Then Validation nr1
		And Validation nr2
		
	Scenario: Example2
		When Test Step nr4
		And Test Step nr5
		And Test Step nr6
		Then Validation nr3
		And Validation nr4
		
#----- Order of Execution -------
# Hooks --> @Before
# Background Steps
# Scenario: Example1
# Hooks --> @After 
#-------------------------------
#-------------------------------
# Hooks --> @Before
# Background Steps
# Scenario: Example2
# Hooks --> @After 





