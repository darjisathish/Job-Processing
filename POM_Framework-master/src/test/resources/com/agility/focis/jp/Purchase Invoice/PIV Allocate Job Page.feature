@PIVRegression @Regression @PIV @AllocateJob
Feature: Purchase Invoice - Allocate Job
#100149975
  Background: Login
    Given User is logged into FOCiS Application

  Scenario Outline: (Pre Condition Scenario) - Create Air Freight - E2E Job and Add Estimates

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
    Examples:
      | DataRow | MenuOption | ChildMenuOption | Product     | ProductType | JobScope | OriginStakeholder    | DestinationStakeholder | IncoTerm | Origin_Country | Origin_NetworkComponent | Origin_Department | Origin_Type | Origin_IsLive | O_Entity | Destination_Country | Destination_NetworkComponent | Destination_Department | Destination_Type | Destination_IsLive | D_Entity | Carrier | FlightNumber | AOD | AOA | ETD | ETDTime | ETA | ETATime | O_Haulier                   | O_Coll_Date | O_Del_Date | D_Haulier         | D_Coll_Date | D_Del_Date |
      | DR1     | Job        | Job Booking     | Air Freight | Expedited   | E2E      | Flyjac Logistics- IN | Smatbot- US            | DAT      | IN             | Mumbai                  | Air Export        | Branch      | Yes           | 5910     | US                  | Chicago                      | Air Import             | Branch           | Yes                | 1200     | EK      | EK123        | BOM | ORD | 7   | 12      | 14  | 12      | Garrisons Logistics Pvt Ltd | 1           | 3          | BESTWAY TRANSPORT | 15          | 16         |

  Scenario Outline: Validate that page navigate to Allocate job page when we click Allocate Job/Consol button

    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Clicks on "Allocate to Jobs/ Consol" button
    Then "Allocate Jobs for Supplier Invoice number : " Dialog should be populated

    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |

  Scenario Outline: Validate that Supplier Invoice Number should be displayed on heading lable

    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Clicks on "Allocate to Jobs/ Consol" button
    Then Supplier Name and Supplier Invoice Number should be populated correctly

    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |

  Scenario Outline: Validate the Amount Info table in Allocate Job Page

    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Clicks on "Allocate to Jobs/ Consol" button
    Then PIV Amount, Tax Amount and Currency should be displayed as "<PIVAmount>" , "<TaxAmount>" ,"<Currency>" in "Header Amount" Row on Allocate Jobs dialog

    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |

  Scenario Outline: Validate that Supplier Name  is displayed in the Allocate Job page

    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Clicks on "Allocate to Jobs/ Consol" button
    Then Supplier Name and Supplier Invoice Number should be populated correctly

    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |


  Scenario Outline: Validate that Charges will be listed in Job List section of Allocate job page based on combination of Supplier Name and Job No.

    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Clicks on "Allocate to Jobs/ Consol" button
    And Enters Current Number in to allocate Charges
    Then Charges belong to Supplier "<Haulier>" only listed

    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |

  Scenario Outline: Validate all the field in Tagged jobs table of Allocate Job page(Ex. Job No., Shipper Name,Status)
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Clicks on "Allocate to Jobs/ Consol" button
    And Enters Current Number in to allocate Charges
    Then Tagged jobs details should be populated correctly

    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |


  Scenario Outline: Validate all the fields related to charges(Ex. Charge Name, Amounts, Tax etc) in Tagged job table of Allocate Job page
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Clicks on "Allocate to Jobs/ Consol" button
    And Enters Current Number in to allocate Charges
    Then Charge Name, Amounts, Tax should be populated correctly

    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |

  Scenario Outline: Validate that charges Name fetched in Allocate Job page screen according to Estimated Charges

    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Clicks on "Allocate to Jobs/ Consol" button
    And Enters Current Number in to allocate Charges
    Then Charges belong to Supplier "<Haulier>" only listed

    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |

  Scenario Outline: Validate the PIV Amount & Tax Amount for Allocated Amount row after in Amount Info table of Allocate job Page after selecting the charge in charge grid
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Clicks on "Allocate to Jobs/ Consol" button
    And Enters Current Number in to allocate Charges
    And selects charges
    Then PIV Amount, Tax Amount and Currency should be displayed as "Sum of PIV Amounts" , "Sum of  Tax Amounts" ,"<Currency>" in "Allocated Amount" Row on Allocate Jobs dialog
    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |


  Scenario Outline: Validate PIV Amount, Tax Amount & Total Amount for To be Allocated row in Amount Info table of Allocate job Page after selecting the charge in charge grid
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Clicks on "Allocate to Jobs/ Consol" button
    And Enters Current Number in to allocate Charges
    And selects charges
    Then PIV Amount, Tax Amount and Currency should be displayed as "Header PIV Amount - Allocated PIV Amount" , "Header Tax Amount - Allocated Tax Amount" ,"<Currency>" in "To be Allocated Amount" Row on Allocate Jobs dialog
    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |

  Scenario Outline: Validate the Total Amount at charge grid level after modifying the tax code at charge level
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Clicks on "Allocate to Jobs/ Consol" button
    And Enters Current Number in to allocate Charges
    And modifies Tax Code for a Charge
    Then Tax Amount and Total Amount should be populated correctly for modified Charge

    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |

  Scenario Outline: Validate that User is able to modify Supplier tax amount at charge code level for Non-Rate Tax code
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Clicks on "Allocate to Jobs/ Consol" button
    And Enters Current Number in to allocate Charges
    Then User is able to modify Supplier Tax Amount

    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |


  Scenario Outline: Validate the Total amount after modifying the Supplier Tax Amount at charge grid level
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Clicks on "Allocate to Jobs/ Consol" button
    And Enters Current Number in to allocate Charges
    When User is able to modify Supplier Tax Amount
    Then Total Amount should be populated correctly after modifying Supplier Tax Amount

    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |

  Scenario Outline: Validate the difference between Tax Amount & Supplier Tax Amount after modifying the Supplier Tax Amount
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Clicks on "Allocate to Jobs/ Consol" button
    And Enters Current Number in to allocate Charges
    When User is able to modify Supplier Tax Amount
    Then difference between Tax Amount and Supplier Tax Amount should be populated correctly

    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |


  Scenario Outline: Validate the PIV Amount & Tax Amount for Allocated Amount row after in Amount Info table of Allocate job Page after changing the Supplier Tax Amount
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Clicks on "Allocate to Jobs/ Consol" button
    And Enters Current Number in to allocate Charges
    And User is able to modify Supplier Tax Amount
    And selects charges
    Then PIV Amount, Tax Amount and Currency should be displayed as "Sum of PIV Amounts" , "Sum of Modified Supplier Tax Amounts" ,"<Currency>" in "Allocated Amount" Row on Allocate Jobs dialog
    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |

  Scenario Outline: Validate the PIV Amount & Tax Amount for To be Allocated Amount row after in Amount Info table of Allocate job Page after changing the Supplier Tax Amount
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Clicks on "Allocate to Jobs/ Consol" button
    And Enters Current Number in to allocate Charges
    And User is able to modify Supplier Tax Amount
    And selects charges
    Then PIV Amount, Tax Amount and Currency should be displayed as "Header PIV Amount - Allocated PIV Amount" , "Header Tax Amount - Allocated Tax Amount" ,"<Currency>" in "To be Allocated Amount" Row on Allocate Jobs dialog
    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |


  Scenario Outline: Validate the PIV Amount & Tax Amount for Allocated Amount row after in Amount Info table of Allocate job Page after changing the Tax Code
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Clicks on "Allocate to Jobs/ Consol" button
    And Enters Current Number in to allocate Charges
    And modifies Tax Code for a Charge
    And selects charges
    Then PIV Amount, Tax Amount and Currency should be displayed as "Sum of PIV Amounts" , "Sum of Modified Supplier Tax Amounts" ,"<Currency>" in "Allocated Amount" Row on Allocate Jobs dialog
    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |

  Scenario Outline: Validate the PIV Amount & Tax Amount for To be Allocated Amount row after in Amount Info table of Allocate job Page after changing the Tax Code
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Clicks on "Allocate to Jobs/ Consol" button
    And Enters Current Number in to allocate Charges
    And modifies Tax Code for a Charge
    And selects charges
    Then PIV Amount, Tax Amount and Currency should be displayed as "Header PIV Amount - Allocated PIV Amount" , "Header Tax Amount - Allocated Tax Amount" ,"<Currency>" in "To be Allocated Amount" Row on Allocate Jobs dialog
    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |

  Scenario Outline: Validate the Total Amount after applying Write Off at charge grid level in Allocate job page
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Clicks on "Allocate to Jobs/ Consol" button
    And Enters Current Number in to allocate Charges
    And applies Write Off for a Charge
    Then Total Amount should be populated correctly after Write Off for Wrote Off Charge
    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |


  Scenario Outline: Validate whether user is able to "Allocate & Continue" in Allocate job page or not
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Clicks on "Allocate to Jobs/ Consol" button
    And Enters Current Number in to allocate Charges
    And modifies Tax Code for a Charge
    And selects charges
#    Then user is able to click on Allocate & Continue
    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |
