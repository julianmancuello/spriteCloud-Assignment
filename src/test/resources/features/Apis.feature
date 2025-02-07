Feature: APIs Functionality

  Scenario: Get user list and check user data
    Given retrieve user list of page 1
    Then check user in position 3 is Emma Wong