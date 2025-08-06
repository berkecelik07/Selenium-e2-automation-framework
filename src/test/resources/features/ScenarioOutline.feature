Feature: Scenario Outline Example

  @outline
  Scenario Outline: 
    When Login with "<username>" and "<password>"
    And Click on the Login button
    Then Validate that "<username>" is displayed
    And We want to say Bye "<fullname>"

    Examples: 
      | username | password | fullname       |
      | Scott    | s1234    | Scott Seyrek   |
      | Erhan    | e1234    | Erhan Gundogdu |
      | berkesolutionssolutions    | b1234    | berkesolutionssolutions Celik    |
      
