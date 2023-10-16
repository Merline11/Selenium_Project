#Author: Merline
Feature: Registration Feature
  In order to register in Axone
  As a User
  I want to access the Axone Portal
  Scenario Outline: Registration in Axone
    Given I am on axone-tech.co.uk registration page
    When I enter username "<username>"
    When I enter password <password>
    When I enter mobilenumber <mobile-number>
    Then registration should be "<result>"
    Examples:
      | username | password | mobile-number | result       |
      | merline  | 1234     | 98564         | Successful   |
      | xyz      | 0000     | 78962         | Unsuccessful |


