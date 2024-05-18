@UISmoke
Feature: Validate Login Functionality

  Scenario: Login with valid credentials
    Given launch the URL "https://www.saucedemo.com/"
    When enter username "standard_user" and password "secret_sauce"
    And click Login button
    Then verify user navigated to dashboard page


  Scenario: Login with Invalid credentials
    Given launch the URL "https://www.saucedemo.com/"
    When enter username "standard_user" and password "pass"
    And click Login button
    Then verify Error displayed