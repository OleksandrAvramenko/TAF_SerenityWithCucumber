@smoke
Feature: Product Items Scenarios
  As an User
  I want to able to add/remove Items to Cart
  So that I can select Products for future purchase

  @test-011
  Scenario: Verify Product Item Grid size
    Given User is on SwagLab Login Page
    When User login with 'STANDARD_USER' credentials
    Then Home Page is opened
    And Product Item Grid is displayed
    And Product Item Grid size equals 6

  @test-012
  Scenario: Verify Add to Cart functionality
    Given User is on SwagLab Login Page
    When User login with 'STANDARD_USER' credentials
    Then Home Page is opened
    When I add item with 'Sauce Labs Backpack' name to Cart
    Then Cart Items Badge count equals '1'