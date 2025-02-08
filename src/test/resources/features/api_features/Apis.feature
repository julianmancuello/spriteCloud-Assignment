@api-test
Feature: APIs Functionality

  Scenario: Get user list and check user data
    Given retrieve user list of page 1
    Then check user in position 3 is Emma Wong

  Scenario: User logs in successfully
    Given user logs in with credentials
    Then token was generated successfully

  Scenario: User tries to log in without password
    Given user logs in without password
    Then Missing password error message is retrieved

  Scenario: Modify user information successfully
    Given modify name to John and job to Developer for user with ID 3
    Then user information was changed to John and Developer