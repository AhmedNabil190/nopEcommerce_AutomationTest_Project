@smoke
Feature: Adding an item to cart from WishList page
  Background: user must login and add item to cart
    Given user navigate to Login page
    When type "abaashelmy@gmail.com" and "123123"
    And Click on Login button
    Given go to item page
    When click on add to wish list and check alert message
    And go back to home page
    And go to Wish List Page
    Then Items Added successfully

    Scenario: adding one item to cart from wishlist page
      Given fill check box
      When press on button add to cart
      And Check navigation to cart page
      Then check item is added to cart successfully