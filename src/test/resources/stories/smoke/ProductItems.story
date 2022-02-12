Smoke --> Product Items story

Narrative:
In order to be able to view/select/remove Items to Cart
As an online User
I want to have Grid with Items on Home Page

Meta:
@smoke

Scenario: Verify Product Item Grid size
Meta:
@test-011
Given User is on SwagLab Login Page
When User login with 'STANDARD_USER' credentials
Then Home Page is opened
And Product Item Grid is displayed
And Product Item Grid size equals '6'

Scenario: Verify Add to Cart functionality
Meta:
@test-011
Given User is on SwagLab Login Page
When User login with 'STANDARD_USER' credentials
Then Home Page is opened
When I add item with 'Sauce Labs Backpack' name to Cart
Then Cart Items Badge count equals '1'