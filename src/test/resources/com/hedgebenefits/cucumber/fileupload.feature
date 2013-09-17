Feature: As a Company Admin I want to upload a csv file for Data-in

  Scenario: A CVS file is uploaded to specified location
    Given An Authenticated user with following credentials uploads a file
      | username | password |
      | a        | a        |
    Then the file should be uploaded at a specified location
      | dir   |
      | /tmp/ |