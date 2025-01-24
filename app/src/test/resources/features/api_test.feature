Feature: API Testing with RestAssured

  Scenario: Verify the status code of a GET request
    Given I send a GET request to "https://jsonplaceholder.typicode.com/posts/1"
    Then the response status code should be 200
    And the response body should contain "userId"

  Scenario: Verify the response body of a GET request
    Given I send a GET request to "https://jsonplaceholder.typicode.com/posts/1"
    Then the response body should contain "id" with value "1"
    And the response body should contain "userId" with value "1"

  Scenario: Verify the response of a POST request
    Given I send a POST request to "https://jsonplaceholder.typicode.com/posts" with the following body:
      """
      {
        "title": "foo",
        "body": "bar",
        "userId": 1
      }
      """
    Then the response status code should be 201
    And the response body should contain "id"
    And the response body should contain "title" with value "foo"
    And the response body should contain "body" with value "bar"
    And the response body should contain "userId" with value "1"

  Scenario: Verify the response of a PUT request
    Given I send a PUT request to "https://jsonplaceholder.typicode.com/posts/1" with the following body:
      """
      {
        "id": 1,
        "title": "updated title",
        "body": "updated body",
        "userId": 1
      }
      """
    Then the response status code should be 200
    And the response body should contain "title" with value "updated title"
    And the response body should contain "body" with value "updated body"

  Scenario: Verify the response of a DELETE request
    Given I send a DELETE request to "https://jsonplaceholder.typicode.com/posts/1"
    Then the response status code should be 200