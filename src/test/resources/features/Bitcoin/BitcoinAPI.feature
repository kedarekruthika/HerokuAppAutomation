Feature: Validate Bitcoin API Response from CoinGecko

  Scenario: Verify bitcoin API response details
    Given the CoinGecko Bitcoin API is available
    When I send a GET request to the bitcoin endpoint
    Then the response should contain BPI currencies as USD, GBP, and EUR
    And the market cap should be present for all 3 currencies
    And the total volume should be present for all 3 currencies
    And the price change percentage over the last 24 hours should be available
    And the homepage URL should not be empty