@api_only
@API
@DB

Feature: end to end scenarios involving api and db layers
  @test_api
  Scenario: Verify user creation
# create user with post request in the api layer
    Given the request is authenticated with a valid API key
    And the request "Content-type" header is set to "application/json"
    And the request body is set to the random values
    When I send a "POST" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 201
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 1000 ms
    And the user id is stored

#    verify created user in the db layer
   When I send a query to retrieve the user with the stored user id
   Then The user should exist in the database



