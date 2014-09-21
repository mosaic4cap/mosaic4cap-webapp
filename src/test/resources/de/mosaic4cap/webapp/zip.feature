Feature: Zip Util class

  Scenario: can download and read zip file
    Given a zipUrl "https://github.com/Lobedan/angular-d3/archive/master.zip"
    Then it can be downloaded
    And it can be read as ZipInputStream
    And delete from local