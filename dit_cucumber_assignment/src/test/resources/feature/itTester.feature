#Author: Merline
    #Scenario: Life of an IT good Tester
     # Given I am a good tester
      #When I complete my tasks
      #And find important bugs
      #Then My Manager rewards me
      #But Developer hates me

    #Scenario: Life of an IT bad Tester
     # Given I am a bad tester
      #When I incomplete my tasks
      #And find unimportant bugs
      #Then My Manager hates me
Feature: IT Tester Feature
   In order to establish my testing skills
   As a Tester
   I want to be a successful in IT Profession
  Scenario Outline: Life of an IT Tester
    Given I am a "<testerType>" tester
    When I "<completion>" my tasks
    And find "<severity>" bugs
    Then My Manager "<compliment>" me
    But Developer "<rating>" me
    #And I verify the pass
    #And I verify the fail
    Examples:
      | testerType | completion | severity    | compliment | rating |
      | good       | complete   | important   | rewards    | hates  |
      | bad        | incomplete | unimportant | hates      | loves  |


