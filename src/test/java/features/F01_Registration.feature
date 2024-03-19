Feature: User Registration
  I want to check that the user register in our e-commerce application successfully.

  Scenario: User Registration
    Given The user is in the home page
    When I click on register link
    And I entered user data
    Then The Registration page displayed successfully