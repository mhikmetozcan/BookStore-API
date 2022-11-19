Feature: Creating a user for the bookstore via API and verify the frontend

  Scenario: Creating a new user using POST request via API
    When user sends POST request to apiUSER endpoint
    Then Status code is 201
    And userID captured and verified
    And userName is correct

    Scenario: Verify created user can login to the system.
      Given user navigates to login page
      When user enters login credentials
      And user clicks on "login" button
      Then user is logged in