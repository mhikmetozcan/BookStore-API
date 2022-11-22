Feature: Comparing the books that user has from API and from UI


  Background: Sending Post request to generate a Token
    When user sends POST request to "apiGenerateToken" endpoint
    And Token and expiry date are captured
    Then There are more than 5 days to expiry
    And Status code is 200
    And Status is success in the response body
    And "User authorized successfully." message is included in the response body

  @wip
  Scenario: Getting the list of Books that the user has with GET request from API
    When user sends GET request to "apiGetUser" endpoint
    And user navigates to login page
    And user enters login credentials
    And user clicks on "login" button
    Then Status code is 200
    And user gets the list of books that are registered to them and verifies each book appears on their profile




