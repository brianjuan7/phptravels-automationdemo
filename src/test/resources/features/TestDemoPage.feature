@phptravels-full-suite @phptravels-demo-page
Feature: Test all functionalities in phptravels Demo page

  Background: User is in Demonstration page
    Given I visit phptravels Home page
    And I click "Demo" in menu
    And I should be able to see phptravels Demo page

  @demo-page-positive-scenarios
  Scenario: Demo Request Form should be successfully submitted
    When I input all Demo Request Form fields
      | Field        | Value        |
      | FirstName    | use-faker    |
      | LastName     | use-faker    |
      | BusinessName | TestBusiness |
      | Email        | use-faker    |
    And I input addition result
    And I click Submit
    Then I should be able to see successful request form message

  @demo-page-negative-scenarios
  Scenario: Demo Request Form should not be submitted when result is not entered
    When I input all Demo Request Form fields
      | Field        | Value        |
      | FirstName    | use-faker    |
      | LastName     | use-faker    |
      | BusinessName | TestBusiness |
      | Email        | use-faker    |
    And I click Submit
    Then the "No Result Number" alert box should be displayed

  @demo-page-negative-scenarios
  Scenario: Demo Request Form should not be submitted when first name is not entered
    When I input all Demo Request Form fields
      | Field        | Value        |
      | LastName     | use-faker    |
      | BusinessName | TestBusiness |
      | Email        | use-faker    |
    And I input addition result
    And I click Submit
    Then the "No First Name" alert box should be displayed

  @demo-page-negative-scenarios @no-last-name
  Scenario: Demo Request Form should not be submitted when last name is not entered
    When I input all Demo Request Form fields
      | Field        | Value        |
      | FirstName    | use-faker    |
      | BusinessName | TestBusiness |
      | Email        | use-faker    |
    And I input addition result
    And I click Submit
    Then the "No Last Name" alert box should be displayed

  @demo-page-negative-scenarios
  Scenario: Demo Request Form should not be submitted when business name is not entered
    When I input all Demo Request Form fields
      | Field     | Value     |
      | FirstName | use-faker |
      | LastName  | use-faker |
      | Email     | use-faker |
    And I input addition result
    And I click Submit
    Then the "No Business Name" alert box should be displayed

  @demo-page-negative-scenarios
  Scenario: Demo Request Form should not be submitted when email is not entered
    When I input all Demo Request Form fields
      | Field        | Value        |
      | FirstName    | use-faker    |
      | LastName     | use-faker    |
      | BusinessName | TestBusiness |
    And I input addition result
    And I click Submit
    Then the "No Email" alert box should be displayed