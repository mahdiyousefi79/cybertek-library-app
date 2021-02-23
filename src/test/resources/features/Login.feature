Feature: Login feature

  As I user, I should be able to login


@librarian
  Scenario: Login in as Librarian
    Given I am on the login page
    When I login as librarian
    Then dashboard should be displayed

@student
  Scenario: Login in as a student
    Given I am on the login page
    When I login as student
    Then books should be displayed



