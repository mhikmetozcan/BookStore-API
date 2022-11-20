Feature: Add a book to user account

  @wip
  Scenario: Sending post request to add a book to the user account
    When user sends POST request to "apiAddBook" endpoint
    Then Status code is 201
    And ISBN exist in the response body