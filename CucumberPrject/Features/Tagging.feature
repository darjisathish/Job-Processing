Feature: Tags in cucumber

@SanityTesting
Scenario: Verify Login
Given This is valid login Test

@SanityTesting @EndToEndTesting
Scenario: Verify logout
Given this is logout test


@RegressionTesting
Scenario: Verify search
Given this is search test

@RegressionTesting @EndToEndTesting
Scenario: Verify advanced search
Given this is advanced search


@EndToEndTesting
Scenario: Verify prepaid recharge
Given this is prepaid recharge test

@EndToEndTesting
Scenario: Verify post paid recharge
Given this is post paid recharge test


