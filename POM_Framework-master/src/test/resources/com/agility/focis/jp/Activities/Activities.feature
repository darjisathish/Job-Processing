@Tasks
Feature: Perform Activities - Ocean

  @Ocean
  Scenario Outline: Perform all mandatory Activities - Ocean - FCL

    Given User is logged into FOCiS Application
    When selects "<ChildMenuOption>" from "<MenuOption>" Menu
    And user clicks on "Book Without Template" button
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

    When Edits Packages as below
      | Packages | Type | Per piece Wt | Gross Wt | Length | Width | Height | Volume | Shipping Marks | Description  |
      | 100      | BOX  | 10           |          | 30     | 25    | 40     |        | Laptops        | Dell Laptops |
      | 10       | BOX  | 10           |          | 20     | 15    | 10     |        | Laptops        | HP Laptops   |

    And Edits Units as below
      | Units | Unit Type                 | Shipper Owned | Gross Wt/Unit | Volume/Unit | Marks And Numbers | Description      |
      | 1     | 20' General Purpose / Dry | Yes           | 1000          | 1000        | Test Marks        | Test Description |
      | 1     | 40' General Purpose / Dry | No            | 1000          | 1000        | Test Marks        | Test Description |

    And Allocates Packages

    And Adds Main Carriage with Carrier - "<Carrier>", Job Type - "<JobType>" along with below details
      | Port of Loading    | ETD      | Port of Discharge    | ETA      |
      | <PortOfLoading_L1> | <ETD_L1> | <PortOfDischarge_L1> | <ETA_L1> |
      | <PortOfLoading_L2> | <ETD_L2> | <PortOfDischarge_L2> | <ETA_L2> |
      | <PortOfLoading_L3> | <ETD_L3> | <PortOfDischarge_L3> | <ETA_L3> |

    And Adds Pre Carriage with Haulage Arrangement as "Merchant"
      | Haulier Name | Cargo Collection Date | Cargo Delivery Date |
      | <O_Haulier>  | <O_Coll_Date>         | <O_Del_Date>        |

#    And Adds On Carriage with Haulage Arrangement as "Merchant"
#      | Haulier Name | Cargo Collection Date | Cargo Delivery Date |
#      | <D_Haulier>  | <D_Coll_Date>         | <D_Del_Date>        |

    And Performs "Carrier Booking Request" Activity
    And Performs "Carrier Booking Confirmation" Activity
    And Performs "Booking Confirmation to Customer" Activity
    And Performs "Master Bill of Lading Instructions" Activity
#    And Performs "Master Bill of Lading Approval" Activity
#    And Performs "Final Master Bill of Lading" Activity
#    And Performs "Seaquest Line Bill of Lading" Activity
#    And Performs "Departure Confirmation" Activity
#    And Performs "Arrival Confirmation" Activity
#    And Performs "Cargo Release to Customer" Activity
    Then Status of Activities should be Completed

    Examples:
      | DataRow | MenuOption | ChildMenuOption | Product       | ProductType | JobScope | JobType      | OriginStakeholder | DestinationStakeholder | IncoTerm | MBLType | MBLTerms | SequestType | Origin_Country | Origin_NetworkComponent | Origin_Department | Origin_Type | Origin_IsLive | Destination_Country | Destination_NetworkComponent | Destination_Department | Destination_Type | Destination_IsLive | Carrier | PortOfLoading_L1 | ETD_L1 | PortOfDischarge_L1 | ETA_L1 | PortOfLoading_L2 | ETD_L2 | PortOfDischarge_L2 | ETA_L2 | PortOfLoading_L3 | ETD_L3 | PortOfDischarge_L3 | ETA_L3 | O_Haulier                   | O_Coll_Date | O_Del_Date | D_Haulier         | D_Coll_Date | D_Del_Date | CBR | CBC | BCTC | MBL |
      | DR2     | Job        | Job Booking     | Ocean Freight | FCL         | E2E      | Back To Back | STK10000798       | STK20009602            | DAT      | Express | Prepaid  | Original    | IN             | Mumbai                  | Ocean Export      | Branch      | Yes           | US                  | Chicago                      | Ocean Import           | Branch           | Yes                | MAEU    | INNSA            | 7      | INMAA              | 8      | INMAA            | 9      | AEDXB              | 10     | AEDXB            | 11     | USCHI              | 14     | Garrisons Logistics Pvt Ltd | 1           | 5          | BESTWAY TRANSPORT | 15          | 16         | Yes | No  | No   | No  |

# @Air @Expedited @E2E @BackToBack @AirTasks
# Scenario Outline: Perform all mandatory Activities - Expedited - Air
#   Given User is logged into FOCiS Application
#    When selects "<ChildMenuOption>" from "<MenuOption>" Menu
#    And user clicks on "Book Without Template" button
#    And creates  a new "<Product>" - "<ProductType>" - "<JobScope>" Job with following details
#    And selects "<OriginStakeholder>" as Origin Stakeholder & "<DestinationStakeholder>" as Destination Stakeholder
#    And Clicks on "Next" button
#    And selects "<IncoTerm>" as Incoterm
#    And selects "Origin" Office as below
#      | Country          | Type          | NetworkComponent          | Department          | IsLive          |
#      | <Origin_Country> | <Origin_Type> | <Origin_NetworkComponent> | <Origin_Department> | <Origin_IsLive> |
#    And selects "Destination" Office as below
#      | Country               | Type               | NetworkComponent               | Department               | IsLive               |
#      | <Destination_Country> | <Destination_Type> | <Destination_NetworkComponent> | <Destination_Department> | <Destination_IsLive> |
#    And Clicks on "Next" button
#    And Clicks on "Next" button
#    And Clicks on "Initiate Job" button
#    Then  new "<Product>" - "<ProductType>" - "<JobScope>" Job is created successfully
#    When Edits Packages as below
#      | Packages | Type | Per piece Wt | Gross Wt | Length | Width | Height | Volume | Shipping Marks | Description  |
#      | 100      | BOX  | 10           |          | 30     | 25    | 40     |        | Laptops        | Dell Laptops |
#      | 10       | BOX  | 10           |          | 20     | 15    | 10     |        | Laptops        | HP Laptops   |
#      | 50       | BOX  | 5            |          | 20     | 15    | 10     |        | Laptops        | MacBook Pro  |
#    And Edits Description of Goods
#    And Adds Airport To Airport with Carrier As "<Carrier>" along with below details
#      | Flight Number  | Airport Of Departure | Airport Of Arrival | ETD   | ETD Time  | ETA   | ETA Time  | Supplier   | Cost   | Revenue   |
#      | <FlightNumber> | <AOD>                | <AOA>              | <ETD> | <ETDTime> | <ETA> | <ETATime> | <Supplier> | <Cost> | <Revenue> |
#    And Add Origin with Haulage Arrangement as "Agility"
#      | Haulier Name | Cargo Collection Date | Cargo Delivery Date |
#      | <O_Haulier>  | <O_Coll_Date>         | <O_Del_Date>        |
#    And Add Destination with Haulage Arrangement as "Agility"
#      | Haulier Name | Cargo Collection Date | Cargo Delivery Date |
#      | <D_Haulier>  | <D_Coll_Date>         | <D_Del_Date>        |
#    And Performs "Booking Confirmation to Customer" Activity
#    And Performs "Issue AWB" Activity

#    Examples:
#      | DataRow | MenuOption | ChildMenuOption | Product     | ProductType | JobScope | OriginStakeholder | DestinationStakeholder | IncoTerm | Origin_Country | Origin_NetworkComponent | Origin_Department | Origin_Type | Origin_IsLive | Destination_Country | Destination_NetworkComponent | Destination_Department | Destination_Type | Destination_IsLive | Carrier | FlightNumber | AOD | AOA | ETD | ETDTime | ETA | ETATime | Supplier          | Cost | Revenue | O_Haulier         | O_Coll_Date | O_Del_Date | D_Haulier                   | D_Coll_Date | D_Del_Date |
#      | DR1     | Job        | Job Booking     | Air Freight | Expedited   | E2E      | STK20016776       | STK20016775            | DAT      | US             | Chicago                 | Air Export        | Branch      | Yes           | IN                  | Mumbai                       | Air Import             | Branch           | Yes                | EK      | EK123        | ORD | BOM | 7   | 12      | 14  | 12      | BESTWAY TRANSPORT | 1    | 2       | BESTWAY TRANSPORT | 1           | 3          | Garrisons Logistics Pvt Ltd | 15          | 16         |
