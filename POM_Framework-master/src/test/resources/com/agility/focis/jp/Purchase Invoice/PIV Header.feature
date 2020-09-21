@PIVRegression @Regression @PIV @Header
Feature: Purchase Invoice - Header

  Background: User navigates to Create PIV Header Page
    Given User is logged into FOCiS Application
    When selects "Purchase Invoice/Credit" from "Purchase Invoice/Credit/Fast Check" from "Job" Menu
    And clicks on "Create New PIV" Icon

  Scenario: Validate the status of header is displayed as NEW before creating the Header
    Then Invoice Status should be "New"

  @CreatePIVHeader
  Scenario Outline: Validate all the field in header after Creating the PIV Header
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    Then PIV Header details should be populated as below
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Invoice Status should be "Created"
    Examples:
      | DataRow | PIVType          | PIVSubType       | Entity | OrgComponent        | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight          | 5910   | Mumbai Ocean Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |
      | DR2     | Purchase Credit  | Freight          | 5910   | Mumbai Ocean Export | Garrisons Logistics Pvt Ltd | Today          | -100      | 0.00      | INR      |
      | DR3     | Purchase Invoice | Duties and Taxes | 5910   | Mumbai Ocean Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |

  Scenario Outline: Validate that Org. Component State & Place of supply field will displayed when GST Entity is selected
    When selects Entity Code as "<GSTEnabledEntity>"
    Then Org Component State and Place Of Supply should be populated
    Examples:
      | DataRow | GSTEnabledEntity |
      | DR1     | 5910             |

  Scenario Outline: Validate that Bank Reference textbox will be enabled based on Entity Setup
    When selects Entity Code as "<EntityCode>"
    Then Bank Reference textbox will be enabled
    Examples:
      | DataRow | EntityCode |
      | DR1     | 7010       |

  Scenario Outline: Validate that Supplier Invoice Date should not allow Future Date
    When selects Entity Code as "<EntityCode>"
    And selects Org Component as "<OrgComponent>"
    And selects Supplier as "<Supplier>"
    And enters Supplier Invoice Date as "<FutureDate>"
    Then application should throw "<ErrorMessage>" Error Message
    Examples:
      | DataRow | EntityCode | OrgComponent        | Supplier                    | FutureDate | ErrorMessage                                                  |
      | DR1     | 5910       | Mumbai Ocean Export | Garrisons Logistics Pvt Ltd | Today + 10 | Supplier Invoice Date Should not be greater than Today's date |


  Scenario Outline: Validate that PIV Due Date should be displayed based on Payment terms of Supplier
    When selects Entity Code as "<EntityCode>"
    And selects Org Component as "<OrgComponent>"
    And selects Supplier as "<Supplier>"
    Then PIV Due Date should be populated as "<PIVDueDate>"
    Examples:
      | DataRow | EntityCode | OrgComponent        | Supplier                    | PIVDueDate |
      | DR1     | 5910       | Mumbai Ocean Export | Garrisons Logistics Pvt Ltd | Today + 45 |


  Scenario Outline: Validate that PIV Amount should not allow negative amount when Invoice Type is selected as Purchase Invoice
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    Then application should throw "<ErrorMessage>" Error Message
    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent        | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency | ErrorMessage                                          |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Ocean Export | Garrisons Logistics Pvt Ltd | Today          | -100      | 0.00      | INR      | For Purchase Invoice, Total Amount should be Positive |


  Scenario Outline: Validate that PIV Amount should not allow Positive amount when Invoice Type is selected as Purchase Credit
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    Then application should throw "<ErrorMessage>" Error Message
    Examples:
      | DataRow | PIVType         | PIVSubType | Entity | OrgComponent        | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency | ErrorMessage                                         |
      | DR1     | Purchase Credit | Freight    | 5910   | Mumbai Ocean Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      | For Purchase Credit, Total Amount should be Negative |

  Scenario Outline: Validate that Tax Amount field will be disabled when Duties & Taxes is selected as Invoice Sub Type
    When selects Entity Code as "<EntityCode>"
    And selects Org Component as "<OrgComponent>"
    And selects Supplier as "<Supplier>"
    And enters Supplier Invoice Date as "<PIVInvoiceDate>"
    And selects Invoice Type as "<PIVType>"
    And selects Invoice Sub Type as "<PIVSubType>"
    Then Tax Amount field should be disabled
    Examples:
      | DataRow | PIVType          | PIVSubType       | EntityCode | OrgComponent        | Supplier                    | PIVInvoiceDate |
      | DR1     | Purchase Invoice | Duties and Taxes | 5910       | Mumbai Ocean Export | Garrisons Logistics Pvt Ltd | Today          |

  Scenario Outline: Validate that Duties & Taxes Invoice Sub Type should not be allowed when Purchase Credit is selected as Invoice Type
    When selects Entity Code as "<EntityCode>"
    And selects Org Component as "<OrgComponent>"
    And selects Supplier as "<Supplier>"
    And enters Supplier Invoice Date as "<PIVInvoiceDate>"
    And selects Invoice Type as "<PIVType>"
    And selects Invoice Sub Type as "<PIVSubType>"
    Then application should throw "<ErrorMessage>" Error Message
    Examples:
      | DataRow | PIVType         | PIVSubType       | EntityCode | OrgComponent        | Supplier                    | PIVInvoiceDate | ErrorMessage                                                 |
      | DR1     | Purchase Credit | Duties and Taxes | 5910       | Mumbai Ocean Export | Garrisons Logistics Pvt Ltd | Today          | PIVSubType should not be duties & taxes for purchase credit. |

  Scenario Outline:Validate the Total Amount after entering PIV Amount & Tax Amount
    When selects Entity Code as "<EntityCode>"
    And selects Org Component as "<OrgComponent>"
    And selects Supplier as "<Supplier>"
    And enters Supplier Invoice Date as "<PIVInvoiceDate>"
    And selects Invoice Type as "<PIVType>"
    And selects Invoice Sub Type as "<PIVSubType>"
    And enters PIV Amount as "<PIVAmount>"
    And enters Tax Amount as "<TaxAmount>"
    Then Total Amount should be populated as "<TotalAmount>"
    Examples:
      | DataRow | PIVType          | PIVSubType | EntityCode | OrgComponent        | Supplier                    | PIVInvoiceDate | PIVAmount | TaxAmount | TotalAmount |
      | DR1     | Purchase Invoice | Freight    | 5910       | Mumbai Ocean Export | Garrisons Logistics Pvt Ltd | Today          | 100.00    | 10.00     | 110.00      |

  Scenario Outline: Validate that Primary Address should displayed as Supplier Invoice Address
    When selects Entity Code as "<EntityCode>"
    And selects Org Component as "<OrgComponent>"
    And selects Supplier as "<Supplier>"
    Then Supplier Address should be populated as Primary Address
    Examples:
      | DataRow | EntityCode | OrgComponent        | Supplier                    |
      | DR1     | 5910       | Mumbai Ocean Export | Garrisons Logistics Pvt Ltd |

  Scenario Outline: Validate that PIV Amount & Tax Amount field should be disabled when Tax At Header is selected
    When selects Entity Code as "<EntityCode>"
    And selects Org Component as "<OrgComponent>"
    And selects Supplier as "<Supplier>"
    And selects Tax At Header CheckBox
    Then PIV Amount field should be disabled
    And Tax Amount field should be disabled
    Examples:
      | DataRow | EntityCode | OrgComponent        | Supplier                    |
      | DR1     | 5910       | Mumbai Ocean Export | Garrisons Logistics Pvt Ltd |

  Scenario Outline: Validate the PIV Amount & Tax Amount for Header Amount row in Amount info table
    When selects Entity Code as "<EntityCode>"
    And selects Org Component as "<OrgComponent>"
    And selects Supplier as "<Supplier>"
    And selects Tax At Header CheckBox
    Then PIV Amount and Tax Amount should be displayed as Zero in "Header Amount" Row
    Examples:
      | DataRow | EntityCode | OrgComponent        | Supplier                    |
      | DR1     | 5910       | Mumbai Ocean Export | Garrisons Logistics Pvt Ltd |

  Scenario Outline: Validate tha Currency in Amount Info Table
    When selects Entity Code as "<EntityCode>"
    And selects Org Component as "<OrgComponent>"
    And selects Supplier as "<Supplier>"
    And selects Tax At Header CheckBox
    And selects Currency as "<Currency>"
    Then Currency should populated as "<Currency>"
    Examples:
      | DataRow | EntityCode | OrgComponent        | Supplier                    | Currency |
      | DR1     | 5910       | Mumbai Ocean Export | Garrisons Logistics Pvt Ltd | INR      |

  Scenario Outline: Validate the PIV Amount & Tax Amount for Total Amount row in Amount info table before charge Allocation
    When selects Entity Code as "<EntityCode>"
    And selects Org Component as "<OrgComponent>"
    And selects Supplier as "<Supplier>"
    And selects Tax At Header CheckBox
    And selects Currency as "<Currency>"
    Then PIV Amount and Tax Amount should be displayed as Zero in "Total Amount" Row
    Examples:
      | DataRow | EntityCode | OrgComponent        | Supplier                    | Currency |
      | DR1     | 5910       | Mumbai Ocean Export | Garrisons Logistics Pvt Ltd | INR      |