@Login
Feature: To test Login functionality
	
  @Test_Id_03
  Scenario Outline: Login with remember me as pre-selected
    Given user launches browser in "chrome"
    And user verify landing page is displayed
    When user click on the Login link
    Then verify title of the Login page
    And user enter "<email>" and "<password>" on the page
    And user click on the Login button
    And close browser
		
    Examples: 
      | email 								| password  |
      | testuser011@gmail.com | testuser 	|
