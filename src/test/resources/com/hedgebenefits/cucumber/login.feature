Feature: This features shows scenarios for admin login

  Scenario Outline: User is not logged but enter invalid username/password
    Given the User is on Hedge benefits page
    And the User clicks on the "Company Home" link
    And and the User is represented with login page
    But the invalid combination of <username> and <password> is given
    Then the User is presented the message "Invalid Username/Password"
  Examples:
    | username     | password |
    | invalidadmin | test     |

  Scenario Outline: User is not logged in and enters a valid username password
    Given the User is on Hedge benefits page
    And the User clicks on the "Company Home" link
    And and the User is represented with login page
    When the User give valid combination of <username> and <password> is given
    Then the User successfully goes to the company home page
  Examples:
    | username | password |
    | a        | a        |


  @login
  Scenario: The logged-in user should not not see login page again
    Given the User is already logged in with following credentials
      | username | password |
      | a        | a        |
    And the User is on Hedge benefits page
    When the User clicks on the "Company Home" link
    Then the User successfully goes to the company home page
    And the User should be able to see the "Logout" link
