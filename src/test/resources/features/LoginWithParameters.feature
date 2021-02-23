Feature: Login with parameters



@librarianParam
    Scenario: Login as Librarian 43
      Given I am on the login page
      When I enter username "librarian49@library"
      And I enter password  'xHdfRYuD'
      And click the sign in button
      And there should be 2841 users
      Then dashboard should be displayed


  @studentParam
  Scenario: Login as student 30
    Given I am on the login page
    When I enter username "student50@library"
    And I enter password  'doN2rYs3'
    And click the sign in button
    Then books should be displayed



  Scenario: Login as librarian same line
    Given I am on the login page
  When I login using "librarian60@library" and "OoNKtPqP"
    Then dashboard should be displayed


      # number can be whatever you have there
      # we should put "Then dashboard should be displayed" at the end because at that step we close Driver