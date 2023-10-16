#Author: Merline
Feature: Examples Sample
  In order to learn cucumber outline scenario

Background: launch browser and establish db connection
  Given a chrome browser is launched
  Given database connection is established

  Scenario Outline: eating cucumbers
    Given there are <start> cucumbers
    When I eat <eat> cucumbers
    Then I should have <left> cucumbers
    But I should not have <negative> cucumbers
    Examples:
      | start | eat | left | negative |
      | 12    | 5   | 7    | 0        |
      | 20    | 5   | 15   | 0        |

