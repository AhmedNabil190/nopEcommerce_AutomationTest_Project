@smoke
Feature: Check that user can search for any proudct

  Background: user must Login First
    Given user navigate to Login page
    When type "abaashelmy@gmail.com" and "123123"
    And Click on Login button
    Then user logged in successfully

  Scenario Outline: user Search for An (product Name)
    Given user types on <Search Item> in Search Bar
    When user Click on Search button
    Then Search result must be appears <Search Item>
    Examples:
      | Search Item |
      | book        |
      | laptop      |
      | nike        |


 Scenario Outline: user Search for An (Sku)
    Given user types on <Search Item> in Search Bar
    When user Click on Search button
    Then Search result must be appearss <Search Item>
    Examples:
      | Search Item |
      | SCI_FAITH   |
      | APPLE_CAM   |
      | SF_PRO_11   |


