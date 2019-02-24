Feature: MODULE_TS001 : Successful log in
  Scenario Outline: Successful log in
    Given Navigate to the "Home page"
    When I sign in with "<USERNAME>" and "<PASSWORD>"
    Then System navigate to "Logged in page"

    Examples:
      | USERNAME          | PASSWORD     |
      | lmorningstar578   | Password123  |
      | lmorningstar578   | Password123  |

