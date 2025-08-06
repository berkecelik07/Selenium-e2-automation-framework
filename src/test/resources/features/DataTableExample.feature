Feature: Scenario with DataTable
@dataTable
  Scenario: Add Employee with DataTable
    When I login to the HRMs
    And I want to add Employees
      | FirstName | MiddleName | LastName |
      | Mohamed   | Y          | Ghazy    |
      | Mucteba   | B          | Yuksel   |
      | Hassan    | G          | Aldoori  |
    Then I validate employee is added
    
    
  