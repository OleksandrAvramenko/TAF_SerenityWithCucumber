Smoke --> Login story

Narrative:
In order to be able to use the SwagLab
As an online User
I want to check login functionality

Meta:
@smoke

Scenario: Verify successfully login with STANDARD_USER credentials
Meta:
@test-001
Given User is on SwagLab Login Page
When User login with 'STANDARD_USER' credentials
Then Home Page is opened

Scenario: Verify error message when User login with LOCKED_OUT_USER credentials
Meta:
@test-002
Given User is on SwagLab Login Page
When User login with 'LOCKED_OUT_USER' credentials
Then Login Error Message contains text 'Epic sadface: Sorry, this user has been locked out.'

Scenario: Verify Login error message when User doesn't provide any credentials
Meta:
@test-003
Given User is on SwagLab Login Page
When User clicks LOGIN button
Then Login Error Message contains text 'Epic sadface: Username is required'

Scenario: Verify Login error message when User doesn't input all mandatory fields
Meta:
@test-004
Given User is on SwagLab Login Page
When User login with '<user>' credentials
Then Login Error Message contains text '<message>'

Examples:
| user                | message                            |
| EMPTY_NAME_USER     | Epic sadface: Username is required |
| EMPTY_PASSWORD_USER | Epic sadface: Password is required |

