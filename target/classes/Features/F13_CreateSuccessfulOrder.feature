@smoke
Feature: user complete His purchase successfully
  Background: user must Login first
    Given user navigate to Login page
    When type "abaashelmy@gmail.com" and "123123"
    And Click on Login button
    And user logged in successfully
    And navigate to cell phone page
    And choose first item
    And Click on add to cart to add first item and check alert message
    Then navigate to home page

    Scenario: user complete process to check out (Happy Scenario)
      Given user Navigate To shoppping cart
      When user Choose Gift Graping
      And fill check box of agreement
      And press on Check Out
      And Fill remaining mandatory fields
      And Choose Shipping Method
      And Press continue2
      And Choose Pyament Method
      And press continue3
      And Check payment info url
      And press continue4
      And Check url confirmation and items to be order
      And press confirm
      Then order should crated successfully