Feature: Comparing the books that user has from API and from UI

  @wip
  Scenario: Getting the list of Books that the user has with GET request from API
    When user sends GET request to "apiGetUser" endpoint
    Then Status code is 200
    And user gets the list of books that are registered to them