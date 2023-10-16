#Author: Merline
Feature: Signin Feature
  In order to sign in Axone Portal

  Background: launch browser and registration
    Given a browser is launched
    And Registration and creating an account

  Scenario: Successful login
    And user is on the homepage
    When user clicks Sign-in link
    And user enters login credentials
    Then user should see name appears in Top menu
    When user clicks Logout
    Then user should see Sign-in link