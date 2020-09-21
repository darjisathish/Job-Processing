@Regression
Feature: Ocean - FCL - Template Page

  Background: Login and Navigate to Job Booking Page
    Given User is logged into FOCiS Application
    When selects "Job Booking" from "Job" Menu

  Scenario Outline: Validate user should be able to initiate new job with E2E as Job Scope from Book Without Template and the same Job Scope should display in Job Basic details section

    When user clicks on "Book Without Template" button
    And creates  a new "<Product>" - "<ProductType>" - "<JobScope>" Job with following details
    And selects "<OriginStakeholder>" as Origin Stakeholder & "<DestinationStakeholder>" as Destination Stakeholder
    And Clicks on "Next" button

    And selects Incoterm, Master Bill Of Lading & Sequest Line Of Billing details as below
      | IncoTerm   | MBLType   | MBLTerms   | SequestType   |
      | <IncoTerm> | <MBLType> | <MBLTerms> | <SequestType> |
    And selects "Origin" Office as below
      | Country          | Type          | NetworkComponent          | Department          | IsLive          |
      | <Origin_Country> | <Origin_Type> | <Origin_NetworkComponent> | <Origin_Department> | <Origin_IsLive> |
    And selects "Destination" Office as below
      | Country               | Type               | NetworkComponent               | Department               | IsLive               |
      | <Destination_Country> | <Destination_Type> | <Destination_NetworkComponent> | <Destination_Department> | <Destination_IsLive> |

    And Clicks on "Next" button
    And Clicks on "Next" button
    And Clicks on "Initiate Job" button
    Then  new "<Product>" - "<ProductType>" - "<JobScope>" Job is created successfully

    Examples:
      | DataRow | Product       | ProductType | JobScope | OriginStakeholder    | DestinationStakeholder | IncoTerm | MBLType | MBLTerms | SequestType | Origin_Country | Origin_NetworkComponent | Origin_Department | Origin_Type | Origin_IsLive | Destination_Country | Destination_NetworkComponent | Destination_Department | Destination_Type | Destination_IsLive |
      | DR1     | Ocean Freight | FCL         | E2E      | Flyjac Logistics- IN | Smatbot- US            | DAT      | Express | Prepaid  | Original    | IN             | Mumbai                  | Ocean Export      | Branch      | Yes           | US                  | Chicago                      | Ocean Import           | Branch           | Yes                |

   Scenario Outline: Validate user should be able to initiate new job with Origin Only as Job Scope from Book Without Template and the same Job Scope should display in Job Basic details section
     When user clicks on "Book Without Template" button
     And creates  a new "<Product>" - "<ProductType>" - "<JobScope>" Job with following details
     And selects "<OriginStakeholder>" as Origin Stakeholder & "<DestinationStakeholder>" as Destination Stakeholder
     And Clicks on "Next" button

     And selects Incoterm, Master Bill Of Lading & Sequest Line Of Billing details as below
       | IncoTerm   | MBLType   | MBLTerms   | SequestType   |
       | <IncoTerm> | <MBLType> | <MBLTerms> | <SequestType> |
     And selects "Origin" Office as below
       | Country          | Type          | NetworkComponent          | Department          | IsLive          |
       | <Origin_Country> | <Origin_Type> | <Origin_NetworkComponent> | <Origin_Department> | <Origin_IsLive> |
     And selects "Destination" Office as below
       | Country               | Type               | NetworkComponent               | Department               | IsLive               |
       | <Destination_Country> | <Destination_Type> | <Destination_NetworkComponent> | <Destination_Department> | <Destination_IsLive> |

     And Clicks on "Next" button
     And Clicks on "Next" button
     And Clicks on "Initiate Job" button
     Then  new "<Product>" - "<ProductType>" - "<JobScope>" Job is created successfully

     Examples:
       | DataRow | Product       | ProductType | JobScope | OriginStakeholder    | DestinationStakeholder | IncoTerm | MBLType | MBLTerms | SequestType | Origin_Country | Origin_NetworkComponent | Origin_Department | Origin_Type | Origin_IsLive | Destination_Country | Destination_NetworkComponent | Destination_Department | Destination_Type | Destination_IsLive |
       | DR1     | Ocean Freight | FCL         | E2E      | Flyjac Logistics- IN | Smatbot- US            | DAT      | Express | Prepaid  | Original    | IN             | Mumbai                  | Ocean Export      | Branch      | Yes           | US                  | Chicago                      | Ocean Import           | Branch           | Yes                |
