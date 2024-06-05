@tag
Feature: To test the Orange HCM functionalities

  Scenario: Login to Orange hCM 
    Given Launch the Orange HCM website
    And Enter the valid credentials "Admin" and "admin123"
    When click on Login button
    Then It will take you to Home page



   