@Captcha
Feature: Captcha Testing

  Scenario Outline: Enter Captcha
#  Scenario Outline: Validate all the field in header after Creating the PIV Header

#    Given User is logged into FOCiS Application
#    When selects "<ChildSubMenu>" from "<ChildMenu>" from "<Menu>" Menu
#    And clicks on "Upload" button
    Then user should be able to read Captcha

    Examples:
      | DataRow | Menu             | ChildMenu         | ChildSubMenu  |
      | DR1     | Rate Cloud & NPC | Carrier Buy Rates | Ocean Freight |