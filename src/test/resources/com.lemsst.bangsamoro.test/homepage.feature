Feature: Homepage Feature
  User should be able to visit the home page

  Scenario Outline: Home page is displayed after logging in
    Given user visits the Homepage
    When I check the Page Title
    Then I should see "<page_title>"

    Examples:
    | page_title |
    |Home - GOV.P |
    |Home - GOV.PH|