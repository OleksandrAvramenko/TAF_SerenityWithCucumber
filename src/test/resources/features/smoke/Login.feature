@smoke
Feature: Login Scenarios
  As an User
  I want to able to login to SwagLab
  So that I can start using the application

  @test-001
  Scenario: Verify successfully login with STANDARD_USER credentials
    Given User is on SwagLab Login Page
    When User login with 'STANDARD_USER' credentials
    Then Home Page is opened

  @test-002
  Scenario: Verify error message when User login with LOCKED_OUT_USER credentials
    Given User is on SwagLab Login Page
    When User login with 'LOCKED_OUT_USER' credentials
    Then Login Error Message contains text 'Epic sadface: Sorry, this user has been locked out.'

  @test-003
  Scenario: Verify Login error message when User doesn't provide any credentials
    Given User is on SwagLab Login Page
    When User clicks LOGIN button
    Then Login Error Message contains text 'Epic sadface: Username is required'

  @test-004
  Scenario Outline: Verify Login error message when User doesn't input all mandatory fields
    Given User is on SwagLab Login Page
    When User login with '<user>' credentials
    Then Login Error Message contains text '<message>'

    Examples:
      | user                | message                            |
      | EMPTY_NAME_USER     | Epic sadface: Username is required |
      | EMPTY_PASSWORD_USER | Epic sadface: Password is required |
