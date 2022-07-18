Feature: Home Sliders Redirect to Specific pages

  Scenario: Navigate to Pages of first Sliders
    Given navigate to first slider Url
    Then check the result of first url "https://demo.nopcommerce.com/nokia-lumia-1020"


    Scenario: Navigate to Page of Second Sliders
    Given navigate to second url
    Then check the result of second url "https://demo.nopcommerce.com/iphone-6"