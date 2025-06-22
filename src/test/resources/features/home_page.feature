@ui @smoke
Feature: Sportsbook search functionality

  Background: Login
    Given I launch the SportingBull homepage
    When I accept cookies

  @TC-001
  Scenario: Verify presence of the search button on the sportsbook Home page
    Then Verify the search button is displayed on the Home Page
    Then Verify the search button is clickable on the Home Page

  @TC-002
  Scenario: Click on the search button and enter search word
    When I click on search button on the Home Page
    And I input "Football" search word in search input field on the Home Page
    Then Verify the "Football" search results are displayed on the Home Page

  @TC-003
  Scenario: Verify the functionality of “X” (clear) of search field
    When I click on search button on the Home Page
    And I input "Football" search word in search input field on the Home Page
    And I click X (clear) of search field
    Then Verify the search field is cleared on the Home Page

  @TC-004
  Scenario: Validate a search word in upper/lower/mixed cases
    When I click on search button on the Home Page
    And I input "FOOTBALL" search word in search input field on the Home Page
    Then Verify the "Football" search results are displayed on the Home Page
    And I click X (clear) of search field
    And I input "football" search word in search input field on the Home Page
    Then Verify the "Football" search results are displayed on the Home Page
    And I click X (clear) of search field
    And I input "FootBALL" search word in search input field on the Home Page
    Then Verify the "Football" search results are displayed on the Home Page

  @TC-006
  Scenario: Enter invalid input word
    When I click on search button on the Home Page
    And I input "@#$@!" search word in search input field on the Home Page
    Then Verify the "There are no results that match your search. Try again." error message is displayed on the Home Page

  @TC-007
  Scenario: Leave search input empty and press Enter
    When I click on search button on the Home Page
    And I input "" search word in search input field on the Home Page
    And I press Enter
    Then Verify the "Search History is empty" history error message is displayed on the Home Page
