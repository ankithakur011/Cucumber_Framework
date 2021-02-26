@Registration
Feature: To test Farnell Registration flow

  Background: 
    Given user launches browser in "Chrome"
    And user accepts cookie policy

  @Test_Id_01 @SanityTest
  Scenario Outline: Register new user with remember me as pre-selected
    And user verify landing page is displayed
    When user click on the Register link
    Then verify title of the Registration page
    And user enter "<username>" and "<password>" on the page
    And user enters "<fullName>" and "<email>" on the page
    And user verify whether Remember is already selected
    And user click on the Register button
    Then verify user is successfully logged
    And throw successful logged in alert
    And close browser
		
    Examples: 
      | username | password  | fullName | email                     |
      | ankit11  | Tester@11 | Ankit    | ankit.thakur011@gmail.com |
	
  @Test_Id_02 @E2ETest
  Scenario Outline: Register new user without remember me selection
    And user verify landing page is displayed
    When user click on the Register link
    Then verify title of the Registration page
    And user enter "<username>" and "<password>" on the page
    And user enters "<fullName>" and "<email>" on the page
    And user click on the checkbox Remember Me
    And user verify whether Remember is not selected
    And user click on the Register button
    Then verify user is successfully logged
    And throw successful logged in alert
    And close browser

    Examples: 
      | username | password  | fullName | email                     |
      | ankit12  | Tester@12 | Ankit    | ankit.thakur011@gmail.com |
