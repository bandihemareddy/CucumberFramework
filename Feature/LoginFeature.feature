Feature: Login
  
  Scenario: Successful login with user Credentials
    Given User Launch Chrome browser
    When User opend URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User clicks on Log out link
    Then Page Title should be "Your store. Login"
    And Close browser
