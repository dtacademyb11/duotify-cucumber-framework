@api_only
@API
Feature: POST /user API endpoint features

  @api_test
  Scenario: Create a new user

    Given the request is authenticated with a valid API key
    And the request "Content-type" header is set to "application/json"
    And the request body is set to the following payload
      """
      {
        "username": "coolherc20559988",
        "firstName": "Cool",
        "lastName": "Herc",
        "email": "coolherc20559988@mail.com",
        "password": "coolherc"
      }
      """

    When I send a "POST" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 201
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 1000 ms
    And I delete the created user





