Feature: Test HomeController Class

  Scenario: Do access index page
    Given initialized HomeController
    When user enters /
    Then template with name index will be displayed

  Scenario: Access start page redirect to index
    Given initialized HomeController
    When user enters /start
    Then template with name index will be displayed

  Scenario: Access home page redirect to index
    Given initialized HomeController
    When user enters /home
    Then template with name index will be displayed