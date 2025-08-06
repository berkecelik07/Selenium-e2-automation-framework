@Login
Feature: Login Functionality

  Scenario: Valid Login
    #Given I navigated to the HRM Website
    When I enter a valid username
    And I enter a valid password
    And I click on the login button
    Then I validate that I am logged in

  #And I will quit the browser
  @smoke
  Scenario: Invalid Login
    #Given I navigated to the HRM Website
    When I enter a valid username
    And I enter an invalid password
    And I click on the login button
    Then I validate Invalid Credentials is displayed

  #And I will quit the browser
  @HW3_1
  Scenario Outline: Login using Scenario Outline and Examples Table
    When user enters login information "<username>" and "<password>"
    And I click on the login button
    Then verify that "<employeeName>" is showing

    Examples: 
      | username  | password  | employeeName |
      | superman1 | Clark1234 | Clark Kent   |
      | spiderman | Peter1234 | Peter Parker |

	@HW3_2
  Scenario: Login using DataTable
    When user enter username and password and clicks on the login button
      | username  | password  | employeeName |
      | superman1 | Clark1234 | Clark Kent   |
      | spiderman | Peter1234 | Peter Parker |
