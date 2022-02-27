@Test123
Feature: Homepage scenarios

  @smoketest123
  Scenario: Verify ViewAll button on the homepage
    Given I launch the app '<shoppingApp>'
    And I find the homepage loaded
    When I click on ViewAll button
    Then I verify product listing page loaded
    
    Examples:
    |shoppingApp|
    |Flipkart|

  @smoke112
  Scenario Outline: Verify search functionality
    Given I launch the app '<shoppingApp>'
    And I find the homepage loaded
    When I click on ViewAll button
    Then I verify product listing page loaded
    When I search for an '<item>' from search field
    Then I verify the product listing page based on the search '<item>'
    And I verify the filter option on the product listing page
    
    Examples:
    |shoppingApp|item|
    |Flipkart|REDMI|
    
  @smoke
  Scenario Outline: Verify product description and seller rating
    Given I launch the app '<shoppingApp>'
    And I find the homepage loaded
    When I click on ViewAll button
    Then I verify product listing page loaded
    When I search for an '<item>' from search field
    Then I verify the product listing page based on the search '<item>'
    When I click on a product from the product listing page
    Then I verify the product description
    And I verify the seller rating
    
    Examples:
    |item|
    |REDMI|
    
    @smoke
  Scenario Outline: Verify Add to Cart functionality
    Given I launch the app '<shoppingApp>'
    And I find the homepage loaded
    When I click on ViewAll button
    Then I verify product listing page loaded
    When I search for an '<item>' from search field
    And I add two products to the cart
    Then I find the cart count is '<cartCount>'
    Examples:
    |item|cartCount|
    |REDMI|2|
    
  @smoke
  Scenario Outline: Verify Delete from Cart functionality
    Given I launch the app '<shoppingApp>'
    And I find the homepage loaded
    When I click on ViewAll button
    Then I verify product listing page loaded
    When I search for an '<item>' from search field
    And I add two products to the cart
    Then I find the cart count is '<cartCount>'
    When I delete one product from the cart
    Then I verify cart count is decreased to 1
    Examples:
    |item|cartCount|
    |REDMI|2|

    @demo
    Scenario: I verify regex for cucumber scenario
      Given I have a fruit "apple" whose price is 100
      And I have a vegetable "tomato" whose price is 200
      When I sell it in the shop
      Then I get double the price 200