Feature: Generating a Token for the User


  Scenario: Sending Post request to generate a Token
    When user sends POST request to "apiGenerateToken" endpoint
    And Token and expiry date are captured
    Then There are more than 5 days to expiry
    And Status code is 200
    And Status is success in the response body
    And "User authorized successfully." message is included in the response body
