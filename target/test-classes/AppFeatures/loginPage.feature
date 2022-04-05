Feature: Login page feature

  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be " Guru99 Bank Home Page "

  Scenario: Forgot Password link
    Given user is on login page
    Then forgot your password link should be displayed
#
  Scenario: Login with correct credentials
    Given user is on login page
    When user enters valid username as "mngr397522"
    And user enters password "ypabypy"
    And user clicks on Login button
    When user gets the title of the page
    And page title should be " Guru99 Bank Manager HomePage "