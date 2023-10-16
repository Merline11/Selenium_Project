#Author: Axone
  Feature: User Login Feature
    In order to publish training articles
    As a trainer
    I want to access the student cloud login application

  Scenario: Successful login with valid credentials
    Given user is on the homepage
    When user navigates to signin page
    And user enters login credentials
    Then user is logged in successfully