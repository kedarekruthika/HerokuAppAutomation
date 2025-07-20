Feature: Get Product Details API

  Background:
    Given base URL is set

  Scenario Outline: Get product by valid ID
    When I request product ID <productId>
    Then status code should be 200
    And response should contain product ID <productId>

    Examples:
      | productId |
      | 9         |
      | 10        |
      | 11        |

  Scenario: Get product by invalid ID
    When I request product ID 99999
    Then status code should be 404
