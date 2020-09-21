Feature: JP - FOCiS
@gui
  Scenario Outline: Create a FCL Job

    Given User is logged into FOCiS Application
    When selects "<MenuOption>" from Menu
    And selects "<ChildMenuOption>" from Child Menu
    Then "Job Creation" Page displays

    Examples:
      | DataRow | MenuOption | ChildMenuOption |
      | DR1     | Job        | Job Creation    |

  @gui
  Scenario Outline: Create a FCL Job2

    Given User is logged into FOCiS Application
    When selects "<MenuOption>" from Menu
    And selects "<ChildMenuOption>" from Child Menu
    Then "Job Creation" Page displays

    Examples:
      | DataRow | MenuOption | ChildMenuOption |
      | DR1     | Job        | Job Creation    |