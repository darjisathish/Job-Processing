@Invoices
Feature: Invoices Generation

  @GenerateInvoices @E2E @AirFreight
  Scenario Outline: Create Air Freight - E2E Job and Process Invoices
#  Scenario Outline: Validate all the field in header after Creating the PIV Header

    Given User is logged into FOCiS Application
    When selects "<ChildMenuOption>" from "<MenuOption>" Menu
    And user clicks on "Book Without Template" button
    And creates  a new "<Product>" - "<ProductType>" - "<JobScope>" Job with following details
    And selects "<OriginStakeholder>" as Origin Stakeholder & "<DestinationStakeholder>" as Destination Stakeholder
    And Clicks on "Next" button
    And selects "<IncoTerm>" as Incoterm
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
      | 50       | BOX  | 5            |          | 20     | 15    | 10     |        | Laptops        | MacBook Pro  |
    And Edits Description of Goods
    And Adds Airport To Airport with Carrier As "<Carrier>" along with below details
      | Flight Number  | Airport Of Departure | Airport Of Arrival | ETD   | ETD Time  | ETA   | ETA Time  |
      | <FlightNumber> | <AOD>                | <AOA>              | <ETD> | <ETDTime> | <ETA> | <ETATime> |
    And Add Origin with Haulage Arrangement as "Agility"
      | Haulier Name | Cargo Collection Date | Cargo Delivery Date |
      | <O_Haulier>  | <O_Coll_Date>         | <O_Del_Date>        |
    And Add Destination with Haulage Arrangement as "Agility"
      | Haulier Name | Cargo Collection Date | Cargo Delivery Date |
      | <D_Haulier>  | <D_Coll_Date>         | <D_Del_Date>        |
    And adds Charges as below
      | Charge Type   | Charge Name            | Supplier                    | Cost | Cost Currency | Revenue | Revenue Currency |
      | Origin        | Documentation          | Garrisons Logistics Pvt Ltd | 100  | INR           | 120     | INR              |
      | Origin        | Booking Fees           | Garrisons Logistics Pvt Ltd | 100  | INR           | 120     | INR              |
      | International | Airline Fuel Surcharge | Garrisons Logistics Pvt Ltd | -80  | INR           | 60      | INR              |
      | International | Advance fee            | Garrisons Logistics Pvt Ltd | -70  | INR           | 50      | INR              |
      | Destination   | Inland Fuel Surcharge  | BESTWAY TRANSPORT           | 100  | USD           | 120     | USD              |
      | Destination   | Booking Fees           | BESTWAY TRANSPORT           | 100  | USD           | 120     | USD              |
#    And Creates PIV Header with below details
#      | Invoice Type | Invoice SubType | Entity Code | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
#      | <PIVType>    | <PIVSubType>    | <D_Entity>  | <D_Haulier>   | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Processes "<PIVType>" with below details
      | Job Number  | Invoice Type | Invoice SubType | Entity Code | Supplier Name | Supplier Invoice Date |
      | Current Job | <PIVType>    | <PIVSubType>    | <O_Entity>  | <O_Haulier>   | <PIVInvoiceDate>      |
    And Processes "<PIVType2>" with below details
      | Job Number  | Invoice Type | Invoice SubType | Entity Code | Supplier Name | Supplier Invoice Date |
      | Current Job | <PIVType2>   | <PIVSubType>    | <O_Entity>  | <O_Haulier>   | <PIVInvoiceDate>      |
#    When user clicks on "Allocate to Jobs/ Consol" button
#    Then Supplier Name and Supplier Invoice Number should be populated correctly
#    And PIV Amount Table should be populated correctly
    And Processes Sales Invoice with below details
      | Job Number  | Charges                   | Bill To Party       |
      | Current Job | <NumberOfChargesForSales> | <OriginStakeholder> |
    And Processes Credit Note against to below details
      | Job Number  | Charges                   | Legal Entity |
      | Current Job | <NumberOfChargesForSales> | <O_Entity>   |
    Examples:
      | DataRow | MenuOption | ChildMenuOption | ChildSubMenuOption      | Product     | ProductType | JobScope | OriginStakeholder    | DestinationStakeholder | IncoTerm | Origin_Country | Origin_NetworkComponent | Origin_Department | Origin_Type | Origin_IsLive | O_Entity | Destination_Country | Destination_NetworkComponent | Destination_Department | Destination_Type | Destination_IsLive | D_Entity | Carrier | FlightNumber | AOD | AOA | ETD | ETDTime | ETA | ETATime | Supplier                    | Cost | Revenue | O_Haulier                   | O_Coll_Date | O_Del_Date | D_Haulier         | D_Coll_Date | D_Del_Date | PIVType          | PIVSubType | PIVInvoiceDate | PIVType2        | NumberOfChargesForSales |
#      | DR1     | Job        | Job Booking     | Purchase Invoice/Credit | Air Freight | Expedited   | E2E      | STK20016776          | STK20016775            | DAT      | US             | Chicago                 | Air Export        | Branch      | Yes           | 1200     | IN                  | Mumbai                       | Air Import             | Branch           | Yes                | 5910     | EK      | EK123        | ORD | BOM | 7   | 12      | 14  | 12      | BESTWAY TRANSPORT           | 1    | 2       | BESTWAY TRANSPORT           | 1           | 3          | Garrisons Logistics Pvt Ltd | 15          | 16         | Purchase Invoice | Freight    | Today          | Purchase Credit | All                     |
      | DR2     | Job        | Job Booking     | Purchase Invoice/Credit | Air Freight | Expedited   | E2E      | Flyjac Logistics- IN | Smatbot- US            | DAT      | IN             | Mumbai                  | Air Export        | Branch      | Yes           | 5910     | US                  | Chicago                      | Air Import             | Branch           | Yes                | 1200     | EK      | EK123        | BOM | ORD | 7   | 12      | 14  | 12      | Garrisons Logistics Pvt Ltd | 1    | 2       | Garrisons Logistics Pvt Ltd | 1           | 3          | BESTWAY TRANSPORT | 15          | 16         | Purchase Invoice | Freight    | Today          | Purchase Credit | All                     |
#      | DR3     | Job        | Job Booking     | Purchase Invoice/Credit | Air Freight | Expedited   | Origin Only      | Flyjac Logistics- IN | Smatbot- US            | DAT      | IN             | Mumbai                  | Air Export        | Branch      | Yes           | 5910     |                     |                              |                        |                  |                    | 1200     | EK      | EK123        | BOM | ORD | 7   | 12      | 14  | 12      | Garrisons Logistics Pvt Ltd | 1    | 2       | Garrisons Logistics Pvt Ltd | 1           | 3          |                   |             |            | Purchase Invoice | Freight    | Today          | Purchase Credit | All                     |
#      | DR4     | Job        | Job Booking     | Purchase Invoice/Credit | Air Freight | Expedited   | Destination Only | Flyjac Logistics- IN | Smatbot- US            | DAT      |                |                         |                   |             |               | 5910     | US                  | Chicago                      | Air Import             | Branch           | Yes                | 1200     | EK      | EK123        | BOM | ORD | 7   | 12      | 14  | 12      | Garrisons Logistics Pvt Ltd | 1    | 2       |           |             |            | BESTWAY TRANSPORT | 15          | 16         | Purchase Invoice | Freight    | Today          | Purchase Credit | All                     |

  @GenerateInvoices @OriginOnly @AirFreight
  Scenario Outline: Create Air Freight - Origin Only Job and Process Invoices

    Given User is logged into FOCiS Application
    When selects "<ChildMenuOption>" from "<MenuOption>" Menu
    And user clicks on "Book Without Template" button
    And creates  a new "<Product>" - "<ProductType>" - "<JobScope>" Job with following details
    And selects "<OriginStakeholder>" as Origin Stakeholder & "<DestinationStakeholder>" as Destination Stakeholder
    And Clicks on "Next" button
    And selects "<IncoTerm>" as Incoterm
    And selects "Origin" Office as below
      | Country          | Type          | NetworkComponent          | Department          | IsLive          |
      | <Origin_Country> | <Origin_Type> | <Origin_NetworkComponent> | <Origin_Department> | <Origin_IsLive> |
    And Clicks on "Next" button
    And Clicks on "Next" button
    And Clicks on "Initiate Job" button
    Then  new "<Product>" - "<ProductType>" - "<JobScope>" Job is created successfully
    When Edits Packages as below
      | Packages | Type | Per piece Wt | Gross Wt | Length | Width | Height | Volume | Shipping Marks | Description  |
      | 100      | BOX  | 10           |          | 30     | 25    | 40     |        | Laptops        | Dell Laptops |
      | 10       | BOX  | 10           |          | 20     | 15    | 10     |        | Laptops        | HP Laptops   |
      | 50       | BOX  | 5            |          | 20     | 15    | 10     |        | Laptops        | MacBook Pro  |
    And Edits Description of Goods
    And Adds Airport To Airport with Carrier As "<Carrier>" along with below details
      | Flight Number  | Airport Of Departure | Airport Of Arrival | ETD   | ETD Time  | ETA   | ETA Time  |
      | <FlightNumber> | <AOD>                | <AOA>              | <ETD> | <ETDTime> | <ETA> | <ETATime> |
    And Add Origin with Haulage Arrangement as "Agility"
      | Haulier Name | Cargo Collection Date | Cargo Delivery Date |
      | <O_Haulier>  | <O_Coll_Date>         | <O_Del_Date>        |
    And adds Charges as below
      | Charge Type | Charge Name            | Supplier                    | Cost | Cost Currency | Revenue | Revenue Currency |
      | Origin      | Documentation          | Garrisons Logistics Pvt Ltd | 100  | INR           | 120     | INR              |
      | Origin      | Booking Fees           | Garrisons Logistics Pvt Ltd | 100  | INR           | 120     | INR              |
      | Origin      | Airline Fuel Surcharge | Garrisons Logistics Pvt Ltd | -80  | INR           | 60      | INR              |
    And Processes "<PIVType>" with below details
      | Job Number  | Invoice Type | Invoice SubType | Entity Code | Supplier Name | Supplier Invoice Date |
      | Current Job | <PIVType>    | <PIVSubType>    | <O_Entity>  | <O_Haulier>   | <PIVInvoiceDate>      |
    And Processes "<PIVType2>" with below details
      | Job Number  | Invoice Type | Invoice SubType | Entity Code | Supplier Name | Supplier Invoice Date |
      | Current Job | <PIVType2>   | <PIVSubType>    | <O_Entity>  | <O_Haulier>   | <PIVInvoiceDate>      |
    And Processes Sales Invoice with below details
      | Job Number  | Charges                   | Bill To Party       |
      | Current Job | <NumberOfChargesForSales> | <OriginStakeholder> |
    And Processes Credit Note against to below details
      | Job Number  | Charges                   | Legal Entity |
      | Current Job | <NumberOfChargesForSales> | <O_Entity>   |

    Examples:
      | DataRow | MenuOption | ChildMenuOption | Product     | ProductType | JobScope    | OriginStakeholder    | DestinationStakeholder | IncoTerm | Origin_Country | Origin_NetworkComponent | Origin_Department | Origin_Type | Origin_IsLive | O_Entity | Destination_Country | Destination_NetworkComponent | Destination_Department | Destination_Type | Destination_IsLive | D_Entity | Carrier | FlightNumber | AOD | AOA | ETD | ETDTime | ETA | ETATime | O_Haulier                   | O_Coll_Date | O_Del_Date | PIVType          | PIVSubType | PIVInvoiceDate | PIVType2        | NumberOfChargesForSales |
      | DR3     | Job        | Job Booking     | Air Freight | Expedited   | Origin Only | Flyjac Logistics- IN | Smatbot- US            | DAT      | IN             | Mumbai                  | Air Export        | Branch      | Yes           | 5910     |                     |                              |                        |                  |                    | 1200     | EK      | EK123        | BOM | ORD | 7   | 12      | 14  | 12      | Garrisons Logistics Pvt Ltd | 1           | 3          | Purchase Invoice | Freight    | Today          | Purchase Credit | All                     |

  @GenerateInvoices @DestinationOnly @AirFreight
  Scenario Outline: Create Air Freight - Destination Only Job and Process Invoices

    Given User is logged into FOCiS Application
    When selects "<ChildMenuOption>" from "<MenuOption>" Menu
    And user clicks on "Book Without Template" button
    And creates  a new "<Product>" - "<ProductType>" - "<JobScope>" Job with following details
    And selects "<OriginStakeholder>" as Origin Stakeholder & "<DestinationStakeholder>" as Destination Stakeholder
    And Clicks on "Next" button
    And selects "<IncoTerm>" as Incoterm
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
      | 50       | BOX  | 5            |          | 20     | 15    | 10     |        | Laptops        | MacBook Pro  |
    And Edits Description of Goods
    And Adds Airport To Airport with Carrier As "<Carrier>" along with below details
      | Flight Number  | Airport Of Departure | Airport Of Arrival | ETD   | ETD Time  | ETA   | ETA Time  |
      | <FlightNumber> | <AOD>                | <AOA>              | <ETD> | <ETDTime> | <ETA> | <ETATime> |
    And Add Destination with Haulage Arrangement as "Agility"
      | Haulier Name | Cargo Collection Date | Cargo Delivery Date |
      | <D_Haulier>  | <D_Coll_Date>         | <D_Del_Date>        |
    And adds Charges as below
      | Charge Type | Charge Name           | Supplier                    | Cost | Cost Currency | Revenue | Revenue Currency |
      | Destination | Advance fee           | Garrisons Logistics Pvt Ltd | -70  | INR           | 50      | INR              |
      | Destination | Inland Fuel Surcharge | Garrisons Logistics Pvt Ltd | 100  | INR           | 120     | INR              |
      | Destination | Booking Fees          | Garrisons Logistics Pvt Ltd | 100  | INR           | 120     | INR              |
    And Processes "<PIVType>" with below details
      | Job Number  | Invoice Type | Invoice SubType | Entity Code | Supplier Name | Supplier Invoice Date |
      | Current Job | <PIVType>    | <PIVSubType>    | <D_Entity>  | <D_Haulier>   | <PIVInvoiceDate>      |
    And Processes "<PIVType2>" with below details
      | Job Number  | Invoice Type | Invoice SubType | Entity Code | Supplier Name | Supplier Invoice Date |
      | Current Job | <PIVType2>   | <PIVSubType>    | <D_Entity>  | <D_Haulier>   | <PIVInvoiceDate>      |
    And Processes Sales Invoice with below details
      | Job Number  | Charges                   | Bill To Party            |
      | Current Job | <NumberOfChargesForSales> | <DestinationStakeholder> |
    And Processes Credit Note against to below details
      | Job Number  | Charges                   | Legal Entity |
      | Current Job | <NumberOfChargesForSales> | <D_Entity>   |
    Examples:
      | DataRow | MenuOption | ChildMenuOption | Product     | ProductType | JobScope         | OriginStakeholder | DestinationStakeholder | IncoTerm | Destination_Country | Destination_NetworkComponent | Destination_Department | Destination_Type | Destination_IsLive | D_Entity | Carrier | FlightNumber | AOD | AOA | ETD | ETDTime | ETA | ETATime | D_Haulier                   | D_Coll_Date | D_Del_Date | PIVType          | PIVSubType | PIVInvoiceDate | PIVType2        | NumberOfChargesForSales |
#      | DR4     | Job        | Job Booking     | Air Freight | Expedited   | Destination Only | Flyjac Logistics- IN | Smatbot- US            | DAT      | US                  | Chicago                      | Air Import             | Branch           | Yes                | 1200     | EK      | EK123        | BOM | ORD | 7   | 12      | 14  | 12      | BESTWAY TRANSPORT           | 15          | 16         | Purchase Invoice | Freight    | Today          | Purchase Credit | All                     |
      | DR4     | Job        | Job Booking     | Air Freight | Expedited   | Destination Only | Smatbot- US       | Flyjac Logistics- IN   | DAT      | IN                  | Mumbai                       | Air Import             | Branch           | Yes                | 5910     | EK      | EK123        | ORD | BOM | 7   | 12      | 14  | 12      | Garrisons Logistics Pvt Ltd | 15          | 16         | Purchase Invoice | Freight    | Today          | Purchase Credit | All                     |

  @OceanFreight @GenerateInvoices @E2E
  Scenario Outline: Create Ocean Freight FCL- E2E Job and Process Invoices

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
      | Mode   | Port of Loading    | ETD      | Port of Discharge    | ETA      |
      | Vessel | <PortOfLoading_L1> | <ETD_L1> | <PortOfDischarge_L3> | <ETA_L3> |
#   |   | <PortOfLoading_L2> | <ETD_L2> | <PortOfDischarge_L2> | <ETA_L2> |
#    |  | <PortOfLoading_L3> | <ETD_L3> | <PortOfDischarge_L3> | <ETA_L3> |

    And Adds Pre Carriage with Haulage Arrangement as "Merchant"
      | Haulier Name | Cargo Collection Date | Cargo Delivery Date |
      | <O_Haulier>  | <O_Coll_Date>         | <O_Del_Date>        |

    And Adds On Carriage with Haulage Arrangement as "Merchant"
      | Haulier Name | Cargo Collection Date | Cargo Delivery Date |
      | <D_Haulier>  | <D_Coll_Date>         | <D_Del_Date>        |

    And adds Charges as below
      | Charge Type   | Charge Name           | Supplier                    | Cost | Cost Currency | Revenue | Revenue Currency |
      | Origin        | Documentation         | Garrisons Logistics Pvt Ltd | 100  | INR           | 120     | INR              |
      | Origin        | Pick-Up Charges       | Garrisons Logistics Pvt Ltd | -70  | INR           | 50      | INR              |
      | International | Inland Transport      | Garrisons Logistics Pvt Ltd | 120  | INR           | 150     | INR              |
      | International | Advance fee           | Garrisons Logistics Pvt Ltd | -70  | INR           | 50      | INR              |
      | Destination   | Inland Fuel Surcharge | BESTWAY TRANSPORT           | -100 | USD           | 120     | USD              |
      | Destination   | Booking Fees          | BESTWAY TRANSPORT           | 100  | USD           | 120     | USD              |

    And Processes "<PIVType>" with below details
      | Job Number  | Invoice Type | Invoice SubType | Entity Code | Supplier Name | Supplier Invoice Date |
      | Current Job | <PIVType>    | <PIVSubType>    | <O_Entity>  | <O_Haulier>   | <PIVInvoiceDate>      |
    And Processes "<PIVType2>" with below details
      | Job Number  | Invoice Type | Invoice SubType | Entity Code | Supplier Name | Supplier Invoice Date |
      | Current Job | <PIVType2>   | <PIVSubType>    | <O_Entity>  | <O_Haulier>   | <PIVInvoiceDate>      |
    And Processes Sales Invoice with below details
      | Job Number  | Charges                   | Bill To Party       |
      | Current Job | <NumberOfChargesForSales> | <OriginStakeholder> |
    And Processes Credit Note against to below details
      | Job Number  | Charges                   | Legal Entity |
      | Current Job | <NumberOfChargesForSales> | <O_Entity>   |
    Examples:
      | DataRow | MenuOption | ChildMenuOption | Product       | ProductType | JobScope | JobType      | OriginStakeholder    | DestinationStakeholder | IncoTerm | MBLType | MBLTerms | SequestType | Origin_Country | Origin_NetworkComponent | Origin_Department | Origin_Type | Origin_IsLive | O_Entity | Destination_Country | Destination_NetworkComponent | Destination_Department | Destination_Type | Destination_IsLive | D_Entity | Carrier | PortOfLoading_L1 | ETD_L1 | PortOfDischarge_L1 | ETA_L1 | PortOfLoading_L2 | ETD_L2 | PortOfDischarge_L2 | ETA_L2 | PortOfLoading_L3 | ETD_L3 | PortOfDischarge_L3 | ETA_L3 | O_Haulier                   | O_Coll_Date | O_Del_Date | D_Haulier         | D_Coll_Date | D_Del_Date | CBR | CBC | BCTC | MBL | PIVType          | PIVSubType | PIVInvoiceDate | PIVType2        | NumberOfChargesForSales |
      | DR1     | Job        | Job Booking     | Ocean Freight | FCL         | E2E      | Back To Back | Flyjac Logistics- IN | Smatbot- US            | DAT      | Express | Prepaid  | Original    | IN             | Mumbai                  | Ocean Export      | Branch      | Yes           | 5910     | US                  | Chicago                      | Ocean Import           | Branch           | Yes                | 1200     | MAEU    | INNSA            | 7      | INMAA              | 8      | INMAA            | 9      | AEDXB              | 10     | AEDXB            | 11     | USCHI              | 14     | Garrisons Logistics Pvt Ltd | 1           | 5          | BESTWAY TRANSPORT | 15          | 16         | Yes | No  | No   | No  | Purchase Invoice | Freight    | Today          | Purchase Credit | All                     |

  @OceanFreight @GenerateInvoices @OriginOnly
  Scenario Outline: Create Ocean Freight FCL- Origin Only Job and Process Invoices

    Given User is logged into FOCiS Application
    When selects "<ChildMenuOption>" from "<MenuOption>" Menu
    And user clicks on "Book Without Template" button
    And creates  a new "<Product>" - "<ProductType>" - "<JobScope>" Job with following details
    And selects "<OriginStakeholder>" as Origin Stakeholder & "<DestinationStakeholder>" as Destination Stakeholder
    And Clicks on "Next" button

    And selects "Origin" Office as below
      | Country          | Type          | NetworkComponent          | Department          | IsLive          |
      | <Origin_Country> | <Origin_Type> | <Origin_NetworkComponent> | <Origin_Department> | <Origin_IsLive> |

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
      | Mode   | Port of Loading    | ETD      | Port of Discharge    | ETA      |
      | Vessel | <PortOfLoading_L1> | <ETD_L1> | <PortOfDischarge_L3> | <ETA_L3> |
#   |   | <PortOfLoading_L2> | <ETD_L2> | <PortOfDischarge_L2> | <ETA_L2> |
#    |  | <PortOfLoading_L3> | <ETD_L3> | <PortOfDischarge_L3> | <ETA_L3> |

    And Adds Pre Carriage with Haulage Arrangement as "Merchant"
      | Haulier Name | Cargo Collection Date | Cargo Delivery Date |
      | <O_Haulier>  | <O_Coll_Date>         | <O_Del_Date>        |

    And adds Charges as below
      | Charge Type | Charge Name     | Supplier                    | Cost | Cost Currency | Revenue | Revenue Currency |
      | Origin      | Booking Fees    | Garrisons Logistics Pvt Ltd | 100  | INR           | 120     | INR              |
      | Origin      | Pick-Up Charges | Garrisons Logistics Pvt Ltd | -70  | INR           | 50      | INR              |
      | Origin      | BAF             | Garrisons Logistics Pvt Ltd | 120  | INR           | 150     | INR              |
    And Processes "<PIVType>" with below details
      | Job Number  | Invoice Type | Invoice SubType | Entity Code | Supplier Name | Supplier Invoice Date |
      | Current Job | <PIVType>    | <PIVSubType>    | <O_Entity>  | <O_Haulier>   | <PIVInvoiceDate>      |
    And Processes "<PIVType2>" with below details
      | Job Number  | Invoice Type | Invoice SubType | Entity Code | Supplier Name | Supplier Invoice Date |
      | Current Job | <PIVType2>   | <PIVSubType>    | <O_Entity>  | <O_Haulier>   | <PIVInvoiceDate>      |
    And Processes Sales Invoice with below details
      | Job Number  | Charges                   | Bill To Party       |
      | Current Job | <NumberOfChargesForSales> | <OriginStakeholder> |
    And Processes Credit Note against to below details
      | Job Number  | Charges                   | Legal Entity |
      | Current Job | <NumberOfChargesForSales> | <O_Entity>   |
    Examples:
      | DataRow | MenuOption | ChildMenuOption | Product       | ProductType | JobScope    | JobType      | OriginStakeholder    | DestinationStakeholder | O_Entity | IncoTerm | MBLType | MBLTerms | SequestType | Origin_Country | Origin_NetworkComponent | Origin_Department | Origin_Type | Origin_IsLive | Carrier | PortOfLoading_L1 | ETD_L1 | PortOfDischarge_L1 | ETA_L1 | PortOfLoading_L2 | ETD_L2 | PortOfDischarge_L2 | ETA_L2 | PortOfLoading_L3 | ETD_L3 | PortOfDischarge_L3 | ETA_L3 | O_Haulier                   | O_Coll_Date | O_Del_Date | PIVType          | PIVSubType | PIVInvoiceDate | PIVType2        | NumberOfChargesForSales |
      | DR1     | Job        | Job Booking     | Ocean Freight | FCL         | Origin Only | Back To Back | Flyjac Logistics- IN | Smatbot- US            | 5910     | DAT      | Express | Prepaid  | Original    | IN             | Mumbai                  | Ocean Export      | Branch      | Yes           | MAEU    | INNSA            | 7      | INMAA              | 8      | INMAA            | 9      | AEDXB              | 10     | AEDXB            | 11     | USCHI              | 14     | Garrisons Logistics Pvt Ltd | 1           | 5          | Purchase Invoice | Freight    | Today          | Purchase Credit | All                     |

  @OceanFreight @GenerateInvoices @DestinationOnly
  Scenario Outline: Create Ocean Freight FCL- Destination Only Job and Process Invoices

    Given User is logged into FOCiS Application
    When selects "<ChildMenuOption>" from "<MenuOption>" Menu
    And user clicks on "Book Without Template" button
    And creates  a new "<Product>" - "<ProductType>" - "<JobScope>" Job with following details
    And selects "<OriginStakeholder>" as Origin Stakeholder & "<DestinationStakeholder>" as Destination Stakeholder
    And Clicks on "Next" button

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
      | Mode   | Port of Loading    | ETD      | Port of Discharge    | ETA      |
      | Vessel | <PortOfLoading_L1> | <ETD_L1> | <PortOfDischarge_L3> | <ETA_L3> |
#   |   | <PortOfLoading_L2> | <ETD_L2> | <PortOfDischarge_L2> | <ETA_L2> |
#    |  | <PortOfLoading_L3> | <ETD_L3> | <PortOfDischarge_L3> | <ETA_L3> |

    And Adds On Carriage with Haulage Arrangement as "Merchant"
      | Haulier Name | Cargo Collection Date | Cargo Delivery Date |
      | <D_Haulier>  | <D_Coll_Date>         | <D_Del_Date>        |

    And adds Charges as below
      | Charge Type | Charge Name           | Supplier                    | Cost | Cost Currency | Revenue | Revenue Currency |
      | Destination | Advance fee           | Garrisons Logistics Pvt Ltd | 70   | INR           | 150     | INR              |
      | Destination | Inland Fuel Surcharge | Garrisons Logistics Pvt Ltd | -100 | INR           | 120     | INR              |
      | Destination | Booking Fees          | Garrisons Logistics Pvt Ltd | 100  | INR           | 120     | INR              |
    And Processes "<PIVType>" with below details
      | Job Number  | Invoice Type | Invoice SubType | Entity Code | Supplier Name | Supplier Invoice Date |
      | Current Job | <PIVType>    | <PIVSubType>    | <D_Entity>  | <D_Haulier>   | <PIVInvoiceDate>      |
    And Processes "<PIVType2>" with below details
      | Job Number  | Invoice Type | Invoice SubType | Entity Code | Supplier Name | Supplier Invoice Date |
      | Current Job | <PIVType2>   | <PIVSubType>    | <D_Entity>  | <D_Haulier>   | <PIVInvoiceDate>      |
    And Processes Sales Invoice with below details
      | Job Number  | Charges                   | Bill To Party            |
      | Current Job | <NumberOfChargesForSales> | <DestinationStakeholder> |
    And Processes Credit Note against to below details
      | Job Number  | Charges                   | Legal Entity |
      | Current Job | <NumberOfChargesForSales> | <D_Entity>   |

    Examples:
      | DataRow | MenuOption | ChildMenuOption | Product       | ProductType | JobScope         | JobType      | OriginStakeholder | DestinationStakeholder | D_Entity | IncoTerm | MBLType | MBLTerms | SequestType | Destination_Country | Destination_NetworkComponent | Destination_Department | Destination_Type | Destination_IsLive | Carrier | PortOfLoading_L1 | ETD_L1 | PortOfDischarge_L1 | ETA_L1 | PortOfLoading_L2 | ETD_L2 | PortOfDischarge_L2 | ETA_L2 | PortOfLoading_L3 | ETD_L3 | PortOfDischarge_L3 | ETA_L3 | D_Haulier                   | D_Coll_Date | D_Del_Date | PIVType          | PIVSubType | PIVInvoiceDate | PIVType2        | NumberOfChargesForSales |
#      | DR1     | Job        | Job Booking     | Ocean Freight | FCL         | Destination Only | Back To Back | Flyjac Logistics- IN | Smatbot- US            | 1200     | DAT      | Express | Prepaid  | Original    | US                  | Chicago                      | Ocean Import           | Branch           | Yes                | MAEU    | INNSA            | 7      | INMAA              | 8      | INMAA            | 9      | AEDXB              | 10     | AEDXB            | 11     | USCHI              | 14     | BESTWAY TRANSPORT           | 15          | 16         | Purchase Invoice | Freight    | Today          | Purchase Credit | All                     |
      | DR1     | Job        | Job Booking     | Ocean Freight | FCL         | Destination Only | Back To Back | Smatbot- US       | Flyjac Logistics- IN   | 5910     | DAT      | Express | Prepaid  | Original    | IN                  | Mumbai                       | Ocean Import           | Branch           | Yes                | MAEU    | USCHI            | 7      | INMAA              | 8      | INMAA            | 9      | AEDXB              | 10     | AEDXB            | 11     | INNSA              | 14     | Garrisons Logistics Pvt Ltd | 15          | 16         | Purchase Invoice | Freight    | Today          | Purchase Credit | All                     |
