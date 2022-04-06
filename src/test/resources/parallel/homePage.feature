Feature: Home Page Feature
  Background:
    Given user is on login page
    Given user has already loggedIn in to application
      | usernmae   | password |
      | mngr397522 | ypabypy  |


Scenario: Home page title
  Given user is on home page
  When user gets the title of the page
  Then page tile should be " Guru99 Bank Manager HomePage "
#
Scenario: Home page element counts
  Given  user is on home page
  Then  user get home page section list
    | Manager              |
    | New Customer         |
    | Edit Customer        |
    | Delete Customer      |
    | New Account          |
    | Edit Account         |
    | Delete Account       |
    | Deposit              |
    | Withdrawal           |
    | Fund Transfer        |
    | Change Password      |
    | Balance Enquiry      |
    | Mini Statement       |
    | Customised Statement |
    | Log out              |
  And section count should be 15

