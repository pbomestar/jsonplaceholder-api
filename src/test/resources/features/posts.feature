Feature: JSONPlaceholder Posts API

  Scenario: Get all posts
    When I request all posts
    Then I receive status code 200

  Scenario Outline: Get a post by ID
    When I request post with ID = <id>
    Then I receive status code <code>

    Examples:
      | id  | code |
      | 1   | 200  |
      | 999 | 404  |

    Scenario: Get post comments
      When I request comments for post ID = 1
      Then I receive status code 200

  Scenario: Create a new post
    When I create a post with title "Hello World" and body "This is a test" for user 1
    Then I receive status code 201
    And the response title is "Hello World"