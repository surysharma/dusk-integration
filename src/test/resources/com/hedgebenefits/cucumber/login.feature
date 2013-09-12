Feature: This features shows scenarios for admin login

  Background: User wants to go to company home page
    Given the User is on Hedge benefits page
    And the User clicks on the "Company Home" link
    And and the User is represented with login page

  Scenario Outline: The User enters an invalid username password
    When the invalid combination of <username> and <password> is given
    Then the User is presented the message "Invalid Username/Password"
  Examples:
    | username     | password |
    | invalidadmin | test     |

  Scenario Outline: The User enters a valid username password
    When the User give valid combination of <username> and <password> is given
    Then the User successfully goes to the company home page
  Examples:
    | username | password |
    | a        | a        |


  Scenario: The logged-in user should not not see login page again
    Given the User is on Hedge benefits page
    And the User is already logged in
    When the User clicks on the "Company Home" link
    Then the User successfully goes to the company home page
