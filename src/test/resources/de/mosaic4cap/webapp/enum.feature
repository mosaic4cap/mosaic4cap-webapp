Feature: Test EnumUtil class
  Scenario: Get a Enum Type by its String name
    Given there is an enum
    When i search for Class type of "VALUE1"
    Then i should receive "TestEnum" type
    And it should print "This is a value"