@smoke
Feature:User Can Add Different Items To cart
  Background: user must Login first
    Given user navigate to Login page
    When type "abaashelmy@gmail.com" and "123123"
    And Click on Login button
    Then user logged in successfully

    Scenario: adding Two Different Products to Shopping Cart
      Given navigate to cell phone page
      When choose first item
      And Click on add to cart to add first item and check alert message
      And navigate to home page
      And check  first item was added
      And navigate to shoes page
      And choose Seccond item
      And Seclect size of second item
      And Select color of second item
      And click on Add to cart button to Add second item and check alert message
      And navigate to home page again
      And check the second Item Was Added
      And navigate to shooping cart page
      Then first and second item was addedd successfully


