Feature: Json Utils class

  Scenario: Convert a Object into a JSONString
    Given there is a TestObject
    When i convert it to json
    Then its of type string
    And its not empty

  Scenario: Convert a JSONString into TestObject
    Given there is a String
    When i convert it to object
    Then its of type TestObject
    And i can read its value "Test"