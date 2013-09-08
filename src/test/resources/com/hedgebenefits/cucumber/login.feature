Feature: This features shows scenarios for admin login

  Background: User wants to go to company home page
    Given the User is on Admin page
    And the User clicks on the "Company Home" link
    And and the User is represented with login page

  Scenario Outline: The User enters an invalid username password
    When the invalid combination of <username> and <password> is given
    Then the User is presented the message "Invalid username/password"
  Examples:
    | username     | password    |
    | invalidadmin | test        |
    | admin        | invalidtest |


  Scenario Outline: The User enters a valid username password
    When the User give valid combination of <username> and <password> is given
    Then the User successfully goes to the company home page
  Examples:
    | username | password |
    | admin    | test     |